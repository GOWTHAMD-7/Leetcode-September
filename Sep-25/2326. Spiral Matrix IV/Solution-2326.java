class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] ret=new int[m][n];
        int is=0;
        int js=0;
        int ie=m-1;
        int je=n-1;
        while(is<=ie && js<=je){
            for(int j=js;j<=je;j++){
                int t=-1;
                if(head!=null){
                    t=head.val;
                    head=head.next;
                }
                ret[is][j]=t;
            }
            is++;
            for(int i=is;i<=ie;i++){
                int t=-1;
                if(head!=null){
                    t=head.val;
                    head=head.next;
                }
                ret[i][je]=t;
            }
            je--;
            if(is<=ie){
                for(int j=je;j>=js;j--){
                    int t=-1;
                    if(head!=null){
                        t=head.val;
                        head=head.next;
                    }
                    ret[ie][j]=t;
                }
                ie--;
            }
            if(js<=je){
                for(int i=ie;i>=is;i--){
                    int t=-1;
                    if(head!=null){
                        t=head.val;
                        head=head.next;
                    }
                    ret[i][js]=t;
                }
                js++;
            }
        }
        return ret;
    }
}
