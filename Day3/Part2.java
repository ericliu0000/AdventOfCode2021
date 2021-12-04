import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

public class Part2 {
    public static void main(String[] args) {
        StringBuffer gamma = new StringBuffer();
        StringBuffer epsilon = new StringBuffer();

        try {
            ArrayList<String> lines = (ArrayList<String>) Files.readAllLines(Path.of("input.txt"));
            int length = lines.get(0).length();

            ArrayList<String> oxygenLines = new ArrayList<>();
            
            for (int i = 0; i < length; i++) {
                int ones = 0;
                int zeros = 0;
                for (String line : lines) {
                    if (line.charAt(i) == '1') {
                        ones++;
                    } else {
                        zeros++;
                    }
                }
                 
                if (ones >= zeros) {
                    for (String line : lines) {
                        if (line.charAt(i) == '0') {
                            oxygenLines 
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}