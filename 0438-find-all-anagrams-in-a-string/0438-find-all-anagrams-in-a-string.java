class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(p.length() > s.length()) return res;
        int[] pcount = new int[26];
        int[] window = new int[26];
        for(char c : p.toCharArray()){
            pcount[c - 'a']++;
        }
        int left = 0;
        for(int i = 0;i < s.length();i++){
            window[s.charAt(i) - 'a']++;
            if(i - left + 1 > p.length()){
                window[s.charAt(left) - 'a']--;
                left++;
            }
            if(Arrays.equals(window,pcount)){
                res.add(left);
            }
        }
        return res;
    }
}