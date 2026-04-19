class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if(s.length() == 0 || words.length == 0 || s == null){
            return ans;
        }
        int wordLen = words[0].length();
        int wordCount = words.length;
        Map<String, Integer> need = new HashMap<>();
        for(String w : words){
            need.put(w, need.getOrDefault(w, 0) + 1);
        }
        for(int offset = 0;offset < wordLen;offset++){
            int left = offset;
            int count = 0;
            Map<String, Integer> seen = new HashMap<>();
            for(int right = offset; right + wordLen <= s.length(); right += wordLen){
                String word = s.substring(right, right + wordLen);
                if(need.containsKey(word)){
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    count++;

                    while(seen.get(word) > need.get(word)){
                        String leftWord = s.substring(left, left + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }
                    if(count == wordCount){
                        ans.add(left);

                        String leftWord = s.substring(left, left + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }
                } else {
                    seen.clear();
                    count = 0;
                    left = right + wordLen;
                }
            }
        }
        return ans;
    }
}