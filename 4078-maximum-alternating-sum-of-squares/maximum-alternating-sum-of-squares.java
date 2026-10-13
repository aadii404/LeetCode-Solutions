class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] < 0){
                nums[i] = Math.abs(nums[i]);
            }
        }
        Arrays.sort(nums);
        long odd = 0;
        long even = 0;

        for(int i = 0; i < n; i++){
            if(i < n/2){
                odd += (long) nums[i] * nums[i];
            }else{
                even += (long) nums[i] * nums[i];
            }
        }

        return even - odd;
    }
}