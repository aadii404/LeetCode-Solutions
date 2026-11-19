class Solution {
    public int minimizeSum(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);
        int case1 = Math.abs(nums[n - 1] - nums[2]);
        int case2 = Math.abs(nums[0] - nums[n - 3]);
        int case3 = Math.abs(nums[n - 2] - nums[1]);

        return Math.min(case1, Math.min(case2, case3));
    }
}