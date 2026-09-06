class Pair{
    int row;
    int col;
    int dir;
    int turn;
    int sum;
    Pair(int row,int col,int dir,int turn,int sum){
        this.row=row;
        this.col=col;
        this.dir=dir;
        this.turn=turn;
        this.sum=sum;
    }
}
class Solution {
    public int minCost(int[][] grid,int k){
        int m=grid.length;
        int n=grid[0].length;
        int[][] arr=grid;
        if(m==1 && n==1){
            return grid[0][0];
        }
        int max=Integer.MAX_VALUE;
        int[][][][] dp=new int[m][n][5][k+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int d=0;d<5;d++){
                    Arrays.fill(dp[i][j][d],max);
                }
            }
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.sum-b.sum);
        if(n>1){
            dp[0][1][4][0]=grid[0][0]+grid[0][1];
            pq.offer(new Pair(0,1,4,0,dp[0][1][4][0]));
        }
        if(m>1){
            dp[1][0][2][0]=grid[0][0]+grid[1][0];
            pq.offer(new Pair(1,0,2,0,dp[1][0][2][0]));
        }
        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            if(p.sum!=dp[p.row][p.col][p.dir][p.turn]){
                continue;
            }
            if(p.row==m-1 && p.col==n-1){
                return p.sum;
            }
            for(int d=1;d<=4;d++){
                int nr=p.row+dr[d-1];
                int nc=p.col+dc[d-1];
                if(nr<0||nr>=m||nc<0||nc>=n){
                    continue;
                }
                int nt=p.turn;
                if(d!=p.dir){
                    nt++;
                }
                if(nt>k){
                    continue;
                }
                int nsum=p.sum+grid[nr][nc];
                if(nsum<dp[nr][nc][d][nt]){
                    dp[nr][nc][d][nt]=nsum;
                    pq.offer(new Pair(nr,nc,d,nt,nsum));
                }
            }
        }
        return -1;
    }
}
