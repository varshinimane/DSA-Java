class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int res = 0;

        for(int n : nums){
            if(n == 0){
                count = 0;
            } else {
                count++;
            }

            if(res < count){
                res = count;
            }
        }
        return res;
    }
}