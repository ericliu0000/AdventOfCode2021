import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

public class Part1 {
    public static void main(String[] args) {
        HashMap<String, Integer> points = new HashMap<>();

        try {
            ArrayList<String> lines = (ArrayList<String>) Files.readAllLines(Path.of("input.txt"));

            for (String line : lines) {
                String[] parts = line.split(" -> ");
                ArrayList<String> temp = new ArrayList<>();
                temp.addAll(generatePoints(parts[0], parts[1]));
                for (String point: temp) {
                    if (points.containsKey(point)) {
                        points.put(point, points.get(point) + 1);
                    } else {
                        points.put(point, 1);
                    }
                }
            }

            System.out.println(points.entrySet().stream().filter(e -> e.getValue() > 1).count());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> generatePoints(String first, String second) {
        ArrayList<String> points = new ArrayList<>();
        int x = Integer.parseInt(first.split(",")[0]);
        int y = Integer.parseInt(first.split(",")[1]);
        int x2 = Integer.parseInt(second.split(",")[0]);
        int y2 = Integer.parseInt(second.split(",")[1]);

        if (x == x2) {
            for (int i = Math.min(y, y2); i <= Math.max(y, y2); i++) {
                points.add(x + "," + i);
            }
        } else if (y == y2) {
            for (int i = Math.min(x, x2); i <= Math.max(x, x2); i++) {
                points.add(i + "," + y);
            }
        } 
        return points;
    }
}
