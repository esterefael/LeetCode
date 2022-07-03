class Solution {
        public boolean validPath(int n, int[][] edges, int source, int destination) {

        boolean visited[]=new boolean[n];
        Queue<Integer> q=new LinkedList<>();
        visited[source]=true;
        q.add(source);
        while(!q.isEmpty() && !visited[destination])
        {
            int head=q.remove();
            for(int [] edge:edges)
            {
                if(edge[0]==head && !visited[edge[1]])
                {
                    visited[edge[1]]=true;
                     q.add(edge[1]);
                }
                if(edge[1]==head && !visited[edge[0]] )
                {
                    visited[edge[0]]=true;
                     q.add(edge[0]);
                }
                   
            }
        }
        return visited[destination];      
    } 


}