class Solution {

    public Boolean isPal(String s){
        int len=s.length();
        for(int i=0,j=len-1;i<j;i++,j--){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
        }
        return true;
    }

    public int countSubstrings(String s) {
        int len=s.length();
        int ret=0;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<=len;j++){
                if(isPal(s.substring(i,j))){
                    ret++;
                }
            }
        }
        return ret;
    }
}
