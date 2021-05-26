package prashanthgedde.codegyan.heap;

/**
 * 692. Top K Frequent Words
 * Medium
 *
 * https://leetcode.com/problems/top-k-frequent-words/
 *
 * Given a non-empty list of words, return the k most frequent elements.
 *
 * Your answer should be sorted by frequency from highest to lowest.
 * If two words have the same frequency, then the word with the lower alphabetical order comes first.
 *
 * Example 1:
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"]
 * Explanation: "i" and "love" are the two most frequent words.
 *     Note that "i" comes before "love" due to a lower alphabetical order.
 *
 * Example 2:
 * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * Output: ["the", "is", "sunny", "day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
 *     with the number of occurrence being 4, 3, 2 and 1 respectively.
 *
 */

import java.util.*;

public class n02_TopKWords {

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordMap = new HashMap<>();

        for(String word: words) {
            if(wordMap.containsKey(word)) {
                wordMap.put(word, wordMap.get(word)+1);
            }
            else {
                wordMap.put(word, 1);
            }
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if((o1.getValue() - o2.getValue()) != 0) {
                    return o1.getValue() - o2.getValue();
                }
                return o2.getKey().compareTo(o1.getKey());
            }
        });

        for(Map.Entry<String, Integer> entry: wordMap.entrySet()) {
            pq.add(entry);
            if(pq.size() > k) {
                pq.poll();
            }
        }

        List<String> retList = new ArrayList<>();
        while(!pq.isEmpty()) {
            retList.add(0, pq.poll().getKey());
        }

        return retList;
    }


    public static void main(String[] args) {

        System.out.println(Arrays.toString(topKFrequent(new String [] {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"},  4).toArray()));
    }
}
