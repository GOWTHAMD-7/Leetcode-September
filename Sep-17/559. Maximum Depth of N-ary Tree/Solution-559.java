class Solution {

    public void max(Node root,int[] ret,int pos){
        ret[0]=Math.max(ret[0],pos);
        for(Node n:root.children){
            max(n,ret,pos+1);
        }
    }

    public int maxDepth(Node root) {
        if(root==null){
            return 0;
        }
        int[] ret=new int[1];
        ret[0]=Integer.MIN_VALUE;
        max(root,ret,1);
        return ret[0];
    }
}
