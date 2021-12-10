import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

public class Part1 {
    public static void main(String[] args) {
        try {
            String[] elements = Files.readString(Path.of("input.txt")).split(",");
            
            ArrayList<Integer> positions = new ArrayList<>();
            double sum = 0;
            int out = 0;
            int mean;

            Arrays.asList(elements).stream().forEach((e) -> positions.add(Integer.parseInt(e)));

            for (Integer position : positions) {
                sum += position;
            }

            mean = (int) Math.round(sum / positions.size());

            // i'm sorry, it just worke
            for (int i = mean - 1000; i < mean + 10; i++) {
                out = 0;
                for (Integer position : positions) {
                    out += Math.abs(position - i);
                }    
                System.out.println(out + "    " + i);
            }
            System.out.println(mean);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}