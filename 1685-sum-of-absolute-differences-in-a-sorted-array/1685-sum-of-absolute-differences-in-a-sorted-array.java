class Solution {
    //lokeshpallapu
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] prefix = new int[n];

        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        int totalSum = prefix[n - 1];

        for (int i = 0; i < n; i++) {
            int leftSum = i > 0 ? nums[i] * i - prefix[i - 1] : 0;
            int rightSum = (totalSum - prefix[i]) - nums[i] * (n - i - 1);
            result[i] = leftSum + rightSum;
        }

        return result;
    }
}