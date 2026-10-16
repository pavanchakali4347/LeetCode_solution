
class Solution {
    static final long MOD = 1_000_000_007L;

    long[] sum;
    long[] squareSum;
    long[] lazy;
    int n;

    public int sumCounts(int[] nums) {
        n = nums.length;

        sum = new long[4 * n];
        squareSum = new long[4 * n];
        lazy = new long[4 * n];

        int[] last = new int[100001];
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int x = nums[i];
            int prev = last[x];
            update(1, 0, n - 1, prev, i);

            ans = (ans + squareSum[1]) % MOD;

            last[x] = i + 1;
        }

        return (int) ans;
    }

    void update(int node, int left, int right,
                int ql, int qr) {
        if (qr < left || right < ql) {
            return;
        }

        if (ql <= left && right <= qr) {
            apply(node, left, right, 1);
            return;
        }

        pushDown(node, left, right);

        int mid = left + (right - left) / 2;

        update(node * 2, left, mid, ql, qr);
        update(node * 2 + 1, mid + 1, right, ql, qr);

        sum[node] =
            (sum[node * 2] + sum[node * 2 + 1]) % MOD;

        squareSum[node] =
            (squareSum[node * 2] + squareSum[node * 2 + 1])
            % MOD;
    }

    void apply(int node, int left, int right, long delta) {
        long len = right - left + 1L;
        long oldSum = sum[node];

        squareSum[node] = (
            squareSum[node]
            + 2L * delta % MOD * oldSum % MOD
            + delta * delta % MOD * len % MOD
        ) % MOD;

        sum[node] = (oldSum + delta * len) % MOD;
        lazy[node] = (lazy[node] + delta) % MOD;
    }

    void pushDown(int node, int left, int right) {
        if (lazy[node] == 0 || left == right) {
            return;
        }

        int mid = left + (right - left) / 2;
        long delta = lazy[node];

        apply(node * 2, left, mid, delta);
        apply(node * 2 + 1, mid + 1, right, delta);

        lazy[node] = 0;
    }
}
