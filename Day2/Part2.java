import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Part2 {
    public static void main(String[] args) {
        ArrayList<String> lines = new ArrayList<>();
        int horizontal = 0;
        int depth = 0;
        int aim = 0;

        try (BufferedReader reader = Files.newBufferedReader(Path.of("input.txt"))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            for (String s : lines) {
                String[] components = s.split(" ");
                String command = components[0];
                int magnitude = Integer.parseInt(components[1]);

                switch (command) {
                    case "forward" -> {
                        horizontal += magnitude;
                        depth += aim * magnitude;
                    }
                    case "up" -> {
                        aim -= magnitude;
                    }
                    case "down" -> {
                        aim += magnitude;
                    }
                }
            }
            System.out.println(horizontal);
            System.out.println(depth);

            System.out.println(horizontal * depth);
        } catch (IOException e) {
            System.out.println("Error reading file");
        }

    }
}