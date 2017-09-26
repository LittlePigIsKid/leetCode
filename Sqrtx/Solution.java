package Sqrtx;

public class Solution {
    public int mySqrt(int x) {
        return (int)helper(x, 0, x);
    }
    private long helper(int x,long value1, long value2){
        if(value1>value2){
            return value2;
        }
        long value = (value1+value2)/2;
        long auxiliary = value*value;
        if(auxiliary==x)
            return value;
        if(auxiliary>x)
            return helper(x, value1, value-1);
        else
            return helper(x, value+1, value2);
    }
}