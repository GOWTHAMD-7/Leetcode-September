class Solution {
    public int maxOperations(String s) {
        int len=s.length();
        int prev=0;
        int ret=0;
        int cnt=0;
        for(int i=0;i<len;i++){
            if(s.charAt(i)=='1'){
                cnt++;
            }
            else{
                if(cnt!=prev){
                    ret+=cnt;
                    prev=cnt;
                }
            }
        }
        return ret;
    }
}
