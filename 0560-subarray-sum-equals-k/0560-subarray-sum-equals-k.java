class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        for(int i = 1;i < n;i++){
            nums[i] = nums[i] + nums[i - 1];
        }
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 0;i < n;i++){
            if(nums[i] == k){
                count ++;
            }
            if(map.containsKey(nums[i] - k)){
                count += map.get(nums[i] - k);
            }
            map.put(nums[i],map.getOrDefault(nums[i], 0) + 1);
        }
        return count;
    }
}