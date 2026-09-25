class Solution {

    public int findLongestChain(int[][] arr) {
        int len=arr.length;
        Arrays.sort(arr,(a,b)-> a[1]-b[1]);
        int max=Integer.MIN_VALUE;
        int cnt=0;
        for(int i=0;i<len;i++){
            if(arr[i][0]>max){
                cnt++;
                max=arr[i][1];
            }
        }
        return cnt;
    }
}
