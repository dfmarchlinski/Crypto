package com.company;

import java.io.File;
import java.util.Scanner;

class Remove {

    Remove() {
        decrypt();
    }

    private static void decrypt() {

        // Input hex ID
        System.out.println("Enter hexadecimal identifier: ");
        Scanner in = new Scanner(System.in);
        String hex = in.nextLine();

        // ANALYZING DATA
        System.out.println("\nANALYZING DATA");

        // Access files
        File prv = new File("./Private/" + hex + ".key");
        File pub = new File("./Public/" + hex + ".pub");
        File msg = new File("./Message/" + hex);

        // Delete files and display deletion status
        boolean prvBool = prv.delete();
        boolean pubBool = pub.delete();
        boolean msgBool = msg.delete();
        System.out.println("\nPrivate key deleted: " + prvBool);
        System.out.println("Public key deleted: " + pubBool);
        System.out.println("Message deleted: " + msgBool);
    }
}
