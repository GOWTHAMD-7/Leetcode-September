class Solution {

    public int bt(int[] nums,int i,int[] max){
        int len=nums.length;
        int one=nums[i];
        int two=nums[i];
        if(i+2<len){
            if(max[i+2]!=-1){
                one+=max[i+2];
            }
            else{
                one+=bt(nums,i+2,max);
            }
        }
        if(i+3<len){
            if(max[i+3]!=-1){
                two+=max[i+3];
            }
            else{
                two+=bt(nums,i+3,max);
            }
        }
        int m=Math.max(one,two);
        max[i]=m;
        return m;
    }

    public int rob(int[] nums) {
        int len=nums.length;
        int[] max=new int[len];
        Arrays.fill(max,-1);
        int x=bt(nums,0,max);
        int y=0;
        if(len>1){
            y=bt(nums,1,max);
        }
        return Math.max(x,y);
    }
}
