package LengthOfLastWorld;

public class Solution {
	public static void main(String[] args){
		String str = " sfdadf fsfdsd s fsad    sdfasf sf     dfa";
		String[] array = str.split("\\s");
		for(String temp : array)
			System.out.println(temp);
	}
}
