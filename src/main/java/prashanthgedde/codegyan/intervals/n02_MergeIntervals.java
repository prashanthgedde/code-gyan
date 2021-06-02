package prashanthgedde.codegyan.intervals;

/**
 * 56. Merge Intervals
 * Medium
 *
 * https://leetcode.com/problems/merge-intervals/
 *
 * Given an array of intervals where intervals[i] = [starti, endi],
 * merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 *
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 *
 *
 *
 * SOLUTION:
 * First, we sort the list.
 * Then, we insert the first interval into a merged list and continue considering each interval in turn as follows:
 *  If the current interval begins after the previous interval ends, then they do not overlap and we can append the current interval to merged.
 *  Otherwise, they do overlap, and we merge them by updating the end of the previous interval if it is less than the end of the current interval.
 */

import java.util.*;

public class n02_MergeIntervals {


    public static int[][] merge(int[][] intervals) {

        if(intervals.length <= 1) return intervals;

        // sort by start-time
        Arrays.sort(intervals, (in1, in2) -> (in1[0] - in2[0]));

        List<int[]> result = new ArrayList<>();
        int[] cur = newInterval(intervals[0]);
        result.add(cur);
        for(int i=1; i<intervals.length; i++) {
            if(intervals[i][0] <= cur[1]) {
                cur[1] = Math.max(cur[1], intervals[i][1]);
            }
            else {
                cur = newInterval(intervals[i]);
                result.add(cur);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    private static int[] newInterval(int[] interval) {
        int []ival = new int[2];
        ival[0] = interval[0];
        ival[1] = interval[1];
        return ival;
    }

    private static void print(int [][]intervals) {
        for(int[] interval: intervals) {
            System.out.println(interval[0]+", "+interval[1]);
        }
        System.out.println("-----------------");
    }
    public static void main(String[] args) {
        print(merge(new int[][] {{1,4},{0,2},{3,5}}));
        print(merge(new int[][] {{1,3},{2,6},{8,10},{15,18}}));
    }

}
