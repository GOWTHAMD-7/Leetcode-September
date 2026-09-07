class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set=new HashSet<>();
        HashSet<Integer> ret=new HashSet<>();
        for(int i:nums1){
            set.add(i);
        }
        for(int i:nums2){
            if(set.contains(i)){
                ret.add(i);
            }
        }
        int[] arr=new int[ret.size()];
        int k=0;    
        for(int i:ret){
            arr[k]=i;
            k++;
        }
        return arr;
    }
}
