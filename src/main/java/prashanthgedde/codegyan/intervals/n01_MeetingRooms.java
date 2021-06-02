package prashanthgedde.codegyan.intervals;

/**
 * 252. Meeting Rooms
 * Given an array of meeting time intervals consisting of start and end times[[s1,e1],[s2,e2],...](si< ei),
 * determine if a person could attend all meetings.
 *
 * https://ttzztt.gitbooks.io/lc/content/sort/meeting-rooms.html
 *
 * Example 1:
 *
 * Input: [[0,30],[5,10],[15,20]]
 * Output: false
 *
 * Example 2:
 *
 * Input:[[7,10],[2,4]]
 * Output:true
 */

import java.util.Arrays;

public class n01_MeetingRooms {

    public static boolean canAttendAll(int[][] intervals) {
        if(intervals.length <= 1) {return true;}

        Arrays.sort(intervals, (int[]in1, int[]in2) -> in1[0] - in2[0]);
        for(int i=1; i<intervals.length; i++) {
            //System.out.println("["+in[0]+", "+in[1]+"]");
            if(intervals[i][0] < intervals[i-1][1]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canAttendAll(new int[][] {{0,30},{5,10},{15,20}}));
        System.out.println(canAttendAll(new int[][] {{0,3},{5,10},{15,20}}));
        System.out.println(canAttendAll(new int[][] {{7,10},{2,4}}));
    }
}
