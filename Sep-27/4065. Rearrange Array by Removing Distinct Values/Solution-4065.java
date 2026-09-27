class Solution {
    public int[] rearrangeArray(int[] nums) {
        int len=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int[] ret=new int[len];
        for(int i=0;i<len;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int k=0;
        while(!map.isEmpty()){
            TreeSet<Integer> set=new TreeSet<>();
            TreeSet<Integer> remo=new TreeSet<>();
            for(Map.Entry<Integer,Integer> entry : map.entrySet()){
                set.add(entry.getKey());
                if(entry.getValue()==1){
                    remo.add(entry.getKey());
                }
                map.put(entry.getKey(),entry.getValue()-1);
            }
            for(int i:set){
                ret[k]=i;
                k++;
            }
            for(int i:remo){
                map.remove(i);
            }
        }
        return ret;
    }
}
