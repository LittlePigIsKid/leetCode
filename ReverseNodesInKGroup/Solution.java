/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
package ReverseNodesInKGroup;
public class Solution {
	public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1)
            return head;
        ListNode result = new ListNode(0);
        ListNode begin = result, end = null;
        begin.next = null;
        ListNode beforeBegin = null, afterEnd = head;
        while(afterEnd!=null){
            
        	beforeBegin = begin;
            beforeBegin.next = null;
            
            begin = afterEnd;
            end = begin;
            
            int i=0; 
            for(; i<k-1; i++){
                if(end.next==null)
                	/*if(i+1==k){
                        reverse(begin, end);
                        beforeBegin.next = end;
                        begin.next = null;
                        return result.next;
                		System.out.println(" in the -----------"+"i+1==k");
                    }else*/
                if(i+1<k){
                        beforeBegin.next = begin;
                        end.next = null;
                        return result.next;
                    }
                else{
                    end = end.next;                    
                }
            }
            afterEnd = end.next;
            reverse(begin, end);
            beforeBegin.next = end;
            begin.next = null;
        }
        
        return result.next;
    }
    private void reverse(ListNode begin, ListNode end){
    	ListNode index = begin;
        ListNode before = null;
        ListNode next = null;
        while(index!=end){
            next = index.next;
            index.next = before;
            before = index;
            index = next;
        }
        index.next = before;
    }
    public static void main(String[] args){
    	ListNode head = new ListNode(1);
    	ListNode index = head;
    	index.next = new ListNode(2);
    	index = index.next;
    	index.next = new ListNode(3);
    	int k = 4;
    	index = new Solution().reverseKGroup(head, k);
    	while(index!=null){
    		System.out.println(index.val);
    		index = index.next;
    	}
    }
}