class Solution {

    public Boolean check(int i,int j,int k,String s1,String s2,String s3,int[][] arr){
        int len1=s1.length();
        int len2=s2.length();
        int len3=s3.length();
        if(i>=len1 && j>=len2){
            return true;
        }
        if(i<len1 && j<len2){
            if((s1.charAt(i)==s3.charAt(k)) && (s2.charAt(j)==s3.charAt(k))){
                if(arr[i+1][j]==0){
                    arr[i+1][j]=check(i+1,j,k+1,s1,s2,s3,arr)?3:2;
                }
                if(arr[i][j+1]==0){
                    arr[i][j+1]=check(i,j+1,k+1,s1,s2,s3,arr)?3:2;
                }
                return arr[i+1][j]==3?true:false || arr[i][j+1]==3?true:false;
            }
            else if(s1.charAt(i)==s3.charAt(k)){
                if(arr[i+1][j]==0){
                    arr[i+1][j]=check(i+1,j,k+1,s1,s2,s3,arr)?3:2;
                }
                return arr[i+1][j]==3?true:false;
            }
            else if(s2.charAt(j)==s3.charAt(k)){
                if(arr[i][j+1]==0){
                    arr[i][j+1]=check(i,j+1,k+1,s1,s2,s3,arr)?3:2;
                }
                return arr[i][j+1]==3?true:false;
            }
            else{
                return false;
            }
        }
        else if(i<len1){
            if(s1.charAt(i)==s3.charAt(k)){
                if(arr[i+1][j]==0){
                    arr[i+1][j]=check(i+1,j,k+1,s1,s2,s3,arr)?3:2;
                }
                return arr[i+1][j]==3?true:false;
            }
            else{
                return false;
            }
        }
        else if(j<len2){
            if(s2.charAt(j)==s3.charAt(k)){
                if(arr[i][j+1]==0){
                    arr[i][j+1]=check(i,j+1,k+1,s1,s2,s3,arr)?3:2;
                }
                return arr[i][j+1]==3?true:false;
            }
            else{
                return false;
            }
        }
        return false;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int len1=s1.length();
        int len2=s2.length();
        int len3=s3.length();
        if(len1+len2!=len3){
            return false;
        }
        if(len1==0){
            if(s2.equals(s3)){
                return true;
            }
            return false;
        }
        if(len2==0){
            if(s1.equals(s3)){
                return true;
            }
            return false;
        }
        int[][] arr=new int[len1+1][len2+1];
        return check(0,0,0,s1,s2,s3,arr);
    }
}
