class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {

        ArrayList<Integer>[] graph = new ArrayList[2 * n];
        buildGraph(graph, n, redEdges, blueEdges);
        
        int [] dist = new int[2 * n];
        
        Set<Integer> seen = new HashSet<>();
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        bfs(graph, 0, dist ,seen); //start from red edges
        seen.clear();
        bfs(graph, n, dist ,seen); //start from blue edges
        
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            ans[i] = Math.min(dist[i], dist[i + n]);
            ans[i] = ans[i] == Integer.MAX_VALUE ?  -1 : ans[i];
        }
        return ans;        
    }
    public void buildGraph(ArrayList<Integer>[] graph, int n, int[][] redEdges, int[][] blueEdges){
        
        for(int i = 0; i < 2 * n; i++)        
            graph[i] = new ArrayList<>();
        
        for(int[] edge:redEdges){
            
            int src = edge[0];
            int dst = edge[1];          
            graph[src].add(dst + n);
        }
        for(int[] edge:blueEdges){
            
            int src = edge[0];
            int dst = edge[1];          
            graph[src + n].add(dst);
        }        
    }
    public void bfs(ArrayList<Integer>[] graph, int src, int [] dist,Set<Integer> seen ){
        
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        dist[src] = 0;
        while(!queue.isEmpty()){
            
            int top = queue.remove();
            if(seen.contains(top))
                continue;
            seen.add(top);
            
            for(int neighbour:graph[top]){
                dist[neighbour] = Math.min(dist[neighbour], dist[top] + 1);
                queue.add(neighbour);
            }
        }
    }
}