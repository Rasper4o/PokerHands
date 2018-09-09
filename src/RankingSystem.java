import java.util.ArrayList;
import java.util.Collections;

public class RankingSystem {

    private Rank rank;

    public Rank getRank() {
        return rank;
    }

    public boolean isConsecutive(ArrayList<Value> values) {
        for (int i = 0; i < values.size() - 1; i++) {
            if (values.get(i+1).ordinal() != values.get(i).ordinal()+1)
                return false;
        }

        return true;
    }

    public boolean isFlush (ArrayList<Card> cards) {
        int distinctSuit = 1;

        for (Card c : cards) {
            if (c.getSuit().ordinal() != cards.get(0).getSuit().ordinal()) {
                distinctSuit++;
            }
        }

        if (distinctSuit == 1)
            return true;
        else
            return false;
    }

    public boolean isStraight(ArrayList<Card> cards) {
        ArrayList<Value> temp = new ArrayList<>();

        Collections.sort(cards, new CardComparator());

        for (Card c : cards) {
            temp.add(c.getValue());
        }

        return isConsecutive(temp);
    }

    public boolean isStraightFlush (ArrayList<Card> cards) {
        if (isFlush(cards) && isStraight(cards))
           return true;
        else
            return false;
    }

    public boolean isRoyalFlush (ArrayList<Card> cards) {
        Collections.sort(cards, new CardComparator());

        if (isFlush(cards) && isStraight(cards) && cards.get(0).getValue() == Value.TEN)
            return true;
        else
            return false;
    }

    public boolean isFullHouse (ArrayList<Card> cards) {
        if (isPair(cards) && isKind_3(cards))
            return true;
        else
            return false;
    }

    public boolean isPair_2 (ArrayList<Card> cards) {
        Collections.sort(cards, new CardComparator());
        int counter = 0;
        int pairCounter = 0;

        for (Card c : cards) {
            for (int i=1; i<cards.size()-1; i++)
            {
                if (c.getValue().ordinal() == cards.get(i).getValue().ordinal())
                    counter++;
            }
            if (counter == 2) {
                pairCounter++;
                counter = 0;
            }
        }

        if (pairCounter == 2)
            return true;
        else
            return false;
    }

    public boolean isPair (ArrayList<Card> cards) {
        Collections.sort(cards, new CardComparator());
        int counter = 0;

        for (Card c : cards) {
            for (int i=1; i<cards.size()-1; i++)
            {
                if (c.getValue().ordinal() == cards.get(i).getValue().ordinal())
                    counter++;
            }
        }

        if (counter == 2) {
            this.rank = Rank.PAIR_1;
            return true;
        }
        return false;
    }

    public boolean isKind_3 (ArrayList<Card> cards) {
        Collections.sort(cards, new CardComparator());
        int counter = 0;

        for (Card c : cards) {
            for (int i = 1; i < cards.size() - 1; i++) {
                if (c.getValue().ordinal() == cards.get(0).getValue().ordinal()) {
                    counter++;
                }
            }
        }

        if (counter == 3) {
            this.rank = Rank.KIND_3;
            return true;
        }
        return false;
    }

    public boolean isKind_4 (ArrayList<Card> cards) {
        Collections.sort(cards, new CardComparator());
        int counter = 0;

        for (Card c : cards) {
            for (int i = 1; i < cards.size() - 1; i++) {
                if (c.getValue().ordinal() == cards.get(0).getValue().ordinal()) {
                    counter++;
                }
            }
        }

        if (counter == 4) {
            this.rank = Rank.KIND_4;
            return true;
        }
        return false;
    }

    public Value HighCard (ArrayList<Card> cards) {
        Collections.sort(cards, new CardComparator());

        return cards.get(cards.size()-1).getValue();
    }
}
