class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++){
            if (nums[i] <= 0 || nums[i] > n+1) nums[i] = n+1;
        }
        for (int i = 0; i < n; i++){
            int num = Math.abs(nums[i]);
            if (num == n + 1) continue;
            int seat = num - 1;
            if (nums[seat] < 0) continue;
            nums[seat] = -nums[seat];
        }
        for (int i = 0; i < n; i++){
            if (nums[i] > 0) return i + 1;
        }
        return n + 1;
    }
}