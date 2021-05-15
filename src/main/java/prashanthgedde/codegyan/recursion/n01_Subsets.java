package prashanthgedde.codegyan.recursion;

/**
 * 78. Subsets
 * Medium
 *
 * https://leetcode.com/problems/subsets/
 *
 * Given an integer array nums of unique elements,
 * return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets.
 * Return the solution in any order.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [[],[0]]
 */
//////////////////////////////////////////////////////////////////////////




/**
 *  Solution: Two Recursive calls:
 *              1. Take a number and proceed.
 *              2. Proceed not selecting that number.
 *  We start with empty set {},
 *               {}
 *               /\
 *              / \Take 1?
 *     NO|-----    ------|Yes
 *      {}              {1}
 *     /\     Take2?    /\
 *  NO/  \Yes        NO/  \Yes
 *  {}  {2}          {1} {1,2}
 */

import java.util.List;
import java.util.ArrayList;

public class n01_Subsets {

    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> retList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        findSubsets(nums, 0, retList, list);
        return retList;
    }

    private static void findSubsets(int[] nums, int index, List<List<Integer>> subsetsList, List<Integer> subset) {
        if(index == nums.length) {
            //NOTE: Need to clone the list here as the same list is used to build other subsets
            subsetsList.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[index]);
        findSubsets(nums, index+1, subsetsList, subset);
        subset.remove(subset.size()-1);

        findSubsets(nums, index+1, subsetsList, subset);
    }

    private static void printSubset(List<Integer> subset) {
        System.out.print("( ");
        for(int num: subset) {
            System.out.print(num+", ");
        }
        System.out.println(") ");
    }

    private static void printSubsets(List<List<Integer>> lists) {
        for(List<Integer> subset: lists) {
            printSubset(subset);
        }
    }

    public static void main(String []args) {
        List<List<Integer>> retList = subsets(new int[]{1,2,3});
        printSubsets(retList);
    }
}
