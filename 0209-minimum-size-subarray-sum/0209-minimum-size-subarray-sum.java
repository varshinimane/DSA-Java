class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int minVal = Integer.MAX_VALUE;
        for(int right = 0;right < nums.length;right++){
            sum += nums[right];
            while(sum >= target){
                minVal = Math.min(minVal, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return minVal == Integer.MAX_VALUE ? 0 : minVal;
    }
}