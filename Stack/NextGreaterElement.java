import java.util.*;
class NextGreaterElement{
    public static void main(String[] args) {
        int arr[] = { 2, 7, 3, 4, 6, 5, 1};
        Stack<Integer> s = new Stack<>();
        int nextGreater[] = new int[arr.length];
        for(int i = arr.length-1; i>=0; i--){
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nextGreater[i] = -1;
            }
            else{
                nextGreater[i] = arr[s.peek()];
            }
            s.push(i);
        }
        for(int i=0; i<nextGreater.length; i++){
            System.out.print(nextGreater[i] + " ");
        }
    }
}