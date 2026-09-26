/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    int ret=0;

    public int max(TreeNode root){
        if(root.left==null && root.right==null){
            ret++;
            return root.val;
        }
        else if(root.left!=null && root.right==null){
            int l=max(root.left);
            if(l<=root.val){
                ret++;
                return root.val;
            }
            return l;
        }
        else if(root.left==null && root.right!=null){
            int r=max(root.right);
            if(r<=root.val){
                ret++;
                return root.val;
            }
            return r;
        }
        else{
            int r=max(root.right);
            int l=max(root.left);
            l=Math.max(r,l);
            if(l<=root.val){
                ret++;
                return root.val;
            }
            return l;
        }
    }

    public int countDominantNodes(TreeNode root) {
        int t=max(root);
        return ret;
    }
}
