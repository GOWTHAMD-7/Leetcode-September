class Solution {

    int ret=0;

    public void find(int[] nums,int tar,int pos,int sum){
        int len=nums.length;
        if(pos==len){
            if(sum==tar){
                ret++;
            }
        }
        else{
            find(nums,tar,pos+1,sum+nums[pos]);
            find(nums,tar,pos+1,sum-nums[pos]);
        }
    }

    public int findTargetSumWays(int[] nums, int tar) {
        find(nums,tar,0,0);
        return ret;
    }
}
