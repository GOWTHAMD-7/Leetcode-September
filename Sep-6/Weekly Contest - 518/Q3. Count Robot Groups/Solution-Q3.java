class Solution {
    public int countGroups(int[] pos, int[] speed, int dist) {
        int len=pos.length;
        List<Long> lst=new ArrayList<>();
        List<Long> spd=new ArrayList<>();
        int prev=pos[0];
        lst.add((long)pos[0]);
        spd.add((long)speed[0]);
        for(int i=1;i<len;i++){
            if(pos[i]-prev<=dist){
                lst.remove(lst.size()-1);
                spd.remove(spd.size()-1);
            }
            lst.add((long)pos[i]);
            spd.add((long)speed[i]);
            prev=pos[i];
        }
        len=lst.size();
        int ret=1;
        long pre=spd.get(len-1);
        for(int i=len-2;i>=0;i--){
            if(pre>=spd.get(i)){
                ret++;
                pre=spd.get(i);
            }
        }
        return ret;
    }
}
