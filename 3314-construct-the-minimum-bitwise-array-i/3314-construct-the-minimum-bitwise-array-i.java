class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for(int i = 0;i < n;i++){
            int val = nums.get(i);

            if((val & (val - 1)) == 0){
                ans[i] = -1;
                continue;
            }
            int bit = 0;
            while((val & (1 << bit)) != 0){
                bit++;
            }
            ans[i] = val - (1 << bit - 1);
        }
        return ans;
    }
}