class Solution {
    int leftsize=0;
    int rightsize=0;
    private void balance(PriorityQueue<Integer> left,PriorityQueue<Integer> right){
        if(leftsize>rightsize+1){
            right.offer(left.poll());
            leftsize--;
            rightsize++;
        }else if(leftsize<rightsize){
            left.offer(right.poll());
            rightsize--;
            leftsize++;
        }
    }
    private void prune(PriorityQueue<Integer> heap,HashMap<Integer,Integer> deleted){
        while(!heap.isEmpty()){
            int cur=heap.peek();
            if(deleted.getOrDefault(cur,0)>0){
                heap.poll();
                if(deleted.get(cur)==1){
                    deleted.remove(cur);
                }else{
                    deleted.put(cur,deleted.get(cur)-1);
                }
            }else{
                break;
            }
        }
    }
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> left=new PriorityQueue<>((a,b)->Integer.compare(b,a));
        PriorityQueue<Integer> right=new PriorityQueue<>();
        HashMap<Integer,Integer> deleted=new HashMap<>();
        int l=0;
        int r=k-1;
        int n=nums.length;
        double[] res=new double[n-k+1];
        for(int i=0;i<k;i++){
            if(left.isEmpty() || nums[i]<=left.peek()){
                left.offer(nums[i]);
                leftsize++;
            }else{
                right.offer(nums[i]);
                rightsize++;
            }
            balance(left,right);
        }
        if(leftsize==rightsize){
            res[0]=((double)left.peek()+right.peek())/2;
        }else{
            res[0]=left.peek();
        }
        int idx=1;
        while(r<n-1){
            r++;
            int add=nums[r];
            if(add<=left.peek()){
                left.offer(add);
                leftsize++;
            }else{
                right.offer(add);
                rightsize++;
            }
            balance(left,right);
            int remove=nums[l];
            prune(left,deleted);
            if(remove<=left.peek()){
                leftsize--;
                if(remove==left.peek()){
                    prune(left,deleted);
                }
            }else{
                rightsize--;
                if(!right.isEmpty()&&remove==right.peek()){
                    prune(right,deleted);
                }
            }
            deleted.put(remove,deleted.getOrDefault(remove,0)+1);
            balance(left,right);
            l++;
            prune(left,deleted);
            prune(right,deleted);
            if(leftsize==rightsize){
                res[idx++]=((double)left.peek()+right.peek())/2;
            }else{
                res[idx++]=left.peek();
            }
        }
        return res;
    }
}