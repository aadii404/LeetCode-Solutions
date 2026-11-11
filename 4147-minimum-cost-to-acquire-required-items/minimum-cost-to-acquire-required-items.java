class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long ans = 0;

        if((long) cost1 + cost2 <= costBoth){
            return (long) cost1 * need1 + (long) cost2 * need2;
        }

        int both = Math.min(need1, need2);
        long total = (long) both * costBoth;

        need1 -= both;
        need2 -= both;

        if(need1 > 0){
            total += (long) need1 * Math.min(cost1, costBoth);
        }else if(need2 > 0){
            total += (long) need2 * Math.min(cost2, costBoth);
        }

        return total;
    }
}