class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        int n1 = num1.length(), n2 = num2.length();
        int[] prod = new int[n1 + n2];
        for(int i = n1 - 1;i >= 0;i--){
            for(int j = n2 - 1;j >= 0;j--){
                int d1 = num1.charAt(i) - '0';
                int d2 = num2.charAt(j) - '0';
                prod[i + j + 1] += d1 * d2; //this value place matches mul
            }
        }
        int carry = 0;
        for(int i = prod.length - 1;i >= 0;i--){
            int temp = (prod[i] + carry) % 10; //add carry
            carry = (prod[i] + carry) / 10; //keep only the last digit
            prod[i] = temp; //pass the carry to the left
        }
        StringBuilder sb = new StringBuilder();
        for(int n : prod){
            sb.append(n);
        }
        while(sb.length() != 0 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}