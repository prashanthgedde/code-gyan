package prashanthgedde.codegyan.slidingWindow;

/**
 * First negative integer in every window of size k
 * Difficulty Level : Medium
 * https://www.geeksforgeeks.org/first-negative-integer-every-window-size-k/
 *
 * Given an array and a positive integer k,
 * find the first negative integer for each window(contiguous subarray) of size k.
 * If a window does not contain a negative integer, then print 0 for that window.
 *
 * Examples:
 *
 * Input : arr[] = {-8, 2, 3, -6, 10}, k = 2
 * Output : -8 0 -6 -6
 *
 * First negative integer for each window of size k
 * {-8, 2} = -8
 * {2, 3} = 0 (does not contain a negative integer)
 * {3, -6} = -6
 * {-6, 10} = -6
 *
 * Input : arr[] = {12, -1, -7, 8, -15, 30, 16, 28} , k = 3
 * Output : -1 -1 -7 -15 -15 0
 *
 */

import java.util.*;
public class n02_FirstNegativeInWindow {

    public static List<Integer> firstNegative(int[] nums, int k) {
        int start = 0;
        int end = start+k-1;
        List<Integer> negList = new ArrayList<>();
        for(int i=start; i<end; i++) {
            if(nums[i] < 0) negList.add(nums[i]);
        }

        List<Integer> retList = new ArrayList<>();
        for(; end < nums.length; end++, start++) {
            if(nums[end] < 0) negList.add(nums[end]);
            retList.add(negList.isEmpty() ? 0 : negList.get(0));
            if(!negList.isEmpty() && nums[start] == negList.get(0)) {
                negList.remove(0);
            }
        }
        return retList;
    }

    public static void main(String[] args) {
        System.out.println(firstNegative(new int[]{-8, 2, 3, -6, 10}, 2));
        System.out.println(firstNegative(new int[]{12, -1, -7, 8, -15, 30, 16, 28}, 3));
    }
}
