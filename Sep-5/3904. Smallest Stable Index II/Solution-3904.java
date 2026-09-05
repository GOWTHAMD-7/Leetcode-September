class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int len=nums.length;
        int[] arr=new int[len];
        int min=Integer.MAX_VALUE;
        for(int i=len-1;i>=0;i--){
            min=Math.min(min,nums[i]);
            arr[i]=min;
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<len;i++){
            max=Math.max(max,nums[i]);
            if(max-arr[i]<=k){
                return i;
            }
        }
        return -1;
    }
}
