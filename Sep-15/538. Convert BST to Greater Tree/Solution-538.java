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

    public int bst(TreeNode root,int prev){
        if(root.left==null && root.right==null){
            int t=root.val;
            root.val+=prev;
            return t;
        }
        else if(root.left==null && root.right!=null){
            int t=root.val;
            int right=bst(root.right,prev);
            root.val+=right+prev;
            return t+right;
        }
        else if(root.left!=null && root.right==null){
            int t=root.val;
            root.val+=prev;
            int left=bst(root.left,t+prev);
            return t+left;
        }
        else{
            int t=root.val;
            int right=bst(root.right,prev);
            root.val+=right+prev;
            int left=bst(root.left,t+prev+right);
            return t+right+left;
        }
    }

    public TreeNode convertBST(TreeNode root) {
        if(root==null){
            return root;
        }
        int ii=bst(root,0);
        return root;
    }
}
