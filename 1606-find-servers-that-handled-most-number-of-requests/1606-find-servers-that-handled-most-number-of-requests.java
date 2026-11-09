class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] count=new int[k];
        TreeSet<Integer> free=new TreeSet<>();
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]); 
        for(int i=0;i<k;i++){
            free.add(i);
        }
        for(int i=0;i<arrival.length;i++){
            int t=arrival[i];
            while(!pq.isEmpty()&&pq.peek()[1]<=arrival[i]){
                free.add(pq.poll()[0]);
            }
            if(free.isEmpty()){
                continue;
            }
            int server=i%k;
            Integer m=free.ceiling(server);
            if(m==null){
                m=free.first();
            }
            free.remove(m);
            count[m]++;
            pq.offer(new int[]{m,t+load[i]});
        }
        int max=0;
        for(int c:count){
            max=Math.max(c,max);
        }
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<k;i++){
            if(count[i]==max){
                res.add(i);
            }
        }
        return res;
    }
}