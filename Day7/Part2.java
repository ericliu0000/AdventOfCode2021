import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

public class Part2 {
    public static void main(String[] args) {
        try {
            String[] elements = Files.readString(Path.of("input.txt")).split(",");
            
            ArrayList<Integer> positions = new ArrayList<>();
            int out = 0;

            Arrays.asList(elements).stream().forEach((e) -> positions.add(Integer.parseInt(e)));

            ArrayList<Integer> results = new ArrayList<>();

            // screw it, brute forcing it now
            for (int i = 0; i < 1000; i++) {
                out = 0;
                for (Integer position : positions) {
                    out += move(position, i);
                }    
                System.out.println(out + "    " + i);
                results.add(i);
            }

            // this didn't work, just got it manually
            System.out.println(results.stream().min(Integer::compareTo).get());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int move(int from, int to) {
        int sum = 0;
        int min = Math.min(from, to);
        int max = Math.max(from, to);
        for (int i = min; i <= max; i++) {
            sum += Math.abs(to - i);
        }
        return sum;
    }
}