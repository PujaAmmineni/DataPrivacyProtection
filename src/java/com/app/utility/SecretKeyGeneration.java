
package com.app.utility;

/**
 *
 * @author Puja
 */
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import java.security.Key;
import java.security.SecureRandom;

public class SecretKeyGeneration {
  public static String secretKey() throws Exception{  
      AccesskeyGeneration akg = new AccesskeyGeneration();
      String skKey = akg.randomUUID(12, 0, '[');
      /*KeyGenerator keyGen = KeyGenerator.getInstance("DES");   
      SecureRandom secRandom = new SecureRandom();
      keyGen.init(secRandom);
      Key key = keyGen.generateKey(); 
      System.out.println("Key s "+key.toString());
      System.out.println(skKey);      
      Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");      
      cipher.init(cipher.ENCRYPT_MODE, key); 
     
      byte[] bytes = cipher.doFinal(skKey.getBytes());      
      System.out.println(bytes);*/   
      return skKey;
   }   
}
