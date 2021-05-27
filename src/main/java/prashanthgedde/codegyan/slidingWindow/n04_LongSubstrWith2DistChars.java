package prashanthgedde.codegyan.slidingWindow;

import java.util.HashMap;

/**
 * Longest Substring with At Most Two Distinct Characters
 * Hard
 *
 * https://aaronice.gitbook.io/lintcode/two_pointers/longest-substring-with-at-most-two-distinct-characters
 *
 * Given a string s, find the length of the longest substring t that contains at most 2 distinct characters.
 *
 * Example 1:
 *
 * Input: "eceba"
 * Output: 3
 * Explanation: t is "ece" which its length is 3.
 *
 * Example 2:
 *
 * Input: "ccaabbb"
 * Output: 5
 * Explanation: t is "aabbb" which its length is 5.
 */

import java.util.*;

public class n04_LongSubstrWith2DistChars {

    public static int longestSubStringWith2DistChars(String input) {

        if(input.length() <= 1) {
            return 0;
        }

        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        int start=0;
        int end=0;
        while(end < input.length()) {
            map.put(input.charAt(end), map.getOrDefault(input.charAt(end), 0)+1);
            if(map.size() <= 2) {
                // expand the window
                end++;
            }
            else {
                // more than 2 distinct chars.
                // stop expanding the window, record the length, and reset window

                //record the length and update max-len;
                maxLen = Math.max(end-start,maxLen);

                // reset the window
                if(map.get(input.charAt(start)) == 1) {
                    map.remove(input.charAt(start));
                }
                else {
                    map.put(input.charAt(start), map.get(input.charAt(start)) - 1);
                }
                start++;
                end++;
            }

        }
        maxLen = Math.max(end-start,maxLen);
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestSubStringWith2DistChars("eceba"));
        System.out.println(longestSubStringWith2DistChars("ccaabbb"));
    }
}
