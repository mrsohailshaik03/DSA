// import java.util.*;
class basic {
    public static void HelloWorld() {
        System.out.println("Hello, World!");
    }

    public static int sum(int a, int b) {
        return a + b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static int fact(int num) {
        int fact;
        if (num == 1) {
            return 1;
        }
        fact = num * fact(num - 1);
        return fact;
    }

    public static int fact1(int n) {
        int f = 1;
        for (int i = 1; i <= n; i++) {
            f = f * i;
        }
        return f;
    }

    public static int nCr(int n, int r) {
        return fact1(n) / (fact1(r) * fact1(n - r));
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static int add(int a, int b, int c) {
        return a + b + c;
    }

    public static int mul(int a, int b) {
        return a * b;
    }

    public static float mul(float a, float b) {
        return a * b;
    }

    public static boolean isPrime(int n) {
        boolean isPrime = true;
        for (int i = 2; i <= n - 1; i++) {
            if (n % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    public static void primeInRange(int n) {
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }

    public static void binToDec(int n) {
        int dec = 0;
        int pow = 0;
        while (n > 0) {
            int lastDigit = n % 10;
            dec = dec + (lastDigit * (int) Math.pow(2, pow));
            pow++;
            n = n / 10;
        }
        System.out.println(dec);

    }

    public static void average(int a, int b, int c) {
        System.out.println("Average is " + (a + b + c) / 3);
    }

    // public static boolean isEven (int n){
    // if(n%2 ==0){
    // return true;
    // }
    // else{
    // return false;
    // }
    // }

    // Hollow Rectangle
    public static void hollow_Rec(int totRow, int totCol) {
        for (int i = 1; i <= totRow; i++) {
            for (int j = 1; j <= totCol; j++) {
                if (i == 1 || i == totRow || j == 1 || j == totCol) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    // Inverted Rotated Half Pyramid
    public static void inverted_Rot_Half_Pyramid(int n) {
        for (int i = 1; i <= n; i++) {
            // Spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            // Stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // Inverted Half Pyramid (Numbers)
    public static void inverted_Half_Pyramid(int n) {
        for (int i = 1; i <= n; i++) {
            // Numbers
            for (int j = 0; j <= n - i + 1; j++) {
                System.out.print(j);
            }
        }
    }

    public static void FLOYD_TRIANGLE(int n) {
        int count = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(count + " ");
                count++;
            }
            System.out.println();
        }
    }

    public static void pattern(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }

    // Butterfly Pattern
    public static void butterfly(int n) {
        // 1st Half
        for (int i = 1; i <= n; i++) {
            // Stars - i
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            // Spaces 2(n-i)
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print(" ");
            }

            // Stars - i
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        // 2nd Half
        for (int i = n; i >= 1; i--) {
            // Stars - i
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            // Spaces 2(n-i)
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print(" ");
            }

            // Stars - i
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // Solid Rhombus
    public static void solidRhombus(int n) {
        for (int i = 1; i <= n; i++) {
            // spaces
            for (int j = 1; j <= (n - i); j++) {
                System.out.print(" ");
            }
            // stars
            for (int j = 1; j <= n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // Diamond Pattern
    public static void diamond(int n){
        // 1st Half
        for(int i = 1; i <= n; i++){
            // spaces
            for(int j = 1; j <= (n-i); j++){
                System.out.print(" ");
            }
            // Stars
            for(int j = 1; j <= (2*i)-1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        // 2nd Half
        for(int i = n; i >= 1; i--){
            // spaces
            for(int j = 1; j <= (n-i); j++){
                System.out.print(" ");
            }
            // Stars
            for(int j = 1; j <= (2*i)-1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // int num1 = sc.nextInt();
        // int num2 = sc.nextInt();
        // System.out.println("The sum of two numbers is "+sum(num1, num2));
        // System.out.println("The sum of two numbers is "+mul(num1, num2));
        // System.out.println(mul(5.5f,5.2f));

        // primeInRange(50);
        // binToDec(1011);
        // System.out.println(isEven(10));
        hollow_Rec(4, 5);
        // inverted_Rot_Half_Pyramid(5);
        // pattern(5);
        // butterfly(4);
    }
}
