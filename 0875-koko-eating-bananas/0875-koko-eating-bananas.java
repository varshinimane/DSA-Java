class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for(int pile : piles){
            high = Math.max(pile, high);
        }
        while(low <= high){
            int mid = (low + high) / 2;
            long hours = 0;

            for(int pile : piles){
                hours += (pile + mid - 1) / mid;
            }
            if(hours <= h){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}