class Solution {
    public long largestPerimeter(int[] nums) {
        long[] pref=new long[nums.length];
        Arrays.sort(nums);
        pref[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            pref[i]=pref[i-1]+nums[i];
        }
        int res=-1;
        for(int i=nums.length-1;i>=2;i--){
            if(pref[i-1]>nums[i]){
                return pref[i-1]+nums[i];
            }
        }
        return -1;
    }
}