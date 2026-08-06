/* https://open.kattis.com/problems/aboveaverage */
import java.util.Arrays;
import java.util.Scanner;

/*
I feel like a FP wizard with this code.
For reference, I spent 1 week tryna learn haskell for a stupid pandoc project
that I realized I had no use for that later on
... and I still don't like haskell
*/

public class aboveaverage {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int dataset = input.nextInt();
        while (dataset != 0) {
            input.nextInt(); // Don't need the class size

            double[] grades = Arrays.stream(input.nextLine().trim().split(" "))
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            double average = Arrays.stream(grades)
                    .average()
                    .getAsDouble();

            long aboveAverage = Arrays.stream(grades)
                   .filter(grade -> grade > average)
                   .count();

            double aboveAveragePercentage = (double)aboveAverage / grades.length * 100;
            System.out.printf("%.3f%%\n",aboveAveragePercentage);

            dataset -= 1;
        }
        input.close();
    }
}
