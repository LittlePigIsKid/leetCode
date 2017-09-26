package MaxSquare;

public class Solution {
    public int maximalSquare(char[][] matrix) {
       int result = 0;
       StringBuilder builder = new StringBuilder();
       int m = matrix.length;
       int n = matrix[0].length;
       int temp = 0;
       boolean[][][][] array = new boolean[m][n][m][n];
       for(int i=0; i<m; i++){
           for(int j=0; j<n; j++){
               if(matrix[i][j]=='1'){
                   array[i][j][i][j] = true;
                   result = 1;
               }
               else
                   array[i][j][i][j] = false;
           }
       }
       for(int length=2; length<=m&&length<=n; length++){
           for(int i=0; m-i>=length; i++){
        	   
        	   temp = (length-1)/2;
               for(int j=0; n-j>=length; j++){
            	   if(array[i][j][temp+i][temp+j]&&
            	      array[i][j+temp+1][temp+i][j+length-1]&&
            	      array[temp+1+i][j][j+length-2][temp+j]&&
            	      array[temp+1+i][temp+1+j][i+length-2][i+length-2]){
                       
            		   array[i][i][j][j] = true;
                       result = length;
            	   }
               }
        	   /*int j = i+length-1;
               if(j>n-1)
                   break;
               temp = (i+j)/2;
               if(array[i][i][temp][temp]&&array[i][temp+1][temp][j]&&array[temp+1][i][j][temp]&&array[temp+1][temp+1][j][j]){
                   array[i][i][j][j] = true;
                   result = length;
               }*/
           }
       }
       return result*result;
    }
    public static void main(String[] args){
    	Solution sol = new Solution();
    	char[][] matrix = {"10100".toCharArray(), "10111".toCharArray()
    			, "11111".toCharArray(), "10010".toCharArray()};
    	System.out.println(sol.maximalSquare(matrix));
    }
}