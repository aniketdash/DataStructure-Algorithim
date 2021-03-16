class Solution {
    int area=0;
    public int maxAreaOfIsland(int[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        int maxArea=Integer.MIN_VALUE;
        boolean[][] visited=new boolean[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                area=0;
                if(grid[i][j]==1 && !visited[i][j]){
                    dfs(grid,visited,i,j);
                    maxArea=Math.max(area,maxArea);
                }
            }
        }
        return maxArea==Integer.MIN_VALUE?0:maxArea;
    }
    
    public void dfs(int[][] grid,boolean[][] visited,int r,int c){
        if(r<0|| c<0 || r>=grid.length || c>=grid[0].length ||grid[r][c]==0||visited[r][c])
            return;
        
        visited[r][c]=true;
        area++;
        dfs(grid,visited,r+1,c);
        dfs(grid,visited,r-1,c);
        dfs(grid,visited,r,c+1);
        dfs(grid,visited,r,c-1);
    }
}