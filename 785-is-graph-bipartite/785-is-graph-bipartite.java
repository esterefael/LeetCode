class Solution {
    public boolean isBipartite(int[][] graph) {
    int[] color = new int[graph.length];
    Arrays.fill(color, -1);
    for (int i = 0; i < graph.length; i++) {
        if (color[i] == -1) {
            if (!bfsCheck(graph, i, color)) {
                return false;
            }
        }
    }
    return true;
}
 public  boolean bfsCheck(int[][] graph, int src, int[] color) {
    Queue<Integer> que = new LinkedList<>();
    que.add(src);
    color[src] = 1;
    while (!que.isEmpty()) {
        int node = que.poll();
        for (Integer it : graph[node]) {
            if (color[it] == -1) {
                color[it] = 1 - color[node];
                que.add(it);
            } else if (color[it] == color[node]) {
                return false;
            }
        }
    }
    return true;
}
//     public boolean isBipartite(int[][] graph) {
//         Queue<Integer> queue = new LinkedList<>();
//         int[] group = new int[graph.length];
//         for(int i = 0; i < graph.length; i++){
//             if(group[i] == 0){
//                 queue.offer(i);
//                 group[i] = 1;
//                 while(!queue.isEmpty()){
//                     int top = queue.poll();
//                     int curGroup = group[top];
//                     int nextGroup = curGroup ==1? 2: 1;
//                     for(int neighbor:graph[top]){
//                         if(group[neighbor] == curGroup)return false;
//                         if(group[neighbor] == 0){
//                             queue.offer(neighbor);
//                             group[neighbor] = nextGroup;                    
//                         }
//                     }
//                 }  
//             }
//         }
//         return true;
//     }
}
