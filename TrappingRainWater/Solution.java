package TrappingRainWater;

public class Solution {
    public int trap(int[] height) {
    	if(height.length<2)
    		return -1;
    	int[] left = new int[height.length];
    	left[0] = 0;
    	int[] right = new int[height.length];
    	right[height.length-1] = 0;
    	for(int i=1; i<left.length; i++)
    		left[i] = Math.max(left[i-1], height[i-1]);
    	for(int i=right.length-2; i>-1; i--)
    		right[i] = Math.max(right[i+1], height[i+1]);
    	int result = 0;
    	for(int i=0; i<left.length; i++){
    		int min = Math.min(left[i], right[i]);
    		if(min>height[i])
    			result += min - height[i];
    	}
    	return result;
    }
    public static void main(String[] args){
    	int[] height = {};
    	System.out.println( new Solution().trap(height) );
    }
}