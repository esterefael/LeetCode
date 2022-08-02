class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        
        // Build a bidirectional graph
        // start dfs from random node
        // color a leaf with color which di
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        buildGraph(graph, paths);
        int[] color = new int[n + 1];
        for(int i = 1; i <= n; i++){
            if(!graph.containsKey(i))//if the node has no neighbor, then it doesn't matter which color that node has. 
                color[i]  = 1;
            if(color[i] == 0)//if is not visited
                dfs(graph, i, color);
        }
        // for(int i = 0; i < n; i++)
        //     color[i] = color[i + 1];        
        // return Arrays.copyOf(color, n);
        return Arrays.copyOfRange(color, 1, n +1);
        
        
    }
    public void buildGraph(Map<Integer, List<Integer>> graph, int[][] paths){
        
        for(int[] path:paths){
            
            int src = path[0];
            int dst = path[1];
            graph.putIfAbsent(src, new LinkedList<>());
            graph.putIfAbsent(dst, new LinkedList<>());
            graph.get(src).add(dst);
            graph.get(dst).add(src);
        }
        
    }
    public void dfs(Map<Integer, List<Integer>> graph, int src, int[]color){
        
        color[src] = -1;// mark as visited
        boolean[] colorNeighbor = new boolean[5];
        for(int neighbor:graph.get(src)){
            
            if(color[neighbor] == 0)
                dfs(graph, neighbor, color);
            if(color[neighbor] != -1)// check the neighbor's color to know which color to choose.
                colorNeighbor[color[neighbor]] = true;            
        }
        for(int i = 1; i <= 4; i++){//choose a color which no neighbor has chosen.
            
            if(!colorNeighbor[i]){
                color[src] = i;
                break;
            }
        }
    }
}