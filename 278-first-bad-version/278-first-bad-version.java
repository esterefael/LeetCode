/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 0, h = n, m;
        while(l + 1 < h){
            m = l + (h - l) / 2;
            if(isBadVersion(m))
                h = m;
            else
                l = m;
        }
        return h;
    }
}