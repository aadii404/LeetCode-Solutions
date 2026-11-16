class Solution {
    public String digitSum(String s, int k) {
        StringBuilder sb = new StringBuilder();

        while(s.length() > k){
            int len = 0;
            int sum = 0;
            for(int i = 0; i < s.length(); i++){
                sum += s.charAt(i) - '0';
                len++;

                if(len == k){
                    sb.append(sum);
                    sum = 0;
                    len = 0;
                }
            }
            if(len > 0){
                sb.append(sum);
            }

            s = sb.toString();
            sb = new StringBuilder();
        }

        return s;
    }
}