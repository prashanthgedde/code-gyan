package prashanthgedde.codegyan.bfs;

import java.util.*;

/**
 * Walls and Gates
 * You are given a m x n 2D grid initialized with these three possible values.
 *
 * -1 - A wall or an obstacle.
 * 0 - A gate.
 * INF - Infinity means an empty room.
 * We use the value 231 - 1 = 2147483647 to represent INF
 * as you may assume that the distance to a gate is less than 2147483647.
 *
 * Fill each empty room with the distance to its nearest gate.
 * If it is impossible to reach a gate, it should be filled with INF.
 *
 * For example, given the 2D grid:
 * INF  -1  0  INF
 * INF INF INF  -1
 * INF  -1 INF  -1
 *   0  -1 INF INF
 *
 * After running your function, the 2D grid should be:
 *   3  -1   0   1
 *   2   2   1  -1
 *   1  -1   2  -1
 *   0  -1   3   4
 */
public class n02_WallsAndGates {

    private static final int []DIR1 = {0, 0, -1, 1};
    private static final int []DIR2 = {-1, 1, 0, 0};

    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    bfs(rooms, i, j);
                    print(rooms);
                }
            }
        }
    }

    private static void print(int[][] rooms) {
        for(int i=0; i<rooms.length; i++) {
            for(int j=0; j<rooms[0].length; j++) {
                System.out.print(rooms[i][j]+"\t");
            }
            System.out.println("");
        }
        System.out.println("---- ----- ----");
    }

    private void bfs(int [][]rooms, int i, int j) {

        boolean [][]visited = new boolean[rooms.length][rooms[0].length];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});

        while(!q.isEmpty()) {
            int[] cell = q.poll();
            int x = cell[0]; int y = cell[1];

            if(!visited[x][y] && rooms[x][y] != -1) {
                visited[x][y] = true;
                int dist = rooms[x][y]+1;
                if(x<rooms.length-1) {
                    q.offer(new int[]{x+1, y});
                    if(rooms[x+1][y] > dist) {
                        rooms[x+1][y] = dist;
                    }
                }
                if(x>0) {
                    q.offer(new int[]{x-1, y});
                    if(rooms[x-1][y] > dist) {
                        rooms[x-1][y] = dist;
                    }
                }
                if(y<rooms[0].length-1) {
                    q.offer(new int[]{x, y+1});
                    if(rooms[x][y+1] > dist) {
                        rooms[x][y+1] = dist;
                    }
                }
                if(y>0) {
                    q.offer(new int[]{x, y-1});
                    if (rooms[x][y-1] > dist) {
                        rooms[x][y-1] = dist;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        n02_WallsAndGates obj = new n02_WallsAndGates();

        int[][]rooms = new int[][]{
                {Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
                {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
                {0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE}};

        obj.wallsAndGates(rooms);
    }
}
