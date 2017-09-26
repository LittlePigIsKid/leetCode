package LRUCache;

import java.util.ArrayDeque;

public class Solution {
	public static void main(String[] args){
		ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
		queue.add(1);
		queue.add(2);
		queue.add(1);
		if(queue.contains(1))
			System.out.println("Hello ArrayDeque!!!");
		for(int i : queue)
			System.out.println(i);
	}
}
