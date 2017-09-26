package GrayCode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> grayCode(int n) {
    	int[] result =  solution(n) ;
    	List<Integer> list = new ArrayList<Integer>(result.length);
    	for(int i=0; i<result.length; i++)
    		list.add(result[i]);
    	return list;
    }
    
    private int[] solution(int n){
        if(n==1){
            int[] a = {0,1};
            return a;
        }
        int value = get2N(n);
        int halfValue = value>>1;
        int[] array = new int[value];
            System.arraycopy(solution(n-1), 0, array, 0, halfValue);
        for(int i=0; i<halfValue; i++)
            array[value-1-i] = halfValue + array[i];
        return array;
    }
    
    private int get2N(int n){
        int i = 1;
        return i<<n;
    }
    public static void main(String[] args){
    	int n = 10;
    	System.out.println(new Solution().grayCode(n));
    }
}