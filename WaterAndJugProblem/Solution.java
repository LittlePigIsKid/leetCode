package WaterAndJugProblem;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Solution {
    private static class Node{
        public int value1;
        public int value2;
        public Node(int value1, int value2){
            this.value1 = value1;
            this.value2 = value2;
        }
        @Override 
        public int hashCode(){
        	int result = 0;
        	result =31*result+value1;
        	result = 31*result+value2;
        	return result;
        }
        @Override
        public boolean equals(Object node){
            Node node2 = (Node)node;
            Node node1 = this;
            if(node1.value1==node2.value1&&node1.value2==node2.value2)
                return true;
            return false;
        }
    }
    
    public boolean canMeasureWater(int x, int y, int z) {
        Set<Node> set = new HashSet<Node>();
        return helper(x, y, z, set);
    }
    private boolean helper(int x, int y, int z, Set<Node> set){
    	Stack<Node> stack = new Stack<Node>();
    	stack.push(new Node(0, 0));
    	while(stack.size()>0){
    		Node temp = stack.pop();
    		if(set.contains(temp))
    			continue;
    		else{
    			set.add(temp);
    			if(temp.value1+temp.value2==z)
    			    return true;
    			int value1 = temp.value1;
    			int value2 = temp.value2;
                stack.push( new Node(x, value2) );
                stack.push( new Node(value1, y) );
                stack.push( new Node(Math.min(x, value1+value2), value2-(Math.min(x, value1+value2))) );
                stack.push( new Node(value1-Math.min(y, value2+value1), Math.min(y, value2+value1)) );
                /*helper(x, y, value1, y, set);
                helper(x, y, Math.min(x, value1+value2), value2-(Math.min(x, value1+value2)), set);
                helper(x, y, value1-Math.min(y, value2+value1), Math.min(y, value2+value1), set);*/
    		}
    	}
    	/*Node node = new Node(value1, value2);
        if(set.contains(node))
            return;
        else{
            set.add(node);
            helper(x, y, x, value2, set);
            helper(x, y, value1, y, set);
            helper(x, y, Math.min(x, value1+value2), value2-(Math.min(x, value1+value2)), set);
            helper(x, y, value1-Math.min(y, value2+value1), Math.min(y, value2+value1), set);
        }*/
        return false;
    }
    public static void main(String[] args){
    	Solution sol = new Solution();
    	int x = 104579;
    	int y = 104593;
    	int z = 12444;
    	System.out.println(sol.canMeasureWater(x, y, z));
    }
}