import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Part1 {
    public static void main(String[] args) {
        ArrayList<Integer> lines = new ArrayList<Integer>();
        int count = 0;

        try (BufferedReader reader = Files.newBufferedReader(Path.of("input.txt"))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                lines.add(Integer.parseInt(line));
            }

            for (int i = 0; i < lines.size() - 1; i++) {
                if (lines.get(i + 1) > lines.get(i)) {
                    count++;
                }
            }
            System.out.println(count);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}