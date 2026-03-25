class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0, totalgas = 0, totalcost = 0, tank = 0;
        for(int i = 0; i < gas.length; i++){
            totalgas += gas[i];
            totalcost += cost[i];
            tank += gas[i] - cost[i];
            if(tank < 0){
                start = i + 1;
                tank = 0;
            }
        }
        if(totalgas < totalcost){
            return -1;
        }
        return start;
    }
}