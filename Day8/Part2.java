import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Part2 {
    public static void main(String[] args) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("supertest.txt"))) {
            String line = null;
            int count = 0;

            while ((line = reader.readLine()) != null) {
                String A = "", B = "", C = "", D = "", E = "", F = "", G = "";

                ArrayList<String> segments = new ArrayList<String>(Arrays.asList(line.split("\\|")[1].strip().split(" ")));
                ArrayList<String> wires = new ArrayList<String>(Arrays.asList(line.split("\\|")[0].strip().split(" ")));

                String one = wires.stream().filter(e -> e.length() == 2).findFirst().get();
                String four = wires.stream().filter(e -> e.length() == 4).findFirst().get();
                String seven = wires.stream().filter(e -> e.length() == 3).findFirst().get();
                String eight = wires.stream().filter(e -> e.length() == 7).findFirst().get();
                String[] length5 = wires.stream().filter(e -> e.length() == 5).toArray(String[]::new);
                String[] length6 = wires.stream().filter(e -> e.length() == 6).toArray(String[]::new);

                System.out.println(one + " " + four + " " + seven + " " + eight);

                //  8:      
                //   aaaa
                //  b    c
                //  b    c
                //   dddd
                //  e    f
                //  e    f
                //   gggg 
                //
                // this is going to be so dumb

                A = unique(seven, one);

                // 8 is 7 segments
                // 0, 6, 9 are 6 segments
                // 2, 3, 5 are 5 segments
                // 4 is 4 segments
                // 7 is 3 segments
                // 1 is 2 segments

                // union of 7 and 4 can narrow down bottom and bottom left (E, G)
                String getTwo = union(seven, four);
                String twoSave = "";

                for (String unknown : length5) {
                    String temp = mask(getTwo, unknown);
                    if (temp.length() == 1) {
                        G = temp;
                    } else if (temp.length() == 2) {
                        // this is the number 2
                        twoSave = unknown;
                    }
                }

                for (String unknown : length5) {
                    // this doesn't work because my union method is screwed
                    // edit: this works now
                    String temp = mask((getTwo + G), unknown);
                    if (temp.length() == 1) {
                        E = temp;
                        break;
                    }
                }

                // At this stage, A, E, and G are known
                //   XXXX
                //  b    c
                //  b    c
                //   dddd
                //  X    f
                //  X    f
                //   XXXX 

                // C and F can be deduced by the mask and the leftover of one and twoSave
                // System.out.println(twoSave);
                // System.out.println(one);
                C = mask(twoSave, one);
                // System.out.println(C);
                F = mask(C, one);

                // At this stage, A, C, E, F, and G are known
                //   XXXX
                //  b    X
                //  b    X
                //   dddd
                //  X    X
                //  X    X
                //   XXXX 

                // D can be deduced by the mask and the leftover of one and twoSave
                D = mask(A + C + E + F + G, twoSave);

                // and B is the rest
                B = mask(A + C + D + E + F + G, eight);

                // System.out.println("pee hahaha");
                System.out.println(A + " " + B + " " + C + " " + D + " " + E + " " + F + " " + G);
                // System.out.println("poop funny !!!");

                String[] numbers = new String[] {A + B + C + E + F + G,
                                                C + F,
                                                A + C + D + E + G,
                                                A + C + D + F + G,
                                                B + C + D + F,
                                                A + B + D + F + G,
                                                A + B + D + E + F + G,
                                                A + C + F,
                                                A + B + C + D + E + F + G,
                                                A + B + C + D + F + G
                                            };

                                            // bcdef
                                            // C G A B D
                                            // A B C D G

                ArrayList<String> correctSegments = new ArrayList<>();

                for (String number : numbers) {
                    char[] tempSorting = number.toCharArray();
                    Arrays.sort(tempSorting);

                    correctSegments.add(String.valueOf(tempSorting));
                }
                
                StringBuilder lineSum = new StringBuilder();
                System.out.println(correctSegments);

                for (String segment : segments) {
                    char[] tempSorting = segment.toCharArray();
                    Arrays.sort(tempSorting);

                    String sortedSegment = String.valueOf(tempSorting);

                    if (correctSegments.contains(sortedSegment)) {
                        lineSum.append(correctSegments.indexOf(sortedSegment));
                    } else {
                        System.out.println(sortedSegment);
                    }
                }

                System.out.println(lineSum.toString());
                count += Integer.parseInt(lineSum.toString());
            }

            System.out.println(count);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    public static String unique(String s1, String s2) {
        char[] x = s1.toCharArray();
        char[] y = s2.toCharArray();
        Arrays.sort(x);
        Arrays.sort(y);

        String xs = String.valueOf(x);
        String ys = String.valueOf(y);

        if (x.length > y.length) {
            return xs.substring(y.length);
        } else {
            return ys.substring(x.length);
        }
    }

    public static String union(String s1, String s2) {
        StringBuilder sb = new StringBuilder(s1);
        
        for (char i : s2.toCharArray()) {
            if (!sb.toString().contains(String.valueOf(i))) {
                sb.append(i);
            }
        }

        return sb.toString();
    }

    public static String mask(String mask, String s) {
        char[] y = s.toCharArray();

        StringBuilder out = new StringBuilder();
        for (char c: y) {
            if (!mask.contains(String.valueOf(c))) {
                out.append(c);
            }
        }

        return out.toString();
    }
}