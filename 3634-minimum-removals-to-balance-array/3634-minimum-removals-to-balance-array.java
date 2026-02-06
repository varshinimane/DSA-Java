class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length; 
        int max_size = 1;
        Arrays.sort(nums);
        int right = 0;
        for(int left = 0;left < n;left++){
            while(right < n && nums[right] <= k * (long)nums[left]) right++;

            int size = right - left;
            max_size = Math.max(max_size, size);
        }
        return n - max_size;
    }
}