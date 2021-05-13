package prashanthgedde.codegyan.backtracking;

import java.util.List;
import java.util.ArrayList;

public class n06_Subsets {

    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> retList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        findSubsets(nums, 0, retList, list);
        return retList;
    }

    private static void findSubsets(int[] nums, int index, List<List<Integer>> subsetsList, List<Integer> subset) {
        if(index == nums.length-1) {
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
        for(int num: subset) {
            System.out.print(num+", ");
        }
        System.out.println("");
    }

    private static void printSubsets(List<List<Integer>> lists) {
        for(List<Integer> subset: lists) {
            printSubset(subset);
        }
    }

    public static void main(String []args) {
        List<List<Integer>> retList = subsets(new int[]{1,2,3,4});
        printSubsets(retList);
    }
}
