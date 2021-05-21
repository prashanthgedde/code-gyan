package prashanthgedde.codegyan.sorting.quicksort;

import java.util.Arrays;

public class n01_Partitioning {

    public static int partition(int arr[], int pivot, int start, int end) {
        while(start < end) {
            while(start<arr.length && arr[start] <= arr[pivot]) {++start;}
            while(end>=0 && arr[end] > arr[pivot]){end--;}
            //System.out.println("Pivot: "+arr[pivot]+", Start: "+start+", End: "+end);
            if(start < end) {
                swap(arr, start, end);
            }
        }

        swap(arr, pivot, end);
        return end;
    }

    private static void swap(int[]arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        //System.out.println(partition(new int[]{1,2,3,4,5,6,7}, 4, 0, 6));
        //System.out.println(partition(new int[]{1,2,3,4,5,6,7}, 0, 0, 6));
        //System.out.println(partition(new int[]{1,2,3,4,5,6,7}, 6, 0, 6));
        int []arr = new int[]{7,1,3,5,2,6,4};
        int partitionPos = partition(arr, 0, 0, 6);
        System.out.println(partitionPos+": "+ Arrays.toString(arr));
        partitionPos = partition(arr, 0, 0, partitionPos-1);
        System.out.println(partitionPos+": "+ Arrays.toString(arr));
        partitionPos = partition(arr, 0, 0, partitionPos-1);
        System.out.println(partitionPos+": "+ Arrays.toString(arr));

    }
}
