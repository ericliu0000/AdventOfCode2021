import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Part2 {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(new File("input.txt"))) {
            int days = 256;
            ArrayList<Integer> initial = new ArrayList<>();
    
            Arrays.asList(input.nextLine().split(","))
                    .stream()
                    .mapToInt(Integer::parseInt)
                    .forEach(initial::add);

                
            long[] newBugs = new long[days];
            for (Integer bug : initial) {
                for (int i = bug; i < days; i += 7) {
                    newBugs[i]++;
                }
            }

            for (int i = 0; i < days; i++) {
                if (newBugs[i] >= 1) {
                    for (int j = i + 9; j < days; j += 7) {
                        newBugs[j] += newBugs[i];
                    }
                }
            }

            long sum = 0;
            for (long bug : newBugs) {
                sum += bug;
            }

            System.out.println(sum + initial.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}