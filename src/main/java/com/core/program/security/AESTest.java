package com.core.program.security;

import javax.crypto.*;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Created by sky on 2017/4/12.
 * This program tests the AEC cipher
 * java AESTest -genkey keyfile
 * java AESTest -encrypt plaintext encrypted keyfile
 * java AESTest -decrypt encrypted decrypted keyfile
 *
 * 密钥生成
 * 1、为加密算法获取KeyGenerator
 * 2、用随机源来初始化密钥发生器。如果密码块长度是可变的，还需要指定期望的密码快长度
 * 3、调用generateKey()
 */
public class AESTest {
    public static void main(String[] args) {
        try {
            if (args[0].equals("-genkey")) {
                //获得一个密码对象  1、为加密算法获取KeyGenerator
                KeyGenerator keygen = KeyGenerator.getInstance("AES");

                //设置模式和密钥进行初始化  2、用随机源来初始化密钥发生器。
                SecureRandom random = new SecureRandom();
                keygen.init(random);

                //3、调用generateKey()
                SecretKey key = keygen.generateKey();

                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(args[1]));
                out.writeObject(key);
                out.close();
            } else {
                int mode;
                if (args[0].equals("-encrypt")) mode = Cipher.ENCRYPT_MODE;
                else mode = Cipher.DECRYPT_MODE;

                ObjectInputStream keyIn = new ObjectInputStream(new FileInputStream(args[3]));
                Key key = (Key) keyIn.readObject();
                keyIn.close();

                InputStream in = new FileInputStream(args[1]);
                OutputStream out = new FileOutputStream(args[2]);
                Cipher cipher = Cipher.getInstance("AES");
                cipher.init(mode, key);
                crypt(in, out, cipher);
                in.close();
                out.close();

            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (ShortBufferException e) {
            e.printStackTrace();
        }
    }

    public static void crypt(InputStream in, OutputStream out, Cipher cipher) throws IOException, ShortBufferException, BadPaddingException, IllegalBlockSizeException {
        int blockSize = cipher.getBlockSize();
        int outputSize = cipher.getOutputSize(blockSize);
        byte[] inBytes = new byte[blockSize];
        byte[] outBytes = new byte[outputSize];

        int inLength = 0;
        boolean more = true;
        while (more) {
            inLength = in.read(inBytes);
            if (inLength == blockSize) {
                //update对数据块进行加密
                int outLength = cipher.update(inBytes, 0, blockSize, outBytes);
                out.write(outBytes, 0, outLength);
            } else more = false;
            //对最后的块进行填充 保证数据块完整
            if (inLength > 0) outBytes = cipher.doFinal(inBytes, 0, inLength);
            else outBytes = cipher.doFinal();
            out.write(outBytes);
        }
    }
}
