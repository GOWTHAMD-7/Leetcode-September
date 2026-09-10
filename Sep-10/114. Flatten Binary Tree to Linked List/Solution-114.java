class Solution {

    public void dfs(TreeNode root,Queue<TreeNode> lst){
        lst.offer(root);
        if(root.left==null && root.right==null){
        }
        if(root.left!=null && root.right==null){
            dfs(root.left,lst);
        }
        if(root.left==null && root.right!=null){
            dfs(root.right,lst);
        }
        if(root.left!=null && root.right!=null){
            dfs(root.left,lst);
            dfs(root.right,lst);
        }
    }

    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        Queue<TreeNode> q=new LinkedList<>();
        dfs(root,q);
        q.poll();
        TreeNode temp=root;
        while(!q.isEmpty()){
            temp.left=null;
            temp.right=q.poll();
            temp=temp.right;
        }
    }
}
