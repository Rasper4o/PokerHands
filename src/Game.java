import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Game {

    public static void main(String[] args) throws IOException {
        PlayerHand player1 = new PlayerHand();
        PlayerHand player2 = new PlayerHand();
        int player1Count = 0;

        try {
            File file = new File("poker.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuffer stringBuffer = new StringBuffer();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                int mid = line.length() / 2;
                String[] cards1 = line.substring(0, mid).split("\\s+");
                String[] cards2 = line.substring(mid + 1).split("\\s+");

                ArrayList<Card> cardList1 = new ArrayList<>();
                ArrayList<Card> cardList2 = new ArrayList<>();

                for (String s : cards1) {
                    cardList1.add(new Card(s));
                }

                for (String s : cards2) {
                    cardList2.add(new Card(s));
                }

                player1.setCards(cardList1);
                player1.rankPlayerHand();

                player2.setCards(cardList2);
                player2.rankPlayerHand();

                if (player1.getHandRank().ordinal() > player2.getHandRank().ordinal())
                    player1Count++;
            }

            fileReader.close();
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Player 1 wins " + player1Count + " games.");
    }
}
