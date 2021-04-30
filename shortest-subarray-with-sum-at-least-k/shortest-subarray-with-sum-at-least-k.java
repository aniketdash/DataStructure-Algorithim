class Solution {
    public int shortestSubarray(int[] A, int K) {
        Deque<Integer> dq= new LinkedList<>();
        long [] preSum= new long[A.length+1];
        for(int i=0;i<A.length;i++){
            preSum[i+1]+=preSum[i]+(long)A[i];
        }
        int minLength=Integer.MAX_VALUE;
        for(int i=0;i<preSum.length;i++){
            while(!dq.isEmpty() && preSum[dq.getLast()]>=preSum[i])
                dq.removeLast();
            while(!dq.isEmpty() && preSum[i]-preSum[dq.getFirst()]>=K){
                minLength=Math.min(minLength,(i-dq.removeFirst()));
            }
            dq.offerLast(i);
        }
        return minLength==Integer.MAX_VALUE?-1:minLength;
    }
}