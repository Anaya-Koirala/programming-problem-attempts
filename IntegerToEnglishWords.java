// https://leetcode.com/problems/integer-to-english-words/description/
public class IntegerToEnglishWords {

    private String getSmallString(int num) {
        return switch (num) {
            case 1 -> "One";
            case 2 -> "Two";
            case 3 -> "Three";
            case 4 -> "Four";
            case 5 -> "Five";
            case 6 -> "Six";
            case 7 -> "Seven";
            case 8 -> "Eight";
            case 9 -> "Nine";
            case 10 -> "Ten";
            case 11 -> "Eleven";
            case 12 -> "Twelve";
            case 13 -> "Thirteen";
            case 14 -> "Fourteen";
            case 15 -> "Fifteen";
            case 16 -> "Sixteen";
            case 17 -> "Seventeen";
            case 18 -> "Eighteen";
            case 19 -> "Nineteen";
            default -> "";
        };
    }

    private String getTensString(int digit) { 
        return switch (digit) {
            case 2 -> "Twenty";
            case 3 -> "Thirty";
            case 4 -> "Forty";
            case 5 -> "Fifty";
            case 6 -> "Sixty";
            case 7 -> "Seventy";
            case 8 -> "Eighty";
            case 9 -> "Ninety";
            default -> "";
        };
    }

    private String getOrderString(int order) {
        return switch (order) {
            case 2 -> "Hundred";
            case 3 -> "Thousand";
            case 6 -> "Million";
            case 9 -> "Billion";
            default -> "";
        };
    }

    private int getOrder(int num) {
        if (num >= 1_000_000_000)
            return 9;
        if (num >= 1_000_000)
            return 6;
        if (num >= 1_000)
            return 3;
        return 2;
    }

    private String join(String... parts) {
        StringBuilder sb = new StringBuilder(64);
        for (String p : parts) {
            if (!p.isEmpty()) {
                if (sb.length() > 0)
                    sb.append(' ');
                sb.append(p);
            }
        }
        return sb.toString();
    }

    private String toWords(int num) {
        if (num < 20)
            return getSmallString(num);
        if (num < 100)
            return join(getTensString(num / 10), toWords(num % 10));

        int order = getOrder(num);
        int divisor = (int) Math.pow(10, order);
        return join(toWords(num / divisor), getOrderString(order), toWords(num % divisor));
    }

    public String numberToWords(int num) {
        return num == 0 ? "Zero" : toWords(num);
    }
}
