import java.util.*;

public class array {

    // Spatial Matrix
    public static void printSpatialMatrix(int[][] matrix) {
        int startRow = 0, endRow = matrix.length - 1;
        int startCol = 0, endCol = matrix[0].length - 1;
        while (startRow <= endRow && startCol <= endCol) {
            // Print the first row
            for (int i = startCol; i <= endCol; i++) {
                System.out.print(matrix[startRow][i] + " ");
            }
            startRow++;

            // Print the last column
            for (int i = startRow; i <= endRow; i++) {
                System.out.print(matrix[i][endCol] + " ");
            }
            endCol--;

            // Print the last row if applicable
            if (startRow <= endRow) {
                for (int i = endCol; i >= startCol; i--) {
                    System.out.print(matrix[endRow][i] + " ");
                }
                endRow--;
            }

            // Print the first column if applicable
            if (startCol <= endCol) {
                for (int i = endRow; i >= startRow; i--) {
                    System.out.print(matrix[i][startCol] + " ");
                }
                startCol++;
            }
        }
    }

    // Diagonal Sum
    public static int diagonalSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i]; // Primary diagonal
            if (i != matrix.length - 1 - i) { // Avoid double counting the middle element in odd-sized matrices
                sum += matrix[i][matrix.length - 1 - i]; // Secondary diagonal
            }
        }
        return sum;
    }

    // Staircase Search
    public static boolean staircaseSearch(int[][] matrix, int key) {
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0){
            if (matrix[row][col] == key) {
                System.out.println("Key found at: ( " + row + ", " + col + " )");
                return true; // Key found
            } else if (matrix[row][col] > key) {
                col--; // Move left
            } else {
                row++; // Move down
            }
        }
        System.out.println("Key not found");
        return false; // Key not found
    }

    public static void main(String[] args) {
        int matrix[][] = new int[3][3];
        int n = 3, m = 3;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}