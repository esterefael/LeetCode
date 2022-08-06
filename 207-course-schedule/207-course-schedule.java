class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Graph g = new Graph(numCourses);
        for(int[] edge:prerequisites){
            g.addEdge(edge[1],edge[0]);
        }
        return !g.isCyclic();        
    }

class Graph {
	
	private final int V;
	private final List<List<Integer>> adj;

	public Graph(int V)
	{
		this.V = V;
		adj = new ArrayList<>(V);
		
		for (int i = 0; i < V; i++)
			adj.add(new LinkedList<>());
	}
	
	// This function is a variation of DFSUtil() in
	// https://www.geeksforgeeks.org/archives/18212
	private boolean isCyclicUtil(int i, boolean[] visited,
									boolean[] recStack)
	{
		
		// Mark the current node as visited and
		// part of recursion stack
		if (recStack[i])
			return true;

		if (visited[i])
			return false;
			
		visited[i] = true;

		recStack[i] = true;
		List<Integer> children = adj.get(i);
		
		for (Integer c: children)
			if (isCyclicUtil(c, visited, recStack))
				return true;
				
		recStack[i] = false;

		return false;
	}

	public void addEdge(int source, int dest) {
		adj.get(source).add(dest);
	}

	// Returns true if the graph contains a
	// cycle, else false.
	// This function is a variation of DFS() in
	// https://www.geeksforgeeks.org/archives/18212
	public boolean isCyclic()
	{
		
		// Mark all the vertices as not visited and
		// not part of recursion stack
		boolean[] visited = new boolean[V];
		boolean[] recStack = new boolean[V];
		
		
		// Call the recursive helper function to
		// detect cycle in different DFS trees
		for (int i = 0; i < V; i++)
			if (isCyclicUtil(i, visited, recStack))
				return true;

		return false;
	}
}
    }