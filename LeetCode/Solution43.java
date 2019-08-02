package leetcode;

public class Solution43 {
    public String multiply(String num1, String num2) {
        if("0".equals(num1) || "0".equals(num2))
            return "0";
        int n1 = num1.length();
        int n2 = num2.length();
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        int[] nums = new int[n1 + n2];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                nums[i + j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length - 1; i++) {
            int tmp = nums[i] / 10;
            nums[i] %= 10;
            nums[i+1] += tmp;
            sb.append(nums[i]);
        }
        if(nums[nums.length - 1] != 0) sb.append(nums[nums.length - 1]);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution43().multiply("123", "456"));
    }
}
