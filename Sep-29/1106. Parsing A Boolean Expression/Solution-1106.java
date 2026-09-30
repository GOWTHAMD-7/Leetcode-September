class Solution {
    public boolean parseBoolExpr(String s) {
        int len=s.length();
        Stack<Character> st=new Stack<>();
        for(int i=0;i<len;i++){
            char c=s.charAt(i);
            if(c==')'){
                int t=0;
                int f=0;
                while(st.peek()!='('){
                    char temp=st.pop();
                    if(temp=='t'){
                        t++;
                    }
                    else{
                        f++;
                    }
                }
                st.pop();
                char temp=st.pop();
                if(temp=='&'){
                    if(f==0){
                        st.push('t');
                    }
                    else{
                        st.push('f');
                    }
                }
                else if(temp=='|'){
                    if(t!=0){
                        st.push('t');
                    }
                    else{
                        st.push('f');
                    }
                }
                else{
                    if(t==1){
                        st.push('f');
                    }
                    if(f==1){
                        st.push('t');
                    }
                }
            }
            else if(c!=','){
                st.push(c);
            }
        }
        char ret=st.pop();
        return ret=='t'?true:false;
    }
}
