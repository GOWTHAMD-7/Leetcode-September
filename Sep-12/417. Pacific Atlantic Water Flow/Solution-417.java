class Solution {

    public void dfs(int[][] arr,int[][] pac,int i,int j){
        int m=arr.length;
        int n=arr[0].length;
        pac[i][j]=1;
        if(i>0){
            if(pac[i-1][j]==0 && arr[i-1][j]>=arr[i][j]){
                dfs(arr,pac,i-1,j);
            }
        }
        if(i<m-1){
            if(pac[i+1][j]==0 && arr[i+1][j]>=arr[i][j]){
                dfs(arr,pac,i+1,j);
            }
        }
        if(j>0){
            if(pac[i][j-1]==0 && arr[i][j-1]>=arr[i][j]){
                dfs(arr,pac,i,j-1);
            }
        }
        if(j<n-1){
            if(pac[i][j+1]==0 && arr[i][j+1]>=arr[i][j]){
                dfs(arr,pac,i,j+1);
            }
        }
    }

    public void dfs2(int[][] arr,int[][] pac,int i,int j){
        int m=arr.length;
        int n=arr[0].length;
        if(pac[i][j]==1){
            pac[i][j]=3;
        }
        else{
            pac[i][j]=2;
        }
        if(i>0){
            if(pac[i-1][j]<2 && arr[i-1][j]>=arr[i][j]){
                dfs2(arr,pac,i-1,j);
            }
        }
        if(i<m-1){
            if(pac[i+1][j]<2 && arr[i+1][j]>=arr[i][j]){
                dfs2(arr,pac,i+1,j);
            }
        }
        if(j>0){
            if(pac[i][j-1]<2 && arr[i][j-1]>=arr[i][j]){
                dfs2(arr,pac,i,j-1);
            }
        }
        if(j<n-1){
            if(pac[i][j+1]<2 && arr[i][j+1]>=arr[i][j]){
                dfs2(arr,pac,i,j+1);
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] h) {
        int m=h.length;
        int n=h[0].length;
        int[][] pac=new int[m][n];
        for(int i=0;i<m;i++){
            if(pac[i][0]==0){
                dfs(h,pac,i,0);
            }
        }
        for(int i=0;i<n;i++){
            if(pac[0][i]==0){
                dfs(h,pac,0,i);
            }
        }

        for(int i=0;i<m;i++){
            if(pac[i][n-1]<2){
                dfs2(h,pac,i,n-1);
            }
        }
        for(int i=0;i<n;i++){
            if(pac[m-1][i]<2){
                dfs2(h,pac,m-1,i);
            }
        }
        List<List<Integer>> lst=new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pac[i][j]==3){
                    List<Integer> t=new ArrayList<>();
                    t.add(i);
                    t.add(j);
                    lst.add(t);
                }
            }
        }
        return lst;
    }
}
