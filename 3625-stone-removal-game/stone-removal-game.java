class Solution {
    public boolean canAliceWin(int n) {
        if(n < 10) return false;
        int remove = 10;
        int turn = 1;

        while(n >= remove){
            turn++;
            n -= remove;
            remove--;
        }

        return turn % 2 == 0 ? true : false;
    }
}