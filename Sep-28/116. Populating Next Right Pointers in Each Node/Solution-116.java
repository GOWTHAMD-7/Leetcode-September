class Solution {
    public Node connect(Node root) {
        if(root==null || root.left==null){
            return root;
        }
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int len=q.size();
            Node out=q.poll();
            if(out.left!=null){
                q.add(out.left);
                q.add(out.right);
            }
            for(int i=1;i<len;i++){
                Node t=q.poll();
                out.next=t;
                out=t;
                if(t.left!=null){
                    q.add(t.left);
                    q.add(t.right);
                }
            }
        }
        return root;
    }
}
