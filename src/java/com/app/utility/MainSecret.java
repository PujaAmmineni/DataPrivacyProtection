
package com.app.utility;

/**
 *
 * @author Puja
 */
public class MainSecret {
    public static void main(String[] args) {
        AccesskeyGeneration akg = new AccesskeyGeneration();
        String sk_Key = akg.randomUUID(15, 0, 'M');
        System.out.println(sk_Key);
    }
}
