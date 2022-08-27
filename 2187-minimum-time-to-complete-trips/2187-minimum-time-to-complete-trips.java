class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long l = 0, h = findMin(time) * totalTrips, m;
        while(l + 1 < h){
            m = (l + h) / 2;
            if(canComplete(time, totalTrips, m))
                h = m;
            else
                l = m;
        }
        return h;
    }
    public long findMin(int[] time){
        long min = Long.MAX_VALUE;
        for(int t: time)
            min = Math.min(min, t);
        return min;
    }
    public boolean canComplete(int[] time, int totalTrips, long curTime){
        for(int t: time){
            totalTrips -= curTime / t;
            if(totalTrips <= 0)
                return true;
        }
        return false;
    }
}