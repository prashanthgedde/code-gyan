package prashanthgedde.codegyan.sorting.mergesort;

public class n01_MergeSort {

    public static void mergeSort(int []array, int start, int end) {
        if(end > start) {
            int mid = (start + end) / 2;
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            merge(array, start, mid, end);
        }
    }

    private static void merge(int []array, int start, int mid, int end) {
        System.out.println("Merge: "+start+", "+mid+", "+end);
        // temp array
        int []a1 = new int[mid-start+1];
        int []a2 = new int[end-mid];

        for(int i=0, j=start; j<=mid; i++, j++) {
            a1[i] = array[j];
        }

        for(int i=0, j=mid+1; j<=end; i++, j++) {
            a2[i] = array[j];
        }

        // merge
        int i = 0, j=0, k=start;
        while(i<a1.length && j<a2.length) {
            array[k++] = (a1[i] <= a2[j]) ? a1[i++] : a2[j++];
        }

        if(i<a1.length) {
            array[k++] = a1[i++];
        }
        if(j<a2.length) {
            array[k++] = a2[j++];
        }
    }


    public static void main(String[] args) {
        int a[] = new int[]{1,79,7,13,89,0,6,3};
        mergeSort(a, 0, a.length-1);
        printArray(a);
    }

    private static void printArray(int[] array) {
        for(int e: array) {
            System.out.print(e+" ");
        }
        System.out.println("");
    }
}
