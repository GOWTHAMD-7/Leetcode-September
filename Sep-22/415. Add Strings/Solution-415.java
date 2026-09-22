class Solution {
    public String addStrings(String num1, String num2) {
        int len1=num1.length();
        int len2=num2.length();
        int i=len1-1;
        int j=len2-1;
        int carry=0;
        StringBuilder sb=new StringBuilder();
        while(i>=0 || j>=0){
            int x=0;
            int y=0;
            if(i>=0){
                x=(int)(num1.charAt(i))-48;
                i--;
            }
            if(j>=0){
                y=(int)(num2.charAt(j))-48;
                j--;
            }
            int t=x+y+carry;
            char c=(char)(t%10 + 48);
            sb.append(c);
            carry=t/10;
        }
        if(carry!=0){
            char c=(char)(carry + 48);
            sb.append(c);
        }
        return sb.reverse().toString();
    }
}
