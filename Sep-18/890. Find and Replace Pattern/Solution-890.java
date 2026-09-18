class Solution {
    public List<String> findAndReplacePattern(String[] word, String pat) {
        List<String> ret=new ArrayList<>();
        int len=pat.length();
        if(len==1){
            for(String s:word){
                ret.add(s);
            }
            return ret;
        }
        HashMap<Character,Integer> map=new HashMap<>();
        List<Integer> lst=new ArrayList<>();
        int cnt=1;
        for(int i=0;i<len;i++){
            char c=pat.charAt(i);
            if(map.containsKey(c)){
                lst.add(map.get(c));
            }
            else{
                lst.add(cnt);
                map.put(c,cnt);
                cnt++;
            }
        }
        int wlen=word.length;
        for(int i=0;i<wlen;i++){
            String s=word[i];
            cnt=1;
            HashMap<Character,Integer> imap=new HashMap<>();
            List<Integer> in=new ArrayList<>();
            len=s.length();
            for(int j=0;j<len;j++){
                char c=s.charAt(j);
                if(imap.containsKey(c)){
                    in.add(imap.get(c));
                }
                else{
                    in.add(cnt);
                    imap.put(c,cnt);
                    cnt++;
                }
            }
            if(lst.size()==in.size()){
                len=lst.size();
                int check=0;
                for(int j=0;j<len;j++){
                    if(lst.get(j)!=in.get(j)){
                        check=1;
                        break;
                    }
                }
                if(check==0){
                    ret.add(s);
                }
            }
        }
        return ret;
    }
}
