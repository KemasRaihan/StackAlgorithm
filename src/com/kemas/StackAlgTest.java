package com.kemas;

import java.util.ArrayList;
import java.util.Scanner;

public class StackAlgTest {

    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        String option;
        do {
            System.out.println("\nWelcome to stack algorithm testing");
            System.out.println("1. Temporary stack algorithm.");
            System.out.println("2. Recursion algorithm.");
            System.out.println("3. Compare two algorithms.");
            System.out.println("9. Quit.");
            System.out.print("Enter an option: ");
            option = input.next();
            switch(option) {
                case "1": enterStack(1);break; // user chooses to reorganise stack using the temporary stack algorithm
                case "2": enterStack(2);break; // user chooses to reorganise stack using the recursion algorithm
                case "3": compare(); break; // user chooses to compare the two algorithms
                case "9": System.out.println("Goodbye!"); break; // user chooses to exit the system
                default: System.out.println("Invalid option, please try again!"); // user enters an invalid input
            }
        }while(!option.equals("9"));
        input.close();
    }

    public static void enterStack(int option){
        // initialise the input stack
        Stack inputStack = new Stack();

        int n;

        System.out.println("Please enter the number of random integers to be sorted: ");
        n=input.nextInt();

        // generate random dataset
        ArrayList<Integer> dataset = new ArrayList<>();
        dataset = Data.genData(n);

        // push dataset into the stack
        for(int i = 0; i < n; i++)
            inputStack.push(dataset.get(i));

        if(option==1)
            tempStack(inputStack);
        else
            recursion(inputStack);
    }

    public static void compare(){
        Stack usingTemp = new Stack();
        Stack usingRecursion = new Stack();



        System.out.println("Enter the number of iterations: ");
        int n = input.nextInt();

        int[] iterations = new int[n];

        double[] timeUsingTemp = new double[n];
        double[] timeUsingRecursion = new double[n];

        // generate random dataset
        ArrayList<Integer> dataset;

        long start, end;
        double time;

        for(int i = 1; i <= n; i++){

            // record iteration
            iterations[i-1] = i;

            // initialise new stacks
            usingTemp = new Stack();
            usingRecursion = new Stack();

            // generate new random dataset
            dataset = Data.genData(i);

            // for each number of dataset, push the values into each stack
            for(int j = 0; j < i; j++){
                usingTemp.push(dataset.get(j));
                usingRecursion.push(dataset.get(j));
            }

//            System.out.println("usingTemp before: ");
//            usingTemp.display();

            // calculate the time using the first algortihm
            start = System.currentTimeMillis();
            StackTempAlg.reorganise(usingTemp);
            end = System.currentTimeMillis();
            time = (double)(end - start);

//            System.out.println("usingTemp after: ");
//            usingTemp.display();

            // record the time it takes
            timeUsingTemp[i-1] = time;

//            System.out.println("usingRecursion before: ");
//            usingRecursion.display();

            // calculate the time using the second algortihm
            start = System.currentTimeMillis();
            StackRecursionAlg.reorganise(usingRecursion);
            end = System.currentTimeMillis();
            time = (double)(end - start);

//            System.out.println("usingRecursion after: ");
//            usingRecursion.display();

            // record the time it takes
            timeUsingRecursion[i-1] = time;

        }

        // display results
        System.out.println("Number of elements\tTime using temp stack (in ms)\tTime using recursion (in ms)");
        for(int i = 0; i < n; i+=100){
            System.out.print(iterations[i]+"\t\t\t\t"+timeUsingTemp[i]+"\t\t\t\t"+timeUsingRecursion[i]);
            System.out.println();
        }

        Data.writeResult(iterations, timeUsingTemp, timeUsingRecursion);


    }

    public double calcAvg(Stack stack){
        double time = 0;
        return time;
    }

    // display input stack before and after sorting
    public static void tempStack(Stack inputStack){

        System.out.println("Stack before sorting: ");
        inputStack.display(); // display initial stack

        Stack result = StackTempAlg.reorganise(inputStack);

        System.out.println("Stack after sorting: ");
        result.display(); // display stack after algorithm

    }

    public static void recursion(Stack inputStack){
        System.out.println("Stack before sorting: ");
        inputStack.display(); // display initial stack

        Stack result = StackRecursionAlg.reorganise(inputStack);

        System.out.println("Stack after sorting: ");
        result.display(); // display stack after algorithm

    }
}
