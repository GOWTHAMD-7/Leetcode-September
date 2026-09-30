class Solution {

    public boolean valid(char[][] grid,int[][][] dp,int i,int j,int st){
        int m=grid.length;
        int n=grid[0].length;
        if(i==m-1 && j==n-1){
            if(st!=1 || grid[i][j]=='('){
                return false;
            }
            return true;
        }
        else{
            if(grid[i][j]=='('){
                st++;
            }
            else{
                if(st==0){
                    return false;
                }
                else{
                    st--;
                }
            }
            if(dp[i][j][st]!=0){
                if(dp[i][j][st]==2){
                    return true;
                }
                return false;
            }
            if(i+1<m){
                boolean temp=valid(grid,dp,i+1,j,st);
                if(temp){
                    dp[i][j][st]=2;
                }
                else{
                    dp[i][j][st]=1;
                }
                if(dp[i][j][st]==2){
                    return true;
                }
            }
            if(j+1<n){
                boolean temp=valid(grid,dp,i,j+1,st);
                if(temp){
                    dp[i][j][st]=2;
                }
                else{
                    dp[i][j][st]=1;
                }
                if(dp[i][j][st]==2){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasValidPath(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        if((m+n)%2==0){
            return false;
        }
        int[][][] dp=new int[m][n][m+n];
        return valid(grid,dp,0,0,0);
    }
}
