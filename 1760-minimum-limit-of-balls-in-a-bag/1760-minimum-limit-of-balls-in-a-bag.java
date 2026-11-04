class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int l=1;
        int r=1000000000;
        while(l<r){
            int mid=(l+r)/2;
            int count=0;
            for(int n:nums){
                count+=(n-1)/mid;
            }
            if(count>maxOperations){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        return l;
    }
}