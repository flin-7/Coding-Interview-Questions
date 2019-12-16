package com.felix;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandling {

    public static void main(String[] args) {
//        createNewFile();
        numberExceptionHandling();
    }

    public static void createNewFile() {
        File file = new File("resource/nonexistingfile");
        try {
            file.createNewFile();
        } catch (Exception e) {
            System.out.println("Directory does not exist");
            e.printStackTrace();
        }
    }

    public static void numberExceptionHandling() {
        File file = new File("resource/number.txt");
        try(Scanner fileReader = new Scanner(file)) {
            while (fileReader.hasNext()) {
                double number = fileReader.nextDouble();
                System.out.println(number);
            }
        } catch (FileNotFoundException | InputMismatchException e) {
            e.printStackTrace();
        }
    }

    public static void createNewFileRethrow() throws IOException {
        File file = new File("resource/nonexistingfile");
        file.createNewFile();
    }
}
