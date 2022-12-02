package com.kemas;

import java.util.Scanner;

public class SortStackTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String option;
        do {
            System.out.print("\nWelcome to sort stack testing. Please enter '1' to sort a stack or '2' to exit: ");
            option = input.next();
            switch(option) {
                case "1": enterStack(input);break; // user chooses to sort stacks
                case "2": System.out.println("Goodbye!"); break; // user chooses to exit the system
                default: System.out.println("Invalid option, please try again!"); // user enters an invalid input
            }
        }while(!option.equals("2"));
        input.close();
    }

    public static void enterStack(Scanner input){
        // initialise the input stack
        Stack<Integer> inputStack = new Stack();
        inputStack.create();

        int number;

        System.out.println("Please enter an integer to push into the stack or enter '0' to finish: ");
        number=input.nextInt();
        while(number>0){
            // push input number into the input stack
            inputStack.push(number);
            number=input.nextInt();
        }
        displayBeforeAndAfter(inputStack);
    }

    // display input stack before and after sorting
    public static void displayBeforeAndAfter(Stack inputStack){
        System.out.println("Stack before sorting: ");
        inputStack.display(); // display initial stack

        System.out.println("Stack after sorting: ");
        SortStack.sortPlates(inputStack).display(); // display sorted stack
    }
}
