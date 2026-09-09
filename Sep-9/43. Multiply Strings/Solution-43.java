class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") | num2.equals("0")){
            return "0";
        }
        int len1=num1.length();
        int len2=num2.length();
        List<StringBuilder> lst=new ArrayList<>();
        int k=0;
        for(int i=len2-1;i>=0;i--){
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<k;j++){
                sb.append("0");
            }
            k++;
            int carry=0;
            for(int j=len1-1;j>=0;j--){
                int pro=(int)(num1.charAt(j)-48)*(int)(num2.charAt(i)-48);
                pro+=carry;
                carry=0;
                if(pro<10){
                    sb.append(String.valueOf(pro));
                }
                else{
                    carry=pro/10;
                    pro=pro%10;
                    sb.append(String.valueOf(pro));
                }
            }
            if(carry!=0){
                sb.append(String.valueOf(carry));
            }
            lst.add(sb);
        }
        StringBuilder sb=new StringBuilder();
        int carry=0;
        int i=0;
        int start=0;
        int len=lst.size();
        while(start<len){
            int sum=0;
            for(int j=start;j<len;j++){
                StringBuilder s=lst.get(j);
                if(s.length()<=i){
                    start=j+1;
                    continue;
                }
                else{
                    sum+=Integer.valueOf(s.charAt(i)-48);
                }
            }
            sum+=carry;
            carry=0;
            if(sum<10){
                sb.append(String.valueOf(sum));
            }
            else{
                carry=sum/10;
                sum=sum%10;
                sb.append(String.valueOf(sum));
            }
            i++;
        }
        if(carry!=0){
            sb.append(String.valueOf(carry));
        }
        String ret= sb.reverse().toString();
        if(ret.charAt(0)=='0'){
            return ret.substring(1);
        }
        return ret;
    }
}
