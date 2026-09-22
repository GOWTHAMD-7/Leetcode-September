class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int len=arr.length;
        for(int i=1;i<len;i++){
            if(arr[i-1]>arr[i]){
                return i-1;
            }
        }
        return len-1;
    }
}
