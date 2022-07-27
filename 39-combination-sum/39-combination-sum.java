class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res= new LinkedList<>();
        combinationSum(candidates, 0, target, new LinkedList<>(), res);
        return res;
    }
    public void combinationSum(int[] candidates, int i, int target, List<Integer>cur, List<List<Integer>> res) {
        
        if(target <= 0){
            
            if(target == 0)
                res.add(new LinkedList<>(cur));
            return;
        }
        for(; i < candidates.length; i++){
            
            cur.add(candidates[i]);
            combinationSum(candidates, i, target - candidates[i], cur, res);
            cur.remove(cur.size() - 1);            
        }
    
    }    
}
