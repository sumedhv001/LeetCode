class Solution {
    public boolean checkString(String s) {
        if(s.length()==1){
            return true;
        }
        int counta=0;
        int countb=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a'){
                counta++;
            }else{
                countb++;
            }
        }
        if(counta==s.length()||countb==s.length()){
            return true;
        }
        int firstb=-1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='b'){
                firstb=i;
                break;
            }
        }
        int posa=-1;
        for(int i=s.length()-1;i>=firstb;i--){
            if(s.charAt(i)=='a'){
                return false;
            }
        }
        return true;
    }
}