package PascalsTriangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(numRows<1)
            return list;
        List<Integer> temp = new ArrayList<Integer>();
        temp.add(1);
        list.add(temp);
        for(int i=1; i<numRows; i++){
            temp = new ArrayList<Integer>();
            temp.add(1);
            for(int j=0; j<i-1; j++){
                List<Integer> value = list.get(i-1);
                temp.add( value.get(j) + value.get(j+1) );
            }
            temp.add(1);
            list.add(temp);
        }
        return list;
    }
    public static void main(String[] args){
    	Solution sol = new Solution();
    	for(List<Integer> temp : sol.generate(3))
    		System.out.println(temp);
    }
}