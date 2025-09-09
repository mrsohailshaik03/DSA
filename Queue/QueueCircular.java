// Circular Queue using Array
// In a circular queue, the last position is connected back to the first position to make a circle.
// It follows the FIFO (First In First Out) principle but efficiently utilizes space by reusing
// the vacated positions when elements are removed from the front.
// Circular Queue allows for better memory utilization compared to a linear queue.


public class QueueCircular {
    public static class Queue{
        static int[] arr;
        static int rear;
        static int size;
        Queue(int n){
            arr = new int[n];
            size = n;
            rear = -1;
        }
        public boolean isEmpty(){
            return rear == -1;
        }
        // Add
        public void add(int data){
            if(rear==size-1){
                System.out.println("Queue is full");
                return;
            }
            rear = rear+1;
            arr[rear] = data;
        }
        // Remove
        public int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int front = arr[0];
            // Shift elements to the left
            // This loop should go up to rear, not rear-1, to correctly shift the last element
            // If rear is 0, this loop won't run, which is correct for a single element queue
            for(int i=0;i<rear;i++){ 
                arr[i] = arr[i+1];
            }
            rear = rear-1;
            return front;
        }
        // Peek
        public int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[0];
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue(3);
        q.add(1);
        q.add(2);
        q.add(3);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
