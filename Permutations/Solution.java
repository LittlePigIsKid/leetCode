package Permutations;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        int N = nums.length;
        int size = size(N);
        for(int i=0; i<size; i++){
            List<Integer> tempList = new ArrayList<Integer>();
            for(Integer ii : nums)
            	tempList.add(ii);
            list.add(tempList);
            nums = nextPermutation(nums);
        }
    
        
        /*List<Integer> tempList = new ArrayList<Integer>();
        for(Integer ii : nums)
        	tempList.add(ii);
        list.add(tempList);
        int index1 = firstVolitate(nums);
        if(index1==-1)
            return list;
        int index2 = firstLarger(nums, index1);
        if(index1==-1)
            return list;
        while(index1!=-1&&index2!=-1){
            
        }*/
        return list;
    }
    
    private int[] nextPermutation(int[] nums){
        int index1 = firstVolitate(nums);
        if(index1==-1)
            return null;
        int index2 = firstLarger(nums, index1);
        if(index2==-1)
            return null;
        swap(nums, index1, index2);
        reverse(nums, index1);
        return nums;
    } 
    private void reverse(int[] nums, int index){
        int end = nums.length-1;
        int begin = index+1;
        while(begin<end)
            swap(nums, begin++, end--);
        return;
    }
    private void swap(int[] nums, int index1, int index2){
        int value = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = value;
        return;
    }
    private int firstLarger(int[] nums, int index){
        for(int i=nums.length-1; i>index; i--){
            if(nums[i]>nums[index])
                return i;
        }
        return -1;
    }
    private int firstVolitate(int[] nums){
        for(int i = nums.length-2; i>=0; i--){
            if(nums[i]<nums[i+1])
                return i;
        }
        return -1;
    }
    
    private int size(int N){
        int index = 1;
        int value = 1;
        while(index<=N){
            value *= index;
            index++;
        }
        return value;
    }
    public static void main(String[] args){
    	int[] nums = {3,2,1};
    	Solution sol = new Solution();
    	for(List<Integer> list : sol.permute(nums)){
    		System.out.println(list);
    	}
    	
    }
}