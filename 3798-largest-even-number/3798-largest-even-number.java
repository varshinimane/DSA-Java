class Solution {
    public String largestEven(String s) {
        int k = s.length() - 1;
        while(k >= 0){
            if(s.charAt(k) == '2'){
                return s.substring(0, k + 1);
            }
            k--;
        }
        return "";
    }
}