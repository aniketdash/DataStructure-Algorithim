class Solution {
    public String validIPAddress(String IP) {
        if(IP.indexOf(".")!=-1)
            return validateIP4(IP);
        return validateIP6(IP);
    }
    public String validateIP4(String IP){
        String[] nums=IP.split("\\.",-1);
        if(nums.length!=4)
            return "Neither";
        for(String x:nums){
            if(x.length()==0 || x.length()>3) return "Neither";
            if(x.charAt(0)=='0'&& x.length()!=1) return "Neither";
            for(char ch:x.toCharArray()){
                if(!Character.isDigit(ch)) return "Neither";
            }
            if(Integer.parseInt(x)>255) return "Neither";
        }
        return "IPv4";
    }
    
    public String validateIP6(String IP){
        String [] nums= IP.split(":",-1);
        if(nums.length!=8)
            return "Neither";
        String hexdigits="0123456789abcdefABCDEF";
        for(String x:nums){
            if(x.length()==0 || x.length()>4) return "Neither";
            for(Character ch: x.toCharArray()){
                if(hexdigits.indexOf(ch)==-1) return "Neither";
            }
        }
        return "IPv6";
    }
}