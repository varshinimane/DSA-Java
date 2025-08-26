class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxlen = 0;
        int left = 0;
        Set<Character> set = new HashSet<>();
        for(int i = 0;i < n;i++){
            while(set.contains(s.charAt(i))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(i));
            maxlen = Math.max(maxlen,i - left + 1);
        }
        return maxlen;
    }
}