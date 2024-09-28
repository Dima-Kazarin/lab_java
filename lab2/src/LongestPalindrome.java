public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return "";

        int start = 0, maxLength = 1;

        for (int i = 0; i < s.length(); i++) {
            int low = i, high = i;
            while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
                if (high - low + 1 > maxLength) {
                    start = low;
                    maxLength = high - low + 1;
                }
                low--;
                high++;
            }

            low = i;
            high = i + 1;
            while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
                if (high - low + 1 > maxLength) {
                    start = low;
                    maxLength = high - low + 1;
                }
                low--;
                high++;
            }
        }

        return s.substring(start, start + maxLength);
    }

    public static void main(String[] args) {
        String input = "12322";
        System.out.println("Longest Palindromic Substring: " + longestPalindrome(input));
    }
}
