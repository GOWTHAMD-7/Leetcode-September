class Solution {
    public int minimumArea(int[][] grid) {
        int top=Integer.MAX_VALUE;
        int bot=Integer.MIN_VALUE;
        int lef=Integer.MAX_VALUE;
        int rig=Integer.MIN_VALUE;
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    top=Math.min(top,i);
                    bot=Math.max(bot,i);
                    lef=Math.min(lef,j);
                    rig=Math.max(rig,j);
                }
            }
        }
        int x=(bot-top)+1;
        int y=(rig-lef)+1;
        return x*y;
    }
}
