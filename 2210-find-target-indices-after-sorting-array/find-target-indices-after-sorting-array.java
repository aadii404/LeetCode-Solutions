class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List <Integer> list = new ArrayList<>();

        int small = 0;
        int equal = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                equal++;
            }else if(nums[i] < target){
                small++;
            }
        }

        for(int i = 0; i < equal; i++){
            list.add(small + i);
        }
        return list;
    }
}