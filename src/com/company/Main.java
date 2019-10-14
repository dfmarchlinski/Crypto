package com.company;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Scanner;

public class Main {

    private static void eval(int input) throws NoSuchPaddingException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException, InvalidKeySpecException {

        // Verify proper input
        switch (input) {
            case 0:
                new Encrypt();
                break;
            case 1:
                new Decrypt();
                break;
            case 2:
                new Remove();
                break;
            default:
                System.out.println("Invalid input\n");
                input();
        }
    }

    private static void integer(String input) throws NoSuchPaddingException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException, InvalidKeySpecException {

        // Determine if input is integer
        int i = 0;
        try {
            i = Integer.parseInt(input);
        } catch (NumberFormatException | NullPointerException nfe) {
            System.out.println("Invalid input\n");
            input();
            return;
        }
        eval(i);
    }

    private static void input() throws NoSuchPaddingException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException, InvalidKeySpecException {

        // Receive input
        System.out.println("Encrypt/Decrypt/Remove (0/1/2): ");
        String input = new Scanner(System.in).nextLine();
        integer(input);
    }

    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException, InvalidKeySpecException {

        // Input plain text message from user
        input();
    }
}
