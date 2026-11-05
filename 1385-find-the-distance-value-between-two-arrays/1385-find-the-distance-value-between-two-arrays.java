class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count=0;
        for(int i:arr1){
            boolean isless=false;
            for(int j:arr2){
                if(Math.abs(i-j)<=d){
                    isless=true;
                    break;
                }
            }
            if(!isless){
                count++;
            }
        }
        return count;
    }
}