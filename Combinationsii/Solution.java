package Combinationsii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        List<Integer> temp  = new ArrayList<Integer>();
        for(int i=0; i<candidates.length; i++){
        	if(i>0&&candidates[i-1]==candidates[i])
                continue;
        	temp.add(candidates[i]);
        	helper(candidates, i+1, target-candidates[i], list, temp);
        	temp.remove(temp.size()-1);
        }
        return list;
    }
    private void helper(int[] candidates, int start, int target, List<List<Integer>> list, List<Integer> temp){
        if(target<0)
            return;
        if(target==0){
            list.add( new ArrayList<Integer>(temp) );
            return;
        }
        for(int i=start; i<candidates.length; i++){
            temp.add(candidates[i]);
            helper(candidates, i+1, target-candidates[i], list, temp);
            temp.remove(temp.size()-1);
        }
    }
    public static void main(String[] args){
    	Solution sol = new Solution();
    	int[] candidates = {10,1,2,7,6,1,5};
    	int target = 8;
    	System.out.println( sol.combinationSum2(candidates, target) );
    }
}