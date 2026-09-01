class Solution {
    public long dividePlayers(int[] arr) {
        int len=arr.length;
        Arrays.sort(arr);
        long pro=(long)(arr[0]*arr[len-1]);
        int sum=arr[0]+arr[len-1];
        for(int i=1,j=len-2;i<j;i++,j--){
            if(arr[i]+arr[j]==sum){
                pro+=(arr[i]*arr[j]);
            }
            else{
                return -1L;
            }
        }
        return pro;
    }
}