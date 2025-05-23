package Assignment3.q7;

public class MatrixOperations {
    public static int[][] add(int[][] a, int[][] b) {
        int rows = a.length;
        int cols = a[0].length;
        int[][] result = new int[rows][cols];
        try {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    result[i][j] = a[i][j] + b[i][j];
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error during matrix addition: " + e.getMessage());
            System.out.println("Check if both matrices have the same dimensions.");
        }
        return result;
    }

    public static int[][] multiply(int[][] a, int[][] b) {
        int row = a.length;
        int col = b[0].length;
        int sum = 0;
        int[][] result = new int[row][col];
        try{for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    sum+=a[i][k]*b[k][j];
                }
                result[i][j] = sum;
                sum  = 0;
            }
        }}catch(ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return result;
    }

    public static int[][] transpose(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] transpose = new int[col][row];
        try{for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }}catch(ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return transpose;
    }

    public static void accessElement(int[][] matrix, int row, int col) {
        try {
            int value = matrix[row][col];
            System.out.println("Element at (" + row + ", " + col + "): " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Tried to access element at (" + row + ", " + col + ").");
            System.out.println("Valid row indices: 0 to " + (matrix.length - 1));
            if (matrix.length > 0) {
                System.out.println("Valid column indices: 0 to " + (matrix[0].length - 1));
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matA = {
            {1, 2, 3},
            {4, 5, 6}
        };
        int[][] matB = {
            {7, 8, 9},
            {10, 11, 12}
        };
        int[][] matC = {
            {1, 2},
            {3, 4},
            {5, 6}
        };

        System.out.println("Matrix Addition:");
        int[][] sum = add(matA, matB);
        printMatrix(sum);

        System.out.println("\nMatrix Multiplication:");
        int[][] product = multiply(matA, matC);
        printMatrix(product);

        System.out.println("\nMatrix Transpose:");
        int[][] transposed = transpose(matA);
        printMatrix(transposed);

        System.out.println("\nAccessing Elements:");
        accessElement(matA, 1, 2);
        accessElement(matA, 2, 0);
        accessElement(matA, 0, 5);

        System.out.println("\nProgram continues execution after handling exceptions.");
    }
}