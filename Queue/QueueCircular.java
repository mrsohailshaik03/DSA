// Circular Queue using Array
// In a circular queue, the last position is connected back to the first position to make a circle.
// It follows the FIFO (First In First Out) principle but efficiently utilizes space by reusing
// the vacated positions when elements are removed from the front.
// Circular Queue allows for better memory utilization compared to a linear queue.

public class QueueCircular {
    public static class Queue {
        int[] arr;      // Array to store queue elements
        int rear;       // Points to the last element
        int size;       // Maximum size of the queue
        int front;      // Points to the first element

        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        // Check if the queue is empty
        public boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        // Check if the queue is full
        public boolean isFull() {
            return (rear + 1) % size == front;
        }

        // Add an element to the queue
        public void add(int data) {
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }
            if (front == -1) {
                front = 0; // Initialize front when adding the first element
            }
            rear = (rear + 1) % size; // Correct operator precedence
            arr[rear] = data;
        }

        // Remove and return the front element from the queue
        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int result = arr[front];
            // If only one element was present
            if (rear == front) {
                rear = front = -1;
            } else {
                front = (front + 1) % size; // Correct operator precedence
            }
            return result;
        }

        // Peek at the front element without removing it
        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[front];
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(3);
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.remove());
        q.add(4);
        System.out.println(q.remove());
        q.add(5);
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
