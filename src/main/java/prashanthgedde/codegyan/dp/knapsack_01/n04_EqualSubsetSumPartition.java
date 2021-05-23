package prashanthgedde.codegyan.dp.knapsack_01;

/**
 * 416. Partition Equal Subset Sum
 * Medium
 *
 * https://leetcode.com/problems/partition-equal-subset-sum/
 *
 * Given a non-empty array nums containing only positive integers,
 * find if the array can be partitioned into two subsets such that
 * the sum of elements in both subsets is equal.
 *
 * Example 1:
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 *
 *  Example 2:
 * Input: nums = [1,2,3,5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 *
 */

public class n04_EqualSubsetSumPartition {

    public boolean[][] DP = null;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums) {sum += num;}

        // if sum is odd we cannot partition to equal sum.
        if(sum%2 != 0) return false;

        // If we can find a subset whose sum = sum/2, then we can successfully partition the given array
        //  as the remaining elements naturally should sum to other half.
        int halfSum = sum/2;
        DP = new boolean[halfSum+1][nums.length+1];
        return subsetSum_tabulation(nums, halfSum, nums.length);
    }

    private boolean subsetSum(int []nums, int sum, int N) {
        if(sum == 0) {
            return true;
        }
        if(N == 0) {
            return false;
        }

        if(nums[N-1] <= sum) {
            return subsetSum(nums, sum-nums[N-1], N-1) || subsetSum(nums, sum, N-1);
        }
        return subsetSum(nums, sum, N-1);
    }

    private boolean subsetSum_tabulation(int []nums, int sum, int N) {

        for(int ind = 0; ind<=N; ind++) {
            DP[0][ind] = true;
        }
        for(int s = 0; s<=sum; s++) {
            DP[s][0] = false;
        }

        for(int s = 1; s<=sum; s++) {
            for(int ind = 1; ind<=N; ind++) {
                if(nums[ind-1] <= s) {
                    DP[s][ind] = DP[s][ind-1] || DP[s-nums[ind-1]][ind-1];
                }
                else {
                    DP[s][ind] = DP[s][ind-1];
                }
            }
        }
        return DP[sum][N];
    }

    public static void main(String[] args) {
        n04_EqualSubsetSumPartition obj = new n04_EqualSubsetSumPartition();

        int []nums = new int[]{1,5,11,5};
        System.out.println(obj.canPartition(nums));

        nums = new int[]{1,2,3,5};
        System.out.println(obj.canPartition(nums));

        nums = new int[]{100,100,100,100,100,100,100,100,100,100,100, 50, 20};
        System.out.println(obj.canPartition(nums));
    }
}
