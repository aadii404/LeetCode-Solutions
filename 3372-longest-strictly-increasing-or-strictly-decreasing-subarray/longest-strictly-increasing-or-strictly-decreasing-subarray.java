class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int longInc = 1;
        int longDec = 1;

        int i = 0, j = 1;
        while(j < n){
            if(nums[j - 1] < nums[j]){
                longInc = Math.max(longInc, j - i + 1);
                j++;
            }else{
                i = j;
                j = i + 1;
            }
        }

        i = 0;
        j = 1;
        while(j < n){
            if(nums[j - 1] > nums[j]){
                longDec = Math.max(longDec, j - i + 1);
                j++;
            }else{
                i = j;
                j = i + 1;
            }
        }

        return Math.max(longInc, longDec);
    }
}