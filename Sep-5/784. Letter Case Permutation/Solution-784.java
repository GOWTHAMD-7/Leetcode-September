class Solution {

    public void backTrack(List<String> lst,StringBuilder s,int pos){
        int len=s.length();
        if(pos>=len){
            String ret=s.toString();
            lst.add(ret);
            return;
        }
        else{
            if(s.charAt(pos)<60){
                backTrack(lst,s,pos+1);
            }
            else if (s.charAt(pos)<96){
                backTrack(lst,s,pos+1);
                char ch=s.charAt(pos);
                char rep=(char)(ch+32);
                s.setCharAt(pos,rep);
                backTrack(lst,s,pos+1);
                s.setCharAt(pos,ch);
            }
            else{
                backTrack(lst,s,pos+1);
                char ch=s.charAt(pos);
                char rep=(char)(ch-32);
                s.setCharAt(pos,rep);
                backTrack(lst,s,pos+1);
                s.setCharAt(pos,ch);
            }
        }
    }
    public List<String> letterCasePermutation(String s) {
        List<String> lst=new ArrayList<>();
        StringBuilder sb=new StringBuilder(s);
        backTrack(lst,sb,0);
        return lst;
    }
}
