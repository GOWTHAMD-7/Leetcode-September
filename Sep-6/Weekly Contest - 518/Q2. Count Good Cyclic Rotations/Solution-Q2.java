class Solution {
    public int countGoodRotations(int[] arr) {
        int len=arr.length;
        int ret=0;
        long fst=0;
        long sec=0;
        for(int j=0;j<len/2;j++){
            fst+=arr[j];
        }
        for(int j=len/2;j<len;j++){
            sec+=arr[j];
        }
        int i=0;
        int j=len/2;
        while(j<len){
            if(fst!=sec){
                ret++;
            }
            fst-=arr[i];
            fst+=arr[j];
            sec-=arr[j];
            sec+=arr[i];
            i++;
            j++;
        }
        return ret;
    }
} 
