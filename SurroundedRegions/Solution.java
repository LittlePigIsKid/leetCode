package SurroundedRegions;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    Set<Point> set = new HashSet<Point>();
    Set<Point> visited = new HashSet<Point>();
    private static class Point{
        int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        public boolean equals(Object o){
            return (this.x == ((Point) o).x && this.y ==((Point) o).y);
        }
        public int hashCode(){
            return x<<y;
        }
    }
    public void solve(char[][] board) {
        if(board==null)
            return ;
        int row = board.length;
        if(row==0)
        	return;
        int column = board[0].length;
        for(int i=0; i<column; i++){
            helper(board, row, column, 0, i);
            helper(board, row, column, row-1, i);
        }
        for(int j=1; j<row-1; j++){
            helper(board, row, column, 0, j);
            helper(board, row, column, column-1, j);
        }
        
        for(int i=1; i<row-1; i++)
            for(int j=1; j<column-1; j++)
                if(!set.contains(new Point(i, j)))
                   board[i][j]='X';
        for(int i=0; i<row; i++)
        	for(int j=0; j<column; j++)
        		System.out.println(board[i][j]);
    }
    private void helper(char[][] board, int row, int column, int i, int j){
        if(i<0||i>=row||j<0||j>=column)
            return;
        if(board[i][j]=='O'){
            Point temp = new Point(i, j);
            if(visited.contains(temp))
                return;
        	set.add(temp);
        	visited.add(temp);
            helper(board, row, column, i+1, j);
            helper(board, row, column, i-1, j);
            helper(board, row, column, i, j+1);
            helper(board, row, column, i, j-1);
        }else
        	return;
    }
    public static void main(String[] args){
    	Solution sol = new Solution();
    	char[][] board = new char[][]{{'X', 'X', 'X'}, {'X', 'O', 'X'},{'X', 'X', 'X'}};
    	sol.solve(board);
    }
}