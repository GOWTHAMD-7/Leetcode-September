class Solution {
    public int scoreDifference(int[] arr) {
        int a=0;
        int b=0;
        boolean isA=true;
        int len=arr.length;
        for(int i=0;i<len;i++){
            if((i+1)%6==0){
                isA=!isA;
            }
            if(arr[i]%2==1){
                isA=!isA;
            }
            if(isA){
                a+=arr[i];
            }
            else{
                b+=arr[i];
            }
        }
        return a-b;
    }
}
