package com.kemas;

import java.util.Scanner;

public class StackTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Stack stack = new Stack();

       System.out.print("Welcome to Stack Testing. Press Enter to initialise stack...");
       input.nextLine();

       stack.initialiseStoragePool();
       stack.create();

       String option;
       do{
           System.out.println();
           System.out.print("Stack: ");
           stack.display();
           System.out.println();
           System.out.println("1. Peek at stack.");
           System.out.println("2. Push an item on top of the stack.");
           System.out.println("3. Pop an item from top of the stack.");
           System.out.println("9. Exit.");
           System.out.print("\n\nChoose an option: ");
           option = input.next();
           switch(option) {
               case "1":
                   if(stack.isEmpty()) System.out.println("Stack is currently empty.");
                   else System.out.print("Item on top of stack: " + stack.peek());
                   break;
               case "2":
                   System.out.print("\nEnter the item to push onto the stack: ");
                   int element = input.nextInt();
                   stack.push(element);
                   System.out.println();
                   break;
               case "3":
                   if(stack.isEmpty()) System.out.println("\nStack is currently empty.");
                   else {
                       stack.pop();
                       System.out.println("Item on top has been removed.");
                   }
                   break;
               case "9":
                   System.out.println("\nGoodbye!");
                   break;
               default:
                   System.out.println("\nInvalid option. Please try again");
           }
       }while(!option.equals("9"));
       input.close();
    }
}
