class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack();
        int sign=1,result=0,sum=0;
        for(int i=0;i<s.length();i++){
            sum=0;
            if(Character.isDigit(s.charAt(i))){
                sum+=s.charAt(i)-'0';
                while(i+1<s.length() && Character.isDigit(s.charAt(i+1))){
                    sum=sum*10+(s.charAt(i+1)-'0');
                    i++;
                }
                result+=sign*sum;
            }else if(s.charAt(i)=='+'){
                sign=1;
            }
            else if(s.charAt(i)=='-'){
                sign=-1;
            }else if(s.charAt(i)=='('){
                st.push(result);
                st.push(sign);
                sign=1;
                result=0;
            }else if(s.charAt(i)==')'){
                result=result*st.pop() + st.pop();
            }
        }
        return result;
    }
}