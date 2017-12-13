package com.spider.test03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by yaman on 2017/3/13.
 */
public class AESUtil {


    protected static Logger logger = LoggerFactory.getLogger(AESUtil.class);

    /**
     * AES加密，加密算法 ：AES，加密模式:AES-128-ECB，PKCS5Padding补码，16位密钥。
     *
     * @param sSrc
     * @param sKey
     * @return
     * @throws Exception
     */
    public static String Encrypt(String sSrc, String sKey) throws Exception {
        if (sKey == null) {
            System.out.print("Key为空null");
            return null;
        }
        // 判断Key是否为16位
        if (sKey.length() != 16) {
            System.out.print("Key长度不是16位");
            return null;
        }
        byte[] raw = sKey.getBytes("utf-8");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");//"算法/模式/补码方式"
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));

        return Base64.encode(encrypted);
    }

    public static String Decrypt(String sSrc, String sKey) throws Exception {
        try {
            // 判断Key是否正确
            if (sKey == null) {
                logger.error("Key为空null");
                return null;
            }
            // 判断Key是否为16位
            if (sKey.length() != 16) {
                logger.error("Key长度不是16位");
                return null;
            }
            byte[] raw = sKey.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] encrypted1 = Base64.decode(sSrc);//先用base64解密
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original, "utf-8");
                return originalString;
            } catch (Exception e) {
                logger.error("解密字符串转换失败 {}=" + e.getMessage());
                System.out.println(e.toString());
                return null;
            }
        } catch (Exception ex) {
            logger.error("解密失败 {}=" + ex.getMessage());
            return null;
        }
    }

    public static void main(String[] args) throws Exception {


        String org="<![CDATA[JNGWt6FNUQ2brEmkBXwk8cePirdLoqhoRgqRBVlUEO+ZgvryDAahj8yQjZ/SIVNyHdTimBnNRolWurZWPS7eSdm05rgiXREC/UbERW5ATcNX2f12Wbw7DKLoPpIPx7EC5ZP6K+KdlZ4f6JSjFjTRRRAX13PLHTZHHVXlqMEiass=]]>";
                //"<![CDATA[DaYQI9CmTLwC3lOsNbLeAoOikhK/0YhlGTc/Zw2QITjcGZmUYLJNa0pY27YNwMmDAzD1bGzE+bZRo0rTDrg+XNwF12VLZc3ieFbTav0Ft0MSjnAZoPf47izd7Btd0LUNsAz6pgBB5mJwoBLNUvn6KRM3oOhoRf3UgHyY7bwfR1u77C9NBxcd+CdVW9B99GBXQlKy7U4kkHuyFaM9XIe9uQPUGX7iC2XUgHut6ZqriyNf+PILRhj/lwX7qQx7RFXL/0+xUEwo3cKq8yElKF77gQzNhWPBi1qjFsFiktx++d4VHuP30IzbztwfZeYxadGGzqywK8PGey0Kbw8d5yJBBvWM6Voyu6Y1Dckhops91wkZ6nM1YVC3lcmtF1IY+ELzCMjxbyInrij6CTO61QzYYvLekdD9ESDUNOFAz0+IugbZyGg2Dl8vWBLI1YZIo291HypSFSQXA/36IVEbY/bsPEi9OCgLHwvlMFclEqMpj2XuFE2Z8e1XnKobEmT9QdMUJ1kfTwD899Poowv9ceqFeYm2Xad3WR/Y8XW7I9fTsR8IQ0EVjRU9H3alyWBSM9aUEnwxvmmkeLLCAS0B/wqC+zTBoglCKimjfRBmV7L3PihzH/VOfj1A4OhSXmImh+AMOdYbnRe00xJBPi9AYU1P8bRQJWG0Aw9H4F+44dbG09uLCT2Y90E4EqxCSZU7x3AKG+2uBIpah7uSm0j5lazmUOjuVvM6pF167HC+whTpnrpnO+hzmSQBl0TnrihIsp5SEMbxmKiDf1/yQZKnxjDEkacBGD5kxAe+J08mjHKi9ws=]]>";
                //"<![CDATA[U555z/rvkxrV6KHRZ5peFC52NIMZi3rd8IteP2mi0hUpH8PtO9n3IIy9BmIainSqpplR9wF8Dmiv9tP0Ed5Go816ec7tTk6PETdVrRuECM/h31/Zw3H3TblprHV/g5Hca/0ofijn0Wl2osSs7JQvvTLX9Lx5KANWIEQXcGLQeIrie45wAFeh2IMjpr0TM0ACcdNmgKWj1W3C1xcDjq70kk6PH9ZyckRx6nvwyc5Pz1iJps+5kRkhV7VTfDJINZ8EzJziIujPyJeyrbVZoeO3giv4cr44KFEaeoXSLFCUZXlnNLe1EJzDqw2WYWEtFDDB63uO94y+zQPyLwRfK5ha/xQCueDDLq28l22u+YGlTyP7queVapS3KaZhj1a8P6InrklDoAC8BMlJpEu6HaE5syse2B8Crtc2c/lMXvnQvp3Bp3d1NMN3vMl9VFm1LwgUOB7y/emQ7wBiLtscx5X2Nd0gKRkp/CuBSsgHe6Eev53dZcMLlMwg8s+530b+jrcEsP7zlXxExWcB2LDq9IaP57hglypD61at2UJA+L5VPzg=]]>";
                //"<![CDATA[i4rTbrY90FrXKxsRmUlvZuQyJkxQ4EuxZKqOCf/8GdFX+gUKd0tMJA7jpG9tMYWEc71VvyGnrlg5skgOXYdhluKk4+Ls3IHs8Ik1fheBuWSxtzGAtEw6fa/+ioOScpLQjCPmaa4Z8N4Em7K2mMfRjfUZm4TjnGP/kRrgELE8ybdXSj2nO8DF5SFDwfczl5tFWlteM/xTPCQqfr8yeZFqZF52xqnw3hs8LAJtt7gGb5kfrZ4FJ8fdDaZQe0B5ybveC3QOk87GDckORJ+e615W/RTA/ypqWG0Jr9YUP1IOWbBKCNjmvSaeXbrDw5CowLEGnmkI03Jkk5sP3jnRkgOMHcsmS6GjRUu91PdbwimIVeVWdYh1K+ZE/XWxBmNEMqNW7ZFoKhPZnuKb08O0bM0jxHxKCpycJy6iqLSVgNrO1xUMjYvpQMcSUr6frORD5LkQq0k+3CoXIEGSZwIJo1bOjKhuywsSEUxxugYGj+scXv9KduHsG3j5zfDLDuWXIF1dHF0eEbgVJykCeAXw0ZHxqMBoiibWRmklhjl2iHmhkn475BoqFCUWGUb+C92EKw6DgCVeLAqOTnMA4n5SItHu6W543KA6XsPGKVbnAY8N9jX5JFs8fJv0zWZwRGK3OV6pzhpoX9xJR+Duec75MlC4jtzHSapI+ODJpqb0VLpEBAp3aGQ5IXT7jdjvG341KFPgcSgATJe2WMR6Uh7NvMGwHMHSBOgBOAGhiK5sHMNd/ZE/+lITOz0b/KPnxNWoa7/N1mintBogOJHQl8yN8A0PS9f+eWmP3D7Oh07tb3earXIqtkS/2FvmpK/RQNoYZp+WKtWSfTTQAWzqf+m/LagTQPZ9Ub4esXFpEukYr7PMoaJVFSjq0OyrKLDilJhY5HCev2UyvEAxmLBKzRD89FN0wFm088TDmMDqMR0I2Qk2XlF70IqzyWcDeX56rKtupHV7]]>";
                //"<![CDATA[IZwGRYJiJcqGGILEubgzqWf4wdnXKF9LQYUJNOtGOzsEymfY218GS6bAUddDqEmbVeSGLv4wId0uSeOlF41edPeAMsZYuEuycS50W4uwBkTjPUQ1CFFiKQNjO0xAGLsfU6LEZLmQG8jrCyvv4Og+Jsv7XxfLLD0lmJqw0T1uNmHFQ8q4OXtzNXy9NzBm4cGyy9hyOz+9hCWGanRncJ+xabx6Vyu2jfFnjH4iu7g6YhMffmf1cwytKe8elMSfg/h87VLl+efVN/3U3YcOUlaP3DlTmxjI9+FK7YcSX9ZjWym4YJcqQ+tWrdlCQPi+VT84]]>";
                //"<![CDATA[IZwGRYJiJcqGGILEubgzqWf4wdnXKF9LQYUJNOtGOzuwhiUkNxC2Tvdq855iRBZxgKxf93ntZpqEfzdFoy9WX8ozjph+0ngpnAJkBBcRJlHd6WYoBKcB9TWA2egZOAPD3elmKASnAfU1gNnoGTgDw93pZigEpwH1NYDZ6Bk4A8Pd6WYoBKcB9TWA2egZOAPD3elmKASnAfU1gNnoGTgDw93pZigEpwH1NYDZ6Bk4A8Pt5HW8DPN6ta2N3+dAUiX68BBYa7L1QPugvZZR8yZcOXQPLVWlms0GS0FjpDtqz4FnSJQEqyjLvNGrC9Vzzw0QrAKrv2Z33xeo53l/gBUB2+iFmnX19SqT83MpK3bjHRfd6WYoBKcB9TWA2egZOAPD3elmKASnAfU1gNnoGTgDw93pZigEpwH1NYDZ6Bk4A8Pd6WYoBKcB9TWA2egZOAPD3elmKASnAfU1gNnoGTgDwzAOWbyi49b/pM3/sFU5HJ3qSK+ts9PNUyMD6fJ6rWCxK38bhdq4oijmGrVISylnTw5WcxkaHWeCh64oN1oBe/CV5pQw9dAevuisIvWSTmQ7cwnVAqv1jFO0L+g2ew3tLeiFmnX19SqT83MpK3bjHRfd6WYoBKcB9TWA2egZOAPD3elmKASnAfU1gNnoGTgDw93pZigEpwH1NYDZ6Bk4A8Pd6WYoBKcB9TWA2egZOAPD3elmKASnAfU1gNnoGTgDwzjO89ReNUGDuqMsWeSp+7YAvqFs2aLizqXd9eHLNkSWcjabW7tDtkBjKnOuTgrK/o2kr1syhCYkvGB0aufBvrVXLQ4D86LP9pQ1mgIz+enN]]>";
                //"<![CDATA[IZwGRYJiJcqGGILEubgzqVx+lPnuDYyqFV06lPSBOuaELJ8lA6l8q2e39vy7lHZKSqYz9PA3rDQmXye+nxBvGA==]]>";
                //"<![CDATA[IZwGRYJiJcqGGILEubgzqVx+lPnuDYyqFV06lPSBOuaELJ8lA6l8q2e39vy7lHZKSqYz9PA3rDQmXye+nxBvGA==]]>";
                //"<![CDATA[eBtR9rIqGHbwJAExCS6igyWJb8z5IdpCvXYu3EKVuY22TcoGffJ1PYGu2TBE5JpkfZHw8DBTB4tL6xcu+RpkJeQmf10Twpp61qG6y5qFWWxF2UFar0Xoq1FzU8BBhzK8jDt3dWu0osnTQ9bGoU0y6LhZC1TRoLZjN8XctkM9n8ILIuDg9QJR/e6XWeZzR0htp3cd0KF6fMQg27+s/FYaFVjKSJXeWwr+OmQif1L0jW28AjUCPQfIh0LhIqBMWINvhVkAclfhkw+sPWSx5CLfXNpuj3O8No7DLJk/sg9hxwFIETV+xVkBhCp7mKsNNyU8mzItvl2AHdAsU6qnZx6fkYM1C+6Uz8jsQUCOrmZ7dWzEWwkmgJvGW9Fl37rE2SXmcHcZR5lAicrTQLxq9FNFf7Lh4kY41sCkOriDlh8rT8nrp+WXT5zSFEaL1U9uVkaUWMmw3IAOxGnCF62pGdkYQWmnrj+K5gGDIBme/G0STOAuccthK1HqEsR1afPNfKhc1OzgM67RYWAlAgrjmLwwmgUQHnb8QgdONOovKMvnutgOBKYbZCeHdt0ciB+WPqQApxCLVBS0avhzf1rxkZobUFVbDoP8OJdL0zQr89U2/ZoameZkBE84X22WtbLwPCToy483LW3XbKlmFltWBmaP3VzNqwM5qbHZxsuzKf88LPIzx+hIPPfphSPVjZibvEY31MLg3DOyaLEyTDjVuyicwwPDikmmLJJBocBvBRjuYPQsKE4W/0/2fZA1YZyOhwTpwPXb3Un7cVRjaK3LjHXRSDiNMLH5bznc+ojzyx4wHlUAXhBen4DwUfjZqXwVzIOgES9VTsDki0/Y7eftl2XO5jybMc4K+mhX4v+RJcgbzKyueK+sXCKmRcTOXHCbmuziLxw1isF9tQ88ewi+q+Y7dPdUiqqbOFuCkCr8pSXqDPnAYGD45rHi2WErh32oVYJ9OR0WQDQwVMs5QoMIF9yJl7HKyjYzNV9m/b3N8t7mB+8Em/y62V37c+qnUsYdv/X3qjyjD2yL5zwABMqIsXWoXTJgGVWKj4OYV9hkkXnHpiR7JxkPiPxDV19TFd9Po2jIU5xQk7QmgEpKDzr5R1EjUkn/BQcuicf9xCFg1mrosurNcMHeMAjWr2ZOvp0kCCW4OdKxiOfTDyCnAq/CRpT7W5u/mewylDHg45r23dDDcVj6YMqsy/Tee651+W4DGGjSXOXfnz0tSJ42/WQjkdJtqQqzcgenFvHmUAvGIS1dLLZIf2Ckx6rfe7KiBZWeS7bBf6cYdcONIvQeb7hZ0Tt2Z+cwVZ3pkBG2qvdWb/2vz1rHhKDnGhbEZizE0qJ0KRbZ6Hj6YMri/+15Tt6U+NWs/fYIEuXNksoKEPHB+mnCJTbbO5a+4KtLQhTRpAUK/pQzBxnYczAmeDDI1nT9xiuDd4WwBXGez0qeir5ErR/zDY0J+pbiPW1rEYqDjt5/mQaahPWlRF4FEDm1EXI+JTS9dvaopdClXkRGbZy2/A4NQz7kkX0g+pdwKE5iajtbYVLcYPTRqe18vvZ6NJunBlDqCPpLE0vlrcfpbHBRPX3OD/xZJ0pWho5kKri/VO29UL2vyLirtT8ayIAP3+TFnq/NdiPlYDN5XBteeJ8NN+gietNaRcgraLaPsJhn3AFa8dEuwee4qxRRWSQYq+JrGxskfuZoIuJxliwrjryRq3YFxf0=]]>";




        String s = org.substring(9, org.length() - 3);
        String decrypt = Decrypt(s, "E34C058BC4D11E1B");

        System.out.println(decrypt);

      /*  Document dataDocument = DocumentHelper.parseText(decrypt);
        Element bussData = dataDocument.getRootElement();

        List objectElement = bussData.elements();

        JSONObject jsonObject = new JSONObject();
        for (Iterator it = objectElement.iterator(); it.hasNext(); ) {
            Element element = (Element) it.next();
            String key = element.getName();
            String value = element.getTextTrim();
            jsonObject.put(key, value);
        }


        System.out.println(jsonObject.toString());*/


    }

}
