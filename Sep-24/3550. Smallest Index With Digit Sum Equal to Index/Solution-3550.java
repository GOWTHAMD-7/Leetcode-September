class Solution {
    public int smallestIndex(int[] nums) {
        int len=nums.length;
        for(int i=0;i<len;i++){
            int sum=0;
            int t=nums[i];
            while(t!=0){
                sum+=t%10;
                t=t/10;
            }
            if(i==sum){
                return i;
            }
        }
        return -1;
    }
}
