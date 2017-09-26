public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        helper(candidates, 0, target, new ArrayList<Integer>(), list);
        return list;
    }
    private void helper(int[] candidates, int start, int target, List<Integer> temp, List<List<Integer>> list){
        if(target<0)
            return;
        else if(target==0){
            list.add(temp);
            return;
        }else{
            
            for(int i=start; i<candidates.length; i++){
            
                if(i>0&&candidates[i]==candidates[i-1])
                    continue;
            
                temp.add(candidates[start]);
            
                ArrayList<Integer> auxiliary = new ArrayList<Integer>(temp);
                helper(candidates, i, target-candidates[start], auxiliary, list);
            }
        }
    }
}