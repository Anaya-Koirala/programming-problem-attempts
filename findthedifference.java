// https://leetcode.com/problems/find-the-difference/
import java.util.Arrays;

class findthedifference {
    public char findTheDifference(String s, String t) {
        if (!s.equals(t)) {
            char[] sArr = s.toCharArray();
            char[] tArr = t.toCharArray();
            Arrays.sort(sArr);
            Arrays.sort(tArr);
            for (int i=0; i < tArr.length; i+=1) {
                if (i >= sArr.length || sArr[i] != tArr[i])
                    return tArr[i];
            }
        }
        return ' ';
    }
}
