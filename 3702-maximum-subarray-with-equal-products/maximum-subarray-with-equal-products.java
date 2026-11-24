class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for(int i = 0; i < n; i++){
            long prod = nums[i];
            long lcm = nums[i];
            long gcd = nums[i];

            for(int j = i + 1; j < n; j++){
                prod *= nums[j];
                gcd = findgcd(gcd, nums[j]);
                lcm = findlcm(lcm, nums[j]);

                if(prod == lcm * gcd){
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }

    long findgcd(long n, long m){
        long a = Math.min(n, m);
        long b = Math.max(n, m);

        while(a != 0){
            long rem = b % a;
            b = a;
            a = rem;
        }

        return b;
    }

    long findlcm(long a, long b){
        return (a / findgcd(a, b)) * b;
    }
}