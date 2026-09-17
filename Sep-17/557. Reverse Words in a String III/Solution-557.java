class Solution {
    public String reverseWords(String s) {
        String[] arr=s.split(" ");
        int len=arr.length;
        for(int i=0;i<len;i++){
            StringBuilder sb=new StringBuilder();
            sb.append(arr[i]);
            arr[i]=sb.reverse().toString();
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
