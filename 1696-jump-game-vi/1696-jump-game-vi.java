class Solution {
    public int maxResult(int[] nums, int k) {
        
        int n = nums.length;
        Deque<Integer> dequeue = new LinkedList<>();
        int[] sum = new int[n];
        sum[0] = nums[0];
        dequeue.add(0);
        for(int i = 1; i < n; i++){
            int top = dequeue.getFirst();
            while(i - top > k){
                dequeue.pollFirst();
                top = dequeue.getFirst();
            } 
            int curSum = sum[top] + nums[i];
            while(!dequeue.isEmpty() && sum[dequeue.getLast()] <= curSum)
                dequeue.pollLast();
            dequeue.addLast(i);
            sum[i] = curSum;
        }
        return sum[n - 1];        
    }
}