class Solution {

    public int[] avg(TreeNode root,int[] ret){
        if(root.left==null && root.right==null){
            ret[0]++;
            int arr[]=new int[2];
            arr[0]=root.val;
            arr[1]=1;
            return arr;
        }
        else if(root.left!=null && root.right==null){
            int arr[]=new int[2];
            arr[0]=root.val;
            arr[1]=1;
            int arrL[]=new int[2];
            arrL=avg(root.left,ret);
            arr[0]+=arrL[0];
            arr[1]+=arrL[1];
            if(arr[0]/arr[1]==root.val){
                ret[0]++;
            }
            return arr;
        }
        else if(root.left==null && root.right!=null){
            int arr[]=new int[2];
            arr[0]=root.val;
            arr[1]=1;
            int arrR[]=new int[2];
            arrR=avg(root.right,ret);
            arr[0]+=arrR[0];
            arr[1]+=arrR[1];
            if(arr[0]/arr[1]==root.val){
                ret[0]++;
            }
            return arr;
        }
        else{
            int arr[]=new int[2];
            arr[0]=root.val;
            arr[1]=1;
            int arrL[]=new int[2];
            arrL=avg(root.left,ret);
            arr[0]+=arrL[0];
            arr[1]+=arrL[1];
            int arrR[]=new int[2];
            arrR=avg(root.right,ret);
            arr[0]+=arrR[0];
            arr[1]+=arrR[1];
            if(arr[0]/arr[1]==root.val){
                ret[0]++;
            }
            return arr;
        }
    }

    public int averageOfSubtree(TreeNode root) {
        int[] ret=new int[2];
        int[] arr=new int[2];
        arr=avg(root,ret);
        return ret[0];
    }
}
