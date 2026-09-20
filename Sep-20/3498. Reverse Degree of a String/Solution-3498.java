class Solution {
    public int reverseDegree(String s) {
        int len=s.length();
        int sum=0;
        for(int i=0;i<len;i++){
            sum+=(26-(int)(s.charAt(i)-'a'))*(i+1);
        }
        return sum;
    }
}
