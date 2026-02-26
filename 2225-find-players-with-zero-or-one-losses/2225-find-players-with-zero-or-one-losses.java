class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int[] match:matches){
            int winner=match[0];
            int loser=match[1];
            map.putIfAbsent(winner,0);
            map.putIfAbsent(loser,0);
            map.put(loser,map.get(loser)+1);
        }
        List<Integer> noloss=new ArrayList<>();
        List<Integer> oneloss=new ArrayList<>();
        for(int player:map.keySet()){
            int losses=map.get(player);
            if(losses==0){
                noloss.add(player);
            }else if(losses==1){
                oneloss.add(player);
            }
        }
        Collections.sort(noloss);
        Collections.sort(oneloss);
        List<List<Integer>> res=new ArrayList<>();
        res.add(noloss);
        res.add(oneloss);
        return res;
    }
}