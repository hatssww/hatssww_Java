import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Card> cards = new ArrayList<Card>();


    public ArrayList<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void print() {
        for (Card card : cards) {
            System.out.println(card.toString());
        }
    }

    public void shuffle() {
        Random random_method = new Random();
        ArrayList<Card> randomCards = new ArrayList<Card>();
        for (int i = 0; i < cards.size(); i++) {
            int index = random_method.nextInt(cards.size());
            Card temp = cards.get(i);
            cards.set(i, cards.get(index));
            cards.set(index, temp);
        }
    }

    public Deck deal(int count) {
        Deck hand = new Deck();

        for (int i = 0; i < count; i++) {
            hand.addCard(cards.remove(0));
        }

        return hand;
    }
}