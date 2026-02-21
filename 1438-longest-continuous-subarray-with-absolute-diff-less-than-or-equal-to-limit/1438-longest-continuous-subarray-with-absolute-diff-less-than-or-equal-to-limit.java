class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxD = new ArrayDeque<>();
        Deque<Integer> minD = new ArrayDeque<>();

        int l = 0, ans = 0;

        for (int r = 0; r < nums.length; r++) {
            while (!maxD.isEmpty() && nums[r] > maxD.peekLast()){
                maxD.pollLast();
            }
            maxD.addLast(nums[r]);

            while (!minD.isEmpty() && nums[r] < minD.peekLast()){
                minD.pollLast();
            }
            minD.addLast(nums[r]);
            while (maxD.peekFirst() - minD.peekFirst() > limit) {
                if (nums[l] == maxD.peekFirst()) maxD.pollFirst();
                if (nums[l] == minD.peekFirst()) minD.pollFirst();
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}