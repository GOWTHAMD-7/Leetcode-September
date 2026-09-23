class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] q, int x) {
        int nlen=nums.length;
        int qlen=q.length;
        int[] ret=new int[qlen];
        List<Integer> lst=new ArrayList<>();
        int cnt=1;
        for(int i=0;i<nlen;i++){
            if(nums[i]==x){
                lst.add(i);
            }
        }
        int len=lst.size();
        for(int i=0;i<qlen;i++){
            if(q[i]<=len){
                ret[i]=lst.get(q[i]-1);
            }
            else{
                ret[i]=-1;
            }
        }
        return ret;
    }
}
