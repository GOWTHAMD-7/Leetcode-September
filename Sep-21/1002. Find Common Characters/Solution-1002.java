class Solution {
    public List<String> commonChars(String[] words) {
        int len=words.length;
        int[][] arr=new int[len][26];
        for(int i=0;i<len;i++){
            String s=words[i];
            int slen=s.length();
            for(int j=0;j<slen;j++){
                arr[i][s.charAt(j)-'a']++;
            }
        }
        List<String> ret=new ArrayList<>();
        for(int i=0;i<26;i++){
            int max=Integer.MAX_VALUE;
            for(int j=0;j<len;j++){
                max=Math.min(max,arr[j][i]);
            }
            if(max!=0){
                for(int j=0;j<max;j++){
                    char c=(char)(i+'a');
                    StringBuilder sb=new StringBuilder();
                    sb.append(c);
                    ret.add(sb.toString());
                }
            }
        }
        return ret;
    }
}
