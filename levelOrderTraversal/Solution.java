package levelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	public static class TreeNode {  
		 int val;
         TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root==null)
            return result;
        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        nodes.add(root);
        levelOrderAuxiliary(result, nodes);
        return result;
    }
    private void levelOrderAuxiliary(List<List<Integer>> result, LinkedList<TreeNode> nodes){
        if(nodes.size()<1)
            return;
        List<Integer> tempList = new ArrayList<Integer>();
        LinkedList<TreeNode> tempNodes = new LinkedList<TreeNode>();
        int n = nodes.size();
        for(int i=0; i<n; i++){
            TreeNode temp = nodes.remove();
            tempList.add(temp.val);
            System.out.println(temp.val);
            if(temp.left!=null)
                tempNodes.add(temp.left);
            if(temp.right!=null)
                tempNodes.add(temp.right);
        }
        result.add(tempList);
        levelOrderAuxiliary(result, tempNodes);
    }
    
    public static void main(String[] args){
    	Solution sol = new Solution();
    	TreeNode root = new TreeNode(1);
    	TreeNode index = root;
    	index.left = new TreeNode(2);
    	index.right = new TreeNode(3);
    	System.out.println( sol.levelOrder(root) );
    }
}