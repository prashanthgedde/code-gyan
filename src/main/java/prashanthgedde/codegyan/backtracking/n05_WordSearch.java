package prashanthgedde.codegyan.backtracking;

/**
 * 79. Word Search
 * Medium
 *
 * https://leetcode.com/problems/word-search/
 *
 * Given an m x n grid of characters board and a string word,
 * return true if word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cells,
 * where adjacent cells are horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 */

public class n05_WordSearch {
    public boolean exist(char[][] board, String word) {

        // init visited array
        boolean [][]visited = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                visited[i][j] = false;
            }
        }

        // Search for the given word
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(wordSearch(board, word, 0, i, j, visited)) return true;
            }
        }
        return false;
    }

    public boolean wordSearch(char[][] board,
                              String word,
                              int index,
                              int row,
                              int col,
                              boolean [][] visited
    ) {

        if(index == word.length()) {
            return true;
        }

        if(row < 0 || row >= board.length ||
                col < 0 || col >= board[0].length) {
            return false;
        }

        if(!visited[row][col] && board[row][col] == word.charAt(index)) {
            visited[row][col] = true;

            if(wordSearch(board, word, index+1, row+1, col, visited) ||
                    wordSearch(board, word, index+1, row-1, col, visited) ||
                    wordSearch(board, word, index+1, row, col+1, visited) ||
                    wordSearch(board, word, index+1, row, col-1, visited)) {
                return true;
            }
            visited[row][col] = false;
        }
        return false;
    }

    public static void main(String[] args) {

        n05_WordSearch wordSearch = new n05_WordSearch();

        char [][]board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};
        System.out.println(wordSearch.exist(board, "ABCCED"));
        System.out.println(wordSearch.exist(board, "SEE"));
        System.out.println(wordSearch.exist(board, "SEED"));
        System.out.println(wordSearch.exist(board, "SEEN"));
    }
}
