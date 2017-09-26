import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String simplifyPath(String path) {
        String[] array = path.split("/");                 //first one contains nothing
        int n = array.length;
        List<String> list = new ArrayList<String>();
        int size = 0;
        for(int i=0; i<n; i++){
            if(array[i].equals("")){
                continue;
            }
            else if(array[i].equals(".")){
                /*if(size==0)
                    continue;
                else if(size<=2){
                    list = new ArrayList<String>();
                    size = 0;
                }
                else{
                	continue;
                }*/
            	continue;
            }else if(array[i].equals("..")){
                if(size<=3){
                    list = new ArrayList<String>();
                    size=0;
                }else{
                    list.remove(--size);
                    list.remove(--size);
                    /*list.remove(--size);
                    list.remove(--size);*/
                }
            }else{
                list.add("/");
                list.add(array[i]);
                size += 2;
            }
        }
        if(size==0)
            return "/";
        StringBuilder result = new StringBuilder();
        for(String temp : list)
            result.append(temp);
        return result.toString();
    }
    public static void main(String[] args){
    	Solution s = new Solution();
    	String str = "/home/foo/.ssh/../.ssh2/authorized_keys/";//"/home/of/foo/../../bar/../../is/./here/.";//"/home/foo/.ssh/../.ssh2/authorized_keys/";
    	System.out.println(s.simplifyPath(str));
    }
}