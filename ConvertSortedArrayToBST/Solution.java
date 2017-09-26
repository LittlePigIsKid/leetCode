package ConvertSortedArrayToBST;

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
	public static  class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		 }
	public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
    private TreeNode helper(int[] nums, int begin, int end){
        if(end<begin)
            return null;
        if(begin==end)
            return new TreeNode(nums[begin]);
        TreeNode root = new TreeNode(nums[begin]);
        int middle = (begin+end)/2;
        root.left = helper(nums, begin, middle-1);
        root.right = helper(nums, middle+1, end);
        return root;
    }
    
    public static void main(String[] args){
    	int[] nums = {1,3};
    	Solution s = new Solution();
    	TreeNode result = s.sortedArrayToBST(nums);
    }
}