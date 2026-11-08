class Position{
    int[] odd;
    int[] even;
    public Position(int[] odd,int[] even){
        this.odd=odd;
        this.even=even;
    }
}
class Solution {
    public int numSpecialEquivGroups(String[] words) {
        Position[] pos=new Position[words.length];
        for(int j=0;j<words.length;j++){
            String s=words[j];
            int[] even=new int[26];
            int[] odd=new int[26];
            for(int i=0;i<s.length();i++){
                if(i%2==0){
                    even[s.charAt(i)-'a']++;
                }else{
                    odd[s.charAt(i)-'a']++;
                }
            }
            pos[j]=new Position(odd,even);
        }
        int res=0;
        HashSet<String> set=new HashSet<>();
        for(Position p:pos){
            int[] odd=p.odd;
            int[] even=p.even;
            StringBuilder code=new StringBuilder();
            for(int i=0;i<26;i++){
                code.append((char)('a'+i));
                code.append(even[i]);
            }
            for(int i=0;i<26;i++){
                code.append((char)('a'+i));
                code.append(odd[i]);
            }
            set.add(code.toString());
        }
        return set.size();
    }
}