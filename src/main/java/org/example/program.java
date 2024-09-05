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
            System.out.print("Choose the option (1-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine();
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
                    System.out.println("Thank you for playing! Goodbye.");
                    break;
                default:
                    System.out.println("Invalid choice please choose again.");
            }
            System.out.println("\n");
        }
        scanner.close();
    }

    public void startGame(){
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        int score = 0;
        int difficultyLevel = 1;
        int correct = 0;
        int wrong = 0;
        for (int i = 0; i < 20; i++) {
            int num1 = random.nextInt(10 * difficultyLevel) + 1;
            int num2 = random.nextInt(10 * difficultyLevel) + 1;
            int correctAnswer = num1 * num2;

            System.out.print("How much is " + num1 + " times " + num2 + "? ");
            int userAnswer = scanner.nextInt();

            if (userAnswer == correctAnswer) {
                System.out.println("Correct!");
                score += 10;
                correct++;
                wrong = 0;

                if (correct == 3) {
                    difficultyLevel++;
                    correct = 0;
                    System.out.println("Level Up! Difficulty increased.");
                }
            } else {
                System.out.println("Wrong answer.");
                wrong++;
                correct = 0;

                if (wrong == 3) {
                    gameOver(name,score);
                    break;
                }
            }
        }

        if (score > highScore) {
            highScore = score;
            System.out.println("Congratulations " + name + "! You've set a new high score: " + highScore);
        } else {
            System.out.println("Your score: " + score);
        }
    }
    public  void gameOver(String name, int score) {
        System.out.println("Game Over, " + name + ". You answered 3 questions incorrectly in a row.");
        System.out.println("Please ask your teacher for extra help.");
        System.out.println("Your final score is " + score);
        showFeedback(score);
    }
    public void showFeedback(int score) {
        if (score >= 150) {
            System.out.println("Excellent work! Your multiplication skills are impressive.");
        } else if (score >= 100) {
            System.out.println("Good job! Keep practicing and you'll improve.");
        } else {
            System.out.println("Don't give up! Keep practicing to improve your multiplication skills.");
        }
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
