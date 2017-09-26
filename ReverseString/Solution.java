package ReverseString;

/*public class Solution {
    public String ReverseSentence(String str) {
		String[] array = str.split(" ");

		StringBuilder builder = new StringBuilder();

		if(array.length>0)
        	builder.append(array[array.length-1]);
        else 
            builder.append(' ');
        for(int i=array.length-2; i>=0; i--){
         	builder.append(" ");
            builder.append(array[i]);
        }
        
        String s = builder.toString();
        return s;
    }
    public static void main(String[] args){
    	Solution sol = new Solution ();
    	String s = "i am a student.";
    	System.out.println(sol.ReverseSentence(s));
    }
}*/
public class Solution {
    public String ReverseSentence(String str) {
        if(str.trim().equals("")){
            return str;
        }
        String[] st = str.split(" ");
        String s = "";
        for(int i=st.length-1;i>0;i--){
            s = s+st[i]+" ";
        }
        s = s+st[0];
        return s;
    }
    public static void main(String[] args){
    	Solution sol = new Solution ();
    	String s = "i am a student.";
    	System.out.println(sol.ReverseSentence(s));
    }
}