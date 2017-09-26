package StringToIntegerATOI;

public class Solution {
    public int myAtoi(String str) {
        int INT_MAX = 2147483647;
        int INT_MIN = -2147483648;
        int n = str.length();
        int i = 0;
        // 边界检查
        if(n==0)
            return 0;
        int num = 0;
        int flag;
        while(i<n&&str.charAt(i)==' ')
            i++;
        if(i==n)
            return 0;
        if(str.charAt(i)=='-'){
            flag = -1;
            i++;
        }
        else{
            flag = 1;
            if(str.charAt(i)=='+')
                i++;
        }
        //正式的处理代码
        long value = 0, temp;
        for(; i<n; i++){
            if(str.charAt(i)<'0'||str.charAt(i)>'9')
                break;
            if(flag>0){
                value = value*10 + (str.charAt(i)-'0');
                temp = value;
                num = (int)temp;
                if(value!=num)
                    return INT_MAX;
            }else{
                value = value*10 - (str.charAt(i)-'0');
                temp = value;
                num = (int)temp;
                if(num!=value)
                    return INT_MIN;
            }
            /*if(((temp^num)<0)&&(((str.charAt(i)-'0')^num)<0)){
                if(flag<0)
                    return INT_MIN;
                else
                    return INT_MAX;
            }*/
            //分成正负数判断溢出
            /*if(flag>0){
                if(temp*10>INT_MAX-(str.charAt(i)-'0'))
                    return INT_MAX;
            }else{
                if(-(str.charAt(i)-'0')<INT_MIN+temp*10)
                    return INT_MIN;
            }*/
        }
       /* System.out.println(num);
        num = num*flag;*/
        
        return num;
    }
    
    public static void main(String[] args){
    	String str = "    10522545459";
    	System.out.println(new Solution().myAtoi(str));
    }
}