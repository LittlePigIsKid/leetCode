package MedianOfTwoSortedArrays;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int value = (m+n)/2;
        int value1 = (m+n)%2;
        if(value1==0){
            double result = 0;
            result += helper(nums1, nums2, value, 0, 0);
            result += helper(nums1, nums2, value+1, 0, 0);
            return result/2;
        }else{
            return (double) helper(nums1, nums2, value+1, 0, 0);
        }
    }
    private int helper(int[] nums1, int[] nums2, int k, int index1, int index2){
        int m = nums1.length;
        int n = nums2.length;
        if(m-index1>n-index2)
            return helper(nums2, nums1, k, index2, index1);
        if(m-index1<=0)
            return nums2[index2+k-1];
        if(k==1)
            return Math.min(nums1[index1], nums2[index2]);
        int temp1 = Math.min(m, index1+k/2)-1;
        int temp2 = index2+k-temp1-2+index1;
        if(nums1[temp1]==nums2[temp2])
            return nums1[temp1];
        else if(nums1[temp1]<nums2[temp2])
            return helper(nums1, nums2, k-temp1+index1-1, temp1+1, index2);
        else
            return helper(nums1, nums2, k-temp2+index2-1, index1, temp2+1);
    }
    public static void main(String[] args){
    	Solution sol = new Solution();
    	int[] nums1 = {2, 4};
    	int[] nums2 = {1};
    	System.out.println( sol.findMedianSortedArrays(nums1, nums2) );
    }
}