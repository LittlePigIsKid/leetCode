package RotateList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
	private static class ListNode {
		    int val;
	        ListNode next;
		    ListNode(int x) { val = x; }
		 }
    public ListNode rotateRight(ListNode head, int k) {
        ListNode temp = head;
        int n = findLength(temp);
        
        if(n==0)
            return null;
        k %= n;
        if(k==0)
            return head;
        
        ListNode begin = head;
        ListNode beforeBegin = null;
        ListNode end = head;
        for(int i=1; i<k; i++)
            end = end.next;
        while(end.next!=null){
        	beforeBegin = begin;
            begin = begin.next;
            end = end.next;
        }
        beforeBegin.next = null;
        reverse(begin);
        begin.next = head;
        return end;
    }
    
    private int findLength(ListNode temp){
        int result = 0;
        while(temp!=null){
            result++;
            temp = temp.next;
        }
        return result;
    }
    
    private void reverse(ListNode begin){
        ListNode index1 = begin;
        ListNode index2 = index1.next;
        index1.next = null;
        while(index2!=null){
            ListNode temp = index2.next;
            index2.next = index1;
            index1 = index2;
            index2 = temp;
        }
    }
    public static void main(String[] args){
    	ListNode head = new ListNode(1);
    	ListNode index = head;
    	index.next = new ListNode(2);
    	index = index.next;
    	index.next = new ListNode(4);
    	int k = 2;
    	Solution s = new Solution();
    	ListNode result = s.rotateRight(head, k);
    	while(result!=null){
    		System.out.println(result.val);
    		result = result.next;
    	}
    }
}