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

    public void dlte(TreeNode root,int key){
        if(root.left==null && root.right==null){
            return;
        }
        else if(root.left!=null && root.right==null){
            if(root.left.val==key){
                root.left=shift(root.left);
            }
            else{
                dlte(root.left,key);
            }
        }
        else if(root.left==null && root.right!=null){
            if(root.right.val==key){
                root.right=shift(root.right);
            }
            else{
                dlte(root.right,key);
            }
        }
        else{
            if(root.left.val==key){
                root.left=shift(root.left);
            }
            else if(root.right.val==key){
                root.right=shift(root.right);
            }
            else{
                dlte(root.left,key);
                dlte(root.right,key);
            }
        }
    }

    public TreeNode shift(TreeNode root){
        if(root.left==null && root.right==null){
            return null;
        }
        else if(root.left==null && root.right!=null){
            return root.right;
        }
        else if(root.left!=null && root.right==null){
            return root.left;
        }
        else{
            TreeNode leftChild=root.left;
            TreeNode rightChild=root.right;
            TreeNode temp=Lshift(root.right,root);
            temp.left=leftChild;
            if(temp!=rightChild){
                temp.right=rightChild;
            }
            return temp;
        }
    }

    public TreeNode Lshift(TreeNode root,TreeNode head){
        if(root.left==null && root.right==null){
            head.left=null;
            return root;
        }
        else if(root.left==null && root.right!=null){
            head.left=root.right;
            return root;
        }
        else{
            return Lshift(root.left,root);
        }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return root;
        }
        TreeNode temp=new TreeNode(-1);
        temp.left=root;
        dlte(temp,key);
        return temp.left;
    }
}
