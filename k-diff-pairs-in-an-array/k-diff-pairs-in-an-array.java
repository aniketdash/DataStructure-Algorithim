class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer,Integer> mp=new HashMap<>();
        for(int n:nums){
            mp.put(n,mp.getOrDefault(n,0)+1);
        }
        int count=0;
        for(int n:mp.keySet()){
            if(k>0 && mp.containsKey(n+k))
                count++;
            else if(k==0 && mp.get(n)>1)
                count++;
        }
        return count;
    }
}