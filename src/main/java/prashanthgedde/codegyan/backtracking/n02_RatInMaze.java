package prashanthgedde.codegyan.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * A Maze is given as M*N binary matrix of blocks where
 * source block is the upper left most block i.e., maze[0][0]
 * and destination block is lower rightmost block i.e., maze[M-1][N-1].
 * A rat starts from source and has to reach the destination.
 * The rat can move only in 4 directions: forward, backward, up and down.
 *
 * In the maze matrix, 1 means the block is a dead end (WALL) and
 * 0 means the block can be used in the path from source to destination.
 *
 * Followup: a more complex version can be with a limited number of moves.
 */

public class n02_RatInMaze {

    private static final int[][] DIR = {
            {0, -1}, //LEFT
            {-1, 0}, //UP
            {0, 1}, //RIGHT
            {1, 0} //DOWN
    };
    private static final int WALL = 1;

    public static boolean findPath(int[][] maze,
                                   int[] cell,
                                   int[] dstCell,
                                   List<int[]> path) {

        // base-case
        if(cell[0] == dstCell[0] && cell[1] == dstCell[1]) {
            System.out.println("Reached destination");
            path.add(cell);
            return true;
        }

        // choose
        System.out.println(cell[0]+", "+cell[1]);
        path.add(cell);

        //explore
        for(int i=0; i<DIR.length; i++) {
            if(validMove(maze, path, cell, DIR[i])) {
                int [] newCell = new int[2];
                newCell[0] = cell[0]+DIR[i][0];
                newCell[1] = cell[1]+DIR[i][1];
                if(findPath(maze, newCell, dstCell, path)) {
                    return true;
                }
            }
        }

        // backtrack
        path.remove(path.size()-1);
        return false;
    }

    // Helper func to validate move, checks below:
    //  1. Boundary condition
    //  2. Already visited node
    //  3. Hits the wall
    private static boolean validMove(int[][] maze, List<int[]> path, int[] cell, int[] dir) {

        int newRow = cell[0]+dir[0];
        int newCol = cell[1]+dir[1];

        // Boundary condition
        if(newRow >= maze.length || newRow < 0 ||
                newCol >= maze[0].length || newCol <0) {
            // out of bound
            return false;
        }

        // if already visited
        for(int[] c: path) {
            if(c[0] == newRow && c[1] == newCol) {
                // already visited
                return false;
            }
        }

        // Is it a wall?
        if(maze[newRow][newCol] == WALL ) {
            return false;
        }

        // all good, its a valid move
        return true;
    }

    public static void main(String [] args) {

        int[][] maze = {
                {0,0,1,0,0},
                {0,0,0,0,1},
                {1,0,1,1,1},
                {0,1,0,0,0},
        };

        for(int i=0; i<maze.length; i++) {
            for(int j=0; j<maze[0].length; j++) {
                System.out.print(maze[i][j]+" ");
            }
            System.out.println("");
        }

        List<int[]> retList = new ArrayList<>();
        if(!findPath(maze,
                new int[]{0,0},
                new int[]{maze.length-1, maze[0].length-1},
                retList)) {
            System.out.println("Path could not be found");
        }
        else {
            System.out.println("Path: ");
            for(int[]c : retList) {
                System.out.print("["+c[0]+", "+c[1]+"]");
            }
            System.out.println("");
        }
    }
}
