## Stack Data Structure in Java

A **stack** is a linear data structure that follows the Last-In-First-Out (LIFO) principle. This means the last element added to the stack is the first one to be removed. Stacks are commonly used for function call management, expression evaluation, undo mechanisms, and more.

### Key Operations

- **push**: Add an element to the top of the stack.
- **pop**: Remove and return the top element.
- **peek**: View the top element without removing it.
- **isEmpty**: Check if the stack is empty.

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

Both implementations support the standard stack operations. Choose the one that best fits your use case.
