class Solution {

    public boolean isPrime(int n){
        int len=(int)Math.sqrt(n);
        for(int i=2;i<=len;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    public int mostFrequentPrime(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int max=-1;
        int freq=-1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int sum=0;
                //S
                for(int k=i;k<m;k++){
                    sum=(sum*10);
                    sum+=mat[k][j];
                    if(sum>10){
                        if(isPrime(sum)){
                            int ff=map.getOrDefault(sum,0)+1;
                            if(ff>freq){
                                freq=ff;
                                max=sum;
                            }
                            else if(ff==freq){
                                max=Math.max(sum,max);
                            }
                            map.put(sum,ff);
                        }
                    }
                }
                sum=0;
                //N
                for(int k=i;k>=0;k--){
                    sum=(sum*10);
                    sum+=mat[k][j];
                    if(sum>10){
                        if(isPrime(sum)){
                            int ff=map.getOrDefault(sum,0)+1;
                            if(ff>freq){
                                freq=ff;
                                max=sum;
                            }
                            else if(ff==freq){
                                max=Math.max(sum,max);
                            }
                            map.put(sum,ff);
                        }
                    }
                }
                sum=0;
                //E
                for(int k=j;k<n;k++){
                    sum=(sum*10);
                    sum+=mat[i][k];
                    if(sum>10){
                        if(isPrime(sum)){
                            int ff=map.getOrDefault(sum,0)+1;
                            if(ff>freq){
                                freq=ff;
                                max=sum;
                            }
                            else if(ff==freq){
                                max=Math.max(sum,max);
                            }
                            map.put(sum,ff);
                        }
                    }
                }
                sum=0;
                //W
                for(int k=j;k>=0;k--){
                    sum=(sum*10);
                    sum+=mat[i][k];
                    if(sum>10){
                        if(isPrime(sum)){
                            int ff=map.getOrDefault(sum,0)+1;
                            if(ff>freq){
                                freq=ff;
                                max=sum;
                            }
                            else if(ff==freq){
                                max=Math.max(sum,max);
                            }
                            map.put(sum,ff);
                        }
                    }
                }
                sum=0;
                //SE
                for(int p=i,q=j;p<m && q<n;p++,q++){
                    sum=(sum*10);
                    sum+=mat[p][q];
                    if(sum>10){
                        if(isPrime(sum)){
                            int ff=map.getOrDefault(sum,0)+1;
                            if(ff>freq){
                                freq=ff;
                                max=sum;
                            }
                            else if(ff==freq){
                                max=Math.max(sum,max);
                            }
                            map.put(sum,ff);
                        }
                    }
                }
                sum=0;
                //SW
                for(int p=i,q=j;p<m && q>=0;p++,q--){
                    sum=(sum*10);
                    sum+=mat[p][q];
                    if(sum>10){
                        if(isPrime(sum)){
                            int ff=map.getOrDefault(sum,0)+1;
                            if(ff>freq){
                                freq=ff;
                                max=sum;
                            }
                            else if(ff==freq){
                                max=Math.max(sum,max);
                            }
                            map.put(sum,ff);
                        }
                    }
                }
                sum=0;
                //NW
                for(int p=i,q=j;p>=0 && q>=0;p--,q--){
                    sum=(sum*10);
                    sum+=mat[p][q];
                    if(sum>10){
                        if(isPrime(sum)){
                            int ff=map.getOrDefault(sum,0)+1;
                            if(ff>freq){
                                freq=ff;
                                max=sum;
                            }
                            else if(ff==freq){
                                max=Math.max(sum,max);
                            }
                            map.put(sum,ff);
                        }
                    }
                }
                sum=0;
                //NE
                for(int p=i,q=j;p>=0 && q<n;p--,q++){
                    sum=(sum*10);
                    sum+=mat[p][q];
                    if(sum>10){
                        if(isPrime(sum)){
                            int ff=map.getOrDefault(sum,0)+1;
                            if(ff>freq){
                                freq=ff;
                                max=sum;
                            }
                            else if(ff==freq){
                                max=Math.max(sum,max);
                            }
                            map.put(sum,ff);
                        }
                    }
                }
            }
        }
        return max;
    }
}
