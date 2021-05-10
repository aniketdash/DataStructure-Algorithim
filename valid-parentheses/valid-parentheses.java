class Solution {
    public boolean isValid(String s) {
        String oB="{[(";
        String cB="}])";
        Stack<Integer> st=new Stack();
        for(int i=0;i<s.length();i++){
            int oIndex=oB.indexOf(s.charAt(i));
            int cIndex=cB.indexOf(s.charAt(i));
            if(cIndex==-1){
                st.push(oIndex);
            }else if(oIndex==-1){
                if(!st.isEmpty() && st.peek()==cIndex)
                    st.pop();
                else return false;
            }
        }
        return st.isEmpty();
    }
}