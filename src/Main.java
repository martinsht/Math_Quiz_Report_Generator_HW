import java.util.Random;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.io.*;
public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to the Random Arithmetic Challenge!");
        Random generator = new Random();
        Random opGen = new Random();
        Scanner read = new Scanner(System.in);


        String option = "";
        int question = 1;
        System.out.println("Type your name: ");
        String name = read.nextLine();


        do { // I used a do-while loop so that it shows 4 questions in the start and then ask the user if they want to continue the game.


            for (int i = 0; i < 4; i++) { // The for loop is so that there is a four question cycle in which the user is asked if they want to exit the game or continue.
                int operator = opGen.nextInt(4);
                int num1 = generator.nextInt(20)+1; // I used integer numbers between 1 and 20 so that I don't complicate the user too much and so that we don't end up in the denominator with a zero.
                int num2 = generator.nextInt(20)+1;
                switch (operator) { /* The switch case statement is needed so that there are four different kinds of mathematical problems.
               The operator variable picks random whole numbers between 0 and 4 (without 4) so that the switch goes randomly to different cases with different arithmetic challenges.
               */
                    case 0:
                        sheet(Sum(read,num1,num2,question),name);
                        break;
                    case 1:
                        sheet(Sub(read,num1,num2, question),name);
                        break;
                    case 2:
                       sheet(Division(num1,num2,question),name);
                        break;
                        case 3:
                        sheet(Multiplication(num1,num2,question),name);
                        break;
                }
                question++; // the question variable lets the user know at what question they are on.
            }
            System.out.println("Do you want to continue the game? Type 'no' if you want to exit and the game will stop or type 'yes' and the game will continue.");
            option = read.next();


        } while (!(option.equals("no")));
    }
// After the main method I have put my different arithmetic operations. In this way, it is more organized.


    public static String Sum (Scanner read,int num1, int num2, int question){
        int result= num1+num2;
        System.out.println("Question " + question + ": What is the result of: " + num1 + " + " + num2+"?");
        System.out.print("Your answer (integer): ");
        int answer = read.nextInt();
        return "Question " + question + ": What is the result of: " + num1 + " + " + num2+" = "+answer+" "+(answer == result);
    }
    public static String Sub (Scanner read, int num1, int num2, int question){
        System.out.println("Question " + question + ": What is the result of: " + num1 + " - " + num2+"?");
        System.out.print("Your answer (integer): ");
        int answer = read.nextInt();
        int result = num1-num2;
       return "Question " + question + ": What is the result of: " + num1 + " + " + num2+" = "+answer+" "+(answer == result);

    }
    public static String Division (int num1, int num2, int question){
        DecimalFormat cut = new DecimalFormat("#.##");/* The decimalFormat class I used so that in the division where there is a long number I can cut it two numbers after the decimal point.
       In this way the user just has to find three numbers after the decimal point and round it up.
       */
        Scanner read = new Scanner(System.in);
        double result= (double)num1/num2;
        String resultCut = cut.format(result); // The method will return a String so with the next line I convert resultCut into a double with parseDouble. In this way, I can compare the user's input with the answer.
        double final_result = Double.parseDouble(resultCut);
        System.out.println("Question " + question + ": What is the result of: " + num1 + " / " + num2+"?");
        System.out.print("Your answer (always with two numbers after the decimal point): ");
        double answer = read.nextDouble();
        return "Question " + question + ": What is the result of: " + num1 + " / " + num2+" = "+answer+" "+(answer == final_result);
    }
    public static void sheet (String input, String name){
        try (FileWriter file = new FileWriter(name+ "-answers.txt",true)){
            file.write(input+"\n");
        }catch (IOException e){
            System.out.println("oppa: " + e);
        }
    }
    public static String Multiplication (int num1, int num2, int question){
        Scanner read = new Scanner(System.in);
        int result= num1*num2;
        System.out.println("Question " + question + ": What is the result of: " + num1 + " * " + num2+"?");
        System.out.print("Your answer (integer): ");
        int answer = read.nextInt();
       return "Question " + question + ": What is the result of: " + num1 + " * " + num2+" = "+answer+" "+(answer == result);
    }
}
