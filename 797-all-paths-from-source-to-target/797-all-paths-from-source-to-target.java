class Solution {
    List<List<Integer>> res = new ArrayList<>();    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        allPathsSourceTarget(graph, list, 0);
        return res;
    }
    public void allPathsSourceTarget(int[][] graph, List<Integer> list, int i) {
        if(i == graph.length - 1){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int neighbor:graph[i]){
            list.add(neighbor);
            allPathsSourceTarget(graph, list, neighbor);
            list.remove(list.size() - 1);
        }
        
    }
}