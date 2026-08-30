// The code fails in the last few test cases due to Time Limit.
// Requires a strong "sliding-window" based implementation
// https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length
class MaxVowelsInSubstring {

    private int getVowelCount(CharSequence s) {
        int count = 0;
        for (int i = 0; i < s.length(); i += 1) {
            count += switch (s.charAt(i)) {
                case 'a', 'e', 'i', 'o', 'u' -> 1;
                default -> 0;
            };
        }
        return count;
    }

    public int maxVowels(String s, int k) {
        int maxVowels = 0;
        for (int i = 0; i <= s.length() - k; i += 1) {
            // Choke point: makes copies
            CharSequence subStr = s.subSequence(i, i + k);
            int count = getVowelCount(subStr);
            if (count > maxVowels) {
                maxVowels = count;
            }
        }
        return maxVowels;
    }
}
