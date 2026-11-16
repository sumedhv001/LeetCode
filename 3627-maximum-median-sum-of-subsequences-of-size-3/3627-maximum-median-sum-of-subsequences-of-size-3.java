class Solution {
    public long maximumMedianSum(int[] nums) {
        Deque<Integer> q=new ArrayDeque<>();
        Arrays.sort(nums);
        q.offerFirst(nums[0]);
        for(int i=1;i<nums.length;i++){
            q.offerLast(nums[i]);
        }
        long res=0;
        while(!q.isEmpty()){
            q.pollFirst();
            q.pollLast();
            res+=q.pollLast();
        }
        return res;
    }
}