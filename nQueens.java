class Solution {
    List<List<String>> r = new ArrayList<>();
    boolean[] c,d1,d2;

    public List<List<String>> solveNQueens(int n) {
        c= new boolean[n];
        d1=new boolean[n*2];
        d2=new boolean[n*2];
        char[][] b= new char[n][n];

        for(char[] row : b) Arrays.fill(row,'.');
        bt(0,n,b);
        return r;
        
    }
    void bt(int i ,int n, char[][] b){
        if(i==n){
            List<String> t = new ArrayList<>();
            for(char[] x : b) t.add(new String(x));
            r.add(t);
            return;
        }
        for(int j=0;j<n;j++){
            if(!c[j] && !d1[i+j] && !d2[i-j+n]){
                b[i][j] = 'Q';
                c[j] = d1[i+j] = d2[i-j+n] = true;

                bt(i+1,n,b);
                b[i][j] = '.';
                c[j]=d1[i+j] = d2[i-j+n] =false;
            }
        }
    }
}