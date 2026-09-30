class Solution {
    public boolean isFascinating(int n) {
        if(n>333){
            return false;
        }
        HashSet<Integer> set=new HashSet<>();
        int t=n;
        while(t!=0){
            int f=t%10;
            if(f==0){
                return false;
            }
            if(set.contains(f)){
                return false;
            }
            set.add(f);
            t=t/10;
        }
        t=n*2;
        while(t!=0){
            int f=t%10;
            if(f==0){
                return false;
            }
            if(set.contains(f)){
                return false;
            }
            set.add(f);
            t=t/10;
        }
        t=n*3;
        while(t!=0){
            int f=t%10;
            if(f==0){
                return false;
            }
            if(set.contains(f)){
                return false;
            }
            set.add(f);
            t=t/10;
        }
        return true;
    }
}
