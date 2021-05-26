package prashanthgedde.codegyan.dp.knapsack_ub;

/**
 * 139. Word Break
 * Medium
 *
 * https://leetcode.com/problems/word-break/
 *
 *
 * Given a string s and a dictionary of strings wordDict,
 * return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 *
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 *
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: false
 *
 */
import java.util.*;

public class WorkBreak {

    public static boolean wordBreak(String s, String[] wordDict) {
        if(s.length() == 0) {
            return true;
        }

        for(String word: wordDict) {
            if(s.startsWith(word)) {
                if (wordBreak(s.substring(word.length()), wordDict)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean wordBreak_memoized(String s, String[] wordDict) {
        return _wordBreak_memoized(s, wordDict, new HashMap<>());
    }

    private static boolean _wordBreak_memoized(String s, String[] wordDict, Map<String, Boolean> map) {
        if(s.length() == 0) {
            map.put("", true);
            return true;
        }
        if(map.containsKey(s)) {
            return map.get(s);
        }

        for(String word: wordDict) {
            if(s.startsWith(word)) {
                map.put(word, true);
                if (_wordBreak_memoized(s.substring(word.length()), wordDict, map)) {
                    return true;
                }
            }
        }

        map.put(s, false);
        return false;
    }

    public static void main(String[] args) {
        String[] dict = new String[]{"apple","pen"};
        System.out.println(wordBreak("applepenapple", dict)+", "+ wordBreak_memoized("applepenapple", dict));
        System.out.println(wordBreak("applepenapples", dict)+", "+ wordBreak_memoized("applepenapples", dict));
        System.out.println(wordBreak("applespenapple", dict)+", "+ wordBreak_memoized("applespenapple", dict));

        System.out.println(wordBreak("catsandog", new String[]{"cats","dog","sand","and","cat"})
                +", "+ wordBreak_memoized("catsandog", new String[]{"cats","dog","sand","and","cat"}));
        System.out.println(wordBreak("catsanddog", new String[]{"cats","dog","sand","and","cat"})
                +", "+ wordBreak_memoized("catsanddog", new String[]{"cats","dog","sand","and","cat"}));

    }
}
