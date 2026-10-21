class Solution {
    public int minOperations(String s) {
        int n = s.length();

        boolean is_sorted = true;
        char max = s.charAt(0);
        char min = s.charAt(0);

        for(int i = 1; i < n; i++){
            char ch = s.charAt(i);
            if(s.charAt(i - 1) > s.charAt(i)) is_sorted = false;
            max = (char) Math.max(max, ch);
            min = (char) Math.min(min, ch);
        }

        if(is_sorted){
            return 0;
        }
        if(n == 2) return -1;
        if(s.charAt(0) == min || s.charAt(n - 1) == max){
            return 1;
        }
        
        for(int i = 1; i < n - 1; i++){
            if(s.charAt(i) == min || s.charAt(i) == max){
                return 2;
            }
        }
        return 3;
    }
}