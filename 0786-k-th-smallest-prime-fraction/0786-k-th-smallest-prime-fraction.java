class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        double l=0.0;
        double r=1.0;
        int n=arr.length;
        while(l<r){
            double mid=(l+r)/2;
            double maxfrac=0.0;
            int count=0;
            int nidx=-1;
            int denidx=-1;
            int j=1;
            for(int i=0;i<arr.length;i++){
                while(j<arr.length&&((double)arr[i]/arr[j])>=mid){
                    j++;
                }
                count+=arr.length-j;
                if(j==arr.length){
                    break;
                }
                double frac=(double)arr[i]/arr[j];
                if(frac>maxfrac){
                    nidx=i;
                    denidx=j;
                    maxfrac=frac;
                }
            }
            if(count==k){
                return new int[]{arr[nidx],arr[denidx]};
            }else if(count<k){
                l=mid;
            }else{
                r=mid;
            }
        }
        return new int[]{};
    }
}