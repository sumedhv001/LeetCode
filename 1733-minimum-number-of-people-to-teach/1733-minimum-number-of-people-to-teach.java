class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        HashMap<Integer,HashSet<Integer>> map=new HashMap<>();
        for(int i=0;i<languages.length;i++){
            map.put(i+1,new HashSet<>());
            for(int j:languages[i]){
                map.get(i+1).add(j);
            }
        }
        HashSet<Integer> users=new HashSet<>();
        for(int f[]:friendships){
            int a=f[0];
            int b=f[1];
            boolean cancomm=false;
            for(int l:map.get(a)){
                if(map.get(b).contains(l)){
                    cancomm=true;
                    break;
                }
            }
            if(!cancomm){
                users.add(a);
                users.add(b);
            }
        }
        int res=Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            int count=0;
            for(int j:users){
                boolean knows=false;
                for(int k:map.get(j)){
                    if(k==i){
                        knows=true;
                        break;
                    }
                }
                if(!knows){
                    count++;
                }
            }
            res=Math.min(res,count);
        }
        return res;
    }
}