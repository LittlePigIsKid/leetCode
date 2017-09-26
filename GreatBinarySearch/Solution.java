package GreatBinarySearch;

import java.util.Arrays;
import java.util.Scanner;

/*
i learned it from programming pearls
it is import in making the codes more efficient
*/
public class Solution {
	public static int binarySearchLeftest(int[] arrays, int target){
		int p = -1;
		int n = arrays.length;
		if(n==0)
			return -1;
		int l = 0;
		int u = n-1;
		Arrays.sort(arrays);
		
		if(arrays[l]==target)
			return l;         
		if(arrays[l]>target) 
			return -1;
		//assert target>arrays[l]
		if(arrays[u]<target)
			return -1;
		//assert target<=arrays[u]
		
		//assert target<=arrays[u]&&assert target>arrays[l]
		while(l+1!=u){
			int m = (l+u)/2;
			if(arrays[m]<target)
				l = m;
			else
				u = m;
		}
		if(arrays[u]==target)
			p = u;
		return p;
	}
	
	public static int binarySearchRightest(int[] arrays, int target){
		int p = -1;
		int n = arrays.length;
		if(n==0)
			return -1;
		int l = 0;
		int u = n-1;
		Arrays.sort(arrays);
		
		if(arrays[u]==target)
			return u;         
		if(arrays[u]<target) 
			return -1;
		//assert target<arrays[u]
		if(arrays[l]>target)
			return -1;
		//assert target>=arrays[l]
		
		//assert target<arrays[u]&&assert target>=arrays[l]
		while(l+1<u){
			int m = (l+u)/2;
			if(arrays[m]>target)
				u = m;
			else
				l = m;
		}
		if(arrays[l]==target)
			p = l;
		return p;
	}
	public static void main(String[] args){
		int[] arrays = {1,2,4,4,4,4,4,4,44,5,11,67,56,54,4,5,433,4,5,43,45};
		int target = 4;
		System.out.println( binarySearchLeftest(arrays, target) );
		System.out.println( binarySearchRightest(arrays, target) );
	}
}
