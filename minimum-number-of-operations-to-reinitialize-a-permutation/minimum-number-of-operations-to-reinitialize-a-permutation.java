class Solution {
    public int reinitializePermutation(int n) {
        boolean flag=true;
        int [] prem= new int[n];
        for(int i=0;i<n;i++){
            prem[i]=i;
        }
        int count=0;
        while(flag){
            int [] arr= new int[n];
            boolean assending=true; 
            for(int i=0;i<n;i++){
                if(i%2==0)
                    arr[i]=prem[i/2];
                else
                    arr[i]=prem[n / 2 + (i - 1) / 2];
                if(i>0){
                    if(arr[i]>arr[i-1] && assending)
                        assending=true;
                    else
                        assending=false;
                }
            }
            count++;
            prem=arr.clone();
            if(assending)
                flag=false;
        }
        return count;
    }
}