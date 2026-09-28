class Solution {
    public int maxDepth(String s) {
        int len=s.length();
        int max=0;
        int cnt=0;
        for(int i=0;i<len;i++){
            if(s.charAt(i)=='('){
                cnt++;
                max=Math.max(max,cnt);
            }
            else if(s.charAt(i)==')'){
                cnt--;
            }
        }
        return max;
    }
}
