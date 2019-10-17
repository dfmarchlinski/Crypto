package com.company;

import java.io.File;
import java.util.Scanner;

class Remove {

    Remove() {
        decrypt();
    }

    private static void decrypt() {

        // Input hex ID
        System.out.println("\nEnter hexadecimal identifier: ");
        String hex = new Scanner(System.in).nextLine();

        // ANALYZING DATA
        System.out.println("\nANALYZING DATA");

        // Delete files and display deletion status
        boolean prvBool = new File("./Private/" + hex + ".key").delete();
        boolean pubBool = new File("./Public/" + hex + ".pub").delete();
        boolean msgBool = new File("./Message/" + hex).delete();
        System.out.println("\nPrivate key deleted: " + prvBool);
        System.out.println("Public key deleted: " + pubBool);
        System.out.println("Message deleted: " + msgBool);
    }
}
