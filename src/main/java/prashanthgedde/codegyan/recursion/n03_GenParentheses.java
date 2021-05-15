package prashanthgedde.codegyan.recursion;

import java.util.List;
import java.util.ArrayList;

public class n03_GenParentheses {

    public static List<String> genParentheses(int num) {
        List<String> list = new ArrayList<>();

        if(num <=0) {
            return list;
        }
        String sofar = "(";
        int open = num-1;
        int close = num;
        _genParentheses(open, close, list, sofar);
        return list;
    }

    private static void _genParentheses(int open, int close, List<String> list, String sofar) {
        //System.out.println("Open: "+open+", Close: "+close);
        if(open == 0 && close == 0) {
            list.add(sofar);
            return;
        }

        if(open == close) {
            _genParentheses(open-1, close, list, sofar+"(");
        }
        else {
            if(open > 0) _genParentheses(open-1, close, list, sofar+"(");
            if(close > 0) _genParentheses(open, close-1, list, sofar+")");
        }
    }

    public static void main(String[] args) {
        List<String> list = genParentheses(4);
        for(String l: list) {
            System.out.println(l);
        }
    }
}
