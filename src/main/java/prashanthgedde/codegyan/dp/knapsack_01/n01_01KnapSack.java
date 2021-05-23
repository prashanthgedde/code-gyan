package prashanthgedde.codegyan.dp.knapsack_01;

import java.util.ArrayList;
import java.util.List;

/**
 * https://miro.com/app/board/o9J_lEQpPZ8=/
 */
public class n01_01KnapSack {
/*
    public static int knapsack_solve(int[] wt, int []val, int capacity) {
        return _knapsack_helper(wt, val, capacity, 0);
    }

    private static int _knapsack_helper(int []wt, int []val, int capacity, int index) {
        if(index == wt.length || capacity == 0) {
            // no more items or no capacity
            return 0;
        }

        if(wt[index] <= capacity) {
            int val1 = val[index]+_knapsack_helper(wt, val, capacity-wt[index], index + 1);
            int val2 = _knapsack_helper(wt, val, capacity, index + 1);
            return Math.max(val1, val2);
        }
        else {
            return _knapsack_helper(wt, val, capacity, index + 1);
        }
    }
*/
    public static int knapsack_solve2(int[] wt, int []val, int capacity) {
        return _knapsack_helper2(wt, val, capacity, wt.length);
    }

    private static int _knapsack_helper2(int []wt, int []val, int capacity, int N) {
        if(N == 0 || capacity == 0) {
            // no more items or no capacity
            return 0;
        }

        if(wt[N-1] <= capacity) {
            return Math.max(val[N-1]+_knapsack_helper2(wt, val, capacity-wt[N-1], N-1),
                    _knapsack_helper2(wt, val, capacity, N-1));
        }
        return _knapsack_helper2(wt, val, capacity, N-1);
    }


    public static void main(String[] args) {

        int []wt = new int[]{10, 20, 30};
        int []vl = new int[]{150, 100, 120};
        System.out.println(knapsack_solve2(wt, vl, 50));

        int[] profits = {31, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        System.out.println(knapsack_solve2(weights, profits, 7));

        int [] w = { 2, 3, 1, 4 };
        int [] p = { 4, 5, 3, 7 };
        System.out.println(knapsack_solve2(w, p, 6));
    }
}
