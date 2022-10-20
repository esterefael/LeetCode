class Solution {
    
    // memoziation
    
    String s;
    Set<String> wordDict;
    boolean[] visited;
    public boolean wordBreak(String s, List<String> wordDict) {
        this.s = s;
        this.wordDict = new HashSet<>(wordDict);
        this.visited = new boolean[s.length()];
        return wordBreak(0);
    }
    public boolean wordBreak(int start) {
        if(start == s.length())
            return true;
        if(visited[start])
            return false;
        visited[start] = true;
        for(int end = start + 1; end <= s.length(); end++){
            if(wordDict.contains(s.substring(start, end)) && wordBreak(end))
                 return true;
        }
        return false;
    }
    
    //dp O(N ^ 4)
    
    // public boolean wordBreak(String s, List<String> wordDict) {        
    //     Set<String> wordDictSet = new HashSet<>(wordDict);
    //     boolean[][]dp = new boolean[s.length()][s.length()];
    //     for(int i = 0; i < s.length(); i++)
    //         dp[i][i] = wordDictSet.contains("" + s.charAt(i));
    //     for(int len = 1; len < s.length(); len++)
    //         for(int start = 0; start < s.length() - len; start++){
    //             int end = start + len;
    //             for(int partition = start; partition < end && !dp[start][end]; partition++)
    //                 if(dp[start][partition] && dp[partition + 1][end] || wordDictSet.contains(s.substring(start, end + 1)))
    //                     dp[start][end] = true;            
    //     }
    //     return dp[0][s.length() - 1];
    // }
    
//     //dp O(N ^ 3)
    
//         public boolean wordBreak(String s, List<String> wordDict) {        
//         Set<String> wordDictSet = new HashSet<>(wordDict);
//         boolean[]dp = new boolean[s.length() + 1];
//         dp[0] = true;
//         for(int end = 1; end <= s.length(); end++){
//             for(int partition = 0; partition < s.length() && !dp[end]; partition++)
//                 if(dp[partition] && wordDictSet.contains(s.substring(partition, end)))
//                     dp[end] = true;            
//         }
//         return dp[s.length()];
//     }
    
    //bfs
    
    // public boolean wordBreak(String s, List<String> wordDict) {
    //     Set<String> wordDictSet = new HashSet<>(wordDict);
    //     Queue<Integer>q = new LinkedList<>();
    //     boolean[] visited = new boolean[s.length()];
    //     q.add(0);
    //     while(!q.isEmpty()){
    //         int start = q.remove();
    //         if(start == s.length())
    //             return true;
    //         if(visited[start])
    //             continue;
    //         visited[start] = true;
    //         for(int end = s.length(); end > start; end--){
    //             if(wordDictSet.contains(s.substring(start, end)))
    //                q.add(end);
    //         }
    //     }
    //     return false;
    // }
}

