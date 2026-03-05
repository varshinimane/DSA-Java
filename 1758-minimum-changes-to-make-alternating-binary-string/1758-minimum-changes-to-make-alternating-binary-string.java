class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int countStart0 = 0;
        int countStart1 = 0;
        for(int i = 0;i < n;i++){
            if(i % 2 == 0){
                if(s.charAt(i) != '0')
                    countStart0++;
                if(s.charAt(i) != '1')
                    countStart1++;
            } else {
                if(s.charAt(i) != '1')
                    countStart0++;
                if(s.charAt(i) != '0')
                    countStart1++;
            }
        }
        return Math.min(countStart0, countStart1);
    }
}