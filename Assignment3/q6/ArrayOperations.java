package Assignment3.q6;

import java.util.Arrays;

public class ArrayOperations {
    public static void sortArray(int[] arr) {
        Arrays.sort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    public static int searchArray(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                System.out.println("Value " + value + " found at index " + i);
                return i;
            }
        }
        System.out.println("Value " + value + " not found in the array.");
        return -1;
    }

    public static void accessElement(int[] arr, int index) {
        try {
            int value = arr[index];
            System.out.println("Element at index " + index + ": " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Tried to access index " + index + ", but valid indices are 0 to " + (arr.length - 1));
        }
    }

    public static void main(String[] args) {
        int[] numbers = {5, 2, 9, 1, 7};
        sortArray(numbers);
        searchArray(numbers, 9);
        searchArray(numbers, 4);
        accessElement(numbers, 2);
        accessElement(numbers, 10);
        accessElement(numbers, -1);
        System.out.println("Program continues execution after handling exceptions.");
    }
}