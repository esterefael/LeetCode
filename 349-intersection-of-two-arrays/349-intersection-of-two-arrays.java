class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        final int  N = nums1.length, M = nums2.length;
        if(N > M)
            return intersection(nums2, nums1);
        Set<Integer> set1 = new HashSet<>();
        for(int n: nums1)
            set1.add(n);
        Set<Integer> set2 = new HashSet<>();
        for(int n: nums2)
            if(set1.contains(n))
                set2.add(n);
        int[] res = new int[set2.size()];
        int i = 0;
        for(int n: set2)
            res[i++] = n;
        return res;
    }
}