 class Solution {

    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[] memo = new int[n];

        int ans = 1;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dfs(arr, d, i, memo));
        }

        return ans;
    }

    private int dfs(int[] arr, int d, int i, int[] memo) {

        if (memo[i] != 0)
            return memo[i];

        int max = 1;

        // Move Right
        for (int j = i + 1; j <= Math.min(i + d, arr.length - 1); j++) {

            if (arr[j] >= arr[i])
                break;

            max = Math.max(max, 1 + dfs(arr, d, j, memo));
        }

        // Move Left
        for (int j = i - 1; j >= Math.max(i - d, 0); j--) {

            if (arr[j] >= arr[i])
                break;

            max = Math.max(max, 1 + dfs(arr, d, j, memo));
        }

        memo[i] = max;
        return max;
    }
}
