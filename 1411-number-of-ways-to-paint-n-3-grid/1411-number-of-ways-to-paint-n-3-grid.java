class Solution {
    public int numOfWays(int n) {
        long x = 6, y = 6;
        long mod = 1000000007;
        for (int i = 1; i < n; i++) {
            long nx = (x * 3 + y * 2) % mod;
            long ny = (x * 2 + y * 2) % mod;
            x = nx;
            y = ny;
        }

        return (int) ((x + y) % mod);
    }
}