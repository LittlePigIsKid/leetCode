package SingleNumberIII;

public class Solution {
    public int[] singleNumber(int[] nums) {
        int value = 0;
        for(int i : nums)
            value ^= i;
        int auxiliary = 1;
        while(true){
            if( (value&1)==1 )
                break;
            auxiliary *= 2;
            value = value >> 1;
        }
        int[] result = new int[2];
        for(int i : nums)
            if((auxiliary&i)==0)
                result[0] ^= i;
            else 
                result[1] ^= i;
        return result;
    }
    public static void main(String[] args){
    	Solution sol = new Solution();
    	int[] nums = {1,2,1,3,2,5};
    	for(int i : sol.singleNumber(nums))
    	System.out.println(i);
    }
}