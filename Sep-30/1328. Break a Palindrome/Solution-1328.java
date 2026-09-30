class Solution {
    public String breakPalindrome(String s) {
        int len=s.length();
        if(len==1){
            return "";
        }
        int pos=0;
        int min=500;
        int check=-1;
        int check2=-1;
        for(int i=0;i<len;i++){
            if(s.charAt(i)!='a'){
                if(check==-1){
                    check=i;
                }
                else if(check2==-1){
                    check2=i;
                }
            }

            if(s.charAt(i)<=min){
                min=s.charAt(i);
                pos=i;
            }
        }
        StringBuilder sb=new StringBuilder();
        sb.append(s);
        if(check!=-1){
            if(check==len/2){
                if(check2!=-1){
                    sb.setCharAt(check2,'a');
                }
                else{
                    sb.setCharAt(pos,'b');
                }
            }
            else{
                sb.setCharAt(check,'a');
            }
        }
        else{
            sb.setCharAt(pos,'b');
        }
        return sb.toString();
    }
}
