class Solution {
    public String decodeString(String s) {
        char [] arr = s.toCharArray();
        Stack<Character> st=new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]==']'){
                List<Character> li=new ArrayList<>();
                while(st.peek()!='[')
                    li.add(st.pop());
                
                st.pop();
                int base=1;
                int num=0;
                while(!st.isEmpty() && Character.isDigit(st.peek())){
                    num+=(st.pop()-'0')*base;
                    base=base*10;
                }
                
                while(num!=0){
                    for(int j=li.size()-1;j>=0;j--){
                        st.push(li.get(j));
                    }
                    num--;
                }
            }else
                st.push(arr[i]);
        }
        char [] ans= new char[st.size()];
        for(int i=st.size()-1;i>=0;i--){
            ans[i]=st.pop();
        }
        return new String(ans);
    }
}