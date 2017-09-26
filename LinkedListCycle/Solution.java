package LinkedListCycle;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
	static class ListNode {
		      int val;
		      ListNode next;
		     ListNode(int x) {
		          val = x;
		          next = null;
		      }
		  }
    public boolean hasCycle(ListNode head) {
        boolean result = false;
        if(head==null||head.next==null||head.next.next==null||head.next.next.next==null)
            return result;
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(fast.next.next!=null&&fast!=slow){
            fast = fast.next.next;
            slow  = slow.next;
        }
        if(fast==slow)
            result = true;
        else
            result = false;
        /*if(fast.next.next==null)
            result = false;
        else
            result = true;*/
        return result;
    }
    public static void main(String[] args){
    	ListNode head = null;
    	ListNode index;
    	for(int i=0; i<28; i++){
    		index = new ListNode(i);
    		if(i==0)
    			head = index;
    		index = index.next;
    	}
    	Solution s= new Solution();
    	s.hasCycle(head);
    }
}