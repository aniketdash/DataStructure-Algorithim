class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1) return 0;
        int left=0,val=1;
        int count=0;
        for(int right=0;right<nums.length;right++ ){
            val=val*nums[right];
            while(val>=k) val=val/nums[left++];
            count+=right-left+1;
        }
        return count;
    }
}