// https://leetcode.com/problems/different-ways-to-add-parentheses/description/
import java.util.ArrayList;
import java.util.List;

class Parentheses {
    private int performOpr(String n1String, String n2String, char opr) {
        int n1 = Integer.valueOf(n1String);
        int n2 = Integer.valueOf(n2String);
        return switch (opr) {
            case '+' -> n1 + n2;
            case '*' -> n1 * n2;
            case '-' -> n1 - n2;
            default -> 0;
        };
    }

    private List<Integer> diffWaysToCompute(List<Integer> lst, String expression) {
        String[] nums = expression.split("[+*-]");
        // Base Case
        if (nums.length == 1) {
            lst.add(Integer.valueOf(expression));
            return lst;
        }
        // Recursively apply each operator
        for (int i = 0; i < expression.length(); i+=1) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                // Solve left and right independently
                String leftExpr = expression.substring(0, i);
                String rightExpr = expression.substring(i + 1);
                List<Integer> leftResults = diffWaysToCompute(new ArrayList<Integer>(), leftExpr);
                List<Integer> rightResults = diffWaysToCompute(new ArrayList<Integer>(), rightExpr);

                // Combine every left result with every right result
                for (int l : leftResults) {
                    for (int r : rightResults) {
                        lst.add(performOpr(String.valueOf(l), String.valueOf(r), c));
                    }
                }
            }
        }
        return lst;
    }

    public List<Integer> diffWaysToCompute(String expression) {
        return diffWaysToCompute(new ArrayList<Integer>(), expression);
    }
}
