class Solution {
    public String largestPalindrome(int n, int k) {
        StringBuilder sb=new StringBuilder();
        if(k==1){
            for(int i=0;i<n;i++){
                sb.append(9);
            }
        }
        else if(k==2){
            sb.append(8);
            for(int i=0;i<n-2;i++){
                sb.append(9);
            }
            if(n>1){
                sb.append(8);
            }
        }
        else if(k==3){
            for(int i=0;i<n;i++){
                sb.append(9);
            }
        }
        else if(k==4){
            sb.append(8);
            if(n>1){
                sb.append(8);
            }
            for(int i=0;i<n-4;i++){
                sb.append(9);
            }
            if(n>4){
                sb.append(88);
            }else{
                for(int i=2;i<n;i++){
                    sb.append(8);
                }
            }
        }
        else if(k==5){
            sb.append(5);
            for(int i=0;i<n-2;i++){
                sb.append(9);
            }
            if(n>1){
                sb.append(5);
            }
        }
        else if(k==6){
            if(n<3){
                for(int i=0;i<n;i++){
                    sb.append(6);
                }
            }
            else{
                if(n%2==0){
                    sb.append(8);
                    int t=(n-2)/2;
                    t--;
                    for(int i=0;i<t;i++){
                        sb.append(9);
                    }  
                    sb.append(77);     
                    for(int i=0;i<t;i++){
                        sb.append(9);
                    }  
                    sb.append(8);
                }
                else{
                    int t=(n-2)/2;
                    sb.append(8);
                    for(int i=0;i<t;i++){
                        sb.append(9);
                    }  
                    sb.append(8);     
                    for(int i=0;i<t;i++){
                        sb.append(9);
                    }  
                    sb.append(8);
                }
            }
        }
        else if(k==7){
            if(n<3){
                for(int i=0;i<n;i++){
                    sb.append(7);
                }
            }
            else{
                List<String> odd=new ArrayList<>();
                List<String> even=new ArrayList<>();
                odd.add("5");
                odd.add("7");
                odd.add("4");
                odd.add("6");
                odd.add("4");
                odd.add("7");
                even.add("77");
                even.add("99");
                even.add("44");
                even.add("44");
                even.add("99");
                even.add("77");
                if(n%2==0){
                    int t=n/2;
                    for(int i=0;i<t-1;i++){
                        sb.append(9);
                    }
                    sb.append(even.get((t-2)%6));
                    for(int i=0;i<t-1;i++){
                        sb.append(9);
                    }
                }
                else{
                    int t=n/2;
                    for(int i=0;i<t;i++){
                        sb.append(9);
                    }
                    sb.append(odd.get((t-1)%6));
                    for(int i=0;i<t;i++){
                        sb.append(9);
                    }

                }
            }
        }
        else if(k==8){
            if(n<7){
                for(int i=0;i<n;i++){
                    sb.append(8);
                }
            }
            else{
                sb.append(888);
                for(int i=0;i<n-6;i++){
                    sb.append(9);
                }
                sb.append(888);
            }
        }
        else if(k==9){
            for(int i=0;i<n;i++){
                sb.append(9);
            }
        }
        return sb.toString();
    }
}
