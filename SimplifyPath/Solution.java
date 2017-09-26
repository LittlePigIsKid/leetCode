package SimplifyPath;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String simplifyPath(String path) {
        List<Character> list = new ArrayList<Character>();
        int index = 0;
        while(path.length()>index){
            char ch = path.charAt(index);
            int begin = index;
            index++;
            int end = index; 
            if(ch=='/'){
                while(end<path.length()&&path.charAt(end)=='/'){
                    end++;
                    index++;
                }
            }else {
            	if(ch=='.'){
	                while(end<path.length()&&path.charAt(end)=='.'){
	                    end++;
	                    index++;
	                }
	            }else{
	                while(end<path.length()&&(path.charAt(end)!='/'&&path.charAt(end)!='.')){
	                    end++;
	                    index++;
	                }
	            }
            }
            helper(list, begin, end, path);
        }
        if(list.size()==1)
        	return "/";
        
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<list.size(); i++){
        	char temp = list.get(i);
        	if(temp=='/'&&i==list.size()-1)
        		break;
        	builder.append(temp);
        }
        String s = builder.toString();
        return s;
    }
            
    private void helper(List<Character> list, int begin, int end, String path){
        if(path.charAt(begin)==path.charAt(end-1)&&path.charAt(begin)=='/'){
        	if(list.size()>0&&list.get(list.size()-1)=='/')
        		return;
        	list.add('/');
        }
        else if(path.charAt(begin)=='.'){
            if(end-begin==1){
                return;
            }else if(end-begin==3){
            	while(begin<end){
            		list.add('.');
            	}
            }else{
                if(list.size()>1){
                    list.remove(list.size()-1);
                    while(list.get(list.size()-1)!='/')
                        list.remove(list.size()-1);
                    if(list.size()>1)
                        list.remove(list.size()-1);
                }else{
                    return;
                }
            }
        }else{
            while(begin<end)
                list.add(path.charAt(begin++));
        }
    }
    public static void main(String[] args){
    	Solution sol = new Solution();
    	String path = "/a//afa//.././//afdas/../afd/../asdfasf/./a/";
    	System.out.println(sol.simplifyPath(path));
    }
}