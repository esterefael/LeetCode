class Solution {
    public int maximumDetonation(int[][] bombs) {
        
        final int N = bombs.length;
        List<Integer>[] graph = new LinkedList[N];
        buildGraph(N, bombs, graph);
        return dfs(N, graph);
    }
    public void buildGraph(final int N, int[][] bombs, List<Integer>[] graph){
        
        for(int i = 0; i < N; i++){
            
            graph[i] = new LinkedList<>();
            for(int j = 0; j < N; j++)            
                if(i != j && check(bombs, i, j))
                    graph[i].add(j);
        }
    }
    public boolean check(int[][] bombs, int i, int j){
        
        double distance = dist(bombs, i, j);
        return distance <= bombs[i][2];
    }
    public double dist(int[][] bombs, int i, int j){
        
        int x1 = bombs[i][0];
        int x2 = bombs[j][0];
        int y1 = bombs[i][1];
        int y2 = bombs[j][1];
        return Math.sqrt(Math.pow((x1-x2), 2) + Math.pow((y1-y2), 2));
    }
    public int dfs(final int N, List<Integer>[] graph){
                
        int max = 0;
        for(int i = 0; i < N; i++){
            boolean[] visited = new boolean[N];
            max = Math.max(max, explore(i, graph, visited)); 
            if(max == N)return max;
        }
        return max;
    }
    public int explore(int i,List<Integer>[] graph, boolean[] visited){
        int res = 1;
        visited[i] = true;
        for(int neighbor:graph[i])
            if(!visited[neighbor])
                res += explore(neighbor, graph, visited);   
            
        return res;
    }
}