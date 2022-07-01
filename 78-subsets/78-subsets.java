class Solution {
       public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        res.add(new ArrayList<>() );
        for(int i=0 ;i<nums.length;i++){
            List<List<Integer>> temp= new ArrayList<>(new ArrayList<>());
            for(List<Integer> l: res){
                List<Integer> newList=new ArrayList<Integer>(l);
                newList.add(nums[i]);
                temp.add(newList);
            }
            res.addAll(temp);
        }       
        return res;  
    }
    
}