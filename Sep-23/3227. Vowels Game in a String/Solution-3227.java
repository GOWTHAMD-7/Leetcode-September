class Solution {
    public boolean doesAliceWin(String s) {
        int len=s.length();
        for(int i=0;i<len;i++){
            if(s.charAt(i)=='a'){
                return true;
            }
            if(s.charAt(i)=='e'){
                return true;
            }
            if(s.charAt(i)=='i'){
                return true;
            }
            if(s.charAt(i)=='o'){
                return true;
            }
            if(s.charAt(i)=='u'){
                return true;
            }
        }
        return false;
    }
}
