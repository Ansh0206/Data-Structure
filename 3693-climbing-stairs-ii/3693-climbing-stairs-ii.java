class Solution {
    public int helper(int n, int i, int[] costs, int[] memo) {
        if (i == n) {
            return 0;
        }

        if (memo[i] != -1) {
            return memo[i];
        }

        int minCost = Integer.MAX_VALUE;
        for (int jump = 1; jump <= 3; jump++) {
            int nextStep = i + jump;
            if (nextStep <= n) {
                int nextCost = helper(n, nextStep, costs, memo);
                if (nextCost != Integer.MAX_VALUE) {
                    int currentJumpCost = costs[nextStep - 1] + (jump * jump) + nextCost;
                    minCost = Math.min(minCost, currentJumpCost);
                }
            }
        }

        return memo[i] = minCost;
    }

    public int climbStairs(int n, int[] costs) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return helper(n, 0, costs, memo);
    }
}