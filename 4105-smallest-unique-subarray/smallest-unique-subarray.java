import java.util.Arrays;

class Solution {
    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;
        int maxVal = 0;
        for (int x : nums) maxVal = Math.max(maxVal, x);
        long M = (long) maxVal + n + 2;

        // --- suffix array by prefix doubling ---
        int[] rank = nums.clone();
        int[] sa = new int[n];
        int[] newRank = new int[n];
        long[] key = new long[n];
        long[] packed = new long[n];

        for (int k = 1; ; k <<= 1) {
            for (int i = 0; i < n; i++) {
                key[i] = rank[i] * M + (i + k < n ? rank[i + k] + 1 : 0);
                packed[i] = key[i] * n + i;
            }
            Arrays.sort(packed);
            for (int j = 0; j < n; j++) sa[j] = (int) (packed[j] % n);

            newRank[sa[0]] = 0;
            for (int j = 1; j < n; j++) {
                newRank[sa[j]] = newRank[sa[j - 1]] + (key[sa[j]] != key[sa[j - 1]] ? 1 : 0);
            }
            System.arraycopy(newRank, 0, rank, 0, n);
            if (rank[sa[n - 1]] == n - 1) break;
        }

        // --- Kasai LCP: lcp[r] = LCP(sa[r], sa[r-1]) ---
        int[] lcp = new int[n + 1];
        int h = 0;
        for (int i = 0; i < n; i++) {
            if (rank[i] > 0) {
                int j = sa[rank[i] - 1];
                while (i + h < n && j + h < n && nums[i + h] == nums[j + h]) h++;
                lcp[rank[i]] = h;
                if (h > 0) h--;
            } else {
                h = 0;
            }
        }

        // --- answer ---
        int ans = n;
        for (int r = 0; r < n; r++) {
            int m = Math.max(lcp[r], r + 1 < n ? lcp[r + 1] : 0);
            if (m + 1 <= n - sa[r]) ans = Math.min(ans, m + 1);
        }
        return ans;
    }
}