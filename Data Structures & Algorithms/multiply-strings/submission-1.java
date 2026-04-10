class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";

        int m = num1.length(), n = num2.length();
        int ans[] = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            int carry = 0, idx = n;
            int curr[] = new int[n + 1];

            for (int j = n - 1; j >= 0; j--) {
                int a1 = num1.charAt(i) - '0';
                int a2 = num2.charAt(j) - '0';

                int prod = a1 * a2 + carry;
                curr[idx--] = prod % 10;
                carry = prod / 10;
            }

            if (carry > 0)
                curr[idx] = carry;

            // System.out.println(Arrays.toString(curr));

            carry = 0;

            idx = (m + n - 1) - (m - 1 - i);
            int k = n;

            // System.out.println(idx);

            while (k >= 0) {
                int sum = ans[idx] + curr[k] + carry;
                ans[idx] = sum % 10;
                carry = sum / 10;

                idx--;
                k--;
            }

            // System.out.println(Arrays.toString(ans));
        }

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < m + n; i++) {
            if (ans[i] == 0) {
                continue;
            } else {
                while (i < m + n)
                    sb.append(ans[i++]);
            }
        }

        return sb.toString();
    }
}
