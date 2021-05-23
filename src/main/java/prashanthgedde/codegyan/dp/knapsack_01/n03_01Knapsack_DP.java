package prashanthgedde.codegyan.dp.knapsack_01;

/**
 * DP Bottom-UP approach using DP matrix to eliminate recursion.
 * A cell in the matrix DP[cap][index] => represent optimal value considering
 *   `index-1` elements from given weight/values for a knapsack capacity of `cap`.
 *
 * Final solution is built in bottom up approach building solution from
 * lowest level sub problem.
 * Solving this problem first recursively is highly recommended.
 */

public class n03_01Knapsack_DP {

    public static int DP[][] = null;
    public static int knapsack_dp(int[] wt, int []val, int capacity) {

        if(capacity <= 0 || wt.length <= 0) {
            return 0;
        }

        DP = new int[capacity+1][wt.length+1];
        for(int i=0; i<=capacity; i++) {
            for(int j=0; j<=wt.length; j++) {
                DP[i][j] = (i==0 || j==0) ? 0 : -1;
            }
        }

        for(int cap=1; cap<=capacity; cap++) {
            for(int ind=1; ind<=wt.length; ind++) {
                if(wt[ind-1] <= cap) {
                    DP[cap][ind] = Math.max(
                            val[ind-1]+DP[cap-wt[ind-1]][ind-1],
                            DP[cap][ind-1]);
                }
                else {
                    DP[cap][ind] = DP[cap][ind-1];
                }
            }
        }

        printDPMatrix();
        return DP[capacity][wt.length];
    }

    private static void printDPMatrix() {
        for(int i=0; i<DP.length; i++) {
            for (int j = 0; j < DP[0].length; j++) {
                System.out.print(DP[i][j]+"\t");
            }
            System.out.println("");
            System.out.println("");
        }
    }

    public static void main(String[] args) {

        int []wt = new int[]{10, 20, 30};
        int []vl = new int[]{150, 100, 120};
        System.out.println(knapsack_dp(wt, vl, 50));

        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        System.out.println(knapsack_dp(weights, profits, 7));

        int [] w = { 2, 3, 1, 4 };
        int [] p = { 4, 5, 3, 7 };
        System.out.println(knapsack_dp(w, p, 6));
    }
}
