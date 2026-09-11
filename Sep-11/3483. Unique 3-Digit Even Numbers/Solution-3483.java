class Solution {

    int ret=0;

    public void ones(int[] arr){
        if(arr[0]==0 && arr[2]==0 && arr[4]==0 && arr[6]==0 && arr[8]==0){
            return;
        }
        for(int i=1;i<10;i++){
            if(arr[i]>0){
                arr[i]--;
                twos(arr);
                arr[i]++;
            }
        }
    }
    public void twos(int[] arr){
        if(arr[0]==0 && arr[2]==0 && arr[4]==0 && arr[6]==0 && arr[8]==0){
            return;
        }
        for(int i=0;i<10;i++){
            if(arr[i]>0){
                arr[i]--;
                threes(arr);
                arr[i]++;
            }
        }
    }
    public void threes(int[] arr){
        if(arr[0]==0 && arr[2]==0 && arr[4]==0 && arr[6]==0 && arr[8]==0){
            return;
        }
        for(int i=0;i<10;i+=2){
            if(arr[i]>0){
                ret++;
            }
        }
    }

    public int totalNumbers(int[] dig) {
        int len=dig.length;
        int[] arr=new int[10];
        for(int i=0;i<len;i++){
            arr[dig[i]]++;
        }
        ones(arr);
        return ret;
    }
}
