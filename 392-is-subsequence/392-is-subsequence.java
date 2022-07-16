class Solution {
    public boolean isSubsequence(String s, String t) {
        
        // int preIndex = -1, curIndex;
        // for(int i = 0; i < s.length(); i++){
        //     curIndex = t.indexOf( s.charAt(i), preIndex + 1);
        //     System.out.println(curIndex);
        //     if(curIndex < 0) return false;
        //     preIndex = curIndex;
        // }
        // return true;   
        
        // Follow up        
        HashMap<Character, List<Integer>> hm = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            List<Integer> list = hm.getOrDefault(t.charAt(i), new LinkedList<>());
            list.add(i);
            hm.put(t.charAt(i), list);
        }

        int index = -1;
        for(int i = 0; i < s.length(); i++){
            boolean flag = false;
            if(!hm.containsKey(s.charAt(i)))return false;
            for(int j: hm.get(s.charAt(i))){
                if(j > index){
                    index = j;
                    flag  = true;
                    break;
                }
            }
            if(!flag)return false;
        }
        return true;
    }
}