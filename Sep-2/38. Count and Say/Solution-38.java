class Solution {
    public String countAndSay(int n) {
        StringBuilder sb=new StringBuilder();
        sb.append("1");
        for(int i=2;i<=n;i++){
            StringBuilder temp=new StringBuilder();
            int cnt=1;
            int len=sb.length();
            char f=sb.charAt(0);
            for(int j=1;j<len;j++){
                if(sb.charAt(j)==f){
                    cnt++;
                }
                else{
                    temp.append(Integer.toString(cnt));
                    temp.append(f);
                    cnt=1;
                    f=sb.charAt(j);
                }
            }
            temp.append(Integer.toString(cnt));
            temp.append(f);
            sb=temp;
        }
        return sb.toString();
    }
}
