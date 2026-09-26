class Solution {
    public String evaluate(String s, List<List<String>> lst) {
        int len=lst.size();
        HashMap<String,String> map=new HashMap<>();
        for(int i=0;i<len;i++){
            map.put(lst.get(i).get(0),lst.get(i).get(1));
        }
        StringBuilder sb=new StringBuilder();
        len=s.length();
        for(int i=0;i<len;i++){
            if(s.charAt(i)=='('){
                StringBuilder t=new StringBuilder();
                i++;
                while(s.charAt(i)!=')'){
                    t.append(s.charAt(i));
                    i++;
                }
                sb.append(map.getOrDefault(t.toString(),"?"));
            }
            else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
