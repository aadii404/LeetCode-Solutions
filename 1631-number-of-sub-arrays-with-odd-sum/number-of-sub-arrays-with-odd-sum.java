class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1_000_000_007;
        int n = arr.length;
        int count = 0;        
        int[] pre = new int[n];
        pre[0] = arr[0];

        for(int i = 1; i < n; i++){
            pre[i] = pre[i - 1] + arr[i];
        }

        int odd = 0;
        int even = 1;

        for(int i = 0; i < n; i++){
            if(pre[i] % 2 == 0){
                count = (count + odd) % MOD;
                even++;
            }else{
                count = (count + even) % MOD;
                odd++;
            }
        }

        return count;
    }
}