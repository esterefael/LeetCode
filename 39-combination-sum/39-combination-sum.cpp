class Solution {
public:
    
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>>res;
        vector<int>cur;
        combinationSum(res, cur, candidates, target, 0);
        return res;
    }
    void combinationSum(vector<vector<int>>& res, vector<int> cur, vector<int>& candidates, int target, int i){
        if(target <= 0){
            if(target == 0){
                res.push_back(cur);                
            }
            return;
        }
        for(; i < candidates.size(); i++){
            cur.push_back(candidates[i]);
            combinationSum(res, cur, candidates, target - candidates[i], i);
            cur.pop_back();
        }
    }
};