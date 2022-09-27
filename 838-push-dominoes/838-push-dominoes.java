class Solution {
    // O(N ^ 2) BF
    // public String pushDominoes(String dominoes) {
    //     String nextState = dominoes;
    //     do{
    //         dominoes = nextState;
    //         nextState = nextSecond(dominoes);
    //     }while(!nextState.equals(dominoes));
    //     return nextState;
    // }
    // private String nextSecond(String dominoes){
    //     StringBuilder res = new StringBuilder();
    //     dominoes = "." + dominoes + ".";
    //     for(int i = 1; i < dominoes.length() - 1; i++){
    //         char c = dominoes.charAt(i);
    //         if(c == '.'){
    //             boolean left = false, right = false;
    //             if(dominoes.charAt(i - 1) == 'R'){
    //                 c = 'R';
    //                 right = true;
    //             }
    //             if(dominoes.charAt(i + 1) == 'L'){
    //                 c = 'L';
    //                 left = true;
    //             }
    //             if(right && left)
    //                 c = '.';
    //         }
    //         res.append(c);
    //     }
    //     return res.toString();
    // }
    // O(N) two pointers
    public String pushDominoes(String dominoes){
        dominoes = "L" + dominoes + "R";
        char[] charr = dominoes.toCharArray();
        int i = 0;
        while(i < charr.length - 1){
            if(charr[i + 1] == '.'){
                int left = i;
                while(charr[++i] == '.');
                int right = i;
                char leftLetter = charr[left], rightLetter = charr[right];
                if(leftLetter == 'L' && rightLetter == 'R')
                    continue;
                if(leftLetter == rightLetter)
                    change(charr, left + 1, right, rightLetter);
                else{
                    int mid = (left + right) / 2;
                    change(charr, left + 1, mid + (left + right) % 2, leftLetter);
                    change(charr, mid + 1, right, rightLetter);
                }
            }else
                i++;
        }
        return String.valueOf(charr, 1, charr.length - 2);
    }
    private void change(char[] charr, int left, int right, char c){
        for(int i = left; i < right; i++)
            charr[i] = c;
    }
}