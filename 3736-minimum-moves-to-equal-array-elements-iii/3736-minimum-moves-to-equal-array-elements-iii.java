class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int max=nums[nums.length-1];
        int res=0;
        for(int i=0;i<nums.length;i++)
            {
                res=res+max-nums[i];
            }
        return res;
    }
}