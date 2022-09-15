class Solution {
    public String strWithout3a3b(int a, int b) {
        if(a + b == 0)
            return "";
        StringBuilder res = new  StringBuilder();
        int cnt = 1;
        char pre;
        if(a > b){
            pre = 'a';
            a--;
        }else{
            pre = 'b';
            b--;
        }
        res.append(pre);
        while(a + b > 0){
            char cur = a > b ? 'a' : 'b';
            if(cnt == 2 && cur == pre)
                cur = cur == 'a' ? 'b' : 'a';
            if(cur != pre)
                cnt = 0;
            cnt++;
            if(cur == 'a')
                a--;
            else
                b--;   
            res.append(cur);  
            pre = cur;
        }
        return res.toString();
    }
}