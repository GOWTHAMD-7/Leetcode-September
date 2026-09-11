class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        int ret=0;
        for(int i:nums){
            int t=i;
            while(t!=0){
                int temp=t%10;
                if(temp==digit){
                    ret++;
                }
                t=t/10;
            }
        }
        return ret;
    }
}
