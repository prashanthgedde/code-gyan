package prashanthgedde.codegyan.backtracking;

import java.util.List;
import java.util.ArrayList;

/**
 * Given a set of non-negative integers, and a value sum,
 * determine if there is a subset of the given set with sum equal to given sum.
 *
 * Example:
 *
 * Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
 * Output: True
 * There is a subset (4, 5) with sum 9.
 *
 * Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 30
 * Output: False
 * There is no subset that add up to 30.
 *
 * Followup: Find any/all Subsets.
 */
public class n03_SubsetSum {

    public static boolean findSubsetForSum(int[] array, int sum, int index, List<Integer> subset) {

        // base-case
        if(sum == 0) {
            // already found the sum!
            return true;
        }
        if(index >= array.length) {
            // reached end of array and sum isn't zero.
            //  this means no subset eas found for the given sum!
            return false;
        }


        // Choose & Explore
        // either include this number or exclude
        // if included, sum will reduce by that number
        subset.add(array[index]);
        if(findSubsetForSum(array, sum-array[index], index+1, subset))
            return true;
        // backtrack
        subset.remove(subset.size()-1);

        // if excluded, sum will remain the same, only index will move
        if(findSubsetForSum(array, sum, index+1, subset))
            return true;

        return false;
    }

    public static void main(String[] args) {

        List<Integer> retList = new ArrayList<>();
        System.out.println(findSubsetForSum(new int[] {3, 34, 4, 12, 5, 2}, 9, 0, retList));
        System.out.println(retList);

        retList = new ArrayList<>();
        System.out.println(findSubsetForSum(new int[] {3, 34, 4, 12, 5, 2}, 22, 0, retList));
        System.out.println(retList);

        retList = new ArrayList<>();
        System.out.println(findSubsetForSum(new int[] {3, 34, 4, 12, 5, 2}, 1, 0, retList));
        System.out.println(retList);

        retList = new ArrayList<>();
        System.out.println(findSubsetForSum(new int[] {3, 34, 4, 12, 5, 2}, 30, 0, retList));
        System.out.println(retList);
    }
}
