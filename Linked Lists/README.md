# Linked List Implementation in Java

A **Linked List** is a linear data structure where each element (node) contains data and a reference to the next node. This implementation provides a variety of operations for singly linked lists in Java.

---

## Features

- **Node Structure:** Each node stores integer data and a reference to the next node.
- **Head & Tail:** The list maintains references to the first (`head`) and last (`tail`) nodes.
- **Size Tracking:** The list tracks its size for efficient operations.

---



| Method                        | Description                                              |
|-------------------------------|---------------------------------------------------------|
| `addFirst(int data)`          | Adds a node at the beginning of the list                |
| `addLast(int data)`           | Adds a node at the end of the list                      |
| `addMiddle(int idx, int data)`| Adds a node at a specific index                         |
| `print()`                     | Prints the linked list                                  |
| `removeFirst()`               | Removes the first node and returns its value            |
| `removeLast()`                | Removes the last node and returns its value             |
| `iterativeSearch(int key)`    | Searches for a value iteratively and returns index      |
| `recursiveSearch(int key)`    | Searches for a value recursively and returns index      |
| `reverse()`                   | Reverses the linked list                               |
| `deleteNthFromEnd(int n)`     | Removes the Nth node from the end                      |
| `findMid(Node head)`          | Finds the middle node                                   |
| `checkPalindrome()`           | Checks if the list is a palindrome                      |
| `detectLoop()`                | Detects a cycle in the list (Floyd's Algorithm)         |
| `removeDuplicates()`          | Removes duplicate values from a sorted linked list      |
| `mergeSort(Node head)`        | Sorts the linked list using merge sort                  |
| `zigZag()`                    | Rearranges the list in zig-zag fashion                  |

---

## Example Usage

```java
public static void main(String[] args){
    LinkedList ll = new LinkedList();
    ll.addFirst(30);
    ll.addFirst(20);
    ll.addFirst(10);
    ll.addLast(50);
    ll.addLast(60);
    ll.addMiddle(3, 40);
    ll.print();
    ll.reverse();
    ll.print();
    ll.removeDuplicates();
    ll.print();
    ll.head = ll.mergeSort(ll.head);
    ll.print();
    ll.zigZag();
    ll.print();
}
```

---

## Full Code

See the `LinkedList/LinkedList.java` file for the complete implementation, including all methods listed above.

```java
public class LinkedList {
    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) { /* ... */ }
    public void addLast(int data) { /* ... */ }
    public void print() { /* ... */ }
    public void addMiddle(int idx, int data) { /* ... */ }
    public int removeFirst() { /* ... */ }
    public int removeLast() { /* ... */ }
    public int iterativeSearch(int key) { /* ... */ }
    public int recursiveSearch(int key) { /* ... */ }
    public void reverse() { /* ... */ }
    public void deleteNthFromEnd(int n) { /* ... */ }
    public Node findMid(Node head) { /* ... */ }
    public boolean checkPalindrome() { /* ... */ }
    public static boolean detectLoop() { /* ... */ }
    public void removeDuplicates() { /* ... */ }
    public Node mergeSort(Node head) { /* ... */ }
    public void zigZag() { /* ... */ }

    public static void main(String[] args) { /* ... */ }
}
```

> **Note:** For full method implementations, refer to the source code in the `LinkedList` folder.

---

## Key Algorithms

- **Reverse Linked List:** Iteratively reverses the links between nodes.
- **Find Middle Node:** Uses slow and fast pointers.
- **Check Palindrome:** Compares first half with reversed second half.
- **Detect Loop:** Floyd’s Cycle Detection (Tortoise and Hare).
- **Remove Duplicates:** Removes consecutive duplicate nodes in a sorted list.
- **Merge Sort:** Recursively sorts the linked list using merge sort.
- **Zig-Zag Rearrangement:** Rearranges nodes in zig-zag order.
## Additional Files

- **Doubly Linked List:**  
    See the [`LinkedList/DoublyLinkedList.java`](LinkedList/DoublyLinkedList.java) file for the implementation of a doubly linked list, which supports both forward and backward traversal.

- **Circular Linked List Notes:**  
    Refer to [`LinkedList/CircularLinkedList.pdf`](LinkedList/CircularLinkedList.pdf) for detailed notes and diagrams explaining circular linked lists.
---

## References

- [GeeksForGeeks: Linked List Data Structure](https://www.geeksforgeeks.org/data-structures/linked-list/)
- [Java Documentation](https://docs.oracle.com/en/java/)
