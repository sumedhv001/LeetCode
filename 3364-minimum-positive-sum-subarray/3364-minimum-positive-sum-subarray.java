class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int res=Integer.MAX_VALUE;
        for(int i=l;i<=r;i++){
            int st=0;
            int en=i-1;
            int sum=0;
            if(en>nums.size()-1){
                break;
            }
            for(int j=st;j<=en;j++){
                sum+=nums.get(j);
            }
            if(sum>0){
                res=Math.min(res,sum);
            }
            while(en<nums.size()-1){
                en++;
                sum+=nums.get(en);
                sum-=nums.get(st);
                st++;
                if(sum>0){
                    res=Math.min(res,sum);
                }
            }
        }
        return (res==Integer.MAX_VALUE)?-1:res;
    }
}