class Solution {
    public int calculate(String s) {
        int num = 0;
        int res = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i < s.length();i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                num = num * 10 + (ch - '0');
            } else if(ch == '+'){
                res += sign * num;
                num = 0;
                sign = 1;
            } else if(ch == '-'){
                res += sign * num;
                num = 0;
                sign = -1;
            } else if(ch == '('){
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if(ch == ')'){
                res += sign * num;
                num = 0;
                res *= stack.pop();
                res += stack.pop();
            }
        }
        res += sign * num;
        return res;
    }
}