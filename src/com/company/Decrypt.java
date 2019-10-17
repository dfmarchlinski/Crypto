package com.company;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Scanner;

class Decrypt {

    Decrypt() throws NoSuchPaddingException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException, InvalidKeySpecException {
        decrypt();
    }

    private static void decrypt() throws NoSuchPaddingException, NoSuchAlgorithmException, IOException, InvalidKeySpecException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {

        // Input hex ID
        System.out.println("\nEnter hexadecimal identifier: ");
        String hex = new Scanner(System.in).nextLine();

        // Initialize RSA cipher
        Cipher rsa = Cipher.getInstance("RSA");

        // Access private key and encrypted message
        byte[] prvBytes = Files.readAllBytes(Paths.get("./Private/" + hex + ".key"));
        PrivateKey prv = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(prvBytes));
        byte[] keyBytes = Files.readAllBytes(Paths.get("./Message/" + hex));

        // ANALYZING DATA
        System.out.println("\nANALYZING DATA");

        // Decrypt and display message
        rsa.init(Cipher.DECRYPT_MODE, prv);
        byte[] decrypted = rsa.doFinal(keyBytes);
        System.out.println("\nDecrypted: " + new String(decrypted));
    }
}
