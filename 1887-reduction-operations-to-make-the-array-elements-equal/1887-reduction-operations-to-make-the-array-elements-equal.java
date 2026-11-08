class Solution {
    public int reductionOperations(int[] nums) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        int res=0;
        int ops=0;
        for(int n:map.values()){
            res+=n*ops;
            ops++;
        }
        return res;
    }
}