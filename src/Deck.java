import java.util.ArrayList;
import java.util.Collections;


public class Deck {
    ArrayList<Card> deck;

    public Deck(boolean init) {
        if (init) {
            this.deck = new ArrayList<Card>(52);
            ArrayList<Shape> shapes = new ArrayList<Shape>();
            shapes.add(Shape.Spades);
            shapes.add(Shape.Clubs);
            shapes.add(Shape.Diamoonds);
            shapes.add(Shape.Haarts);

            for (Shape s : shapes) {
                for (int j = 0; j < 13; j++) {
                    Card c = new Card(j + 1, s);
                    deck.add(c);
                }
            }
        }else{
            this.deck = new ArrayList<Card>(0);
        }
    }

    public int getDeckSize() {
        return this.deck.size();
    }

    public void addCard(Card card) {
        deck.add(card);
    }

    public Card removeTopCard() {
        Card last = deck.get(deck.size() - 1);
        deck.remove((deck.size()-1));
        return last;
    }

    public boolean isEmpty() {
        if (deck.size() == 0) {
            return true;
        }
        return false;
    }

    public void shuffle() {
        for (int i = 0; i < 50; i++) {
            int j = Main.rnd.nextInt(this.deck.size());
            int k = Main.rnd.nextInt(this.deck.size());
            Collections.swap(this.deck, j, k);
        }
    }
}
//    public Deck united (Deck d1, Deck d2) {
//        int UNITED_DECK_SIZE = d2.getDeckSize();
//        for(int i=0; i< UNITED_DECK_SIZE ;i++)
//            d1.addCard(d2.removeTopCard());
//        return d1;
//    }
//}