class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer,Integer> lookup=new HashMap<>();
        int ans=0;
        for(int t:time){
            int rem=t%60;
            if(rem==0){
                ans+=lookup.getOrDefault(rem,0);
                lookup.put(rem,lookup.getOrDefault(rem,0)+1);
            }
            else{
                ans+=lookup.getOrDefault(60-rem,0);
                lookup.put(rem,lookup.getOrDefault(rem,0)+1);
            }
        }
        return ans;
    }
}