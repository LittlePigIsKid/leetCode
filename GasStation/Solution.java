package GasStation;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int hasGone = 0;
        int index = 0;
        int capacity = 0;
        int n = gas.length;
        for(int i=0; i<n; i++){
            capacity = gas[i]-cost[i];
            if(capacity<0)
                continue;
            else{
                index = i;
                hasGone++;
                int j = i;
                while(hasGone<n){
                    j++;
                	j = j%(n);
                    capacity += gas[j]-cost[j];
                    if(capacity<0)
                        break;
                    hasGone++;
                }
                if(hasGone==n)
                    return index;
                else{
                    capacity = 0;
                    hasGone = 0;
                }
                i = Math.max(j, i);
            }
        }
        return -1;
    }
    public static void main(String[] args){
    	Solution sol = new Solution();
    	int[] gas = {1, 2, 3, 4 ,5};
    	int[] cost = {3, 4, 5, 1, 2};
    	System.out.println( sol.canCompleteCircuit(gas, cost) );
    }
}