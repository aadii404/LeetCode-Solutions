class Solution {
    int n;
    String str;
    int[][] costMemo;
    int[][] memo;

    private int getCost(int i, int j) {
        int len = j - i + 1;

        int minCost = Integer.MAX_VALUE;

        for (int d = 1; d < len; d++) {
            if (len % d != 0)
                continue;

            int cost = 0;
            for (int group = 0; group < d; group++) { // for d, we will have d groups
                int l = i + group;
                int r = l + (len / d - 1) * d;

                while (l < r) {
                    if (str.charAt(l) != str.charAt(r))
                        cost++;

                    l += d;
                    r -= d;
                }
            }

            minCost = Math.min(minCost, cost);
        }

        return minCost;
    }

    public int minimumChanges(String s, int k) {
        n = s.length();
        str = s;

        costMemo = new int[n][n];
        for (int[] row : costMemo)
            Arrays.fill(row, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                costMemo[i][j] = getCost(i, j);
            }
        }

        memo = new int[n + 1][k + 1];
        for (int[] row : memo)
            Arrays.fill(row, Integer.MAX_VALUE); // MAX_VALUE = impossible

        memo[n][0] = 0;

        for (int start = n; start >= 0; start--) {
            for (int pieces = 1; pieces <= k; pieces++) {
                if (start + 2 * pieces > n)
                    continue;

                int result = Integer.MAX_VALUE;

                for (int end = start + 1; end < n; end++) {
                    int remainCost = memo[end + 1][pieces - 1];

                    if (remainCost == Integer.MAX_VALUE)
                        continue;

                    result = Math.min(result, costMemo[start][end] + remainCost);
                }

                memo[start][pieces] = result;
            }
        }

        return memo[0][k];
    }
}