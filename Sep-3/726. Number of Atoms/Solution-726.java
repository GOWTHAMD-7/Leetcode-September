class Pair{
    String s;
    long cnt;
    Pair(String s,long cnt){
        this.s=s;
        this.cnt=cnt;
    }
}

class Solution {
    public String countOfAtoms(String s) {
        int len=s.length();
        Stack<Pair> st=new Stack<>();
        StringBuilder sb=new StringBuilder("");
        int cnt=0;
        for(int i=0;i<len;i++){
            if(s.charAt(i)>=65 && s.charAt(i)<=92){
                if(!sb.toString().equals("")){
                    if(cnt>0){
                        st.push(new Pair(sb.toString(),cnt));
                    }
                    else{
                        st.push(new Pair(sb.toString(),1));
                    }
                }
                cnt=0;
                sb.setLength(0);
                sb.append(s.charAt(i));
            }
            else if(s.charAt(i)>=97 && s.charAt(i)<=122){
                sb.append(s.charAt(i));
            }
            else if(s.charAt(i)>=48 && s.charAt(i)<=57){
                cnt=(cnt*10)+(int)(s.charAt(i)-48);
            }
            else if(s.charAt(i)=='('){
                if(!sb.toString().equals("")){
                    if(cnt>0){
                        st.push(new Pair(sb.toString(),cnt));
                    }
                    else{
                        st.push(new Pair(sb.toString(),1));
                    }
                }
                cnt=0;
                sb.setLength(0);
                st.push(new Pair("(",1));
            }
            else if(s.charAt(i)==')'){
                if(!sb.toString().equals("")){
                    if(cnt>0){
                        st.push(new Pair(sb.toString(),cnt));
                    }
                    else{
                        st.push(new Pair(sb.toString(),1));
                    }
                }
                i++;
                int ccnt=0;
                while(i<len && s.charAt(i)>=48 && s.charAt(i)<=57){
                    ccnt=(ccnt*10)+(int)(s.charAt(i)-48);
                    i++;
                }
                if(ccnt==0){
                    ccnt=1;
                }
                i--;
                List<Pair> lst=new ArrayList<>();
                Pair in=st.pop();
                while(!st.isEmpty() && !in.s.equals("(")){
                    lst.add(in);
                    in=st.pop();
                }
                for(Pair ss:lst){
                    ss.cnt=ss.cnt*ccnt;
                    st.push(ss);
                }
                cnt=0;
                sb.setLength(0);
            }
        }
        if(!sb.toString().equals("")){
            if(cnt>0){
                st.push(new Pair(sb.toString(),cnt));
            }
            else{
                st.push(new Pair(sb.toString(),1));
            }
        }
        TreeMap<String,Long> map=new TreeMap<>();
        while(!st.isEmpty()){
            Pair ss=st.pop();
            map.put(ss.s,map.getOrDefault(ss.s,0L)+ss.cnt);
        }
        sb.setLength(0);
        for(Map.Entry<String,Long> entry: map.entrySet()){
            sb.append(entry.getKey());
            if(entry.getValue()!=1){
                sb.append(entry.getValue());
            }
        }
        return sb.toString();
    } 
}
