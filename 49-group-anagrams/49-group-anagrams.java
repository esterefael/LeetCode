class Solution {
       public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> map= new HashMap<>();
        for(String s:strs){
            char[] chars = new char[26];
            for(char ch:s.toCharArray())
                chars[ch-'a']++;
            String hash=new String(chars); 
            map.putIfAbsent(hash,new ArrayList<>());
            map.get(hash).add(s);
        }
        res.addAll(map.values());
        return res;        
    }
}