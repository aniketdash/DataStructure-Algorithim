class Solution {
    Map<String,List<Integer>> dp= new HashMap<>();
    public List<Integer> diffWaysToCompute(String expression) {
        if(dp.get(expression)!=null)
            return dp.get(expression);
        int val=0;
        List<Integer> res= new ArrayList();
        boolean flag=true;
        try{
            val=Integer.parseInt(expression);
        }catch(NumberFormatException e){
            flag=false;
        }
        if(flag){
            res.add(val);
            return res;
        }
        for(int i=0;i<expression.length();i++){
            char c=expression.charAt(i);
            if(c=='+'||c=='-'||c=='*'){
                for(int x:diffWaysToCompute(expression.substring(0,i))){
                    for(int y:diffWaysToCompute(expression.substring(i+1))){
                        if(c=='+')
                            res.add(x+y);
                        else if(c=='-')
                            res.add(x-y);
                        else
                            res.add(x*y);
                    }
                }
            }
        }
        dp.put(expression,res);
        return res;
    }
}