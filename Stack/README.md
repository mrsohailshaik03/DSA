<!--
Stack Data Structure Documentation
==================================

Definition:
-----------
A **Stack** is a linear data structure that follows the Last-In-First-Out (LIFO) principle. This means the element that is added last will be the first one to be removed. Stacks are widely used in programming for their simplicity and utility in various algorithms and system processes.

Main Operations:
----------------
1. **push(x)**: Inserts element `x` onto the top of the stack.
2. **pop()**: Removes and returns the top element from the stack. If the stack is empty, an error value (e.g., -1) is returned.
3. **peek()**: Returns the top element without removing it from the stack. If the stack is empty, an error value (e.g., -1) is returned.
4. **isEmpty()**: Checks if the stack is empty and returns a boolean value.

Applications:
-------------
- Expression evaluation and syntax parsing (e.g., evaluating postfix expressions)
- Undo mechanisms in text editors and other applications
- Backtracking algorithms (such as maze solving and recursion)
- Function call management in programming languages (call stack)

Implementations:
----------------
- **ArrayList-based Stack**: Utilizes Java's `ArrayList` to store stack elements, allowing dynamic resizing and efficient addition/removal from the end.
- **Linked List-based Stack**: Uses a singly linked list where each node represents an element in the stack, providing efficient push and pop operations at the head of the list.

Both implementations support the standard stack operations and can be chosen based on specific requirements such as memory usage and performance characteristics.
-->
## Stack Implementations in Java

This section provides Java implementations of the Stack data structure using both `ArrayList` and a `singly linked list`. Each implementation includes the main stack operations and example usage.

---

### Stack Using ArrayList

```java
import java.util.ArrayList;

public class StacksUsingArrayList {
    static class Stack {
        static ArrayList<Integer> list = new ArrayList<>();

        public static boolean isEmpty() {
            return list.size() == 0;
        }

        public static void push(int data) {
            list.add(data);
        }

        public static int pop() {
            if (isEmpty()) {
                return -1;
            }
            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }

        public static int peek() {
            if (isEmpty()) {
                return -1;
            }
            return list.get(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
```

---

### Stack Using Linked List

```java
public class StacksUsingLinkedList {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Stack {
        static Node head = null;

        public static boolean isEmpty() {
            return head == null;
        }

        public static void push(int data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }

        public static int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            int popped = head.data;
            head = head.next;
            return popped;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            return head.data;
        }

        public static void main(String[] args) {
            Stack s = new Stack();
            s.push(1);
            s.push(2);
            s.push(3);

            while (!s.isEmpty()) {
                System.out.println(s.peek());
                s.pop();
            }
        }
    }
}
```

---

Both implementations support the standard stack operations: `push`, `pop`, `peek`, and `isEmpty`. Use the implementation that best fits your requirements.