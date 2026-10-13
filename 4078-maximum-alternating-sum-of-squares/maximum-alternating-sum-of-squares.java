class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;

        // store the square of element 
        for(int i = 0; i < n; i++){
            nums[i] = nums[i] * nums[i];
        }

        Arrays.sort(nums);
        long odd = 0; // store the sum of small value element
        long even = 0; // store the sum of large value element

        for(int i = 0; i < n; i++){
            if(i < n/2){
                odd += (long) nums[i];
            }else{
                even += (long) nums[i];
            }
        }

        return even - odd;
    }
}