import java.util.ArrayList;

public class BlackjackHand extends Deck {
    public int getValue() {
        int cardSum = 0;
        for (Card c : getCards()) {
            BlackjackCard card = (BlackjackCard) c;
            if (card.isAce() && (cardSum + card.getValue()) > 21) {
                cardSum += 1;
            } else {
                cardSum += card.getValue();
            }
        }

        return cardSum;
    }

    public boolean isBusted() {
        return getValue() > 21;
    }

    public boolean isBlackjack() {
        return (getCards().size() == 2 && getValue() == 21);
    }


}
