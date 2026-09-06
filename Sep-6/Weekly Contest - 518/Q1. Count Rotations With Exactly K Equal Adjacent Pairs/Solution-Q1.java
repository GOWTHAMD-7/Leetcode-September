class Solution {
    public int countRotations(String s, int k) {
        int len=s.length();
        int ret=0;
        for(int i=0;i<len;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=i;j<i+len;j++){
                sb.append(s.charAt(j%len));
            }
            int score=0;
            for(int j=1;j<len;j++){
                if(sb.charAt(j)==sb.charAt(j-1)){
                    score++;
                }
            }
            if(score==k){
                ret++;
            }
        }
        return ret;
    }
}
