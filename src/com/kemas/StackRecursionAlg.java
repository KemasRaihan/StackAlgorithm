package com.kemas;

public class StackRecursionAlg {

    private static void reorganiseAndInsert(Stack stack, int item)
    {
        int temp;
        if(stack.isEmpty() || (item > stack.peek()))
        {
            stack.push(item);
            return;
        }

        temp = stack.pop();
        reorganiseAndInsert(stack, item);
        stack.push(temp);
    }

    public static Stack reorganise(Stack stack)
    {
        int item;
        if(!stack.isEmpty())
        {
            item = stack.pop();
            reorganise(stack);
            reorganiseAndInsert(stack, item);
        }

        return stack;
    }
}
