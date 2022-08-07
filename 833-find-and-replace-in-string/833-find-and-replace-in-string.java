class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
 
//      // Using array
//         final int N = s.length();
        
//         String[] resArr = new String[N];
//         for(int i = 0; i < N; i++)
//             resArr[i] = "" + s.charAt(i);        
        
//         for(int i = 0; i < indices.length; i++){
            
//             int startIndex = indices[i];
//             if(s.startsWith(sources[i], startIndex)){
                
//                 resArr[startIndex] = targets[i];
//                 int endIndex = Math.min(startIndex + sources[i].length(), N);
//                 while(++startIndex < endIndex)
//                     resArr[startIndex] = "";
//             } 
//         }
//         StringBuilder res = new StringBuilder();
//         for(String substr:resArr)
//             res.append(substr);
//         return res.toString();
//         // return String.join("", resArr); 
//     }
        
    // Using hashmap        
        final int N = s.length(), K = indices.length;
        Map<Integer, Integer> replace = new HashMap<>();//index in string, index in sources & targets
        for(int i = 0; i < K; i++)
            if(s.startsWith(sources[i],indices[i]))
                replace.put(indices[i], i);        
                        
        StringBuilder res = new StringBuilder();
        int i = 0;
        while(i < N){
                
            Integer index = replace.get(i);            
            if(index != null){
                res.append(targets[index]);  
                i += sources[index].length();
            }else{
                
                res.append(s.charAt(i));
                i++;
            }
        }
        return res.toString();
    }        
}