class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] == b[1]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            }
        });
        
        int count = 1;
        int last = pairs[0][1];
        
        for (int[] p : pairs) {
            if (last < p[0]) {
                count++;
                last = p[1];
            }
        }
        
        return count;
    }
}