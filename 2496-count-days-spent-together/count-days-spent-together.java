class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int aliceArriveDay = findDay(arriveAlice);
        int aliceLeaveDay = findDay(leaveAlice);
        int bobArriveDay = findDay(arriveBob);
        int bobLeaveDay = findDay(leaveBob);

        int start = Math.max(aliceArriveDay, bobArriveDay);
        int end = Math.min(aliceLeaveDay, bobLeaveDay);

        if (start > end) {
            return 0;
        }

        return end - start + 1;        
    }

    int findDay(String s){
        int month = (s.charAt(0) - '0') * 10 + (s.charAt(1) - '0');
        int totalDay = (s.charAt(3) - '0') * 10 + (s.charAt(4) - '0');

        for(int i = 1; i < month; i++){
            if(i == 2){
                totalDay += 28;
            }else if(i == 1 || i == 3 || i == 5 || i == 7 || i ==8 || i == 10 || i == 12){
                totalDay += 31;
            }else{
                totalDay += 30;
            }
        }

        return totalDay;
    }
}