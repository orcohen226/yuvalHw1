public class WarGame {
    Player player1;
    Player player2;
    Player first;
    Player second;

    Player winner;

    public WarGame(String p1, String p2) {
        player1 = new Player(p1);
        player2 = new Player(p2);
    }

    public void firstPlayer() {
        int diff = player1.getName().compareTo(player2.getName());

        if (diff < 0) {
            this.first = new Player(player1);
            this.second = new Player(player2);
        } else {
            this.first = new Player(player2);
            this.second = new Player(player1);
        }
    }

    public void initializeGame() {
        this.firstPlayer();
        Deck deck = new Deck(true);
        deck.shuffle();
        System.out.println(first.getName());
        System.out.println(second.getName());

        for (int i = 0; i < 26; i++) {
            first.gamePack.addCard(deck.removeTopCard());
            second.gamePack.addCard(deck.removeTopCard());
        }
    }

    public String start() {
        initializeGame();

        int n = 1;
        System.out.println("Initializing the game...");

        while (!(this.first.outOfCards() && this.second.outOfCards())) {
            Deck temp = new Deck(false);

            System.out.println("------------------------- Round number " + n + "-------------------------");
            Card c1 = first.drawCard();
            System.out.println(first.getName() + " drew " + c1.toString());
            Card c2 = second.drawCard();
            temp.addCard(c2);
            System.out.println(second.getName() + " drew " + c2.toString());
            temp.addCard(c1);

            cardsCompare(temp, c1, c2);
//
//            if (winner == first) {
//                Deck united = first.getWinPack().united(first.getWinPack(), temp);
//                first.setWinPack(united);
//            }
//            if (winner == second) {
//                Deck united = second.getWinPack().united(second.getWinPack(), temp);
//                second.setWinPack(united);
//            }
            n++;
        }

        if (first.outOfCards()) {
            return this.second.getName();
        }
        return this.first.getName();

    }

    public void cardsCompare(Deck temp, Card c1, Card c2) {
        int compare1 = 0;
        while (compare1 == 0) {
            if ((c1.compare(c2)) == 1) {
                winner = first;
                System.out.println(first.getName() + " won ");
                first.addCardToWinPack(c2);
                first.addCardToWinPack(c1);
            } else {if ((c1.compare(c2)) == -1) {
                winner = second;
                System.out.println(second.getName() + " won ");
                second.addCardToWinPack(c2);
                second.addCardToWinPack(c1);
            } else {for (int i = 0; i < 2; i++) {
                if (first.outOfCards() || second.outOfCards()) {
                    break;
                }
            }
            c1 = first.drawCard();
            temp.addCard(c1);
            System.out.println(first.getName() + " drew " + c1.toString());
            c2 = first.drawCard();
            temp.addCard(second.drawCard());
            System.out.println(second.getName() + " drew " + c2.toString());
            }
        }
            if (first.outOfCards() || second.outOfCards()) {
                break;
            }
            Card c3 = first.drawCard();
            Card c4 = second.drawCard();
            System.out.println(first.getName() + " drew " + c3.toString());
            System.out.println(second.getName() + " drew " + c4.toString());
            temp.addCard(c3);
            temp.addCard(c4);
            compare1 = c3.compare(c4);
            int WAR_DECK_SIZE = temp.getDeckSize();

            if (compare1 == 1) {for (int i = 0; i < WAR_DECK_SIZE; i++) {
                first.addCardToWinPack(temp.removeTopCard());
            }
            System.out.println(first + " won the war");
            } else if (compare1 == -1) {for (int i = 0; i < WAR_DECK_SIZE; i++) {
                second.addCardToWinPack(temp.removeTopCard());
            }
            System.out.println(second + " won the war");
            }
        }
    }
}

