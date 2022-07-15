class Solution {
    public boolean isBipartite(int[][] graph) {
        Queue<Integer> queue = new LinkedList<>();
        int[] group = new int[graph.length];
        Arrays.fill(group, -1);
        for(int i = 0; i < graph.length; i++){
            if(group[i] == -1){
                queue.offer(i);
                group[i] = 1;
                while(!queue.isEmpty()){
                    int top = queue.poll();
                    int curGroup = group[top];
                    int nextGroup = 1 - curGroup;
                    for(int neighbor:graph[top]){
                        if(group[neighbor] == curGroup)return false;
                        if(group[neighbor] == -1){
                            queue.offer(neighbor);
                            group[neighbor] = nextGroup;                    
                        }
                    }
                }  
            }
        }
        return true;
    }
}
