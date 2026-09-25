class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] arr) {
        int len=arr.length;
        List<List<Integer>> ret=new ArrayList<>();
        int cnt=0;
        int sum=0;
        for(int i=0;i<len;i++){
            if(arr[i]==2){
                cnt++;
            }
            sum+=arr[i];
        }   
        if(upper+lower!=sum || cnt>lower || cnt>upper){
            return ret;
        }
        ret.add(new ArrayList<>());
        ret.add(new ArrayList<>());
        upper-=cnt;
        lower-=cnt;
        for(int i=0;i<len;i++){
            if(arr[i]==0){
                ret.get(0).add(0);
                ret.get(1).add(0);
            }
            else if(arr[i]==2){
                ret.get(0).add(1);
                ret.get(1).add(1);
            }
            else{
                if(upper!=0){
                    ret.get(0).add(1);
                    ret.get(1).add(0);
                    upper--;
                }
                else{
                    ret.get(0).add(0);
                    ret.get(1).add(1);
                    lower--;
                }
            }
        }
        return ret;
    }
}
