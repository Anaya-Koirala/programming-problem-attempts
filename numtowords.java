public class numtowords {

    private String getDigitString(int digit, int order) {
        String digitStr = switch (digit) {
            case 0 -> "Zero";
            case 1 -> "One";
            case 2 -> "Two";
            case 3 -> "Three";
            case 4 -> "Four";
            case 5 -> "Five";
            case 6 -> "Six";
            case 7 -> "Seven";
            case 8 -> "Eight";
            case 9 -> "Nine";
            default -> "son 😭";
        };
        if (order == 2) {
            digitStr = switch (digitStr) {
                case "Two" -> "Twenty";
                case "Three" -> "Thirty";
                case "Five" -> "Fifty";
                default -> digitStr + "ty";
            };
        }
        return digitStr;
    }

    private String getOrderString(int order) {
        return switch (order) {
            case 2 -> "Hundred";
            case 3 -> "Thousand";
            case 6 -> "Million";
            case 10 -> "Billion";
            default -> "";
        };
    }

    private int getOrder(int num) {
        int order = 0;
        while (num != 0) {
            num /= 10;
            order += 1;
        }
        return order;
    }

    public StringBuilder applyOrder(StringBuilder digits) {
        String[] s = digits.toString().trim().split(" ");

        StringBuilder sb = new StringBuilder(s.length + 3);
        for (int i = 0; i < s.length; i += 1) {
            sb.append(s[i]);
            sb.append(" ");
            String order = getOrderString(s.length - i - 1);
            if (order != "") {
                sb.append(order);
                sb.append(" ");
            }
        }
        return sb;
    }

    public String numberToWords(int num) {
        int order = getOrder(num);
        StringBuilder sb = new StringBuilder(order);
        System.out.println(order);

        while (order >= 1) {
            int divisor = (int) Math.pow(10, order - 1);
            int digit = num / divisor;
            String digitStr = getDigitString(digit,order);
            sb.append(digitStr);
            sb.append(" ");
            num = num % divisor;
            order -= 1;
        }
        System.out.println(applyOrder(sb).toString());
        return " ";
    }
}
