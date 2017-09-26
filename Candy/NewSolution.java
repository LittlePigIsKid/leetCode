package Candy;

public class NewSolution {
	public int candyNum(int[] array){
		int result = 0;
		int n = array.length;
		int[] candy = new int[n];
		if(n>0)
			candy[0] = 1;
		for(int i=0; i<n-1; i++){
			if(array[i]<array[i+1])
				candy[i+1] = candy[i]+1;
			else 
				candy[i+1] = 1;
		}
		for(int i=n-2; i>-1; i--){
			if(array[i]>array[i+1]){
				if(candy[i]>candy[i+1])
					continue;
				else
					candy[i] = candy[i+1]+1;
			}else{
				continue;
			}
		}
		for(int i : candy)
			result += i;
		return result;
	}
	public static void main(String[] args){
		NewSolution sol = new NewSolution();
		int[] array = {1,2,1,3,1,1,1,1,1,1,2,2};
		System.out.println(sol.candyNum(array));
	}
}
