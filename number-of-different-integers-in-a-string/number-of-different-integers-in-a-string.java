class Solution {
    public int numDifferentIntegers(String word) {
        //String w="";
        Set<Integer> s= new HashSet<>();
        int base=10,num=0;
        boolean flag=false;
        for(char c:word.toCharArray()){
            if(!Character.isDigit(c)){
              if(flag){
                  s.add(num);
                  num=0;
              }
                flag=false;
            }
            else{
                num=num*base;
                num+=c-'0';
                flag=true;
                //System.out.println(c);
            }
        }
        if(flag)
            s.add(num);
        //System.out.println(s.toString());
        return s.size();
       
    }
}