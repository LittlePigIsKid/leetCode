package MergekSortedLists;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
	public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;
        if(lists.length==1)
            return lists[0];
        ListNode temp = mergeTwoLists(lists[0], lists[1]);
        for(int i=2; i<lists.length; i++){
            temp = mergeTwoLists(temp, lists[i]);
        }
        return temp;
    }
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode index = result;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                index.next = l1;
                l1 = l1.next;
                index = index.next;
                index.next = null;
            }else{
                index.next = l2;
                l2 = l2.next;
                index = index.next;
                index.next = null;
            }
        }
        if(l1==null)
            index.next = l2;
        else
            index.next = l1;
        return result.next;
    }
    
    public static void main(String[] args){
    	ListNode[] array = new ListNode[10];
    }
}