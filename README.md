# Stack Algorithm

The algorithm uses stack operations to sort an array since only one element at the top can be moved.
It reorganises the elements in the stack data structure by using recursion. The algorithm uses two recursive methods  to do so. 

Suppose the set of elements are represented with the values 1,1,2,2,3,4. Let D be a linked list
implementation of a stack containing the elements. Here we can
represent the data as such:

<img width="371" alt="image" src="https://github.com/user-attachments/assets/d17a6246-97e7-4e71-9ff3-5f12b6cf576c">

Figure - conceptual linked list representation of the stack

An array was originally considered to represent both the input stack and the sorted stack. 
However, if we examine the worst case scenario of a push operation for the array implementation; 
the maximum capacity of the input stack could exceed that of the temporary stack thus it would result in the array for the temporary stack to be filled. 
Consequently, the time complexity of pushing an item to be O(n), since the array size has to be changed and all elements in the array need to be copied from one array to another.  
In the end, as the algorithm requires stack push operations, it would be appropriate to approach the linked list implementation, since the time complexity remains constant at O(1) and there is space efficiency. 
