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

    public void tree(int[] nums,TreeNode root,int start,int end){
        int pos=0;
        int max=Integer.MIN_VALUE;
        for(int i=start;i<end;i++){
            if(nums[i]>max){
                max=nums[i];
                pos=i;
            }
        }
        if(max==Integer.MIN_VALUE){
            return;
        }
        root.val=nums[pos];
        if(start<pos){
            root.left=new TreeNode();
            tree(nums,root.left,start,pos);
        }
        if(pos+1<end){
            root.right=new TreeNode();
            tree(nums,root.right,pos+1,end);
        }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode ret=new TreeNode();
        tree(nums,ret,0,nums.length);
        return ret;
    }
}
