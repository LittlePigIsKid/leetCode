/*package SingleNumberII;

public class Solution {
    public int singleNumber(int[] nums) {
    	int n = nums.length;
    	if(n<1)
    		return 0;
    	int[] array = new  int[32];
        for(int i=0; i<n; i++)
            for(int j=0; j<32; j++){
                if((nums[i]&1)==1)
                    array[j]++;
                nums[i] = nums[i]>>1;
            }
        int result = 0;
        int value = 1;
        if(array[0]%3==1)
            result += value;
        for(int i=1; i<32; i++){
            value = value<<1;
            if(array[i]%3==1)
                result += value;
        }
        return result;
    }
    public static void main(String[] args){
    	int[] nums = {};
    	System.out.println(new Solution().singleNumber(nums));
    }
} success*/
// this is the solution after i conquerred the problem for a long time
package SingleNumberII;
public class Solution {
    public int singleNumber(int[] nums) {
        int[] count = new int[32];
        int auxiliary = 1;
        int result = 0;
        int idiotValue = 0;
        int flag = 0;
        for(int i=0; i<nums.length; i++){
            int value = Math.abs( nums[i] );
            
            if(value==-2147483648){
                idiotValue++;
                continue;
            }
            
            if(nums[i]<0)
                flag++;
            int j = 0;
            while(value!=0){
                if( (value&1)!=0 )
                    count[j]++;
                value = value>>1;
            	j++;
            }
        }
        if(idiotValue%3!=0)
            return -2147483648;
            
        for(int i=0; i<32; i++){
            if(count[i]%3!=0)
                result += auxiliary;
                auxiliary *= 2;
        }
        if(flag%3!=0)
            result = -result;
        return result;
    }
    public static void main(String[] args){
    	Solution sol = new Solution();
    	int[] nums = {0, 0, 0, 5};
    	System.out.println( sol.singleNumber(nums) );
    }
}