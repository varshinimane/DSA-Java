class Solution {
    public int countGoodSubstrings(String s) {
        int count = 0;
        for(int i = 0;i + 2 < s.length();i++){
            char a = s.charAt(i);
            char b = s.charAt(i + 1);
            char c = s.charAt(i + 2);

            if(a != b && b != c && c != a){
                count++;
            }
        }
        return count;
    }
}