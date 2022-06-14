import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Part1 {
    public static void main(String[] args) {
        try (BufferedReader input = Files.newBufferedReader(Path.of("input.txt"))) {
            ArrayList<ArrayList<Integer>> inputArray = new ArrayList<>();

            String line;
            int risks = 0;

            ArrayList<Integer> padding = new ArrayList<>();
            for (int i = 0; i < 102; i++) {
                padding.add(90);
            }

            inputArray.add(padding);
            while ((line = input.readLine()) != null) {
                ArrayList<Integer> lineArray = new ArrayList<>();
                // padding
                lineArray.add(90);
                for (int i = 0; i < line.length(); i++) {
                    lineArray.add(Integer.parseInt(String.valueOf(line.charAt(i))));
                }
                lineArray.add(90);
                System.out.println(lineArray);
                System.out.println(lineArray.size());
                inputArray.add(lineArray);
            }
            inputArray.add(padding);

            for (int col = 0; col < 100; col++) {
               for (int row = 0; row < 100; row++) {
                   int value = inputArray.get(col + 1).get(row + 1);
                   System.out.println(inputArray.get(col + 1).size());
                   System.out.println(inputArray.size());


                //    System.out.println(value + " " + inputArray.get(col).get(row + 1) + " " + inputArray.get(col + 2).get(row + 1) + " " + inputArray.get(col + 1).get(row) + " " + inputArray.get(col + 1).get(row + 2));
                   if (value < inputArray.get(col).get(row + 1) &&
                        value < inputArray.get(col + 2).get(row + 1) &&
                        value < inputArray.get(col + 1).get(row) &&
                        value < inputArray.get(col + 1).get(row + 2)) {
                        
                       risks += value + 1;
                   }
               }
           }

           System.out.println(risks);
           System.out.println(inputArray.size());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}