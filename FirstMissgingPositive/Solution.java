package FirstMissgingPositive;

public class Solution {
    public int firstMissingPositive(int[] nums) {
        int N = nums.length;
        if(N<1)
            return 1;
        helper(nums, N);
        for(int i=0; i<N; i++)
            if(nums[i]!=i+1)
                return i+1;
        return nums[N-1]+1;            
    }
    private void helper(int[] nums, int N){
        for(int i=0; i<N; i++){
            int value = nums[i];
            if(nums[i]!=i+1&&value>0&&value-1>=0&&value-1<N){
                int temp = nums[value-1];
                nums[value-1] = value;
                nums[i] = temp;
                i--;
            }
        }
    }
    public static void main(String[] args){
    	int[] nums = {3,4,-1, 1};
    	Solution sol = new Solution();
    	System.out.println(sol.firstMissingPositive(nums));
    }
}