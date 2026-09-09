class Solution {
    public int start(int idx,int nums[],int tar){
        int low=0;
        int high=idx;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]<tar && nums[mid+1]==tar){
                return mid+1;
            }
            else if(nums[mid]==tar){
                high=mid-1;
            }
            else if(nums[mid]<tar){
                low=mid+1;
            }
        }
        return 0;
    }

    public int end(int idx,int nums[],int tar){
        int low=idx;
        int len=nums.length;
        int high=len-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]>tar && nums[mid-1]==tar){
                return mid-1;
            }
            else if(nums[mid]==tar){
                low=mid+1;
            }
            else if(nums[mid]>tar){
                high=mid-1;
            }
        }
        return len-1;
    }

    public int searchRange(int[] nums, int tar) {
        int len=nums.length;
        int[] ret=new int[2];
        ret[0]=-1;
        ret[1]=-1;
        int low=0;
        int high=len-1;;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==tar){
                ret[0]=start(mid,nums,tar);
                ret[1]=end(mid,nums,tar);
                break;
            }
            else if(nums[mid]>tar){
                high=mid-1;
            }
            else if(nums[mid]<tar){
                low=mid+1;
            }
        }
        return ret;
    }
}
