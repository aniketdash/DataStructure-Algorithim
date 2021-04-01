class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result= new ArrayList<>();
        generate(result,new StringBuilder(),0,0,n);
        return result;
    }
    
    public void generate(List<String> result,StringBuilder sb,int open,int close,int len){
        if(sb.length()==len*2){
            result.add(sb.toString());
            return;
        }
        if(open<len){
            sb.append('(');
            generate(result,sb,open+1,close,len);
            sb.deleteCharAt(sb.length()-1);
                
        }
        if(close<open){
            sb.append(')');
            generate(result,sb,open,close+1,len);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}