class Solution {
    public int numIslands(char[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        int count=0;
        boolean [][] visited= new boolean[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    count++;
                    dfs(i,j,visited,grid);
                }
                    
            } 
        }
        return count;
    }
    
    public void dfs(int r,int c,boolean[][] visited,char [][] grid){
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]=='0'||visited[r][c])
            return;
        visited[r][c]=true;
        dfs(r-1,c,visited,grid);
        dfs(r+1,c,visited,grid);
        dfs(r,c-1,visited,grid);
        dfs(r,c+1,visited,grid);
    }
}