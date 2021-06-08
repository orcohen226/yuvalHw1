public class Card {
    final int val;
    final String picture;
    final Shape shape;

    public Card(int num, Shape s) {
        this.val = num;
        this.shape = s;

        switch (num) {
            case 1:

                this.picture = "Ace of " + this.shape;
                break;
            case 11:
                this.picture = "Jack of " + this.shape;
                break;
            case 12:
                this.picture = "Queen of " + this.shape;
                break;
            case 13:
                this.picture = "King of " + this.shape;
                break;

            default:
                this.picture = num + " of " + this.shape;
        }
    }

    public int getValue() {
        return this.val;
    }

    public int compare(Card other) {
        if (this.val < other.val)
            return -1;
        else if (this.val > other.val)
            return 1;
        return 0;
    }

    public String toString() {
        return this.picture;
    }

}