class Solution {
    public int minChanges(String s) {
        int res=0;
        for(int i=0;i<s.length();i+=2){
            int a=(int)(s.charAt(i)-'0');
            int b=(int)(s.charAt(i+1)-'0');
            if(a!=b){
                res++;
            }
        }
        return res;
    }
}