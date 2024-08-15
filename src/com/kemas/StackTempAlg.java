package com.kemas;

public class StackTempAlg {

    // given a stack of integers, sort the stack in ascending order
    public static Stack reorganise(Stack inputStack){
       int temp;

        // initialise tempStack
        Stack tempStack = new Stack();

        // complete sorting once inputStack contains no elements
        while(!inputStack.isEmpty()){

            // assign element on top of inputStack to temp
            temp = inputStack.pop();

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
       transfer(tempStack, inputStack);

        return inputStack;


    }

    public static void transfer(Stack original, Stack result)
    {
        while(!original.isEmpty())
        {
            result.push(original.pop());
        }

    }
}
