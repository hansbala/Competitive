class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int breakpoint = -1;
        for (int i = n - 1; i > 0; i--) {
            int j = i - 1;
            if (nums[j] < nums[i]) {
                breakpoint = j;
                break;
            }
        }
        // already in descending order
        if (breakpoint == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // find smallest in [breakpoint + 1, n - 1]
        int smallestAfterBreakpoint = -1;
        for (int i = n - 1; i >= breakpoint + 1; i--) {
            if (nums[i] > nums[breakpoint]) {
                smallestAfterBreakpoint = i;
                break;
            }
        }
        swap(nums, breakpoint, smallestAfterBreakpoint);
        reverse(nums, breakpoint + 1, n - 1);
    }
    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}
