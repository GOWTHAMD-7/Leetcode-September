class Solution {
    public long maximumProduct(int[] nums, int m) {
        int len=nums.length;
        int[] arr1=new int[len];
        int[] arr2=new int[len];
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=len-1;i>=0;i--){
            max=Math.max(max,nums[i]);
            min=Math.min(min,nums[i]);
            arr1[i]=max;
            arr2[i]=min;
        }
        long ret=Long.MIN_VALUE;
        m--;
        for(int i=0;i<len-m;i++){
            long t=nums[i];
            t=t*(long)arr1[i+m];
            ret=Math.max(ret,t);
            t=nums[i];
            t=t*(long)arr2[i+m];
            ret=Math.max(ret,t);
        }
        return ret;
    }
}
