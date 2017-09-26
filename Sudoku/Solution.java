package Sudoku;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public void solveSudoku(char[][] board) {
        System.out.println( helper(board, 0, 0) );
    }
    private boolean helper(char[][] board, int i, int j){
    	System.out.println(i+" "+j);
        if(i>=9){
            return true;
        }else if(j>=9){
            return helper(board, i+1, 0);
        }else{
            if(board[i][j]!='.'){
                return helper(board, i, j+1);
            }else{
                List<Character> list = generateCh(board, i, j);
                for(int k=0; k<list.size(); k++){
                    board[i][j] = list.get(k);
                    if( helper(board, i, j+1) )
                    	return true;
                }
                board[i][j] = '.';
                return false;
            }
        }
    }
    private List<Character> generateCh(char[][] board, int i, int j){
        boolean[] array = new boolean[9];
        for(int tempI=0; tempI<9; tempI++){
            if(board[tempI][j]=='.'){
                continue;
            }else{
                array[board[tempI][j]-'1'] = true;
            }
        }
        for(int tempJ=0; tempJ<9; tempJ++){
            if(board[i][tempJ]=='.'){
                continue;
            }else{
                array[board[i][tempJ]-'1'] = true;
            }
        }
        int index1 = i/3*3;
        int index2 = j/3*3;
        for(int index=0; index<3; index++){
            for(int temp=0; temp<3; temp++){
                if(board[index1+index][index2+temp]=='.'){
                    continue;
                }else{
                    array[board[index1+index][index2+temp]-'1'] = true;
                }
            }
        }
        List<Character> list = new ArrayList<Character>();
        for(int k=0; k<array.length; k++){
            if(!array[k])
                list.add((char)('1'+k));
        }
        return list;
    }
    public static void main(String[] args){
    	Solution sol = new Solution();
    	/*char[][] board = {
    			{'.', '.', '9', '4', '7', '8', '.', '.', '.'},
    			{'7', '.', '.', '.', '.', '.', '.', '.', '.'},
    			{'.', '2', '.', '1', '.', '9', '.', '.', '.'},
    			{'.', '.', '7', '.', '.', '.', '2', '4', '.'},
    			{'.', '6', '4', '.', '1', '.', '5', '9', '.'},
    			{'.', '9', '8', '.', '.', '.', '3', '.', '.'},
    			{'.', '.', '.', '8', '.', '3', '.', '2', '.'},
    			{'.', '.', '.', '.', '.', '.', '.', '.', '6'},
    			{'.', '.', '.', '2', '7', '5', '9', '.', '.'}
    			
    	};*/
    	char[][] board = {
    			{'5', '1', '9', '4', '7', '8', '6', '3', '2'},
    			{'.', '8', '3', '6', '5', '2', '4', '1', '9'},
    			{'4', '2', '6', '1', '3', '9', '8', '7', '5'},
    			{'3', '5', '7', '9', '8', '6', '2', '4', '1'},
    			{'2', '6', '4', '3', '1', '7', '5', '9', '8'},
    			{'1', '9', '8', '5', '2', '4', '3', '6', '7'},
    			{'9', '7', '5', '8', '6', '3', '1', '2', '4'},
    			{'8', '3', '2', '4', '9', '1', '7', '5', '6'},
    			{'6', '4', '1', '2', '7', '5', '9', '8', '3'}
    			
    	};
    	sol.solveSudoku(board);
    	for(char[] temp : board){
    		for(char ch : temp){
    			System.out.print(ch);
    		}
    		System.out.println();
    	}
    }
}