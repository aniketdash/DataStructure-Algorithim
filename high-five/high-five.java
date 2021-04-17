class Solution {
    public int[][] highFive(int[][] items) {
        TreeMap<Integer,PriorityQueue<Integer>> lookup= new TreeMap<>();
        for(int[] i:items){
            PriorityQueue pq= lookup.getOrDefault(i[0],new PriorityQueue<Integer>((a,b)->b-a));
            pq.add(i[1]);
            lookup.put(i[0],pq);
        }
        
        List<int[]> solution= new ArrayList<>();
        
        for(int k:lookup.keySet()){
            int sum=0;
            int count=5;
            while(count>0){
                sum+= lookup.get(k).poll();
                count--;
            }
            solution.add(new int[]{k,sum/5});
        }
        int[][] solutionArray = new int[solution.size()][];
        return solution.toArray(solutionArray); 
    }
}