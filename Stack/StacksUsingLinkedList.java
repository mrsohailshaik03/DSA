/**
 * Stack Implementation using Linked List
 * --------------------------------------
 * A stack is a linear data structure that follows the Last In First Out (LIFO) principle.
 * The element added last to the stack will be the first one to be removed.
 *
 * Operations:
 * -----------
 * 1. Push: Add an element to the top of the stack.
 * 2. Pop: Remove and return the top element of the stack.
 * 3. Peek: Return the top element without removing it.
 * 4. isEmpty: Check if the stack is empty.
 *
 * Implementation:
 * ---------------
 * Here, we implement a stack using a singly linked list.
 * Each node in the linked list contains data and a reference to the next node.
 */

public class StacksUsingLinkedList {

    // Node class represents each element in the stack
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Stack class with stack operations
    static class Stack {
        static Node head = null; // Top of the stack

        // Check if the stack is empty
        public static boolean isEmpty() {
            return head == null;
        }

        // Push operation: Add an element to the top of the stack
        public static void push(int data) {
            Node newNode = new Node(data);
            newNode.next = head; // Point new node to current head
            head = newNode;      // Update head to new node
        }

        // Pop operation: Remove and return the top element of the stack
        public static int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            int popped = head.data;
            head = head.next; // Move head to next node
            return popped;
        }

        // Peek operation: Return the top element without removing it
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            return head.data;
        }

        // Main method to demonstrate stack operations
        public static void main(String[] args) {
            Stack.push(1); // Stack: 1
            Stack.push(2); // Stack: 2 -> 1
            Stack.push(3); // Stack: 3 -> 2 -> 1

            // Print and remove elements from stack
            while (!Stack.isEmpty()) {
                System.out.println(Stack.peek()); // Print top element
                Stack.pop();                      // Remove top element
            }
        }
    }
}
