class Pair{
    char c;
    int cnt;
    Pair(char c,int cnt){
        this.c=c;
        this.cnt=cnt;
    }
}

class Solution {
    public String repeatLimitedString(String s, int lmt) {
        int len=s.length();
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<len;i++){
            char c=s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)-> b.c-a.c);
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            char c=entry.getKey();
            int cnt=entry.getValue();
            pq.add(new Pair(c,cnt));
        }
        StringBuilder sb=new StringBuilder();
        Pair p=pq.poll();
        if(p.cnt<=lmt){
            for(int i=0;i<p.cnt;i++){
                sb.append(p.c);
            }
        }
        else{
            for(int i=0;i<lmt;i++){
                sb.append(p.c);
            }
            p.cnt=p.cnt-lmt;
            pq.add(p);
        }
        char prev=p.c;
        while(!pq.isEmpty()){
            p=pq.poll();
            if(p.c==prev){
                if(!pq.isEmpty()){
                    Pair pp=pq.poll();
                    pq.add(p);
                    sb.append(pp.c);
                    pp.cnt=pp.cnt-1;
                    if(pp.cnt>0){
                        pq.add(pp);
                    }
                    prev=pp.c;
                }
                else{
                    break;
                }
            }
            else{
                if(p.cnt<=lmt){
                    for(int i=0;i<p.cnt;i++){
                        sb.append(p.c);
                    }
                }
                else{
                    for(int i=0;i<lmt;i++){
                        sb.append(p.c);
                    }
                    p.cnt=p.cnt-lmt;
                    pq.add(p);
                }
                prev=p.c;
            }
        }
        return sb.toString();
    }
}
