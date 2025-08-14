 
class basic {

    // Linear Search
    public static int linearSearch(int number[], int key) {
        for (int i = 0; i < number.length; i++) {
            if (number[i] == key) {
                return i;
            }
        }
        return -1;
    }

    // Largest and smallest of an array
    public static int getLargestAndSmallest(int numbers[]) {
        int largest = Integer.MIN_VALUE; // -infinity
        int smallest = Integer.MAX_VALUE; // +infinity

        for (int i = 0; i < numbers.length; i++) {
            if (largest < numbers[i]) {
                largest = numbers[i];
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            if (smallest > numbers[i]) {
                smallest = numbers[i];
            }
        }

        System.out.println("Smallest value is " + smallest);
        return largest;
    }

    // Binary Search
    public static int binarySearch(int number[], int key) {
        int start = 0;
        int end = number.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (number[mid] == key) {
                return mid;
            }
            if (number[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    // Reversing an Array
    public static void reverseArray(int number[]) {
        int first = 0;
        int last = number.length - 1;

        while (first < last) {
            // Swap
            int temp = number[last];
            number[last] = number[first];
            number[first] = temp;

            first++;
            last--;
        }
    }

    public static void printPairs(int number[]) {
        int tp = 0;
        for (int i = 0; i < number.length; i++) {
            int curr = number[i];
            for (int j = i + 1; j < number.length; j++) {
                System.out.print("(" + curr + "," + number[j] + ")");
                tp++;
            }
            System.out.println();
        }
    }

    // Print sub-arrays of an Array
    public static void printSubArrays(int number[]) {
        // int tsa = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < number.length; i++) {
            int start = i;
            for (int j = i; j < number.length; j++) {
                int end = j;
                int sum = 0;
                for (int k = start; k <= end; k++) {
                    // System.out.print(number[k] + ",");
                    sum = sum + number[k];
                }
                if (sum > maxSum) {
                    maxSum = sum;
                }
                // tsa++;
                System.out.print("  ");
                System.out.print("sum = " + sum + " | ");
            }
            System.out.println();
        }
        System.out.println("Maximum sum of array = " + maxSum);
    }

    // KADANE'S ALGORITHM
    // This algorithm is used to find the maximum sum of a subarray in linear time.
    public static void kadanes(int number[]) {
        int ms = Integer.MIN_VALUE;
        int cs = 0;
        for (int i = 0; i < number.length; i++) {
            cs += number[i];
            if (cs < 0) {
                cs = 0;
            }
            ms = Math.max(ms, cs);
        }
        System.out.println("Maximum sum of subarray = " + ms);
    }

    // Trapping Rain Water Problem
    public static int trappedRainWater(int height[]) {
        int n = height.length;
        // Calculate left max array
        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        // Calculate right max array
        int rightMax[] = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        // Calculate trapped water
        int trappedWater = 0;
        // loop through each element
        for (int i = 0; i < n; i++) {
            // Water level at current index
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            // Water trapped at current index
            trappedWater += waterLevel - height[i];
        }
        return trappedWater;
    }

    // Buy and Sell Stock Problem
    public static int buyAndSellStock(int prices[]) {
        int maxProfit = 0;
        int buyPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            // If we find a lower price, we update the buy price
            if (prices[i] < buyPrice) {
                buyPrice = prices[i];
            }
            // Calculate profit if we sell at current price
            int profit = prices[i] - buyPrice;
            // Update max profit if current profit is greater
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }

    public static void main(String[] args) {

        // int number[] = { 1, 2, 6, 3, 5 };

        // // linearSearch
        // int key = 10;
        // int answer = linearSearch(number, key);
        // if (answer == -1) {
        // System.out.println("Not Found");
        // } else {
        // System.out.println("Index found at " + answer);
        // }

        // System.out.println("The largest number is " + getLargest(number));

        // binarySearch
        // int key = 1;
        // int number[] = { 2, 4, 6, 8, 10, 12, 14, 16, 18 };
        // System.out.println("The key is found at index " + binarySearch(number, key));

        // reverse(number);

        // for (int i = 0; i < number.length; i++) {
        // System.out.print(number[i] + " ");
        // }

        // printPairs(number);
        int number[] = { 1, -2, 6, -1, 3 };
        printSubArrays(number);
    }
}