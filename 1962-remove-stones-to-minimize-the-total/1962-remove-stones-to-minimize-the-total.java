class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int p:piles){
            pq.offer(p);
        }
        while(k!=0){
            Integer temp=pq.poll();
            temp-=(int)Math.floor(temp/2);
            pq.offer(temp);
            k--;
        }
        Integer res=0;
        while(!pq.isEmpty()){
            res+=pq.poll();
        }
        return res;
    }
}