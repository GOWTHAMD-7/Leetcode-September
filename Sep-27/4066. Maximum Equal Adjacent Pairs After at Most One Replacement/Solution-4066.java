class Solution {
    public int maxEqualAdjacentPairs(int[] nums) {
        int len=nums.length;
        HashMap<String,Integer> map=new HashMap<>();
        int max=-1;
        String pos="22";
        int ret=0;
        for(int i=0;i<len-1;i++){
            if(nums[i]==nums[i+1]){
                ret++;
            }
            else if(nums[i]>nums[i+1]){
                StringBuilder sb=new StringBuilder();
                sb.append(Integer.toString(nums[i+1]));
                sb.append("-");
                sb.append(Integer.toString(nums[i]));
                String p=sb.toString();
                map.put(p,map.getOrDefault(p,0)+1);
                if(map.get(p)>max){
                    max=map.get(p);
                    pos=p;
                }
            }
            else{
                StringBuilder sb=new StringBuilder();
                sb.append(Integer.toString(nums[i]));
                sb.append("-");
                sb.append(Integer.toString(nums[i+1]));
                String p=sb.toString();
                map.put(p,map.getOrDefault(p,0)+1);
                if(map.get(p)>max){
                    max=map.get(p);
                    pos=p;
                }
            }
        }
        if(pos.equals("22")){
            return ret;
        }
        int j=0;
        while(pos.charAt(j)!='-'){
            j++;
        }
        int f=Integer.valueOf(pos.substring(0,j));
        int ff=Integer.valueOf(pos.substring(j+1,pos.length()));
        int ret1=0;
        int ret2=0;
        for(int i=0;i<len-1;i++){
            int p=nums[i];
            int q=nums[i+1];
            if(p==f){
                p=ff;
            }
            if(q==f){
                q=ff;
            }
            if(p==q){
                ret1++;
            }
            p=nums[i];
            q=nums[i+1];
            if(p==ff){
                p=f;
            }
            if(q==ff){
                q=f;
            }
            if(p==q){
                ret2++;
            }
        }
        return ret1>ret2?ret1:ret2;
    }
}
