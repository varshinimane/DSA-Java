class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int freq = 0;
        int count = 0;
        for(int i = 0;i < nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for(int val : map.values()){
            if(val == freq){
                count++;
            } else if(val > freq){
                freq = val;
                count = 1;
            }
        }
        return freq * count;
    }
}