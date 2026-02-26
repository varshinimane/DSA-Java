class Solution {
    public int countPairs(int[] deliciousness) {
        final int MOD = 1_000_000_007;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int val : deliciousness){
            int power = 1;
            for(int i = 0;i <= 21;i++){
                int target = power - val;
                if(map.containsKey(target)){
                    count += map.get(target);
                    count %= MOD;
                }
                power <<= 1;

            }
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        return (int)count;
    }
}