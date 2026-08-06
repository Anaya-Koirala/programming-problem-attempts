/*
 * https://open.kattis.com/problems/pokerhand
 *
 */
import java.util.Arrays;
import java.util.Scanner;

public class pokerhand {

    // **WARNING** NEVER TRY TO MAKE THIS STRING SHIT YOURSELF, ALWAYS END UP FORGETTING THE TEN AND ADDING AN EXTRA 1
    final static String stringRanks = "A23456789TJQK";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] count = new int[13];
        int idx;
        char c;

        for (int i = 0; i < 5; i++) {
            c = input.next().toUpperCase().charAt(0);
            idx = stringRanks.indexOf(c);
            count[idx]+=1;
        }

        System.out.println(Arrays.stream(count).max().getAsInt());
        input.close();
    }
}
