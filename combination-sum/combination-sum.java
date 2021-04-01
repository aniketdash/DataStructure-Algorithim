class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<Integer> comb= new LinkedList<>();
        List<List<Integer>> result= new ArrayList<>();
        
        backtrack(candidates,comb,result,0,target);
        return result;
    }
    
    public void backtrack(int[] candidates,LinkedList<Integer> comb,List<List<Integer>> result,int start,int target ){
        if(target==0)
            result.add(new ArrayList<Integer>(comb));
        if(target<0)
            return;
        for(int i=start;i<candidates.length;i++){
            comb.add(candidates[i]);
            backtrack(candidates,comb,result,i,target-candidates[i]);
            comb.removeLast();
        }
    }
}