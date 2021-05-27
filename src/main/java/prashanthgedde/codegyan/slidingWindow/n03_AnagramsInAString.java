package prashanthgedde.codegyan.slidingWindow;

/**
 * 438. Find All Anagrams in a String
 * Medium
 *
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 *
 * Given two strings s and p,
 * return an array of all the start indices of p's anagrams in s.
 * You may return the answer in any order.
 *
 * Example 1:
 *
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 *
 * Example 2:
 *
 * Input: s = "abab", p = "ab"
 * Output: [0,1,2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */

import java.util.*;

public class n03_AnagramsInAString {

    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> retList = new ArrayList<>();

        if(p.length() > s.length()) {
            return retList;
        }

        // build frequency map for characters of `p`
        int [] orgCounter = new int[26];
        for(char c: p.toCharArray()) {
            orgCounter[c - 'a']++;
        }

        int [] winCounter = new int[26];
        // first window
        for(int i=0; i<p.length()-1; i++) {
            winCounter[s.charAt(i) - 'a']++;
        }

        for(int start=0, end=p.length()-1; end<s.length(); start++, end++) {
            winCounter[s.charAt(end)- 'a']++;
            if(Arrays.equals(winCounter, orgCounter)) {
                retList.add(start);
            }
            winCounter[s.charAt(start) - 'a']--;
        }

        return retList;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findAnagrams("cbaebabacd", "abc").toArray()));
        System.out.println(Arrays.toString(findAnagrams("abab", "ab").toArray()));
        System.out.println(Arrays.toString(findAnagrams("aaaaaaaaaa", "aaaaaaaaaaaaa").toArray()));
    }
}
