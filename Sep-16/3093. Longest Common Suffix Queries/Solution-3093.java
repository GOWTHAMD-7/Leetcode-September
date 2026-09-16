class Trie{
    int pos;
    int len;
    char c;
    HashMap<Character,Trie> map;
    Trie(int pos,int len,char c){
        this.pos=pos;
        this.len=len;
        this.c=c;
        map=new HashMap<>();
    }
}

class Solution {

    public void build(String s,Trie t,int i,int len,int pos){
        if(i<0){
            return;
        }
        char c=s.charAt(i);
        if(!t.map.containsKey(c)){
            t.map.put(c,new Trie(pos,len,c));
            build(s,t.map.get(c),i-1,len,pos);
        }
        else{
            if(t.map.get(c).len>len){
                t.map.get(c).len=len;
                t.map.get(c).pos=pos;
            }
            build(s,t.map.get(c),i-1,len,pos);
        }
    }

    public int find(String s,int i,Trie t){
        if(i<0){
            return t.pos;
        }
        int len=s.length();
        char c=s.charAt(i);
        if(t.map.containsKey(c)){
            return find(s,i-1,t.map.get(c));
        }
        return t.pos;
    }


    public int[] stringIndices(String[] cont, String[] query) {
        HashMap<Character,Trie> map=new HashMap<>();
        int clen=cont.length;
        int qlen=query.length;
        int[] ret=new int[qlen];
        for(int i=0;i<clen;i++){
            String s=cont[i];
            int len=s.length();
            char c=s.charAt(len-1);
            if(!map.containsKey(c)){
                map.put(c,new Trie(i,len,c));
                build(s,map.get(c),len-2,len,i);
            }
            else{
                if(map.get(c).len>len){
                    map.get(c).len=len;
                    map.get(c).pos=i;
                }
                build(s,map.get(c),len-2,len,i);
            }
        }
        int min=Integer.MAX_VALUE;
        int p=0;
        for(int i=0;i<clen;i++){
            int len=cont[i].length();
            if(len<min){
                min=len;
                p=i;
            }
        }
        for(int i=0;i<qlen;i++){
            int len=query[i].length();
            char c=query[i].charAt(len-1);
            if(map.containsKey(c)){
                if(len-2>=0){
                    ret[i]=find(query[i],len-2,map.get(c));
                }
                else{
                    ret[i]=map.get(c).pos;
                }
            }
            else{
                ret[i]=p;
            }
        }
        return ret;
    }
}
