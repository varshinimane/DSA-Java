class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] res = new int[nums.size()];
        for(int i = 0;i < res.length;i++){
            int k = nums.get(i), n = 1, ans = -1;
            while((k & n) != 0){
                ans = k - n;
                n <<= 1;
            }
            res[i] = ans;
        }
        return res;
    }
}