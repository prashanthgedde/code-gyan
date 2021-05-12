package prashanthgedde.codegyan.bfs;

import java.util.Queue;
import java.util.LinkedList;

/**
 * 200. Number of Islands
 * Medium
 *
 * https://leetcode.com/problems/number-of-islands/
 *
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 */
public class n01_NumIslands {

    public static int numIslands(char[][] grid) {

        boolean [][]visited = new boolean[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                visited[i][j] = false;
            }
        }

        int numIsland = 0;
        for(int i=0; i<grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(isValidMove(grid, visited, i, j)) {
                    numIsland++;

                    Queue<int[]> q = new LinkedList<>();

                    q.add(new int[]{i, j});
                    while(!q.isEmpty()) {
                        int[] e = q.poll();
                        int row = e[0];
                        int col = e[1];
                        //System.out.println("cell: "+row+", "+col);


                        visited[row][col] = true;
                        if(isValidMove(grid, visited, row+1, col)) {q.add(new int[] {row+1, col});}
                        if(isValidMove(grid, visited, row-1, col)) {q.add(new int[] {row-1, col});}
                        if(isValidMove(grid, visited, row, col+1)) {q.add(new int[] {row, col+1});}
                        if(isValidMove(grid, visited, row, col-1)) {q.add(new int[] {row, col-1});}
                    }
                }
            }
        }
        return numIsland;
    }

    private static boolean isValidMove(char [][]grid, boolean[][] visited, int row, int col) {
        return (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length &&
                !visited[row][col] &&
                grid[row][col] == '1');
    }

    public static void printBoard(boolean[][] board) {

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                System.out.print(board[i][j] ? "1 ": "0 ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public static void main(String[] args) {

        char [][] grid1 = {{'0', '0', '1'}};
        System.out.println(n01_NumIslands.numIslands(grid1));

        char [][] grid2 = {{'1', '0', '1'}};
        System.out.println(n01_NumIslands.numIslands(grid2));

        char [][] grid3 = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','1'},
                {'0','0','0','0','1'}};
        System.out.println(n01_NumIslands.numIslands(grid3));
        
        char [][] grid4 ={
                {'1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','0','1','0','1','1'},
                {'0','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','0'},
                {'1','0','1','1','1','0','0','1','1','0','1','1','1','1','1','1','1','1','1','1'},
                {'1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                {'1','0','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                {'1','0','1','1','1','1','1','1','0','1','1','1','0','1','1','1','0','1','1','1'},
                {'0','1','1','1','1','1','1','1','1','1','1','1','0','1','1','0','1','1','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                {'0','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                {'1','1','1','1','1','0','1','1','1','1','1','1','1','0','1','1','1','1','1','1'},
                {'1','0','1','1','1','1','1','0','1','1','1','0','1','1','1','1','0','1','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','0'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','0'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'}};
        System.out.println(n01_NumIslands.numIslands(grid4));
                
    }
}
