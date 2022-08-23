class Solution {
    private Map<Character, char[]> KeyBoard;
    public List<String> letterCombinations(String digits) {
        List <String> res = new ArrayList<>();
        if(digits.length() > 0){
            initKeyBoard();
            dfs(new StringBuilder(),res, digits.toCharArray());         
        } 
        return res;        
    }
    public void initKeyBoard(){
        KeyBoard = new HashMap<>();
        KeyBoard.put('2', new char[]{'a','b','c'});
        KeyBoard.put('3', new char[]{'d','e','f'});
        KeyBoard.put('4', new char[]{'g', 'h','i'});
        KeyBoard.put('5', new char[]{'j','k','l'});
        KeyBoard.put('6', new char[]{'m','n','o'});
        KeyBoard.put('7', new char[]{'p','q','r','s'});
        KeyBoard.put('8', new char[]{'t','u','v'});
        KeyBoard.put('9', new char[]{'w','x','y','z'});
    }
    private void dfs(StringBuilder sb,List<String> res, char[] digits){
        if(sb.length()==digits.length){
            res.add(sb.toString());;
            return;
        }
        char nextDigit = digits[sb.length()];
        for(char letter:KeyBoard.get(nextDigit)){
            sb.append(letter);
            dfs(sb,res, digits);
            sb.deleteCharAt(sb.length()-1);                
        }
    }
}