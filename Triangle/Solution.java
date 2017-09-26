package Triangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        return helper(triangle);
    }
    private int helper(List<List<Integer>> triangle){
        /*if(i>=triangle.size()||j>=triangle.get(i).size())
            return 0;
        return triangle.get(i).get(j)+Math.min(helper(i+1, j, triangle), helper(i+1, j+1, triangle));*/
        int sum = 0;
        int sizeI = triangle.size();
        
        List<Integer> list = new ArrayList<Integer>();
        for(int k=0; k<triangle.get(sizeI-1).size()+1; k++)
            list.add(0);
        
        for(int i=sizeI-1; i>=0; i--){
            List<Integer> temp = new ArrayList<Integer>();
            int sizeJ = triangle.get(i).size();
            for(int j=0; j<sizeJ; j++)
                temp.add(Math.min(list.get(j), list.get(j+1))+triangle.get(i).get(j));        
            list = temp;
            temp = null;
        }
        return list.get(0);
    }
    public static void main(String[] args){
    	Solution sol = new Solution();
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	int[][] array = {{1},{2,-1},{1,10,11}};
    	for(int i=0; i<3; i++){
    		List<Integer> temp = new ArrayList<Integer>();
    		for(int j : array[i])
    			temp.add(j);
    		list.add(temp);
    	}
    	System.out.println(sol.minimumTotal(list));
    }
}