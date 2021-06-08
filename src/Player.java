public class Player {
    private String name;
    public Deck winPack;
    public Deck gamePack;

    public Player(String name)
    {
        this.name = name;
        this.gamePack = new Deck(false);
        this.winPack = new Deck(false);
    }
    public Player(Player player)
    {
        this.name = player.getName();
        this.gamePack = player.getGamePack();
        this.winPack = player.getWinPack();

    }

    public String toString() {
        return name;
    }

    public Deck getWinPack() {return winPack;}

    public Deck getGamePack() {return this.gamePack;}

    public String getName() {return name;}

    public void setWinPack(Deck pack) {this.winPack = pack;}
    public void setGamePack(Deck pack) {this.gamePack = pack;}

    public void addCardToWinPack(Card card) {winPack.addCard(card);}
    public void addCardToGamePack(Card card) {gamePack.addCard(card);}

    public Card drawCard(){
        if(gamePack.getDeckSize() < 1){
            winPack.shuffle();
            gamePack = winPack;
            winPack = new Deck(false);
        }
        return gamePack.removeTopCard();}

    public boolean outOfCards() {return gamePack.isEmpty() && winPack.isEmpty();}

}