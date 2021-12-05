import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Part2 {
    public static void main(String[] args) {
        try (Scanner reader = new Scanner(new File("input.txt"))) {
            ArrayList<Integer> cards = new ArrayList<>();
            ArrayList<Board> boards = new ArrayList<>();

            Arrays.asList(reader.nextLine().split(",")).forEach(card -> cards.add(Integer.parseInt(card)));

            // flush thing
            reader.nextLine();

            // Populate Board objects with next lines
            ArrayList<String> tempBoard = new ArrayList<>();
            String line;
            while (reader.hasNextLine()) {
                if ((line = reader.nextLine()) != "") {
                    tempBoard.add(line);
                } else {
                    // System.out.println(tempBoard);
                    boards.add(new Board(tempBoard));
                    tempBoard = new ArrayList<>();
                }
            }

            Board winner = runBoards(boards, cards);
            System.out.println(winner.getAllUnvisited() * winner.lastCard);
            // get score from winner


        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static Board runBoards(ArrayList<Board> boards, ArrayList<Integer> cards) {
        ArrayList<Board> losers = new ArrayList<>(boards);

        for (Integer card : cards) {
            for (Board board : boards) {

                board.checkBoard(card);

                if (board.isWinning()) {
                    board.lastCard = card;

                    Board temp = board;
                    losers.remove(board);

                    if (losers.size() == 0) {
                        return temp;
                    }
                }
            }
        }
        
        return new Board();
    }
}