class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String,String> lookup=new HashMap<>();
        for(List<String> li:knowledge){
            lookup.put(li.get(0),li.get(1));
        }
        String ans="";
        char [] arr= s.toCharArray();
        for(int i=0;i<arr.length;){
            if(arr[i]=='('){
                i++;
                String key="";
                while(arr[i]!=')'){
                    key+=arr[i];
                    i++;
                }
                ans+=lookup.getOrDefault(key,"?");
                i++;
            }else{
                ans+=arr[i];
                i++;
            }
        }
        return ans;
    }
}