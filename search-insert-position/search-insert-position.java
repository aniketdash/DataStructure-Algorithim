class Solution {
    public int searchInsert(int[] nums, int target) {
        return binarySearch(0,nums.length-1,target,nums);
    }
    public int binarySearch(int start,int end,int target,int[] nums){
        if(start>end)
            return start;
        int mid=start+(end-start)/2;
        if(nums[mid]==target)
            return mid;
        else if(target<nums[mid])
            return binarySearch(start,mid-1,target,nums);
        else
            return binarySearch(mid+1,end,target,nums);
    }
}