class Solution {
    Map<Integer,Integer> memo= new HashMap<>();
    public int numDecodings(String s) {
        return helper(0,s);
    }
    public int helper(int index, String str){
        if(memo.containsKey(index))
            return memo.get(index);
        
        if(index==str.length())
            return 1;
        
        if(str.charAt(index)=='0')
            return 0;
        
        if(index==str.length()-1)
            return 1;
        
        int val= helper(index+1,str);
        if(Integer.parseInt(str.substring(index,index+2))<=26){
            val+=helper(index+2,str);
        }
        
        memo.put(index,val);
        
        return val;
    }
}