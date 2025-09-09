public class DoubleLL{
    public static class Node{
        int data;
        Node next;
        Node prev;
        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;
    public static int size;

    // Add first
    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            size++;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        size++;
    }

    // Add last
    public void addLast(int data){
        Node newNode = new Node(data);
        if(tail == null){
            head = tail = newNode;
            size = 1;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;
    }

    // print list
    public void printList(){
        Node current = head;
        while(current != null){
            System.out.print(current.data + "<->");
            current = current.next;
        }
        System.out.println("null");
    }

    // Remove first
    public int removeFirst(){
        if(head == null) System.out.println("List is empty");
        if(head == tail){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        {
            int val = head.data;
            head = head.next;
            head.prev = null;
            size--;
            return val;
        }
    }
    // Remove last
    public int removeLast(){
        if(head == null) System.out.println("List is empty");
        if(head == tail){
            int val = tail.data;
            head = tail = null;
            size = 0;
            return val;
        }
        {
            int val = tail.data;
            tail = tail.prev;
            tail.next = null;
            size--;
            return val;
        }
    }
    // Reverse the list
    public void reverse(){
        Node curr = head;
        Node prev = null;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    public static void main(String args[]){
        DoubleLL ll = new DoubleLL();
        ll.addFirst(10);
        ll.addLast(20);
        ll.addFirst(5);
        ll.printList();
        System.out.println(DoubleLL.size);
        ll.reverse();
        ll.printList();
    }
}