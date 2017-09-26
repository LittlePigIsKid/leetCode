package PartitionList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
	static public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
	}
    public ListNode partition(ListNode head, int x) {
        ListNode less1 = null, less2 = null;
        ListNode greater1 = null, greater2 = null;
        boolean firstLess = true, firstGreater = true;
        ListNode index = head;
        while(index!=null){
            if(index.val<x){
                if(firstLess) {
                    less1 = index;
                    less2 = index;
                    firstLess = false;
                    index = index.next;
                    less2.next = null;
                }else{
	                less2.next = index;
	                less2 = less2.next;
	                index = index.next;
	                less2.next = null;
                }
            }else{
                if(firstGreater){
                    greater1 = index;
                    greater2 = index;
                    firstGreater = false;
                    index = index.next;
                    greater2.next = null;
                }else{ 
	                greater2.next = index;
	                greater2 = greater2.next;
	                index = index.next;
	                greater2.next = null;
                }
            }
        }
        if(less1==null) return greater1;
        less2.next = greater1;
        return less1;
    }
    
    public static void main(String[] args){
    	ListNode head = new ListNode(2);
    	head.next = new ListNode(5);
    	ListNode index = head.next;
    	index.next = new ListNode(1);
    	ListNode temp = new Solution().partition(head, 2);
    	while(temp!=null){
    		System.out.println(temp.val);
    		temp = temp.next;
    	}
    }
}