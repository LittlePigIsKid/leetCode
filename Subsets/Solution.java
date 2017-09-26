package Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsets(int[] nums) {
        int N = nums.length;
        if(N<1)
            return list;
        Arrays.sort(nums);
        helper(nums, 0, N,
               new ArrayList<Integer>());
        return list;
    }
    private void helper(int[] nums, int index, int size,
                        List<Integer> temp){
        if(index==size){
            list.add(temp);
            return;
        }
        List<Integer> temp1 = new ArrayList<Integer>();
        for(Integer i : temp)
            temp1.add(i);
        
        temp.add(nums[index]);
        helper(nums, index+1, size,
               temp);
        helper(nums, index+1, size,
               temp1);
        return;
    }
    
    public static void main(String[] args){
    	Solution sol = new Solution();
    	int[] nums = {0};
    	for(List<Integer> i : sol.subsets(nums))
    		System.out.println(i);
    }
}