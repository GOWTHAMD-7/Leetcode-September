class Solution {
    public String replaceWords(List<String> dict, String sen) {
        String[] arr=sen.split(" ");
        int len=arr.length;
        for(String s:dict){
            int t=s.length();
            for(int i=0;i<len;i++){
                if(arr[i].length()<t){
                    continue;
                }
                if(s.equals(arr[i].substring(0,t))){
                    arr[i]=s;
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<len;i++){
            if(i!=0){
                sb.append(" ");
            }
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
