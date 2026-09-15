class Pair{
    int lvl;
    Node node;
    Pair(int lvl,Node node){
        this.lvl=lvl;
        this.node=node;
    }
}


class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret=new ArrayList<>();
        if(root==null){
            return ret;
        }
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(1,root));
        while(!q.isEmpty()){
            Pair p=q.poll();
            Node n=p.node;
            if(ret.size()<p.lvl){
                ret.add(new ArrayList<>());
            }
            ret.get(p.lvl-1).add(n.val);
            for(Node t:n.children){
                q.add(new Pair(p.lvl+1,t));
            }
        }
        return ret;
    }
}
