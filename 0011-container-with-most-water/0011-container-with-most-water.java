class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int maxlen = 0;
        int right = height.length - 1;
        while(left <= right){
            int width = right - left;
            int min = Math.min(height[left],height[right]);
            int area = width * min;

            maxlen = Math.max(maxlen, area);

            if(height[left] < height[right]){
                left++;
            } else {
                right--;
            }
        }
        return maxlen;
    }
}