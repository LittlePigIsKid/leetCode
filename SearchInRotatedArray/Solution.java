package SearchInRotatedArray;
public class Solution{
	public int search(int[] nums, int target){
		int result = -1;
		int begin = 0;
		int end = nums.length-1;
		if(end==begin)
			if(nums[end]==target)
				return end;
			else 
				return -1;
		while(end>=begin){
			int middle = (begin+end)/2;
			if(nums[middle]==target){
				result = middle;
				break;
			}else if(nums[middle]>=nums[begin]){
				if(target<nums[middle]&&nums[begin]<=target)
					end = middle-1;
				else
					begin = middle + 1;
			}else{
				if(target>nums[middle]&&target<=nums[end])
					begin = middle + 1; 
				else
					end = middle - 1;
			}
		}
		return result;
	}
	/*public int search(int[] A, int target) {  
	    if(A==null || A.length==0)  
	        return -1;  
	    int l = 0;  
	    int r = A.length-1;  
	    while(l<=r)  
	    {  
	        int m = (l+r)/2;  
	        if(target == A[m])  
	            return m;  
	        if(A[m]<A[r])  
	        {  
	            if(target>A[m] && target<=A[r])  
	                l = m+1;  
	            else  
	                r = m-1;  
	        }  
	        else  
	        {  
	            if(target>=A[l] && target<A[m])  
	                r = m-1;  
	            else  
	                l = m+1;                      
	        }  
	    }  
	    return -1;  
	}  */
	public static void main(String[] args){
		int[] nums = {3,1};
		int target = 1;
		System.out.println(new Solution().search(nums, target));
	}
}