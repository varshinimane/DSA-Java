class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int start = 0, end = nums.length - 1;
        int max = 0;
        while(start < end){
            int pair = nums[start] + nums[end];
            if(pair > max){
                max = pair;
            } 
            start++;
            end--;
        }
        return max;
    }
}