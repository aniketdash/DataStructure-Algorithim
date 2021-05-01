class Solution {
    public int findCircleNum(int[][] isConnected) {
        int [] visited=new int[isConnected.length];
        int count=0;
        for(int i=0;i<isConnected.length;i++){
            if(visited[i]==0){
                dfs(i,visited,isConnected);
                count++;
            }
        }
        return count;
    }
    
    public void dfs(int i,int[] visited,int[][] graph){
        if(visited[i]==1)
            return;
        visited[i]=1;
        for(int j=0;j<graph.length;j++){
            if(graph[i][j]==1)
                dfs(j,visited,graph);   
        }
    }
}