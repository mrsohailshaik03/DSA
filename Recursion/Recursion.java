class Recursion {

    static int fact(int n) {
        int fact;
        if (n == 0) {
            return 1;
        }
        fact = n * fact(n - 1);
        return fact;
    }

    static int sum(int n) {
        int sum;
        if (n == 1) {
            return 1;
        }
        sum = n + sum(n - 1); 
        return sum;
    }


    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int fibn = fib(n - 1) + fib(n - 2);
        return fibn;
    }

    public static void main(String[] args) {
        // System.out.println("Hello World");
        // System.out.println(fact(5));
        // System.out.println(sum(5));
        for (int i = 0; i <= 10; i++) {
            System.out.print(fib(i) + " ");
        }
    }

}
