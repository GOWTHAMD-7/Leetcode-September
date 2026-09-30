class Solution {

    public boolean isPal(String sb,int start,int end){
        for(int i=start,j=end;i<j;i++,j--){
            if(sb.charAt(i)!=sb.charAt(j)){
                return false;
            }
        }
        return true;
    }

    public boolean checkPalindromeFormation(String a, String b) {
        int len=a.length();
        if(isPal(a,0,len-1)){
            return true;
        }
        if(isPal(b,0,len-1)){
            return true;
        }
        int check=0;
        for(int i=0,j=len-1;i<=j;i++,j--){
            if(a.charAt(i)!=b.charAt(j)){

                if(isPal(a,i,j)){
                    return true;
                }
                if(isPal(b,i,j)){
                    return true;
                }
                check=1;
                break;
            }
        }
        if(check==0){
            return true;
        }
        check=0;
        for(int i=0,j=len-1;i<j;i++,j--){
            if(a.charAt(j)!=b.charAt(i)){
                if(isPal(a,i,j)){
                    return true;
                }
                if(isPal(b,i,j)){
                    return true;
                }
                check=1;
                break;
            }
        }
        if(check==0){
            return true;
        }
        return false;
    }
}
