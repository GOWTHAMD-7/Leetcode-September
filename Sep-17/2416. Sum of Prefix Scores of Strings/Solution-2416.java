class Trie{
    int cnt;
    Trie[] child=new Trie[26];
    boolean[] check=new boolean[26];
    Trie(int cnt){
        this.cnt=cnt;
    }
}

class Solution {

    public void build(String s,int pos,Trie t){
        int len=s.length();
        if(pos==len){
            return;
        }
        char c=s.charAt(pos);
        int i=(int)(c-'a');
        if(!t.check[i]){
            t.child[i]=new Trie(1);
            t.check[i]=true;
        }
        else{
            t.child[i].cnt++;
        }
        build(s,pos+1,t.child[i]);
    }

    public int find(String s,int pos,Trie t){
        int len=s.length();
        if(pos==len){
            return 0;
        }
        char c=s.charAt(pos);
        int i=(int)(c-'a');
        return t.child[i].cnt + find(s,pos+1,t.child[i]);

    }

    public int[] sumPrefixScores(String[] words) {
        int wlen=words.length;
        Trie[] arr=new Trie[26];
        boolean[] check=new boolean[26];
        int[] ret=new int[wlen];
        for(String s:words){
            int len=s.length();
            char c=s.charAt(0);
            int i=(int)(c-'a');
            if(!check[i]){
                arr[i]=new Trie(1);
                check[i]=true;
            }
            else{
                arr[i].cnt++;
            }
            if(len<2){
                continue;
            }
            build(s,1,arr[i]);
        }
        for(int i=0;i<wlen;i++){
            String s=words[i];
            int len=s.length();
            char c=s.charAt(0);
            int idx=(int)(c-'a');
            int cnt=arr[idx].cnt;
            if(len<2){
                ret[i]=cnt;
                continue;
            }
            cnt+=find(s,1,arr[idx]);
            ret[i]=cnt;
        }
        return ret;
    }
}
