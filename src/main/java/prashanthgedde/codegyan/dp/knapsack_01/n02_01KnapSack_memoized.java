package prashanthgedde.codegyan.dp.knapsack_01;

public class n02_01KnapSack_memoized {

    public static int DP[][] = null;
    public static int knapsack_solve(int[] wt, int []val, int capacity) {
        DP = new int[capacity+1][wt.length+1];
        for(int i=0; i<DP.length; i++) {
            for(int j=0; j<DP[0].length; j++) {
                DP[i][j] = -1;
            }
        }

        return _knapsack_helper(wt, val, capacity, 0);
    }

    private static int _knapsack_helper(int []wt, int []val, int capacity, int index) {
        if(index == wt.length || capacity == 0) {
            // no more items or no capacity
            DP[capacity][index] = 0;
        }
        else {
            if(DP[capacity][index] == -1) {
                if (wt[index] <= capacity) {
                    int val1 = val[index] + _knapsack_helper(wt, val, capacity - wt[index], index + 1);
                    int val2 = _knapsack_helper(wt, val, capacity, index + 1);
                    DP[capacity][index] = Math.max(val1, val2);
                } else {
                    DP[capacity][index] = _knapsack_helper(wt, val, capacity, index + 1);
                }
            }
        }
        return DP[capacity][index];
    }

    public static void main(String[] args) {

        int []wt = new int[]{10, 20, 30};
        int []vl = new int[]{150, 100, 120};
        System.out.println(knapsack_solve(wt, vl, 50));

        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        System.out.println(knapsack_solve(weights, profits, 7));

        int [] w = { 2, 3, 1, 4 };
        int [] p = { 4, 5, 3, 7 };
        System.out.println(knapsack_solve(w, p, 6));
    }
}
