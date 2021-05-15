package prashanthgedde.codegyan.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. Letter Combinations of a Phone Number
 * Medium
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.*
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 * 1 -> _
 * 2 -> a,b,c
 * 3 -> d,e,f
 * 4 -> g,h,i
 * 5 -> j,k,l
 * 6 -> m,n,o
 * 7 -> p,q,r,s
 * 8 -> t,u,v
 * 9 -> w,x,y,z
 * 0 -> _
 *
 * Example 1:
 *
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * Example 2:
 *
 * Input: digits = ""
 * Output: []
 * Example 3:
 *
 * Input: digits = "2"
 * Output: ["a","b","c"]
 */
public class n04_PhoneNumLetterCombn {

    private static Map<Character, char[]> charMap = new HashMap<>();
    static {
        charMap.put('2', new char[]{'a', 'b', 'c'});
        charMap.put('3', new char[]{'d', 'e', 'f'});
        charMap.put('4', new char[]{'g', 'h', 'i'});
        charMap.put('5', new char[]{'j', 'k', 'l'});
        charMap.put('6', new char[]{'m', 'n', 'o'});
        charMap.put('7', new char[]{'p', 'q', 'r', 's'});
        charMap.put('8', new char[]{'t', 'u', 'v'});
        charMap.put('9', new char[]{'w', 'x', 'y', 'z'});
    }
    public List<String> letterCombinations(String digits) {
        List<String> retList = new ArrayList<>();
        if(digits == null || digits.length()==0) {
            return retList;
        }

        _letterCombinations(digits, 0, retList, "");
        return retList;
    }

    private void _letterCombinations(String input, int index, List<String> retList, String sofar) {
        if(index == input.length()) {
            retList.add(sofar);
            return;
        }

        char curChar = input.charAt(index);
        if(charMap.containsKey(curChar)) {
            char[]keyChars = charMap.get(curChar);
            for(int i=0; i<keyChars.length; i++) {
                _letterCombinations(input, index+1, retList, sofar+keyChars[i]);
            }
        }
        else {
            _letterCombinations(input, index+1, retList, sofar);
        }
    }

    public static void main(String[] args) {
        n04_PhoneNumLetterCombn obj = new n04_PhoneNumLetterCombn();
        List<String> retList = obj.letterCombinations("123");

        for(String str: retList) {
            System.out.println(str);
        }
    }
}
