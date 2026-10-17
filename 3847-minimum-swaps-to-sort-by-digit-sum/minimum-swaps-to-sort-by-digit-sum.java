class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;

        Integer[] afterSorted = new Integer[n];
        for (int i = 0; i < n; i++) {
            afterSorted[i] = nums[i];
        }

        Arrays.sort(afterSorted, this::compareByDigitSum);

        Map<Integer, Integer> valToIdx = new HashMap<>();
        for (int i = 0; i < n; i++) {
            valToIdx.put(nums[i], i);
        }

        int swapCount = 0;
        for (int i = 0; i < n; i++) {
            int expectedVal = afterSorted[i];
            int currVal = nums[i];

            if (expectedVal == currVal) continue;

            int idx = valToIdx.get(expectedVal);

            nums[i] = expectedVal;
            nums[idx] = currVal;

            valToIdx.put(expectedVal, i);
            valToIdx.put(currVal, idx);

            swapCount++;
        }

        return swapCount;
    }

    int digitSum(int num){
        int sum = 0;
        while(num != 0){
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }

    int compareByDigitSum(int num1, int num2) {
        int num1DigitSum = digitSum(num1);
        int num2DigitSum = digitSum(num2);

        if (num1DigitSum != num2DigitSum) {
            return Integer.compare(num1DigitSum, num2DigitSum);
        }

        return Integer.compare(num1, num2);
    }
}