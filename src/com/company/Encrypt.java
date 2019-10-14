package com.company;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Scanner;

class Encrypt {

    Encrypt() throws NoSuchPaddingException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
        encrypt();
    }

    private static void encrypt() throws NoSuchAlgorithmException, NoSuchPaddingException, IOException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {

        // Input message
        System.out.println("Enter a message: ");
        Scanner in = new Scanner(System.in);
        String plain = in.nextLine();

        // Generate hexadecimal ID for files
        System.out.println("\nGenerating hexadecimal identifier: ");
        String hex = String.format("%x", (int) (Math.random() * 2147483647));
        System.out.println("Hexadecimal identifier (save this as it is used to access the message files): " + hex);

        // Generate keys
        System.out.println("\nGenerating 4096 bit RSA keys ...");
        KeyPairGenerator kg = KeyPairGenerator.getInstance("RSA");
        kg.initialize(4096);
        KeyPair pair = kg.generateKeyPair();
        Cipher rsa = Cipher.getInstance("RSA");

        // ANALYZING DATA
        System.out.println("\nANALYZING DATA");

        // Save keys
        System.out.println("\nSaving keys to files ...");
        FileOutputStream prv = new FileOutputStream("./Private/" + hex + ".key");
        System.out.println("\nPrivate key location: ./Private/" + hex + ".key");
        prv.write(pair.getPrivate().getEncoded());
        prv.close();
        FileOutputStream pub = new FileOutputStream("./Public/" + hex + ".pub");
        System.out.println("Public key location: ./Public/" + hex + ".pub");
        pub.write(pair.getPublic().getEncoded());
        pub.close();

        // Encrypt message
        rsa.init(Cipher.ENCRYPT_MODE, pair.getPublic());
        byte[] encrypted = rsa.doFinal(plain.getBytes());

        // Save encrypted message
        FileOutputStream text = new FileOutputStream("./Message/" + hex);
        text.write(encrypted);
        text.close();

        // Display encrypted message and location
        System.out.println("Encrypted message location: ./Message/" + hex);
        System.out.println("\nEncrypted message: " + Arrays.toString(encrypted));
    }
}
