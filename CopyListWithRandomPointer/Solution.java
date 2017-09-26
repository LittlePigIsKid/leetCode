package CopyListWithRandomPointer;

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
	static class RandomListNode {
	     int label;
	     RandomListNode next, random;
	     RandomListNode(int x) { this.label = x; }
	 }
	public RandomListNode copyRandomList(RandomListNode head) {
    	 
        if(head==null)
            return null;
        if(head.next==null){
            RandomListNode index =  new RandomListNode(head.label);
            if(head.random==null)
                index.random = null;
            else
                index.random = index;
            return index;
        }
        RandomListNode index, beforeIndex, afterIndex;
        RandomListNode result = new RandomListNode(0);
        result.next = head;
        beforeIndex = result;
        index = head;
        while(index!=null){
            afterIndex = index.next;
            beforeIndex.next = index;
            index.next = new RandomListNode(index.label);
            beforeIndex = index.next;
            index = afterIndex;
        }
        index = result.next;
        while(index!=null){
            afterIndex = index.next.next;
            if(index.random!=null)
                index.next.random = index.random.next;
            else
                index.next.random = null;
            index = afterIndex;
        }
        beforeIndex = result;
        index = result.next;
        while(index!=null){
            afterIndex = index.next.next;
            beforeIndex.next = index.next;
            beforeIndex = beforeIndex.next;
            index = afterIndex;
        }        
        return result.next;
    }
	public static void main(String[] args){
		RandomListNode head = new RandomListNode(1);
		RandomListNode index = head;
		index.next = new RandomListNode(2);
		index = index.next;
		head.random = null;
		index.random = head;
		index = new  Solution().copyRandomList(head);
		while(index!=null){
			if(index.random==null)
				System.out.println("---"+index.label+"---"+index.random);
			else
				System.out.println("---"+index.label+"---"+index.random.label);
			index = index.next;
		}
	}
}