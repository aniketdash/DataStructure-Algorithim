class Solution {
    List<List<Integer>> output = new ArrayList<>();
    int k,n;
    public List<List<Integer>> subsets(int[] nums) {
        n=nums.length;
        for(k=0;k<n+1;k++){
            backtrack(0,new LinkedList<Integer>(),nums);
        }
        return output;
    }
    
    public void backtrack(int start,LinkedList<Integer> comb,int[] nums){
        if(comb.size()==k){
            output.add(new ArrayList<Integer>(comb));
            return;
        }
        for(int i=start;i<n;i++){
            comb.add(nums[i]);
            backtrack(i+1,comb,nums);
            comb.removeLast();
        }
    }
}