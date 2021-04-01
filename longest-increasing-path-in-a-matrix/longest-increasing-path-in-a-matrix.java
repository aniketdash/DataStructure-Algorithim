class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int [][] dir= new int [][]{{0,1},{1,0},{0,-1},{-1,0}};
        int r=matrix.length;
        int c=matrix[0].length;
        int ans=Integer.MIN_VALUE;
        int [][] dp= new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                ans=Math.max(ans,dfs(i,j,matrix,dp,dir));
            }
        }
        return ans;
    }
    
    public int dfs(int r,int c,int[][] matrix,int[][]dp,int[][]dir){
        if(dp[r][c]!=0)
            return dp[r][c];
        for(int x=0;x<dir.length;x++){
            int row=r+dir[x][0];
            int col=c+dir[x][1];
            if(row>=0 && row<matrix.length && col>=0 && col<matrix[0].length && matrix[r][c]<matrix[row][col])
                dp[r][c]=Math.max(dp[r][c],dfs(row,col,matrix,dp,dir));
        }
        return ++dp[r][c];
    }
}