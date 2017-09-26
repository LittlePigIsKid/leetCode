package DumplicateNumber;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        Set<Integer> set = new HashSet<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<n; i++){
            for(int value=-t; value<=t; value++){
                long temp = 0;
                temp += nums[i]+value;
                if(temp<Integer.MIN_VALUE||temp>Integer.MAX_VALUE){
                    continue;
                }else if( set.contains( ((int)temp)) ){
                    if(i-map.get(((int)temp))<=k)
                        return true;
                }else{
                    map.put(((int)temp), i);
                    set.add((int)temp);
                }
            }
        }
        return false;
    }
    public static void main(String[] args){
    	Solution sol = new Solution();
    	int[] nums = {2, 4};
    	int k = -3;
    	int t = 3;
    	System.out.println(sol.containsNearbyAlmostDuplicate(nums, k, t));
    }
}