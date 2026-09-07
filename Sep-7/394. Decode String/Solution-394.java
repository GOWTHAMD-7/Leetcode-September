class Solution {
    public String decodeString(String s) {
        Stack<Character> st=new Stack<>();
        int len=s.length();
        for(int i=0;i<len;i++){
            if(s.charAt(i)==']'){
                StringBuilder sb=new StringBuilder();
                StringBuilder cn=new StringBuilder();
                StringBuilder in=new StringBuilder();
                while(st.peek()!='['){
                    sb.append(st.pop());
                }
                st.pop();
                while(!st.isEmpty() && st.peek()<60){
                    cn.append(st.pop());
                }
                int cnt=Integer.valueOf(cn.reverse().toString());
                sb.reverse();
                for(int j=0;j<cnt;j++){
                    in.append(sb);
                }
                int ll=in.length();
                for(int j=0;j<ll;j++){
                    st.push(in.charAt(j));
                }
            }
            else{
                st.push(s.charAt(i));
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}
