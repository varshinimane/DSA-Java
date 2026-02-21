class Solution {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int n = candiesCount.length;
        long[] prefix = new long[n];
        prefix[0] = candiesCount[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + candiesCount[i];
        }
        boolean[] answer = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int type = queries[i][0];
            long day = queries[i][1];
            long dailyCap = queries[i][2];
            long minEaten = day + 1;
            long maxEaten = (day + 1) * dailyCap;
            long start = (type == 0) ? 0 : prefix[type - 1];
            long end = prefix[type];
            if (minEaten <= end && maxEaten > start) {
                answer[i] = true;
            } else {
                answer[i] = false;
            }
        }
        return answer;
    }
}