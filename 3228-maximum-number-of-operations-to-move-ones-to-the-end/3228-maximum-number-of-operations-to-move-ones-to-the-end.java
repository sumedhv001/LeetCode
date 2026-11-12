class Solution {
    public int maxOperations(String s) {
        int ones=0;
        int res=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                ones++;
                if(i+1<s.length()&&s.charAt(i+1)=='0'){
                    res+=ones;
                }
            }
        }
        return res;
    }
}