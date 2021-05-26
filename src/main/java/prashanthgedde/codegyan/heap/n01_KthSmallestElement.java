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

    /**
     *  Use MAX-HEAP.
     *
     *  1) Build a MaxHeap MH of the first k elements (arr[0] to arr[k-1]) of the given array. O(k)
     *  2) For each element, after the kth element (arr[k] to arr[n-1]), compare it with root of MH.
     *       a) If the element is less than the root then add it (make it root and call heapify)
     *       b) Else ignore it.
     *     The step 2 is O((n-k)*log(k))
     *  3) Finally, MH has k smallest elements and root of the MH is the kth smallest element.
     *
     *  Time Complexity:            O(k + (n-k)*log(k)) without sorted output.
     *  If sorted output is needed: O(k + (n-k)*log(k) + k*log(k))
     *
     *  This also is better for Bigger K's.
     */
    public static int findKthSmall(int[] arr, int k) {
        if(k <1 || k > arr.length) {
            return -1;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((I1, I2) -> (I2-I1));

        for(int a : arr) {
            if(pq.size() == k) {
                if(pq.peek() >= a ) {
                    pq.offer(a);
                    pq.poll();
                }
            }
            else {
                pq.add(a);
            }
        }
        return pq.peek();
    }

    /**
     *
     *  Using MIN-HEAP
     *
     *  Build heap of n elements -> o(n)
     *  Pop K elemnts out of stack -> klogn
     *  Total: O(n + klogn)
     *
     *  This also is better for Bigger N's and smaller K's.
     */

    public static int findKthSmall_minHeap(int[] arr, int k) {
        if(k <1 || k > arr.length) {
            return -1;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int a : arr) {
            pq.add(a);
        }

        int ret = 0;
        while(k > 0) {
            ret = pq.poll();
            k--;
        }
        return ret;
    }

    public static void main(String[] args) {
        int []arr = {7, 10, 4, 3, 20, 15};
        System.out.println(findKthSmall(arr, 0)+" "+findKthSmall_minHeap(arr, 0));
        System.out.println(findKthSmall(arr, 1)+" "+findKthSmall_minHeap(arr, 1));
        System.out.println(findKthSmall(arr, 3)+" "+findKthSmall_minHeap(arr, 3));
        System.out.println(findKthSmall(arr, 4)+" "+findKthSmall_minHeap(arr, 4));
        System.out.println(findKthSmall(arr, 5)+" "+findKthSmall_minHeap(arr, 5));
        System.out.println(findKthSmall(arr, 6)+" "+findKthSmall_minHeap(arr, 6));
        System.out.println(findKthSmall(arr, 7)+" "+findKthSmall_minHeap(arr, 7));
    }
}
