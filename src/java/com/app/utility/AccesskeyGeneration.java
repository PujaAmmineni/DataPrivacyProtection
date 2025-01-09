
package com.app.utility;

import java.security.SecureRandom;
import java.util.Random;

/**
 *
 * @author Puja
 */
public class AccesskeyGeneration {
     static final private String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
    final private Random rng = new SecureRandom();

    char randomChar() {
        return ALPHABET.charAt(rng.nextInt(ALPHABET.length()));
    }

   public String randomUUID(int length, int spacing, char spacerChar) {
        StringBuilder sb = new StringBuilder();
        int spacer = 0;
        while (length > 0) {
            if (spacer == spacing) {
                sb.append(spacerChar);
                spacer = 0;
            }
            length--;
            spacer++;
            sb.append(randomChar());
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        AccesskeyGeneration gsk = new AccesskeyGeneration();
        char spacerChar = 'D';
        String key = gsk.randomUUID(15, 0, spacerChar);
        System.out.println("Key "+key+" And its Length is "+key.length());
        
    }
}
