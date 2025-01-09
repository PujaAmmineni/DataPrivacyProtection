
package com.app.wrapper;

import com.app.utility.ECC;
import static com.app.utility.ECC.generateKeyPair;
import com.app.utility.EllipticCurve;
import com.app.utility.Helpers;
import com.app.utility.KeyPair;
import com.app.utility.Point;
import com.app.utility.PrivateKey;
import com.app.utility.PublicKey;

/**
 *
 * @author Puja
 */
public class TestMyECC {
    private static EllipticCurve c;
    private static ECC ecc;
    public KeyPair getKeys() {
         c = new EllipticCurve(4, 20, 29, new Point(1, 5));
         ecc = new ECC(c);
        ecc.displayCodeTable();
        String msg = "i understood the importance in principle of public key cryptography, but it is all moved much faster than i expected i did not expect it to be a mainstay of advanced communications technology";

        // generate pair of keys
        KeyPair keys = generateKeyPair(c);
        return keys;
    }

    public static void main(String[] args) {
        TestMyECC test = new TestMyECC();
        KeyPair keys = test.getKeys();
       
        ecc.displayCodeTable();
        String msg1 = "To solve the problem of poor security and performance caused by traditional ";
        String msg = msg1.toLowerCase();
        
        PublicKey pub = keys.getPublicKey();
        PrivateKey privkey = keys.getPrivateKey();
        System.out.println("Public Key "+pub.getKey());
        System.out.println("Private key "+privkey);
        int[] cipher = test.doEncryptMessage(msg,  pub);
        String plain = test.doDecryptionMessage(cipher, privkey);
        System.out.println("Plain Text is "+plain);
        
    }
    
    public int[] doEncryptMessage(String msg,PublicKey pub){
    int[] cipherText = ecc.encrypt(msg, pub);
        System.out.println("Ciphet Data is");
        Helpers.print(cipherText);
        return cipherText;
    }
    public String doDecryptionMessage(int[] cipher,PrivateKey priv){
    String plainText = ecc.decrypt(cipher, priv);
    return plainText;
    }
}
