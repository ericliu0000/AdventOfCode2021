import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Part1 {
    public static void main(String[] args) {
        StringBuffer gamma = new StringBuffer();
        StringBuffer epsilon = new StringBuffer();

        try {
            ArrayList<String> lines = (ArrayList<String>) Files.readAllLines(Path.of("input.txt"));

            int length = lines.get(0).length();

            for (int i = 0; i < length; i++) {
                int ones = 0, zeros = 0;
                for (String line : lines) {
                    if (line.charAt(i) == '1') {
                        ones++;
                    } else {
                        zeros++;
                    }
                }
                if (ones > zeros) {
                    gamma.append('1');
                    epsilon.append('0');
                } else {
                    gamma.append('0');
                    epsilon.append('1');
                }
            }
            System.out.println(gamma);
            System.out.println(epsilon);

            int result = Integer.parseInt(gamma.toString(), 2) * Integer.parseInt(epsilon.toString(), 2);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}