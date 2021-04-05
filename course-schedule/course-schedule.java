class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> graph=new HashMap<>();
        boolean[] visited= new boolean[numCourses];
        boolean[] checked= new boolean[numCourses];
        for(int []p:prerequisites){
            List<Integer> temp= graph.getOrDefault(p[0],new ArrayList<Integer>());
            temp.add(p[1]);
            graph.put(p[0],temp);
        }
        
        for(int i=0;i<numCourses;i++){
            if(isCyclic(i,graph,checked,visited))
                return false;
        }
        
        return true;
        
    }
    
    public boolean isCyclic(int course,Map<Integer,List<Integer>> graph,boolean[] checked,boolean[] visited){
        if(checked[course])
            return false;
        if(visited[course])
            return true;
        if(!graph.containsKey(course))
            return false;
        boolean flag=false;
        visited[course]=true;
        for(int neighbour:graph.get(course)){
            flag=isCyclic(neighbour,graph,checked,visited);
            if(flag)
                break;
        }
        visited[course]=false;
        
        checked[course]=true;
        
        return flag;
        
    }
}