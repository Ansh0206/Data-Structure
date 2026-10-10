
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2;

        long[] diff = new long[n];
        long maxDiff = 0;
        long totalDiff = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs((long) nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diff[i]);
            totalDiff += diff[i];
        }

        if (k >= totalDiff) {
            return 0;
        }

        long low = 0;
        long high = maxDiff;

        while (low < high) {
            long mid = low + (high - low) / 2;
            long required = 0;

            for (long d : diff) {
                if (d > mid) {
                    required += d - mid;
                }
            }

            if (required <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        long threshold = low;
        long used = 0;
        long answer = 0;

        for (long d : diff) {
            if (d > threshold) {
                used += d - threshold;
                d = threshold;
            }

            answer += d * d;
        }

        long remaining = k - used;
        answer -= remaining * (2 * threshold - 1);

        return answer;
    }
}
