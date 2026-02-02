class Solution {
    // lokeshpallapu
    public void moveZeroes(int[] nums) {
        int index = 0;

        // Move non-zero elements forward
        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }

        // Fill remaining positions with zero
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }
}