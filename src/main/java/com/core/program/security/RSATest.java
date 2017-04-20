package com.core.program.security;

import javax.crypto.*;
import java.io.*;
import java.security.*;

/**
 * Created by sky on 2017/4/13.
 * This program tests the AEC cipher
 * java RSATest -genkey keyfile
 * java RSATest -encrypt plaintext encrypted keyfile
 * java RSATest -decrypt encrypted decrypted keyfile
 */
public class RSATest {

    private static final int KEYSIZE = 512;

    public static void main(String[] args) {
        try {
            if (args[0].equals("-genkey")) {
                //获得一个密码对象
                KeyPairGenerator pairgen = KeyPairGenerator.getInstance("RSA");

                //设置模式和密钥进行初始化
                SecureRandom random = new SecureRandom();
                pairgen.initialize(KEYSIZE, random);

                //generateKeyPair
                KeyPair keyPair = pairgen.generateKeyPair();

                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(args[1]));
                out.writeObject(keyPair.getPublic());
                out.close();
                out = new ObjectOutputStream(new FileOutputStream(args[2]));
                out.writeObject(keyPair.getPrivate());
                out.close();
            } else if (args[0].equals("-encrypt")) {
                KeyGenerator keygen = KeyGenerator.getInstance("AES");
                SecureRandom random = new SecureRandom();
                keygen.init(random);
                SecretKey key = keygen.generateKey();

                //wrap with RSA public key
                ObjectInputStream keyIn = new ObjectInputStream(new FileInputStream(args[3]));
                Key publicKey = (Key) keyIn.readObject();
                keyIn.close();

                Cipher cipher = Cipher.getInstance("RSA");
                cipher.init(Cipher.WRAP_MODE, publicKey);
                byte[] wrappedKey = cipher.wrap(key);
                DataOutputStream out = new DataOutputStream(new FileOutputStream(args[2]));
                out.writeInt(wrappedKey.length);
                out.write(wrappedKey);

                InputStream in = new FileInputStream(args[1]);
                cipher = Cipher.getInstance("AES");
                cipher.init(Cipher.ENCRYPT_MODE, key);
                crypt(in, out, cipher);
                in.close();
                out.close();
            } else {
                DataInputStream in = new DataInputStream(new FileInputStream(args[1]));
                int length = in.readInt();
                byte[] wrappedKey = new byte[length];
                in.read(wrappedKey, 0, length);

                //unwrap with RSA private key
                ObjectInputStream keyIn = new ObjectInputStream(new FileInputStream(args[3]));
                Key privateKey = (Key) keyIn.readObject();
                keyIn.close();

                Cipher cipher = Cipher.getInstance("RSA");
                cipher.init(Cipher.UNWRAP_MODE, privateKey);
                Key key = cipher.unwrap(wrappedKey, "AES", Cipher.SECRET_KEY);

                OutputStream out = new FileOutputStream(args[2]);
                cipher = Cipher.getInstance("AES");
                cipher.init(Cipher.DECRYPT_MODE, key);

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
