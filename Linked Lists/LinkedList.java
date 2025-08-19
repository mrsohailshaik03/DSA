// LinkedList Implementation in Java
// ---------------------------------
// Definition:
// A Linked List is a linear data structure where elements (nodes) are stored in non-contiguous memory locations.
// Each node contains data and a reference (pointer) to the next node in the sequence.

// Operations Implemented:
// 1. addFirst(int data)      : Adds a node at the beginning of the list.
// 2. addLast(int data)       : Adds a node at the end of the list.
// 3. addMiddle(int idx, int data) : Adds a node at a specific index.
// 4. print()                 : Prints the linked list.
// 5. removeFirst()           : Removes the first node and returns its value.
// 6. removeLast()            : Removes the last node and returns its value.
// 7. iterativeSearch(int key): Searches for a value iteratively and returns its index.
// 8. recursiveSearch(int key): Searches for a value recursively and returns its index.

// Creation of LinkedList:
// - The LinkedList class contains a static inner Node class.
// - Each Node has an integer data and a reference to the next Node.
// - The LinkedList maintains references to head and tail nodes, and tracks its size.

// Example Usage (see main method):
// - Create a LinkedList object.
// - Add nodes using addFirst, addLast, and addMiddle.
// - Print the list and its size.

// Code:
public class LinkedList {
    // Node definition: stores data and reference to next node
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head and tail references, and size of the list
    public static Node head;
    public static Node tail;
    public int size;

    // Adds a node at the beginning of the list
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        // If list is empty, head and tail are the new node
        if (head == null) {
            head = tail = newNode;
            return;
        }
        // Otherwise, insert at the beginning
        newNode.next = head;
        head = newNode;
    }

    // Adds a node at the end of the list
    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        // If list is empty, head and tail are the new node
        if (head == null) {
            head = tail = newNode;
            return;
        }
        // Otherwise, insert at the end
        tail.next = newNode;
        tail = newNode;
    }

    // Prints the linked list
    public void print() {
        Node temp = head;
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Adds a node at a specific index (middle)
    public void addMiddle(int idx, int data) {
        if (idx == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        // Traverse to the node before the desired index
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }
        // Insert the new node
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Removes the first node and returns its value
    public int removeFirst() {
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    // Removes the last node and returns its value
    public int removeLast() {
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        // Traverse to the second last node
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    // Iteratively searches for a key and returns its index, or -1 if not found
    public int iterativeSearch(int key) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) { // Key found
                return i;
            }
            temp = temp.next;
            i++;
        }
        // Key Not Found
        return -1;
    }

    // Helper for recursive search
    public int helper(Node head, int key) {
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int subIdx = helper(head.next, key);
        if (subIdx == -1) {
            return -1;
        }
        return subIdx + 1;
    }

    // Recursively searches for a key and returns its index, or -1 if not found
    public int recursiveSearch(int key) {
        return helper(head, key);
    }

    // Reverse a linked list using iterative approach
    // 1. next = curr.next;
    // 2. curr.next = prev;
    // 3. prev = curr;
    // 4. curr = next;
    public void reverse() {
        Node prev = null;
        Node curr = tail = head; // Start with head
        Node next;
        while (curr != null) {
            next = curr.next; // Store next node
            curr.next = prev; // Reverse the link
            prev = curr; // Move prev to current
            curr = next; // Move to next node
        }
        head = prev; // Update head to the new first node
    }

    // Removes the Nth node from the end of the linked list
    public void deleteNthFromEnd(int n) {
        // Step 1: Calculate the size of the linked list
        int sz = 0;
        Node temp = head;
        while (temp != null) {
            sz++;
            temp = temp.next;
        }
        // Step 2: If n equals the size, remove the first node
        if (n == sz) {
            head = head.next; // Remove the first node
            return;
        }
        // Step 3: Find the node just before the Nth node from end
        int i = 1;
        int iToFind = sz - n;
        Node prev = head;
        while (i < iToFind) {
            prev = prev.next;
            i++;
        }
        // Step 4: Remove the Nth node from end
        prev.next = prev.next.next;
    }

    // Finding the middle node of the Linked List usind the slow and fast pointer
    // technique
    // 1. Initialize two pointers, slow and fast, both pointing to the head.
    // 2. Move slow by one step and fast by two steps in each iteration.
    // 3. When fast reaches the end, slow will be at the middle.
    // 4. Return the middle node.
    // This method returns the middle node of the linked list
    // If the list has an even number of nodes, it returns the second middle node.
    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow by 1
            fast = fast.next.next; // Move fast by 2
        }
        return slow; // Return the middle node
    }

    // Check if the linked list is a palindrome
    // 1. Find the middle node using the findMid method.
    // 2. Reverse the second half of the linked list.
    // 3. Compare the first half with the reversed second half.
    public boolean checkPalindrome() {
        if (head == null || head.next == null) {
            return true; // Empty or single node list is a palindrome
        }

        Node mid = findMid(head); // Find the middle node

        Node prev = null;
        Node curr = mid;
        Node next;

        // Reverse the second half of the linked list
        while (curr != null) {
            next = curr.next; // Store next node
            curr.next = prev; // Reverse the link
            prev = curr; // Move prev to current
            curr = next; // Move to next node
        }

        // Compare first half and reversed second half
        Node left = head;
        Node right = prev; // Start from the end of the original second half

        while (right != null) {
            if (left.data != right.data) {
                return false; // Not a palindrome
            }
            left = left.next;
            right = right.next;
        }
        return true; // Is a palindrome
    }

    // Detect a loop/cycle in a LinkedList
    // Floyd's Cycle Detection Algorithm (Tortoise and Hare)
    // 1. Initialize two pointers, slow and fast.
    // 2. Move slow by one step and fast by two steps.
    // 3. If they meet, there is a cycle; otherwise, if fast reaches null, there is
    // no cycle.
    public static boolean detectLoop() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow by 1
            fast = fast.next.next; // Move fast by 2
            if (slow == fast) { // Cycle detected
                return true;
            }
        }
        return false; // No cycle
    }

    // Merge Sort on a Linked List
    public static Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // Return the middle node
    }

    // Merge two sorted linked lists
    public static Node merge(Node head1, Node head2) {
        Node mergedLL = new Node(-1); // Dummy node
        Node temp = mergedLL; // Pointer to build the new list
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                temp.next = head1; // Attach head1 to merged list
                head1 = head1.next; // Move head1 forward
            } else {
                temp.next = head2; // Attach head2 to merged list
                head2 = head2.next; // Move head2 forward
            }
            temp = temp.next; // Move temp forward
        }
        while (head1 != null) {
            temp.next = head1; // Attach remaining nodes of head1
            head1 = head1.next; // Move head1 forward
            temp = temp.next; // Move temp forward
        }
        while (head2 != null) {
            temp.next = head2; // Attach remaining nodes of head2
            head2 = head2.next; // Move head2 forward
            temp = temp.next; // Move temp forward
        }
        return mergedLL.next; // Return the merged list, skipping the dummy node
    }

    // Merge Sort for Linked List
    // Sorts the linked list using the merge sort algorithm
    // 1. Find the middle of the list to split it into two halves.
    // 2. Recursively sort each half.
    // 3. Merge the two sorted halves.
    public static Node mergeSort(Node head) {
        // Base case: if the list is empty or has one node, it's already sorted
        if (head == null || head.next == null) {
            return head;
        }
        // Step 1: Get the middle node to split the list
        Node mid = getMid(head);
        Node rightHead = mid.next; // Start of the right half
        mid.next = null; // Split the list into two halves

        // Step 2: Recursively sort the left and right halves
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        // Step 3: Merge the sorted halves and return the merged list
        return merge(newLeft, newRight);
    }

    /**
     * Converts the current linked list into a zigzag linked list.
     * <p>
     * In a zigzag linked list, the nodes are rearranged such that the elements are
     * ordered as:
     * first node < second node > third node < fourth node > fifth node ... and so
     * on.
     * This means that every even-indexed node (starting from index 0) is less than
     * its next node,
     * and every odd-indexed node is greater than its next node, if such a node
     * exists.
     * <p>
     * The method should rearrange the nodes in-place without using extra space for
     * another list.
     * After execution, the linked list will follow the zigzag pattern.
     * Example:
     * Input: 1 -> 2 -> 3 -> 4 -> 5
     * Output: 1 -> 3 -> 2 -> 5 -> 4
     *
     * Note: If the linked list is empty, the method will not perform any operation.
     */

    public void zigZag() {
        // Check if the list is empty or has only one node
        if (head == null || head.next == null) {
            return;
        }
        // Find Mid
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow by 1
            fast = fast.next.next; // Move fast by 2
        }
        Node mid = slow; // Mid is the slow pointer
        // Reverse the second half of the linked list
        Node curr = mid.next;
        mid.next = null; // Split the list into two halves
        Node prev = null;
        Node next;
        while (curr != null) {
            next = curr.next; // Store next node
            curr.next = prev; // Reverse the link
            prev = curr; // Move prev to current
            curr = next; // Move to next node
        }
        Node left = head; // Start from the head of the first half
        Node right = prev; // Start from the head of the reversed second half
        Node nextL, nextR; // Pointers to store next nodes
        // Rearrange nodes in zigzag order
        while (left != null && right != null) {
            nextL = left.next;
            left.next = right; // Link left to right
            nextR = right.next;
            right.next = nextL; // Link right to next left

            // Move to the next nodes
            left = nextL;
            right = nextR;
        }
    }

    // Main method: demonstrates creation and operations on LinkedList
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
    }
}