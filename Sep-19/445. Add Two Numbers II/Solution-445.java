class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder num1=new StringBuilder();
        StringBuilder num2=new StringBuilder();
        while(l1!=null){
            num1.append(String.valueOf(l1.val));
            l1=l1.next;
        }
        while(l2!=null){
            num2.append(String.valueOf(l2.val));
            l2=l2.next;
        }
        int len1=num1.length();
        int len2=num2.length();
        int i=len1-1;
        int j=len2-1;
        StringBuilder ret=new StringBuilder();
        int carry=0;
        while(i>=0 || j>=0){
            int t1=0;
            int t2=0;
            if(i>=0){
                t1=Integer.valueOf(num1.toString().substring(i,i+1));
                i--;
            }
            if(j>=0){
                t2=Integer.valueOf(num2.toString().substring(j,j+1));
                j--;
            }
            int sum=t1+t2+carry;
            carry=0;
            if(sum>9){
                carry=sum/10;
                ret.append(String.valueOf(sum%10));
            }
            else{
                ret.append(String.valueOf(sum));
            }
        }
        if(carry>0){
            ret.append(String.valueOf(carry));
        }
        int len=ret.length();
        ListNode retu=new ListNode(0);
        l1=retu;
        for(i=len-1;i>=0;i--){
            l1.next=new ListNode(Integer.valueOf(ret.toString().substring(i,i+1)));
            l1=l1.next;
        }
        return retu.next;
    }
}
