package RotateImage;


public class Solution {
    public void rotate(int[][] matrix) {
        exchangeByCenture(matrix);
        exchangeByHalf(matrix);
    }
    private void exchange(int[][] matrix, int r1, int c1, int r2, int c2){
        int temp = matrix[r1][c1];
        matrix[r1][c1] = matrix[r2][c2];
        matrix[r2][c2] = temp;
    }
    private void exchangeByCenture(int[][] matrix){
        int n = matrix.length;
        for(int i=0; i<n; i++)
            for(int j=0; j<n-i; j++)
                exchange(matrix, i, j, n-1-j, n-1-i);
    }
    private void exchangeByHalf(int[][] matrix){
        int n = matrix.length;
        int k = n/2;
        for(int i=0; i<k; i++)
            for(int j=0; j<n; j++)
                exchange(matrix, i, j, n-1-i, j);
    }
    public static void main(String[] agrs){
    	int[][] matrix = {{1,2,3,64,4,5,5,6}, {1,3,2,8,4,67,4}, {1,2,3,4,56,7,5},
    	                  {1,6,3,4,6,4,3},{5,6,4,1,7,4,4},{1,2,3,4,5,6,7},{0,9,8,7,6,5,4} 
    	                 };
    	new Solution().rotate(matrix);
    	for(int i=0; i<matrix.length; i++)
    		for(int j=0; j<matrix.length; j++)
    	System.out.println(matrix[i][j]);
    }
}