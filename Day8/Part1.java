import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class Part1 {
    public static void main(String[] args) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("input.txt"))) {
            String line = null;
            int count = 0;

            while ((line = reader.readLine()) != null) {
                ArrayList<String> segments = new ArrayList<String>(Arrays.asList(line.split("\\|")[1].strip().split(" ")));
                ArrayList<String> wires = new ArrayList<String>(Arrays.asList(line.split("\\|")[0].strip().split(" ")));

                for (int i = 0; i < wires.size(); i++) {
                    char[] wire = wires.get(i).toCharArray();
                    Arrays.sort(wire);
                    wires.set(i, String.valueOf(wire));
                }
                
                for (String segment : segments) {
                    char[] temp = segment.toCharArray();
                    Arrays.sort(temp);
                    String sorted = String.valueOf(temp);
                    int len = sorted.length();

                    boolean validLength = (len == 2 || len == 3 || len == 4 || len == 7);

                    if (validLength && wires.contains(sorted)) {
                        System.out.println(wires);
                        System.out.println(sorted);
                        count++;
                    }
                }
            }

            System.out.println(count);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}