class Solution {
    private int dfs(int[] a,int i,List<List<Integer>> adj,int size[]){
        for(int k:adj.get(i)){
            size[i]+=dfs(a,k,adj,size);
        }
        return size[i];
    }
    private void dfs2(int a[],int i,List<List<Integer>> adj,int last[],String s){
        char curr=s.charAt(i);
        int old=last[curr-'a'];
        if(i>0&&old!=-1){
            a[i]=old;
        }
        last[curr-'a']=i;
        for(int k:adj.get(i)){
            dfs2(a,k,adj,last,s);
        }
        last[curr-'a']=old;
    }
    public int[] findSubtreeSizes(int[] parent, String s) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<parent.length;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=1;i<parent.length;i++){
            adj.get(parent[i]).add(i);
        }
        int last[]=new int[26];
        Arrays.fill(last,-1);
        dfs2(parent,0,adj,last,s);
        List<List<Integer>> adj2=new ArrayList<>();
        for(int i=0;i<parent.length;i++){
            adj2.add(new ArrayList<>());
        }
        for(int i=1;i<parent.length;i++){
            adj2.get(parent[i]).add(i);
        }
        int size[]=new int[parent.length];
        Arrays.fill(size,1);
        dfs(parent,0,adj2,size);
        return size;
    }
}