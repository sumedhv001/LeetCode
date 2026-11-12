class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int inclen=1;
        int max1=-1;
        if(nums.length==1){
            return 1;
        }
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                inclen++;
                max1=Math.max(max1,inclen);
            }else{
                max1=Math.max(max1,inclen);
                inclen=1;
            }
        }
        int declen=1;
        int max2=-1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]){
                declen++;
                max2=Math.max(max2,declen);
            }else{
                max2=Math.max(max2,declen);
                declen=1;
            }
        }
        return Math.max(max1,max2);
    }
}