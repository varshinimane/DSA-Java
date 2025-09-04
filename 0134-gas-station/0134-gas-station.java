class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalgas = 0, totalcost = 0;
        for(int i = 0;i < gas.length;i++){
            totalgas += gas[i];
            totalcost += cost[i];
        }

        if(totalgas < totalcost){
            return -1;
        }

        int current = 0;
        int start = 0;

        for(int i = 0;i < gas.length;i++){
            current += gas[i] - cost[i];
            if(current < 0){
                current = 0;
                start = i + 1;
            }
        }
        return start;
    }
}