package Candy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public int candy(int[] ratings) {
        Set<Map<Integer, Integer>> set = new TreeSet<Map<Integer, Integer>>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(1, 5);
        map.put(2, 4);
        map.put(4, 1);
        map.put(6, 9);
        set.add(map);
        System.out.println(set);
        return 1;
    	/*Arrays.sort(ratings);
        if(ratings.length<1)
        
            return 0;
        int result = 1;
        int candy = 1;
        for(int i=1; i<ratings.length; i++){
            if(ratings[i-1]<ratings[i])
                candy++;
            result += candy;
        }
        return candy;*/
    }
    public static void main(String[] args){
    	int[] ratings = {0};
    	new Solution().candy(ratings);
    }
}
