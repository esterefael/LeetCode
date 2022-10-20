class Solution {
    String s;
    Set<String> wordDict;
    boolean[] cantbreak;    
    List<String>res;
    public boolean wordBreak(int start, String sentence) {
        if(start == s.length()){
            res.add(sentence.substring(1));
            return false;            
        }
        if(cantbreak[start])
            return true;
        StringBuilder sb = new StringBuilder();
        for(int end = start; end < s.length(); end++){
            sb.append(s.charAt(end));
            if(wordDict.contains(new String(sb))){ 
                cantbreak[start] &= wordBreak(end + 1, new String((sentence + ' ' + sb))); 
            }
        }
        return cantbreak[start];
    } 
    public List<String> wordBreak(String s, List<String> wordDict) {
        this.s = s;
        this.wordDict = new HashSet<>(wordDict);
        this.cantbreak = new boolean[s.length()];
        res = new LinkedList<>();
        wordBreak(0, "");  
        return res;
    }

}