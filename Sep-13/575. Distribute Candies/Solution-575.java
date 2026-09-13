class Solution {
    public int distributeCandies(int[] candy) {
        int len=candy.length;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<len;i++){
            set.add(candy[i]);
        }
        int s=set.size();
        return Math.min(s,len/2);
    }
}
