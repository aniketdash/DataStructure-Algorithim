class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> st=new Stack<>();
        int [] ans=new int[T.length];
        
        for(int i=0;i<T.length;i++){
            while(!st.isEmpty() && T[st.peek()]<T[i]){
                int index=st.pop();
                ans[index]=i-index;
            }
            st.push(i);
        }
        return ans;
    }
}