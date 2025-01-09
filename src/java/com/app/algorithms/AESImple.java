
package com.app.algorithms;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.tomcat.util.codec.binary.Base64;

/**
 *
 * @author Puja
 */
public class AESImple {

   // private static final String key = "aesEncryptionKey";
   // private static final String initVector = "encryptionIntVec";

    public static String encrypt(String value,String key, String initVector) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(value.getBytes());
            return Base64.encodeBase64String(encrypted);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static String decrypt(String encrypted,String key, String initVector) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));

            return new String(original);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        String originalString = "Mayank Agarwal";
        System.out.println("Original String to encrypt - " + originalString);
        String key = MyKeyGenerations.getAlphaNumericString(16);
        String initVector = MyKeyGenerations.getAlphaNumericString(16);
        String encryptedString = encrypt(originalString,key,initVector);
        System.out.println("Encrypted String - " + encryptedString);
        //String decryptedString = decrypt(encryptedString,key,initVector);
        String decryptedString = decrypt("G+cqnvurjos+qFxYaqqG4kQc1EqdfG2jrbkgPX6VjnlgT9eA6hIjEcGEqlns9gfX", "HGvzPq3pEG47E21x", "SSlDtnPILg3kU7kT");
        System.out.println("After decryption - " + decryptedString);
    }

}
