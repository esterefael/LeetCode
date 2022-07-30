class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        final int N = temperatures.length;
        int[] res = new int[N];
        Stack<Integer> stack = new Stack<>();
        
        for(int day = 0; day < N; day++)        {
            int curTemp = temperatures[day];
            while(!stack.isEmpty() && temperatures[stack.peek()] < curTemp){
                int lastCoolerDay = stack.pop();
                res[lastCoolerDay] = day - lastCoolerDay;
            }
            stack.push(day);
        }
        return res;
    }
}