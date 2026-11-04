class Result{
    long score;
    List<Integer> list;
    public Result(long score,List<Integer> list){
        this.score=score;
        this.list=list;
    }
}
class Solution {
    private Result solve(List<List<Integer>> intervals,int i,int k,Result dp[][]){
        if(k==0||i==intervals.size()){
            return new Result(0,new ArrayList<>());
        }
        if(dp[i][k]!=null){
            return dp[i][k];
        }
        int st=intervals.get(i).get(0);
        int en=intervals.get(i).get(1);
        int wt=intervals.get(i).get(2);
        int idx=intervals.get(i).get(3);
        int nextidx=bs(intervals,i);
        Result curr=solve(intervals,nextidx,k-1,dp);
        List<Integer> takelist=new ArrayList<>(curr.list);
        takelist.add(idx);
        Result take=new Result(curr.score+wt,takelist);
        Result skip=solve(intervals,i+1,k,dp);
        if(take.score > skip.score){
            return dp[i][k]=take;
        } 
        if(take.score < skip.score){
            return dp[i][k]=skip;
        } 
        return dp[i][k]=(smaller(take.list,skip.list)?take:skip);
    }
    private boolean smaller(List<Integer> a, List<Integer> b) {
        List<Integer> x = new ArrayList<>(a);
        List<Integer> y = new ArrayList<>(b);
        Collections.sort(x);
        Collections.sort(y);
        for (int i = 0; i < Math.min(x.size(), y.size()); i++) {
            if (!x.get(i).equals(y.get(i))) {
                return x.get(i) < y.get(i);
            }
        }
        return false;
    }
    private int bs(List<List<Integer>> intervals,int i){
        int low=i+1;
        int high=intervals.size()-1;
        int target=intervals.get(i).get(1);
        int res=intervals.size();
        while(low<=high){
            int mid=(low+high)/2;
            if(intervals.get(mid).get(0)>target){
                res=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return res;
    }
    public int[] maximumWeight(List<List<Integer>> intervals) {
        for(int i=0;i<intervals.size();i++) {
            intervals.get(i).add(i);
        }
        Collections.sort(intervals,(a,b)->a.get(0)-b.get(0));
        Result[][] dp=new Result[intervals.size()][5];
        Result r=solve(intervals,0,4,dp);
        int ans[]=new int[r.list.size()];
        int i=0;
        for(int k:r.list){
            ans[i++]=k;
        }
        Arrays.sort(ans);
        return ans;
    }
}