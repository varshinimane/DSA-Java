class Solution {
    public int binaryGap(int n) {
        int max_dist = 0;
        int curr_pos = 0;
        int last_pos = -1;
        while(n > 0) {
            if(n % 2 == 1){
                if(last_pos != -1) {
                    int dist = curr_pos - last_pos;
                    max_dist = Math.max(max_dist, dist);
                }
                last_pos = curr_pos;
            }
            n = n / 2;
            curr_pos += 1;
        }
        return max_dist;
    }
}