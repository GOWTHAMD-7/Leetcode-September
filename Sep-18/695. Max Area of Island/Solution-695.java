class Solution {

    public int dfs(int[][] grid,int[][] vis,int i,int j){
        int m=grid.length;
        int n=grid[0].length;
        vis[i][j]=1;
        int sum=1;
        if(i>0 && grid[i-1][j]==1 && vis[i-1][j]==0){
            sum+=dfs(grid,vis,i-1,j);
        }
        if(i<m-1 && grid[i+1][j]==1 && vis[i+1][j]==0){
            sum+=dfs(grid,vis,i+1,j);
        }
        if(j>0 && grid[i][j-1]==1 && vis[i][j-1]==0){
            sum+=dfs(grid,vis,i,j-1);
        }
        if(j<n-1 && grid[i][j+1]==1 && vis[i][j+1]==0){
            sum+=dfs(grid,vis,i,j+1);
        }
        return sum;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] vis=new int[m][n];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    int area=dfs(grid,vis,i,j);
                    max=Math.max(max,area);
                }
            }
        }
        if(max==Integer.MIN_VALUE){
            return 0;
        }
        return max;
    }
}
