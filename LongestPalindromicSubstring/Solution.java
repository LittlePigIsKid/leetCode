package LongestPalindromicSubstring;

public class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n==0) 
            return null;
        int l = 0, r = 0;
        int begin = 0, end = 0;
        for(int i=0; i<n; i++){
            if(i-1>-1&&i+1<n&&s.charAt(i-1)==s.charAt(i+1)){
                r = l = i;
                while(l>-1&&r<n&&s.charAt(l)==s.charAt(r)){
                    l--; r++;
                }
                l++; r--;
                if(r-l>end-begin){
                    end = r;
                    begin = l;
                }
            } if(i-1>-1&&s.charAt(i-1)==s.charAt(i)){
                l = i-1;
                r = i;
                while(l>-1&&r<n&&s.charAt(l)==s.charAt(r)){
                    l--; r++;
                }
                l++; r--;
                if(r-l>end-begin){
                    end = r;
                    begin = l;
                }
            }
        }
        end++;
        return s.substring(begin, end);
    }

/*String expandAroundCenter(String s, int c1, int c2) {
  int l = c1, r = c2;
  int n = s.length();
  while (l >= 0 && r <= n-1 && s.charAt(l) == s.charAt(r)) {
    l--;
    r++;
  }
  return s.substring(l+1, r-l-1);
}
 
String longestPalindromeSimple(String s) {
  int n = s.length();
  if (n == 0) return "";
  String longest = s.substring(0, 1);  // a single char itself is a palindrome
  for (int i = 0; i < n-1; i++) {
    String p1 = expandAroundCenter(s, i, i);
    if (p1.length() > longest.length())
      longest = p1;
 
    String p2 = expandAroundCenter(s, i, i+1);
    if (p2.length() > longest.length())
      longest = p2;
  }
  return longest;
}*/
    
    public static void main(String[] args){
    	Solution s = new Solution();
    	String  str = "aaaa";
    	System.out.println(s.longestPalindrome(str));
    }
}