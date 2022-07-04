class Solution {
    public int findCircleNum(int[][] isConnected) {
        int res = 0;
        boolean[] visited = new boolean[isConnected.length];
        for(int i = 0; i < isConnected.length; i++){
            if(!visited[i]){
                explore(isConnected, visited, i); 
                res++;               
            }
        }
        return res;
    }
    public void explore(int[][] isConnected, boolean[] visited, int i){
        visited[i] = true;
        for(int k = 0; k < isConnected.length; k++){
            if(!visited[k] && isConnected[i][k] == 1)
                explore(isConnected, visited, k );               

        }
    }
}