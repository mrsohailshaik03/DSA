public class Sorting {

    // Bubble-Sort
    public static void bubble_sort(int number[]) {
        for (int turn = 0; turn < number.length; turn++) {
            for (int j = 0; j < number.length - turn - 1; j++) {
                if (number[j] > number[j + 1]) {
                    //
                    int temp = number[j];
                    number[j] = number[j + 1];
                    number[j + 1] = temp;
                }
            }
        }
    }

    // Selection-sort
    public static void selectionSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minPos] > arr[i]) {
                    minPos = j;
                }
            }
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }
    }

    // Insertion-sort
    public static void insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int prev = i - 1;
            while (prev >= 0 && arr[prev] > current) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            // insert current at the correct position
            arr[prev + 1] = current;
        }
    }


    // Counting-sort
    public static void countingSort(int arr[]) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int count[] = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        // sorting the array
        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[j++] = i;
                count[i]--;
            }
        }
    }

    public static void printArray(int number[]) {
        for (int i = 0; i < number.length; i++) {
            System.out.print(number[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int numbers[] = { 2, 5, 6, 8, 1, 7 };
        bubble_sort(numbers);
        printArray(numbers);
    }
}