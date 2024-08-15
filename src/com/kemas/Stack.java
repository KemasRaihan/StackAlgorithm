package com.kemas;

import java.util.ArrayList;

/**Linked list implementation of a stack**/
public class Stack {
    final int max = 100000;

    /**AV: points to the next available node in the pool
     * max: maximum size of storage pool
     * n: number of memory cells for the linked list
     * start: points to the first node in the list **/
    int AV, top;

    /**DATA: holds the items
     * LINK: contains pointers to items in DATA
     * POOL_LINK: represents the storage pool**/
    int[] DATA, LINK, POOL_LINK;

    public Stack()
    {
        create();
    }

    //initialise the storage pool, through the LINK array, to contain nodes with addresses 1, 2, 3, ...., n and
    //set AV to point to the first node in this list.
    void initialiseStoragePool() {
        POOL_LINK = new int[max];
        for (int i = 0; i < max - 1; ++i) {
            POOL_LINK[i] = i + 1;
            }
        POOL_LINK[max - 1] = 0;
        AV = 1;

        //System.out.println("\nStorage pool has been initialised\n");

    }

    // returns pointer that points to the first available node
    int GETNODE() {
        int reference = 0;
        if(AV == 0) {
            System.out.println("Storage pool is full");
        }else {
            reference = AV;
            AV = POOL_LINK[AV];
        }

        return reference;
    }

    // reference points to a node that is to be returned to the storage pool
    void RETNODE(int reference) {
        POOL_LINK[reference] = AV;
        AV = reference;
    }

    // initialise stack
    void create() {
       top = 0;
       initialiseStoragePool();
       DATA = new int[max]; // create a DATA array of size max
        LINK = new int[max]; // create a LINK array of size max
    }

    // push an item into the top of the stack
    void push(int item) {
        // get random index
        int pointer = GETNODE();

        // add item to data
        DATA[top]=item;

        // item being added now points to previous top
        LINK[pointer] = top;

        // item being added becomes the element on top of the stack
        top = pointer;
    }

    // pop an item from the stack
    int pop() {
        int item = 0;
        if(isEmpty()) {
            System.out.println("Stack is empty");
        }
        else {
            item = DATA[top-1];
            RETNODE(top);
            top = LINK[top];
        }
        return item;
    }

    int peek(){
        if(!isEmpty())
            return DATA[top-1];
        return -1;
    }


    boolean isEmpty() {
        return (top==0);
    }

    // display all elements in the stack
    void display(){
        for(int i = 0; i < top; i++) {
            System.out.print(DATA[i] + ",");
        }
        System.out.println();
    }
}
