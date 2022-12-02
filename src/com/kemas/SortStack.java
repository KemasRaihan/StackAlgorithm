package com.kemas;

public class SortStack {

    // given a stack of integers, sort the stack in ascending order
    public static Stack sortPlates(Stack inputStack){
        int temp;

        // initialise tempStack
        Stack<Integer> tempStack = new Stack();
        tempStack.create();

        // complete sorting once inputStack contains no elements
        while(!inputStack.isEmpty()){

            // assign element on top of inputStack to temp
            temp = (int) inputStack.pop();

            // push elements from tempStack to inputStack while
            // tempStack is not empty
            // the element on top of tempStack is larger than temp
            while(!tempStack.isEmpty() && (tempStack.peek() < temp)){
                inputStack.push(tempStack.pop());
            }

            // push temp to tempStack
            tempStack.push(temp);
//
//            System.out.println("\ntemp = " + temp);
//            System.out.print("Input Stack: ");
//            inputStack.display();
//            System.out.print("Temporary Stack: ");
//            tempStack.display();
        }

        return tempStack;
    }
}
