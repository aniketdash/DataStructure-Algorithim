class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0,j=0,sum=nums[j],min=Integer.MAX_VALUE;
        while(j<nums.length && i<nums.length){
            if(sum<target){
                j++;
                if(j<nums.length){
                    
                    sum+=nums[j];
                }
            }else{
                min=Math.min(min,(j-i)+1);
                sum-=nums[i];
                i++;
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}