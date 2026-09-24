class Pair{
    int i;
    int j;
    int cnt;
    Pair(int i,int j,int cnt){
        this.i=i;
        this.j=j;
        this.cnt=cnt;
    }
}

class Solution {

    public int child2(int[][] arr,int i,int j,int endi,int endj){
        int n=arr.length;
        int[][] vis=new int[n][n];
        List<Integer> lst=new ArrayList<>();
        int cnt=2;
        int mid=(i+endj)/2;
        for(int k=1;k<mid;k++){
            lst.add(cnt);
            cnt++;
        }
        if(endi%2==0){
            lst.add(cnt);
        }
        for(int k=0;k<mid;k++){
            cnt--;
            lst.add(cnt);
        }
        lst.add(1);
        Queue<Pair> q=new LinkedList<>();
        vis[i][j]=arr[i][j];
        q.offer(new Pair(i,j,arr[i][j]));
        int lvl=0;
        while(!q.isEmpty()){
            int len=q.size();
            if(lvl>=lst.size()){
                break;
            }
            int jlmt=n-lst.get(lvl);
            lvl++;
            HashMap<Integer,Integer> map=new HashMap<>();
            for(int k=0;k<len;k++){
                Pair p=q.poll();
                if(p.i==endi && p.j==endj){
                    break;
                }
                if(p.i+1==n){
                    continue;
                }
                if(p.j+1<n){
                    if(vis[p.i+1][p.j+1]<=p.cnt+arr[p.i+1][p.j+1]){
                        map.put(p.j+1,p.cnt+arr[p.i+1][p.j+1]);
                        vis[p.i+1][p.j+1]=p.cnt+arr[p.i+1][p.j+1];
                    }
                }
                if(p.j<n && p.j>=jlmt){
                    if(vis[p.i+1][p.j]<=p.cnt+arr[p.i+1][p.j]){
                        map.put(p.j,p.cnt+arr[p.i+1][p.j]);
                        vis[p.i+1][p.j]=p.cnt+arr[p.i+1][p.j];
                    }
                }
                if(p.j-1>=jlmt){
                    if(vis[p.i+1][p.j-1]<=p.cnt+arr[p.i+1][p.j-1]){
                        map.put(p.j-1,p.cnt+arr[p.i+1][p.j-1]);
                        vis[p.i+1][p.j-1]=p.cnt+arr[p.i+1][p.j-1];
                    }
                }
            }
            for(Map.Entry<Integer,Integer> entry:map.entrySet()){
                q.offer(new Pair(lvl,entry.getKey(),entry.getValue()));
            }
        }
        return vis[endi][endj];
    }

    public int child3(int[][] arr,int i,int j,int endi,int endj){
        int n=arr.length;
        int[][] vis=new int[n][n];
        List<Integer> lst=new ArrayList<>();
        int cnt=2;
        int mid=(j+endi)/2;
        for(int k=1;k<mid;k++){
            lst.add(cnt);
            cnt++;
        }
        if(endj%2==0){
            lst.add(cnt);
        }
        for(int k=0;k<mid;k++){
            cnt--;
            lst.add(cnt);
        }
        lst.add(1);
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(i,j,arr[i][j]));
        vis[i][j]=arr[i][j];
        int lvl=0;
        while(!q.isEmpty()){
            int len=q.size();
            if(lvl>=lst.size()){
                break;
            }
            int jlmt=n-lst.get(lvl);
            lvl++;
            HashMap<Integer,Integer> map=new HashMap<>();
            for(int k=0;k<len;k++){
                Pair p=q.poll();
                if(p.i==endi && p.j==endj){
                    break;
                }
                if(p.j+1==n){
                    continue;
                }
                if(p.i+1<n){
                    if(vis[p.i+1][p.j+1]<=p.cnt+arr[p.i+1][p.j+1]){
                        map.put(p.i+1,p.cnt+arr[p.i+1][p.j+1]);
                        vis[p.i+1][p.j+1]=p.cnt+arr[p.i+1][p.j+1];
                    }
                }
                if(p.i<n && p.i>=jlmt){
                    if(vis[p.i][p.j+1]<=p.cnt+arr[p.i][p.j+1]){
                        map.put(p.i,p.cnt+arr[p.i][p.j+1]);
                        vis[p.i][p.j+1]=p.cnt+arr[p.i][p.j+1];
                    }
                }
                if(p.i-1>=jlmt){
                    if(vis[p.i-1][p.j+1]<=p.cnt+arr[p.i-1][p.j+1]){
                        map.put(p.i-1,p.cnt+arr[p.i-1][p.j+1]);
                        vis[p.i-1][p.j+1]=p.cnt+arr[p.i-1][p.j+1];
                    }
                }
            }
            for(Map.Entry<Integer,Integer> entry:map.entrySet()){
                q.offer(new Pair(entry.getKey(),lvl,entry.getValue()));
            }
        }
        return vis[endi][endj];
    }

    public int maxCollectedFruits(int[][] arr) {
        int n=arr.length;
        int ret=0;
        for(int i=0;i<n;i++){
            ret+=arr[i][i];
        }
        int a=child2(arr,0,n-1,n-2,n-1);
        int b=child3(arr,n-1,0,n-1,n-2);
        return ret+a+b;
    }
}
