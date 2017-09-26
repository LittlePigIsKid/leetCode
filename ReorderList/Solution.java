package ReorderList;

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
    public void reorderList(ListNode head){
        if(head==null||head.next==null)
            return;
        ListNode begin = head, end = head.next;
        while(true){
            if(end.next==null||end.next.next==null){
                ListNode temp = begin;
                begin = begin.next;
                temp.next = null;
                break;
            }else{
                begin = begin.next;
                end = end.next.next;
            }
        }
        ListNode first = head;
        ListNode second  = reverse(begin);
        head = merge(first, second);
        while(head!=null){
        	System.out.println(head.val);
        	head = head.next;
        }
    }
    
    private ListNode merge(ListNode first, ListNode second){
        ListNode result = new ListNode(0);
        ListNode before = result;
        while(first!=null){
            ListNode nextOfFirst = first.next;
            ListNode nextOfSecond = second.next;
            before.next = first;
            before = before.next;
            before.next = second;
            before = before.next;
            before.next = null;
            first = nextOfFirst;
            second = nextOfSecond;
        }
        before.next = second;
        return result.next;
    }
    
    private ListNode reverse(ListNode head){
        ListNode before = null;
        ListNode next = null;
        ListNode index = head;
        while(index!=null){
            next = index.next;
            index.next = before;
            before = index;
            index = next;
        }
        return before;
    }
    
    public static void main(String[] args){
    	ListNode head = new ListNode(0);
    	ListNode index = head;
    	for(int i=1; i<3; i++){
    		index.next = new ListNode(i);
    		index = index.next;
    	}
    	
    	Solution s= new Solution();
    	s.reorderList(head);
    }
}