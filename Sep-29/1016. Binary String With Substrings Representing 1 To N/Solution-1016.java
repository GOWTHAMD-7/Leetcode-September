class Solution {
    public boolean queryString(String s, int n) {
        int len=s.length();
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<len;i++){
            for(int j=i+1;j<=len;j++){
                if(j-i>30){
                    break;
                }
                int t=Integer.parseInt(s.substring(i,j),2);
                set.add(t);
            }
        }
        for(int i=1;i<=n;i++){
            if(!set.contains(i)){
                return false;
            }
        }
        return true;
    }
}
