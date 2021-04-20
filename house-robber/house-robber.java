class Solution {
    public int rob(int[] nums) {
        int N=nums.length;
        if(N==0)
            return 0;
        int [] dp= new int[nums.length+1];
        dp[N]=0;
        dp[N-1]=nums[N-1];
        
        for(int i=N-2;i>=0;i--){
            dp[i]=Math.max(dp[i+1],dp[i+2]+nums[i]);
        }
        return dp[0];
    }
}