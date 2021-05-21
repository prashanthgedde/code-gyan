package prashanthgedde.codegyan.heap;

import java.util.PriorityQueue;

/**
 * Given an array and a number k where k is smaller than the size of the array,
 * we need to find the k’th smallest element in the given array.
 * It is given that all array elements are distinct.
 *
 * Examples:
 *
 * Input: arr[] = {7, 10, 4, 3, 20, 15}
 * k = 3
 * Output: 7
 *
 * Input: arr[] = {7, 10, 4, 3, 20, 15}
 * k = 4
 * Output: 10
 *
 */
public class n01_KthSmallestElement {

    // Using MAX HEAP
    public static int findKthSmall(int[] arr, int k) {
        if(k <1) {
            return -1;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((I1, I2) -> (I2-I1));
        for(int a : arr) {
            pq.add(a);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    // Using MIM HEAP
    public static int findKthSmall_minHeap(int[] arr, int k) {
        if(k <1) {
            return -1;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((I1, I2) -> (I2-I1));
        for(int a : arr) {
            pq.add(a);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }



    public static void main(String[] args) {
        int []arr = {7, 10, 4, 3, 20, 15};
        System.out.println(findKthSmall(arr, 1));
        System.out.println(findKthSmall(arr, 3));
        System.out.println(findKthSmall(arr, 4));
    }
}
