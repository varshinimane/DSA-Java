class Fancy {

    List<Long> arr;
    long mul = 1;
    long add = 0;
    int mod = 1000000007;

    public Fancy() {
        arr = new ArrayList<>();
    }
    
    public void append(int val) {
        long stored = (val - add + mod) % mod;
        stored = stored * modInverse(mul) % mod;
        arr.add(stored);
    }
    
    public void addAll(int inc) {
        add = (add + inc) % mod;
    }
    
    public void multAll(int m) {
        mul = (mul * m) % mod;
        add = (add * m) % mod;
    }
    
    public int getIndex(int idx) {
        if (idx >= arr.size()) return -1;
        return (int)((arr.get(idx) * mul + add) % mod);
    }

    private long modInverse(long x) {
        return pow(x, mod - 2);
    }

    private long pow(long x, long n) {
        long res = 1;
        x %= mod;
        while (n > 0) {
            if ((n & 1) == 1) res = res * x % mod;
            x = x * x % mod;
            n >>= 1;
        }
        return res;
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */