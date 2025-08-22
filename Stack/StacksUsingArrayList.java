/*
 * StacksUsingArrayList.java
 *
 * Definition of Stack:
 * --------------------
 * A Stack is a linear data structure that follows the Last-In-First-Out (LIFO) principle.
 * This means the element that is added last will be removed first.
 *
 * Main Operations of Stack:
 * 1. push(x): Insert element x onto the stack.
 * 2. pop(): Remove and return the top element from the stack.
 * 3. peek(): Return the top element without removing it.
 * 4. isEmpty(): Check if the stack is empty.
 *
 * Applications of Stack:
 * - Expression evaluation and syntax parsing
 * - Undo mechanisms in editors
 * - Backtracking algorithms (like maze, recursion)
 * - Function call management in programming languages
 * 
 * Implementation:
 * ---------------
 * Here, we implement a stack using Java's ArrayList.
 * ArrayList provides dynamic array features, making it easy to add/remove elements from the end.
 */

import java.util.ArrayList;

public class StacksUsingArrayList {
    // Stack class using ArrayList for storage
    static class Stack {
        // ArrayList to store stack elements
        static ArrayList<Integer> list = new ArrayList<>();

        // Checks if the stack is empty
        public static boolean isEmpty() {
            return list.size() == 0;
        }

        // Push operation: Adds an element to the top of the stack
        public static void push(int data) {
            list.add(data);
        }

        // Pop operation: Removes and returns the top element of the stack
        public static int pop() {
            if (isEmpty()) {
                // If stack is empty, return -1 as error value
                return -1;
            }
            int top = list.get(list.size() - 1); // Get the last element
            list.remove(list.size() - 1);        // Remove the last element
            return top;                          // Return the popped element
        }

        // Peek operation: Returns the top element without removing it
        public static int peek() {
            if (isEmpty()) {
                // If stack is empty, return -1 as error value
                return -1;
            }
            return list.get(list.size() - 1);    // Return the last element
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();

        // Push elements onto the stack
        s.push(1);
        s.push(2);
        s.push(3);

        // Pop and print all elements from the stack
        while (!s.isEmpty()) {
            System.out.println(s.peek()); // Print the top element
            s.pop();                      // Remove the top element
        }
    }
}