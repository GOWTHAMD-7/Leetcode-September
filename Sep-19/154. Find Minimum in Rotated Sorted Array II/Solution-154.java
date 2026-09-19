class Solution {
    public int findMin(int[] nums) {
        int len=nums.length;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<len;i++){
            min=Math.min(min,nums[i]);
        }
        return min;
    }
}
