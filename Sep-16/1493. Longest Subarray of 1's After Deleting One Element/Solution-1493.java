class Solution {
    public int longestSubarray(int[] nums) {
        int len=nums.length;
        List<Integer> lst=new ArrayList<>();
        int zero=0;
        int one=0;
        boolean isz=true;
        if(nums[0]==1){
            one=1;
            isz=false;
        }
        else{
            zero=1;
        }
        for(int i=1;i<len;i++){
            if(nums[i]==1){
                if(isz){
                    lst.add(zero*-1);
                    zero=0;
                    isz=!isz;
                    one++;
                }
                else{
                    one++;
                }
            }
            else{
                if(isz){
                    zero++;
                }
                else{
                    lst.add(one);
                    one=0;
                    isz=!isz;
                    zero++;
                }
            }
        }
        if(isz){
            lst.add(zero*-1);
        }
        else{
            lst.add(one);
        }
        if(lst.size()==1 && lst.get(0)>0){
            return lst.get(0)-1;
        }
        len=lst.size();
        int max=Integer.MIN_VALUE;
        for(int i=0;i<len;i++){
            int t=lst.get(i);
            if(t>0){
                max=Math.max(max,lst.get(i));
            }
            else if(t==-1){
                if(i-1>=0 && i+1<len){
                    int prev=lst.get(i-1);
                    int next=lst.get(i+1);
                    if(prev>0 && next>0){
                        max=Math.max(max,prev+next);
                    }
                }
            }
        }
        if(max==Integer.MIN_VALUE){
            return 0;
        }
        return max;
    }
}
