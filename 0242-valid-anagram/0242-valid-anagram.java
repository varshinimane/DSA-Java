class Solution {
    int Index(char ch){
        return ch - 'a';
    }
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] arr = new int[26];
        for(int i = 0;i < s.length();i++){
            arr[Index(s.charAt(i))]++;
            arr[Index(t.charAt(i))]--;
        }
        for(int i = 0;i < arr.length;i++){
            if(arr[i] != 0){
                return false;
            }
        }
        return true;
    }
}