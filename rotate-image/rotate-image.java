class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reflect(matrix);
    }
    public void transpose(int [][] arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int temp=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }
    }
    
    public void reflect(int [][] arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int temp=arr[i][j];
                arr[i][j]=arr[i][n-j-1];
                arr[i][n-j-1]=temp;
            }
        }
    }
}