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
public class LinkedList{
    // Node definition: stores data and reference to next node
    public static class Node{
        int data;
        Node next;
        
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    // Head and tail references, and size of the list
    public static Node head;
    public static Node tail;
    public static int size;

    // Adds a node at the beginning of the list
    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        // If list is empty, head and tail are the new node
        if(head == null){
            head = tail = newNode;
            return;
        }
        // Otherwise, insert at the beginning
        newNode.next = head;
        head = newNode;
    }

    // Adds a node at the end of the list
    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        // If list is empty, head and tail are the new node
        if(head == null){
            head = tail = newNode;
            return;
        }
        // Otherwise, insert at the end
        tail.next = newNode;
        tail = newNode;
    }

    // Prints the linked list
    public void print(){
        Node temp = head;
        if(head == null){
            System.out.println("LL is empty");
            return;
        }
        while(temp != null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Adds a node at a specific index (middle)
    public void addMiddle(int idx, int data){
        if(idx == 0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        // Traverse to the node before the desired index
        while(i < idx-1){
            temp = temp.next;
            i++;
        }
        // Insert the new node
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Removes the first node and returns its value
    public int removeFirst(){
        if(size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }else if(size==1){
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
    public int removeLast(){
        if(size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val = head.data;
            head = tail = null;
            size=0;
            return val;
        }
        // Traverse to the second last node
        Node prev = head;
        for(int i=0; i<size-2; i++){
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    // Iteratively searches for a key and returns its index, or -1 if not found
    public int iterativeSearch(int key){
        Node temp = head;
        int i = 0;
        while(temp != null){
            if(temp.data == key){ //Key found
                return i;
            }
            temp = temp.next;
            i++;
        }
        // Key Not Found
        return -1;
    }

    // Helper for recursive search
    public int helper(Node head, int key){
        if(head == null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }
        int subIdx = helper(head.next, key);
        if(subIdx == -1){
            return -1;
        }
        return subIdx+1;
    }

    // Recursively searches for a key and returns its index, or -1 if not found
    public int recursiveSearch(int key){
        return helper(head, key);
    }

    // Reverse a linked list using iterative approach
    // 1. next = curr.next;
    // 2. curr.next = prev;
    // 3. prev = curr;
    // 4. curr = next;
    public void reverse(){
        Node prev = null;
        Node curr = tail = head; // Start with head
        Node next;
        while(curr != null){
            next = curr.next; // Store next node
            curr.next = prev; // Reverse the link
            prev = curr;      // Move prev to current
            curr = next;      // Move to next node
        }
        head = prev; // Update head to the new first node
    }
    // Removes the Nth node from the end of the linked list
    public void deleteNthFromEnd(int n){
        // Step 1: Calculate the size of the linked list
        int sz = 0;
        Node temp = head;
        while(temp != null){
            sz++;
            temp = temp.next;
        }
        // Step 2: If n equals the size, remove the first node
        if(n == sz){
            head = head.next; // Remove the first node
            return;
        }
        // Step 3: Find the node just before the Nth node from end
        int i = 1;
        int iToFind = sz - n;
        Node prev = head;
        while(i < iToFind){
            prev = prev.next;
            i++;
        }
        // Step 4: Remove the Nth node from end
        prev.next = prev.next.next;
    }


    // Finding the middle node of the Linked List usind the slow and fast pointer technique
    // 1. Initialize two pointers, slow and fast, both pointing to the head.
    // 2. Move slow by one step and fast by two steps in each iteration.
    // 3. When fast reaches the end, slow will be at the middle.
    // 4. Return the middle node.
    // This method returns the middle node of the linked list
    // If the list has an even number of nodes, it returns the second middle node.
    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next; // Move slow by 1
            fast = fast.next.next; // Move fast by 2
        }
        return slow; // Return the middle node
    }

    // Check if the linked list is a palindrome
    // 1. Find the middle node using the findMid method.
    // 2. Reverse the second half of the linked list.
    // 3. Compare the first half with the reversed second half.
    public boolean checkPalindrome(){
        if(head == null || head.next == null){
            return true; // Empty or single node list is a palindrome
        }

        Node mid = findMid(head); // Find the middle node

        Node prev = null;
        Node curr = mid;
        Node next;

        // Reverse the second half of the linked list
        while(curr != null){
            next = curr.next; // Store next node
            curr.next = prev; // Reverse the link
            prev = curr;      // Move prev to current
            curr = next;      // Move to next node
        }

        // Compare first half and reversed second half
        Node left = head;
        Node right = prev; // Start from the end of the original second half

        while(right != null){
            if(left.data != right.data){
                return false; // Not a palindrome
            }
            left = left.next;
            right = right.next;
        }
        return true; // Is a palindrome
    }

    // Main method: demonstrates creation and operations on LinkedList
    public static void main(String[] args){
        LinkedList ll = new LinkedList();
        ll.addFirst(30);      // Add 30 at beginning
        ll.addFirst(20);      // Add 20 at beginning
        ll.addFirst(10);      // Add 10 at beginning
        ll.addLast(50);       // Add 50 at end
        ll.addLast(60);       // Add 60 at end
        ll.addMiddle(3, 40);  // Add 40 at index 3
        ll.print();           // Print the list
        // System.out.println(LinkedList.size); // Print size of the list
        ll.reverse();      // Reverse the linked list
        ll.print();           // Print the reversed list
    }
}