class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words= new HashSet<>(wordList);
        if(!words.contains(endWord))
            return 0;
        Queue<String> q= new LinkedList<>();
        words.remove(beginWord);
        q.offer(beginWord);
        int distance=0;
        while(!q.isEmpty()){
            int size=q.size();
            distance++;
            for(int i=0;i<size;i++){
                String curr= q.poll();
                if(curr.equals(endWord))
                    return distance;
                List<String> neighbours= neighbours(curr);
                for(String n:neighbours){
                    if(words.contains(n)){
                        words.remove(n);
                        q.offer(n);
                    }
                }
                    
            }
        }
        return 0;
    }
    
    public List<String> neighbours(String s){
        char[] arr=s.toCharArray();
        List<String> result= new ArrayList();
        for(int i=0;i<arr.length;i++){
            char temp=arr[i];
            for(char c='a';c<='z';c++){
                arr[i]=c;
                String n= new String(arr);
                result.add(n);
            }
            arr[i]=temp;
        }
        return result;
    }
}