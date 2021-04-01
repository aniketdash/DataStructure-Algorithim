class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        LinkedList<Integer> comb=new LinkedList<>();
        List<List<Integer>> result= new ArrayList<>();
        backtrack(comb,result,1,k,n);
        return result;
    }
    
    public void backtrack(LinkedList<Integer> comb, List<List<Integer>> result,int start, int k, int remain){
        if(remain==0 && comb.size()==k){
            result.add(new ArrayList<Integer>(comb));
            return;
        }else if(remain<0 || comb.size()==k){
            return;
        }
        
        for(int i=start;i<=9;i++ ){
            comb.add(i);
            backtrack(comb,result,i+1,k,remain-i);
            comb.removeLast();
        }
    }
}