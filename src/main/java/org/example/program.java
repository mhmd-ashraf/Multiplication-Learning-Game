package org.example;

import java.util.Random;
import java.util.Scanner;

public class program {
    Scanner scanner;
    Random random;
    private int highScore = 0;

    public program(){
        scanner = new Scanner(System.in);
        random = new Random();
        System.out.println("******************************************************************");
        System.out.println("\t Welcome to Multiplication Learning Game ");
        System.out.println("******************************************************************");
    }

    public void run(){

        boolean flag = true;
        while (flag){
            System.out.println("1. Start Game");
            System.out.println("2. Help");
            System.out.println("3. Show High score");
            System.out.println("4. Exit");
            System.out.print("Choose the option: ");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    startGame();
                    break;
                case 2:
                    displayHelp();
                    break;
                case 3:
                    showHighScore();
                    break;
                case 4:
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid choice please choose again.");
            }
        }
    }

    public void startGame(){
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        int score = 0;
        int difficultyLevel = 1;
        int correct = 0;
        int wrong = 0;

    }

    public void displayHelp(){
        System.out.println("\nHelp:");
        System.out.println("1. You will be asked multiplication questions.");
        System.out.println("2. For each correct answer, your score increases.");
        System.out.println("3. After 3 consecutive correct answers, the difficulty increases.");
        System.out.println("4. If you get 3 answers wrong in a row, the game ends.");
        System.out.println("5. The game concludes after 20 questions or upon Game Over.");
    }

    public void showHighScore(){
        System.out.println("\nHigh Score: " + highScore);
    }
}
