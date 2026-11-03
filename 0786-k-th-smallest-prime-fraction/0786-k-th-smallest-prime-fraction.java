class Frac{
    int n;
    int d;
    double val;
    public Frac(int n,int d,double val){
        this.n=n;
        this.d=d;
        this.val=val;
    }
}
class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Frac> pq=new PriorityQueue<>((a,b)->Double.compare(a.val,b.val));
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                pq.offer(new Frac(arr[i],arr[j],(double)arr[i]/(double)arr[j]));
            }
        }
        Frac res=null;
        for(int i=0;i<k;i++){
            res=pq.poll();
        }
        return new int[]{res.n,res.d};
    }
}