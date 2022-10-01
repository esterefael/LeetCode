class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        final int N = recipes.length;
        List<String> res = new LinkedList<>();
        Set<String> set = new HashSet<>(Arrays.asList(supplies));
        int[] degree = new int[N];
        Queue<String> q = new LinkedList<>();
        Map<String, List<Integer>> graph = new HashMap<>();
        for(String rec:recipes)
            graph.put(rec, new LinkedList<>());
        for(int i = 0; i < N; i++){
            for(String ingr:ingredients.get(i)){
                if(!set.contains(ingr)){
                    degree[i]++;
                    if(graph.containsKey(ingr))
                        graph.get(ingr).add(i);
                }
            }
            if(degree[i] == 0)
                q.add(recipes[i]);
        }
        while(!q.isEmpty()){
            String rec = q.remove();
            res.add(rec);
            for(Integer neig:graph.get(rec)){
                if(--degree[neig] == 0)
                    q.add(recipes[neig]);
            }                
        }
        return res;
    }
}