class Solution {
    public int minPathSum(int[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        for(int i=grid.length-1;i>=0;i--){
            for(int j=grid[0].length-1;j>=0;j--){
                if(i+1<r && j+1<c)
                    grid[i][j]+=Math.min(grid[i+1][j],grid[i][j+1]);
                else if(i+1>=r && j+1<c)
                    grid[i][j]+=grid[i][j+1];
                else if(i+1<r && j+1>=c)
                    grid[i][j]+=grid[i+1][j];  
            }
        }
        return grid[0][0];
    }
}