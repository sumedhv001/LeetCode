class Info{
    char c;
    int i;
    public Info(char c,int i){
        this.c=c;
        this.i=i;
    }
}
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb=new StringBuilder();
        PriorityQueue<Info> pq=new PriorityQueue<>((x,y)->y.i-x.i);
        if(a>0){
            pq.add(new Info('a',a));
        }
        if(b>0){
            pq.add(new Info('b',b));
        }
        if(c>0){
            pq.add(new Info('c',c));
        }
        while(!pq.isEmpty()){
            Info first=pq.poll();
            char ch=first.c;
            if(sb.length()>=2&&sb.charAt(sb.length()-1)==ch&&sb.charAt(sb.length()-2)==ch){
                if(pq.isEmpty()){
                    break;
                }
                Info second=pq.poll();
                int count=second.i;
                sb.append(second.c);
                count--;
                if(count>0){
                    pq.offer(new Info(second.c,count));
                }
                pq.offer(first);
            }else{
                int count=first.i;
                sb.append(first.c);
                count--;
                if(count>0){
                    pq.offer(new Info(first.c,count));
                }
            }
        }
        return sb.toString();
    }
}