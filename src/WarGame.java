public class WarGame {
    Player player1;
    Player player2;
    Player first;
    Player second;
    int firstPlayer;

    public WarGame(String p1, String p2) {
        this.player1 = new Player(p1);
        this.player2 = new Player(p2);
        this.firstPlayer = whoPlayFirst(this.player1, this.player2);
        if (firstPlayer == 1) {
            this.first = this.player1;
            this.second = this.player2;

        } else {
            this.first = this.player2;
            this.second = this.player1;
        }
    }


    public int whoPlayFirst(Player player1, Player player2) {
        if (player1.getName().compareTo(player2.getName()) < 0) {
            return 1;
        }
        return 2;
    }

    public void initializeGame() {
        System.out.println("Initializing the game...");
        Deck firstDeck = new Deck(true);
        firstDeck.shuffle();

        while (!firstDeck.isEmpty()) {

            if (firstPlayer == 1) {
                player1.addCardToGamePack(firstDeck.removeTopCard());
                player2.addCardToGamePack(firstDeck.removeTopCard());
            } else {
                player2.addCardToGamePack(firstDeck.removeTopCard());
                player1.addCardToGamePack(firstDeck.removeTopCard());
            }
        }
    }


    public String start() {
        initializeGame();
        int n = 0;
        while ((!first.outOfCards() && !second.outOfCards())) {
            ++n;
            System.out.println("------------------------- Round number " + n + " -------------------------");
            cardsCompare();

        }

        if (first.outOfCards()) {
            return second.getName();
        }
        return first.getName();

    }

    public void cardsCompare() {
        Card firstTopCard = first.drawCard();
        System.out.println(first + " drew " + firstTopCard);
        Card secondTopCard = second.drawCard();
        System.out.println(second + " drew " + secondTopCard);
        int compareCards = firstTopCard.compare(secondTopCard);
        if (compareCards == 1) {
            first.addCardToWinPack(secondTopCard);
            first.addCardToWinPack(firstTopCard);
            System.out.println(first + " won");
        } else if (compareCards == -1) {
            second.addCardToWinPack(secondTopCard);
            second.addCardToWinPack(firstTopCard);
            System.out.println(second + " won");
        } else {
            theWarIsStarting(firstTopCard, secondTopCard);
        }
    }

    public void theWarIsStarting(Card firstTopCard, Card secondTopCard){
        Deck temp = new Deck(false);
        int compareInWar = 0;
        temp.addCard(firstTopCard);
        temp.addCard(secondTopCard);
        while (compareInWar == 0) {
            System.out.println("Starting a war...");
            for (int i = 0; i < 2; i++) {
                if (first.outOfCards() || (second.outOfCards())) {
                    break;
                }
                temp.addCard(first.drawCard());
                System.out.println(first + " drew a war card");
                temp.addCard(second.drawCard());
                System.out.println(second + " drew a war card");
            }if (first.outOfCards() || (second.outOfCards())) {
                break;
            }
            Card topCardOfFirstPlayerInWar = first.drawCard();
            System.out.println(first + " drew " + topCardOfFirstPlayerInWar);
            Card topCardOfSecondPlayerInWar = second.drawCard();
            System.out.println(second + " drew " + topCardOfSecondPlayerInWar);
            temp.addCard(topCardOfFirstPlayerInWar);
            temp.addCard(topCardOfSecondPlayerInWar);
            compareInWar = topCardOfFirstPlayerInWar.compare(topCardOfSecondPlayerInWar);
            int WAR_DECK_SIZE = temp.getDeckSize();

            if (compareInWar == 1) {
                for (int i = 0; i < WAR_DECK_SIZE; i++) {
                    first.addCardToWinPack(temp.removeTopCard());
                }
                System.out.println(first + " won the war");
            } else if (compareInWar == -1) {
                for (int i = 0; i < WAR_DECK_SIZE; i++) {
                    second.addCardToWinPack(temp.removeTopCard());
                }
                System.out.println(second + " won the war");
            }
        }
    }
}

