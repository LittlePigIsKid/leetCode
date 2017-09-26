package InterleavingString;

public class Solution {
	public boolean solution(String s1, String s2, String s3){
		int n1 = s1.length();
		int n2 = s2.length();
		int n3 = s3.length();
		boolean[][] array = new boolean[n1+1][n2+1];
		array[0][0] = true;
		for(int index=0; index<n3; index++){
			for(int i=0; i<=n1&&i<=index; i++){
				int j = index-i;
				if(j<=n2&&array[i][j]){
					if(i<n1&&s1.charAt(i)==s3.charAt(index))
						array[i+1][j] = true;
					if(j<n2&&s2.charAt(j)==s3.charAt(index))
						array[i][j+1] = true;
				}
			}
		}
		return array[n1][n2];
	}
	public static void main(String[] args){
		String s1 = "acedfadsfas";
		String s2 = "bd";
		String s3 = "abcdedfadsfas";
		Solution sol = new Solution();
		System.out.println(sol.solution(s1, s2, s3));
	}
}
