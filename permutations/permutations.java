class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> perm=new LinkedList<>();
        Set<Integer> lookup=new HashSet<>();
        backtrack(nums,perm,result,lookup);
        return result;
    }
    public void backtrack(int[] nums,LinkedList<Integer> perm,List<List<Integer>> result,Set<Integer> lookup){
        if(perm.size()==nums.length){
            result.add(new ArrayList<>(perm));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(lookup.contains(nums[i])) continue;
            perm.add(nums[i]);
            lookup.add(nums[i]);
            backtrack(nums,perm,result,lookup);
            lookup.remove(nums[i]);
            perm.removeLast();
        }
    }
}