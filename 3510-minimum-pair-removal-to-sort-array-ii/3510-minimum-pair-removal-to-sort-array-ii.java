import java.util.*;

class Solution {
    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;

        // Doubly linked list using arrays
        int[] left = new int[n];
        int[] right = new int[n];
        boolean[] alive = new boolean[n];

        for (int i = 0; i < n; i++) {
            left[i] = i - 1;
            right[i] = i + 1;
            alive[i] = true;
        }
        right[n - 1] = -1;

        // Min-heap of (sum, index)
        PriorityQueue<long[]> pq =
            new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));

        for (int i = 0; i < n - 1; i++) {
            pq.offer(new long[]{(long) nums[i] + nums[i + 1], i});
        }

        int ops = 0;

        while (true) {
            // Check if array is already non-decreasing
            boolean sorted = true;
            for (int i = 0; i != -1 && right[i] != -1; i = right[i]) {
                if (nums[i] > nums[right[i]]) {
                    sorted = false;
                    break;
                }
            }
            if (sorted) break;

            // Take minimum adjacent sum
            long[] cur;
            int i;
            while (true) {
                cur = pq.poll();
                i = (int) cur[1];
                if (alive[i] && right[i] != -1 && alive[right[i]]) break;
            }

            int j = right[i];

            // Merge i and j
            nums[i] += nums[j];
            alive[j] = false;
            right[i] = right[j];
            if (right[j] != -1) left[right[j]] = i;

            ops++;

            // Push new adjacent sums
            if (left[i] != -1) {
                pq.offer(new long[]{(long) nums[left[i]] + nums[i], left[i]});
            }
            if (right[i] != -1) {
                pq.offer(new long[]{(long) nums[i] + nums[right[i]], i});
            }
        }

        return ops;
    }
}
