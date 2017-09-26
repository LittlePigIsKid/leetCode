package SerializeTree;

/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
public class Solution {
    StringBuilder builder = new StringBuilder();
    int value = 0;
    String Serialize(TreeNode root) {
        helperSerialize(root);      
        String s = builder.toString();
        return s;
    }
    public void helperSerialize(TreeNode root){
        if(root==null){
            builder.append("@,");
            return;
        }
        builder.append(root.val);
        builder.append(',');
        helperSerialize(root.left);
        helperSerialize(root.right);
    }
    TreeNode Deserialize(String str) {
    	return helperDeserialize(str);
    }
    public TreeNode helperDeserialize(String str){
		if(value>=str.length()){
            return null;
        }
        TreeNode root = null;
        if(str.charAt(value)=='@'){
			value += 2;
            return null;
        }else{
            int temp = 0;
            while(value<str.length()&&str.charAt(value)!=',')
                temp = temp*10+str.charAt(value++)-'0';
            value++;
            root = new TreeNode(temp);
            root.left = helperDeserialize(str);
            root.right = helperDeserialize(str);
            return root;
        }
    }
    private void firstVisit(TreeNode root){
    	if(root==null)
    		System.out.println("@");
    	else{
    		System.out.println(root.val);
    		firstVisit(root.left);
    		firstVisit(root.right);
    	}
    }
    public static void main(String[] args){
    	Solution sol = new Solution();
    	TreeNode root = new TreeNode(8);
    	root.left = new TreeNode(6);
    	root.right = new TreeNode(10);
    	root.left.left = new TreeNode(5);
    	root.left.right = new TreeNode(7);
    	root.right.left = new TreeNode(9);
    	String str = sol.Serialize(root);
    	System.out.println(str);
    	TreeNode temp = sol.Deserialize(str);
    	sol.firstVisit(temp);
    }
}