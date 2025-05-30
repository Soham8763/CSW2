package Classworks;

public class quickSort {
    public static int partition(int[] arr,int low,int high){
        int pivot = arr[low];
        int i = low;
        int j = high;
        while(i<j){
            while(arr[i]<=pivot && i<=high-1){
                i++;
            }
            while(arr[j]>pivot && j>=low+1){
                j--;
            }
            if(i<j){
                swap(arr,i,j);
            }
        }
        swap(arr,low,j);
        return j;
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void quickSort(int[] arr,int low, int high){
        if(low<high){
            int partitionIndex= partition(arr,low,high);
            quickSort(arr,low,partitionIndex-1);
            quickSort(arr,partitionIndex+1,high);
        }
    }
    public static void main(String[] args) {
        int[] arr = {3,2,3,5,1,4,5,1};
        quickSort(arr,0,arr.length-1);
        for(Integer elem: arr){
            System.out.print(elem+" ");
        }
    }
}
