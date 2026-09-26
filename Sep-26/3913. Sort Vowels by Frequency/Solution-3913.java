class Solution {
    public String sortVowels(String s) {
        int len=s.length();
        HashMap<Character,Integer> map=new HashMap<>();
        LinkedHashSet<Character> set=new LinkedHashSet<>();
        for(int i=0;i<len;i++){
            char c=s.charAt(i);
            if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){
                if(!set.contains(c)){
                    set.add(c);
                }
                map.put(c,map.getOrDefault(c,0)+1);
            }
        }
        List<Character> lst=new ArrayList<>();
        for(int i=0;i<5;i++){
            int max=-1;
            char ch='3';
            for(char c:set){
                if(map.get(c)>max){
                    max=map.get(c);
                    ch=c;
                }
            }
            set.remove(ch);
            for(int j=0;j<max;j++){
                lst.add(ch);
            }
        }
        char[] arr=s.toCharArray();
        int k=0;
        for(int i=0;i<len;i++){
            if(arr[i]=='a' || arr[i]=='e' || arr[i]=='i' || arr[i]=='o' || arr[i]=='u'){
                arr[i]=lst.get(k);
                k++;
            }
        }
        return new String(arr);
    }
}
