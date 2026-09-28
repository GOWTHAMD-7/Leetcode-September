class Solution {
    public Node connect(Node root) {
        if(root==null){
            return root;
        }
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int len=q.size();
            Node out=q.poll();
            if(out.left!=null){
                q.add(out.left);
            }
            if(out.right!=null){
                q.add(out.right);
            }
            for(int i=1;i<len;i++){
                Node t=q.poll();
                out.next=t;
                out=t;
                if(t.left!=null){
                    q.add(t.left);
                }
                if(t.right!=null){
                    q.add(t.right);
                }
            }
        }
        return root;
    }
}
