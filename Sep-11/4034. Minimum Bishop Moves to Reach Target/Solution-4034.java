class Solution {    

    public boolean isBlack(int a,int b){
        if(a%2==0 && b%2==0){
            return true;
        }
        if(a%2==1 && b%2==1){
            return true;
        }
        return false;
    }

    public int minBishopMoves(int[] s, int[] t) {
        if(isBlack(s[0],s[1]) && !isBlack(t[0],t[1])){
            return -1;
        }
        if(!isBlack(s[0],s[1]) && isBlack(t[0],t[1])){
            return -1;
        }
        if(isBlack(s[0],s[1])){
            System.out.println("Black");
            for(int i=s[0],j=s[1];i>0 && j>0;i--,j--){
                if(i==t[0] && j==t[1]){
                    return 1;
                }
            }
            for(int i=s[0],j=s[1];i>0 && j<9;i--,j++){
                if(i==t[0] && j==t[1]){
                    return 1;
                }
            }
            for(int i=s[0],j=s[1];i<9 && j>0;i++,j--){
                if(i==t[0] && j==t[1]){
                    return 1;
                }
            }
            for(int i=s[0],j=s[1];i<9 && j<9;i++,j++){
                if(i==t[0] && j==t[1]){
                    return 1;
                }
            }
            return 2;
        }
        else{
            System.out.println("White");
            for(int i=s[0],j=s[1];i>0 && j>0;i--,j--){
                if(i==t[0] && j==t[1]){
                    return 1;
                }
            }
            for(int i=s[0],j=s[1];i>0 && j<9;i--,j++){
                if(i==t[0] && j==t[1]){
                    return 1;
                }
            }
            for(int i=s[0],j=s[1];i<9 && j>0;i++,j--){
                if(i==t[0] && j==t[1]){
                    return 1;
                }
            }
            for(int i=s[0],j=s[1];i<9 && j<9;i++,j++){
                if(i==t[0] && j==t[1]){
                    return 1;
                }
            }
            return 2;
        }
    }
}
