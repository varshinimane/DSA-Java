import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        String[] phone = {
            "",     "",     "abc",  "def",
            "ghi",  "jkl",  "mno",  "pqrs",
            "tuv",  "wxyz"
        };
        backtrack(digits, phone, 0, new StringBuilder(), result);
        return result;
    }
    private void backtrack(String digits, String[] phone, int index, 
                           StringBuilder current, List<String> result) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        String letters = phone[digits.charAt(index) - '0'];
        for (char ch : letters.toCharArray()) {
            current.append(ch);
            backtrack(digits, phone, index + 1, current, result);
            current.deleteCharAt(current.length() - 1); 
        }
    }
}