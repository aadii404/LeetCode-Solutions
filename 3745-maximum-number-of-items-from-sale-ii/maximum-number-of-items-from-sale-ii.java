class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;

        // count of each factor in items
        int[] freq = new int[n + 1];
        int cheapestPrice = Integer.MAX_VALUE;
        for(int[] item : items){
            int f = item[0];
            int p = item[1];
            freq[f]++;
            cheapestPrice = Math.min(cheapestPrice, p);
        }

        // factorSum[f] = how many items have a factor that is multiple of f(including f itself)
        int[] factorSum = new int[n + 1];  // f -> f, 2f, 3f....
        for(int i = 1; i <= n; i++){
            for(int j = i; j <= n; j += i){
                factorSum[i] += freq[j];
            }
        }

        // Store items which can give "2 copy" but ensure that its price <2 * cheapestPrice
        // Later we sort on the basic of price cheapest first
        List<int[]> units = new ArrayList<>();
        for(int[] item : items){
            int f = item[0];
            int p = item[1];

            int cnt = factorSum[f] - 1; // exclude the item itself
            if(cnt > 0 && p < 2L *cheapestPrice){
                units.add(new int[]{p, cnt});
            }
        }

        units.sort((a,b) -> Integer.compare(a[0], b[0]));

        int result = 0;

        for(int[] unit : units){
            int price = unit[0];
            int factorCount = unit[1];

            int k = Math.min(factorCount, budget / price);
            budget -= k * price;
            result += 2 * k; // each item creates 2 copy for us
        }

        result += budget /cheapestPrice;
        return result;
    }
}