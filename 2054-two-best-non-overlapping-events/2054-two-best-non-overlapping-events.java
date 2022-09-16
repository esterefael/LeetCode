class Solution {
    public int maxTwoEvents(int[][] events) {
        final int N = events.length;
        Arrays.sort(events, (a, b)-> a[0] - b[0]);
        int[] suffix = new int[N];
        suffix[N - 1] = events[N - 1][2];
        for(int i = N - 2; i >= 0; i--)
            suffix[i] = Math.max(suffix[i + 1], events[i][2]);
        int res = 0;
        for(int[] e:events){            
            int nextIndex= binarySearch(e[1], events);
            res = Math.max(res, e[2] + (nextIndex == N ? 0 : suffix[nextIndex]));
        }
        return res;
    }
    public int binarySearch(int key, int[][] events){
        int l = 0, r = events.length - 1, res = events.length, m;
        while(l <= r){
            m = (l + r) / 2;
            int start = events[m][0];
            if(start > key){
                res = m;
                r = m - 1;
            }else
                l = m + 1;
        }
        return res;        
    }
}