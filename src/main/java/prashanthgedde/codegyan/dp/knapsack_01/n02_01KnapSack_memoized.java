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

        return _knapsack_helper(wt, val, capacity, wt.length);
    }

    private static int _knapsack_helper(int []wt, int []val, int capacity, int N) {
        if(N == 0 || capacity == 0) {
            // no more items or no capacity
            DP[capacity][N] = 0;
            return DP[capacity][N];
        }

        if(DP[capacity][N-1] != -1) {
            return DP[capacity][N-1];  //<<--- Memoization used here
        }

        if (wt[N-1] <= capacity) {
            int val1 = val[N-1] + _knapsack_helper(wt, val, capacity - wt[N-1], N-1);
            int val2 = _knapsack_helper(wt, val, capacity, N-1);
            DP[capacity][N-1] = Math.max(val1, val2);  // <<-- Once computed, the value is cached
        } else {
            DP[capacity][N-1] = _knapsack_helper(wt, val, capacity, N-1); // <<-- cached here too
        }
        return DP[capacity][N-1];
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
