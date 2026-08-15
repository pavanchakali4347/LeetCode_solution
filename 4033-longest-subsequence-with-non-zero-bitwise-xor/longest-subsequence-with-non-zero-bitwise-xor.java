class Solution {
    public int longestSubsequence(int[] A) {
        int tot = 0, n = A.length;
        boolean nonZero = false;
        for (int x : A) {
            nonZero = nonZero | x > 0;
            tot ^= x;
        }
        if (!nonZero) {
            return 0;
        }
        if (tot == 0) {
            return n - 1;
        } else {
            return n;
        }
    }
}