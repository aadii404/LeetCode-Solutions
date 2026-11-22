class Solution {
    public boolean checkString(String s) {
        int n = s.length();
        boolean seen = false;

        for(int i = 0; i < n; i++){
            if(s.charAt(i) == 'b') seen = true;
            if(seen && s.charAt(i) == 'a'){
                return false;
            }
        }

        return true;
    }
}