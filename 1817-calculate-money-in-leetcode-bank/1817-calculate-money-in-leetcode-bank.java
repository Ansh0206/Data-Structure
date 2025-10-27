class Solution {
    public int totalMoney(int n) {
        int total=0;
        int day=1;
        int money=1;
        int i=1;
        while(day<=n){
            total+=money;
            money++;
            day++;
            if(day%7==1){
                i++;
                money=i;
            }
        }
        return total;
        
    }
}