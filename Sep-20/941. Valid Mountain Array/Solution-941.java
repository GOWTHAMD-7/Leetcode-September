class Solution {
    public boolean validMountainArray(int[] arr) {
        int len=arr.length;
        if(len<3){
            return false;
        }
        int prev=arr[0];
        int change=0;
        for(int i=1;i<len;i++){
            if(arr[i]==prev){
                return false;
            }
            if(arr[i]<prev){
                if(change==0){
                    return false;
                }
                change=2;
            }
            else if(arr[i]>prev){
                if(change==2){
                    return false;
                }
                change=1;
            }
            prev=arr[i];
        }
        if(change!=2){
            return false;
        }
        return true;
    }
}
