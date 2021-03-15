class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> pq=new PriorityQueue<>((a,b)-> a.get(2)-b.get(2));
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                List<Integer> li=new ArrayList<>();
                li.add(nums1[i]);
                li.add(nums2[j]);
                li.add(nums1[i]+nums2[j]);
                pq.add(li);
            }
        }
        List<List<Integer>> ans=new ArrayList<>();
        int count=1;
        while(!pq.isEmpty() && count<=k){
            List<Integer> li=new ArrayList<>();
            li.add(pq.peek().get(0));
            li.add(pq.peek().get(1));
            ans.add(li);
            pq.poll();
            count++;
            
        }
        return ans;
    }
}