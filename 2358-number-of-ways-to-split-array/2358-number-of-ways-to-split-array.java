class Solution {
    public int waysToSplitArray(int[] nums) {
        long total = 0;
        long curr = 0;
        int count = 0;

        for(int i = 0;i < nums.length;i++){
            total += nums[i];
        }

        for(int i = 0;i < nums.length - 1;i++){
            curr += nums[i];
            if(curr >= total - curr){
                count ++;
            }
        }
        return count;
    }
}