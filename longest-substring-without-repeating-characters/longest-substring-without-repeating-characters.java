class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0)
            return 0;
        Map<Character,Integer> mp=new HashMap<>();
        int max=0;
        int i=0,j=0;
        while(i<s.length() && j<s.length()){
            if(mp.containsKey(s.charAt(j))){
                i=Math.max(mp.get(s.charAt(j)),i);
            }
            mp.put(s.charAt(j),j+1);
            max=Math.max(max,j-i+1);
            j++;
           
        }
        return max;
    }
}