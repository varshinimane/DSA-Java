class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> num = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!num.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}