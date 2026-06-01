package TictactoeProject.service;


import TictactoeProject.exception.InvalidInputException;

import java.util.InputMismatchException;
import java.util.Scanner;



public class InputService {

    private Scanner scanner = new Scanner(System.in);

    public int getInput(String message)
            {

        try {

            System.out.print(message);

            return scanner.nextInt();

        } catch (InputMismatchException e) {

            scanner.nextLine();

            throw new InvalidInputException("Only numbers are allowed");
        }
    }
}