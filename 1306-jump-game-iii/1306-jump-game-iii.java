class Solution {
//     public boolean canReach(int[] arr, int start) {
//         int n = arr.length;
//         boolean[]visited = new boolean[n];
//         Queue<Integer> queue = new LinkedList<>();
        
//         queue.offer(start);
//         while(!queue.isEmpty()){
//             int top = queue.remove();
//             if(arr[top] == 0)return true;
//             visited[top] = true;
            
//             int left = top - arr[top];
//             int right = top + arr[top];

//             if(left >= 0 && !visited[left])
//                 queue.offer(left);
            
//             if(right < n && !visited[right])
//                 queue.offer(right);            
//         }
//         return false;
//     }
        public boolean canReach(int[] arr, int i) {
            
            if(i < 0 || arr.length <= i || arr[i] < 0) return false;
            
            if(arr[i] == 0) return true;
            
            int val = arr[i];
            arr[i] = -1;
            return  canReach(arr, i + val) || canReach(arr, i - val);
    }
}
