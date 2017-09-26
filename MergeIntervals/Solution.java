package MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Interval {
      int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
 }

 public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        Interval[] array = new Interval[intervals.size()];
        for(int i=0; i<intervals.size(); i++)
        	array[i] = intervals.get(i);
        intervals = null;
        Arrays.sort(array,  new  MyComparator());
        for(int i=0; i<array.length; i++)
        	System.out.println(array[i].start+"-----"+array[i].end);
        List<Interval> list = new ArrayList<Interval>();
        int index = 1;
        Interval value = array[0];
        while(index<array.length){
        	if(value.end>=array[index].start)
        		value = new Interval(Math.min(value.start, array[index].start), 
        				             Math.max(value.end, array[index].end));
        	else{
        		list.add(value);
        		value = array[index];
        	}
        	index++;
        }
        list.add(value);
        return list;
    }
    public static void main(String[] args){
    	Solution sol = new Solution();
    	List<Interval> intervals = new ArrayList<Interval>();
    	intervals.add(new Interval(2,5));
    	intervals.add(new Interval(1,5));
    	intervals.add(new Interval(4,5));
    	intervals.add(new Interval(6,9));
    	intervals.add(new Interval(10,15));
    	for(Interval temp : sol.merge(intervals))
    		System.out.println( temp.start+"-----"+temp.end );
    }
}
class MyComparator implements Comparator<Interval>{
	@Override
	public int compare(Interval o1, Interval o2) {
		return o1.start-o2.start;
	}
}