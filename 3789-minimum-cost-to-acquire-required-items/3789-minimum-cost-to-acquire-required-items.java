class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long total1=(long)need1*cost1+(long)need2*cost2;
        long total2=(long)(Math.max(need1,need2))*costBoth;
        total1=Math.min(total1,total2);
        long total3=(long)Math.min(need1,need2)*costBoth;
        if(need1>need2)
        {
            total3=total3+(long)(need1-need2)*cost1;
        }
        else
        {
            total3=total3+(long)(need2-need1)*cost2;
        }
        total1=Math.min(total1,total3);
        return total1;
    }
}