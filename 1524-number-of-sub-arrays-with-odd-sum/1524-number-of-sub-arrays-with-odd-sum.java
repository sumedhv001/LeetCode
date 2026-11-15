class Solution {
    final int MOD=1000000007;
    private int solve(int i,int a[],int rem,Integer dp[][]){
        if(i==a.length){
            if(rem==0){
                return 0;
            }else{
                return 1;
            }
        }
        if(dp[rem][i]!=null){
            return dp[rem][i];
        }
        if(rem==0){
            return dp[rem][i]=solve(i+1,a,(rem+a[i])%2,dp);
        }
        return dp[rem][i]=1+solve(i+1,a,(rem+a[i])%2,dp);
    }
    public int numOfSubarrays(int[] arr) {
        int res=0;
        Integer dp[][]=new Integer[2][arr.length];
        for(int i=0;i<arr.length;i++){
            res+=solve(i,arr,0,dp);
            res=res%MOD;
        }
        return res;
    }
}