class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];
        boolean[] safe = new boolean[graph.length];
        for(int i = 0; i < graph.length; i++){
            explore(graph, i, visited, safe);
        }
        for(int i = 0; i < graph.length; i++){
            if(safe[i])res.add(i);
        }
        return res;
    }
    public void explore(int[][] graph, int vertex, boolean[] visited, boolean[] safe){
        if(visited[vertex])
            return;
        visited[vertex] = true;
        if(graph[vertex].length == 0){
            safe[vertex] = true;
            return;            
        }            
        boolean flag = true;
        for(int neighbor:graph[vertex]){
            explore(graph, neighbor, visited, safe);
            flag = flag && safe[neighbor];            
        }
        safe[vertex] = flag;
    }
}