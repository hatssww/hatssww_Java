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
        for (int i = 0; i < cards.size(); i++) {
            System.out.println(getCards().get(i).toString());
        }
    }

    public void shuffle() {
        Random random_method = new Random();
        ArrayList<Card> randomCards = new ArrayList<Card>();
        for (int i = 0; i < cards.size(); i++) {
            boolean duplicate = true;
            while (duplicate) {
                int index = random_method.nextInt(cards.size());
                if (randomCards.contains(cards.get(index))) {
                    duplicate = true;
                } else {
                    randomCards.add(cards.get(index));
                    break;
                }
            }
        }
        cards = randomCards;
    }

    public Deck deal(int count) {
        Deck hand = new Deck();

        for (int i = cards.size() - 1; i >= cards.size() - count; i--) {
            hand.addCard(cards.get(i));
        }
        for (int i = 1; i <= count; i++) {
            cards.remove(cards.size() - 1);
        }
        return hand;
    }
}