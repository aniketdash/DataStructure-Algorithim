class Solution {
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList();
        LinkedList<Integer> li= new LinkedList();
        Set<Integer> st=new HashSet();
        backtrack(res,li,st,nums);
        return res;
    }
    
    public void backtrack(List<List<Integer>> res,LinkedList<Integer> li,Set<Integer> st,int[] nums){
        if(li.size()==nums.length){
            res.add(new ArrayList<>(li));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(st.contains(nums[i])) continue;
            li.add(nums[i]);
            st.add(nums[i]);
            backtrack(res,li,st,nums);
            li.removeLast();
            st.remove(nums[i]);
        }
    }
}