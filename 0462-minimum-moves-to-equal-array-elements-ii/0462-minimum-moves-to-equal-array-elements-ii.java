class Solution {
    public int minMoves2(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        if(nums.length==2){
            int median=(nums[0]+nums[1])/2;
            return Math.abs(median-nums[0])+Math.abs(median-nums[1]);
        }
        Arrays.sort(nums);
        int median=nums[nums.length/2];
        int res=0;
        for(int k:nums){
            res+=Math.abs(k-median);
        }
        return res;
    }
}