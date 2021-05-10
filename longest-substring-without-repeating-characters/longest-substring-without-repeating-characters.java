class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> mp=new HashMap<>();
        int i=0,j=0;
        int ans=Integer.MIN_VALUE;
        while(i<s.length() && j<s.length()){
            char c=s.charAt(j);
            if(mp.containsKey(c)){
                i=Math.max(mp.get(c),i);
            }
            ans=Math.max(ans,(j-i+1));
            mp.put(c,j+1);
            j++;
        }
        return ans==Integer.MIN_VALUE?0:ans;
    }
}