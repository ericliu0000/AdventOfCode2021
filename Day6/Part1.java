import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(new File("input.txt"))) {
            ArrayList<Integer> initial = new ArrayList<>();
            Arrays.asList(input.nextLine().split(","))
                    .stream()
                    .mapToInt(Integer::parseInt)
                    .forEach(initial::add);

            for (int i = 0; i < 256; i++) {
                ArrayList<Integer> next = new ArrayList<>();
                for (Integer bug : initial) {
                    if (bug == 0) {
                        next.add(6);
                        next.add(8);
                    } else {
                        next.add(bug - 1);
                    }
                }
                initial = new ArrayList<>(next);
            }

            System.out.println(initial.size());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}