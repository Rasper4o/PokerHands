import java.util.ArrayList;

public class PlayerHand {
    private ArrayList<Card> cards = new ArrayList<Card>();
    private Rank handRank;
    public RankingSystem rankingSystem = new RankingSystem();

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public Rank getHandRank() {
        return handRank;
    }

    public void rankPlayerHand () {
        if (rankingSystem.isFlush(cards)) {
            if (rankingSystem.isRoyalFlush(cards)) this.handRank = Rank.ROYAL_FLUSH;
            else if (rankingSystem.isStraightFlush(cards)) this.handRank = Rank.STRAIGHT_FLUSH;
            else
                this.handRank = Rank.FLUSH;
        } else {

            if (rankingSystem.isKind_4(cards)) this.handRank = Rank.KIND_4;
            else if (rankingSystem.isFullHouse(cards)) this.handRank = Rank.FULL_HOUSE;
            else if (rankingSystem.isStraight(cards)) this.handRank = Rank.STRAIGHT;
            else if (rankingSystem.isKind_3(cards)) this.handRank = Rank.KIND_3;
            else if (rankingSystem.isPair_2(cards)) this.handRank = Rank.PAIR_2;
            else if (rankingSystem.isPair(cards)) this.handRank = Rank.PAIR_1;
            else
                getHighCard();
        }
    }

    public Value getHighCard () {
        return rankingSystem.HighCard(cards);
    }
}
