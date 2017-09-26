package SameTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	  public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	public boolean isSameTree(TreeNode p, TreeNode q) {
        Boolean result = new Boolean(true);
        preorderTraversal(p, q, result);
        return result;
    }
    private void preorderTraversal(TreeNode p, TreeNode q, Boolean result){
    	if(p==null&&q==null) return;
        else if(p==null&&q!=null){result = new Boolean(false); return;}
        else if(p!=null&&q==null){result = new Boolean(false); return;}
        else if(p.val!=q.val){result = new Boolean(false); return;}
        preorderTraversal(p.left, q.left, result);
        preorderTraversal(p.right, q.right, result);
    }
    
    public static void main(String[] args){
    	Solution solution = new Solution();
    	TreeNode q = new TreeNode(0);
    	TreeNode p = null;
    	System.out.println(solution.isSameTree(p, q));
    }
}