package IntegerToRaman;

public class Solution {
    public String intToRoman(int num) {
        int[] count = new int[7];
        int[] divide = new int[7];
        init(divide);
        int index = 0;
        while(num>0){
            count[index] = num/divide[6-index];
            num = num%divide[6-index++];
        }
        return helper(count);
    }
    private String helper(int[] count){
        char[] chars = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        StringBuilder builder = new StringBuilder();
        int index = 0;
        while(index<7){
            if(count[6-index]==4){
                if(count[6-index-1]==1){
                    builder.insert(0, chars[index+2]);
                    builder.insert(0, chars[index]);
                }else{
                    builder.insert(0, chars[index+1]);
                    builder.insert(0, chars[index]);
                }
                index++;
                index++;
            }
            else{
                int temp = 0;
                while(temp<count[6-index]){
                    temp++;
                    builder.insert(0, chars[index]);
                }
                index++;
            }
        }
        String s = builder.toString();
        return s;
    }
    private void init(int[] array){
        boolean flag = false;
        int value1 = 1;
        int value5 = 5;
        for(int i=0; i<7; i++){
            if(!flag){
                array[i] = value1;
                value1 *= 10;
                flag = true;
            }else{
                array[i] = value5;
                value5 *= 10;
                flag = false;
            }
        }
    }
    public static void main(String[] args){
    	Solution sol = new Solution();
    	int value = 15;
    	System.out.println(sol.intToRoman(value));
    }
}