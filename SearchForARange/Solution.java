package SearchForARange;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int index = binarySearch(nums, 0, n-1, target);
        int[] result = new int[2];
        if(index==-1){
            result[0] = -1;
            result[1] = -1;
        }else{
            System.out.println(index);
            int begin = index;
            int end = index;
            while(begin-1>=0&&nums[begin-1]==target)
                begin--;
            while(end+1<n&&nums[end+1]==target)
                end++;
            result[0] = begin;
            result[1] = end;
        }
        return result;            
    }
    private int binarySearch(int[] nums, int begin, int end, int target){
        if(begin>end)
            return -1;
        int middle = (begin+end)/2;
        if(nums[middle] == target)
            return middle;
        else if(nums[middle]>target)
            return binarySearch(nums, begin, middle-1, target);
        else 
            return binarySearch(nums, middle+1, end, target);
    }
    public static void main(String[] args){
    	int[] nums = {1,2,3,3,3,3,4,5,9};
    	Solution sol = new Solution();
    	nums = sol.searchRange(nums, 3);
    	for(int temp : nums)
    		System.out.println(temp);
    }
}