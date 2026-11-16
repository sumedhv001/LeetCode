class Solution {
    public String digitSum(String s, int k) {
        StringBuilder sb=new StringBuilder(s);
        while(sb.length()>k){
            int i=0;
            StringBuilder temp=new StringBuilder();
            while(i<sb.length()){
                String a=sb.substring(i,Math.min(i+k,sb.length()));
                
                int sum=0;
                for(char c:a.toCharArray()){
                    sum+=(int)(c-'0');
                }
                temp.append(sum);
                i+=k;
            }
            sb=temp;
        }
        return sb.toString();
    }
}