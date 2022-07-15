package 回溯.Lee37;

import java.util.Arrays;
import java.util.Comparator;

public class Lee37 {
    public static void main(String[] args) {
        Integer[] ints = new Integer[2];

    }
    public void solveSudoku(char[][] board) {
        backtracking(board);

    }
    boolean backtracking(char[][] board){
        for(int i = 0; i< board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j] != '.') continue;
                for(int k = 1; k <= 9; k++){
                    if(isValid(i,j,k,board)){
                        board[i][j] = 'k';
                        if(backtracking(board)) return true;
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }
    boolean isValid(int row,int col,int k, char[][] board){
        for(int i = 0; i < 9; i++){
            if(board[i][col] == 'k'){
                return false;
            }
        }
        for(int i = 0; i< 9; i++){
            if(board[row][i] == 'k'){
                return false;
            }
        }
        int n = (col/3)*3;
        int m = (row/3)*3;
        for(int i = m; i < m+3;i++){
            for(int j = n ; j<n+3; j++){
                if(board[i][j]=='k'){
                    return false;
                }
            }
        }
        return true;
    }
}
