import java.util.Hashtable;
class Solution {
    public int lengthOfLongestSubstring(String s) {
          int res=0,max=0,start=0;
          Hashtable<Character,Integer> ht=new Hashtable<>();
          for(int i=0;i<s.length();i++){
            Integer temp= ht.get(s.charAt(i));
            if(temp!=null && temp >= start)
            {            
                max=Math.max(res,max);
                res=i-temp-1;
                start=temp+1;
            }
            ht.put(s.charAt(i),i);
            res++;
            }
        return Math.max(res,max);
    }
}