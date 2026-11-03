class disjointSet{
    public List<Integer> parent=new ArrayList<>();
    public List<Integer> size=new ArrayList<>();
    public disjointSet(int n)
    {
        for(int i=0;i<n;i++)
        {
            parent.add(i);
            size.add(1);
        }
    }
    public int find(int node)
    {
        if(node==parent.get(node))
        {
            return node;
        }
        int ultparent=find(parent.get(node));
        parent.set(node,ultparent);
        return parent.get(node);
    }
    public void unionbysize(int u,int v)
    {
        int ultofu=find(u);
        int ultofv=find(v);
        if(ultofu==ultofv)
        {
            return;
        }
        if(size.get(ultofu)<size.get(ultofv))
        {
            parent.set(ultofu,ultofv);
            size.set(ultofv,size.get(ultofv)+size.get(ultofu));
        }
        else
        {
            parent.set(ultofv,ultofu);
            size.set(ultofu,size.get(ultofu)+size.get(ultofv));
        }
    }
}
class Solution {
    private boolean check(int row,int col,disjointSet ds,boolean land[][]){
        for(int i=0;i<col;i++){
            if(!land[0][i]){
                continue;
            }
            for(int j=0;j<col;j++){
                if(!land[row-1][j]){
                    continue;
                }
                int cell1=i;
                int cell2=(row-1)*col+j;
                if(ds.find(cell1)==ds.find(cell2)){
                    return true;
                }
            }
        }
        return false;
    }
    public int latestDayToCross(int row, int col, int[][] cells) {
        disjointSet ds=new disjointSet(row*col);
        int n=cells.length;
        final int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
        boolean land[][]=new boolean[row][col];
        for(int i=n-1;i>=0;i--){
            int r=cells[i][0]-1;
            int c=cells[i][1]-1;
            land[r][c]=true;
            for(int d[]:dir){
                int nr=r+d[0];
                int nc=c+d[1];
                if(nr>=0&&nr<row&&nc>=0&&nc<col&&land[nr][nc]){
                    ds.unionbysize(r*col+c,nr*col+nc);
                }
            }
            if(check(row,col,ds,land)) {
                return i;
            }
        }
        return -1;
    }
}