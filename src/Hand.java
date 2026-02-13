


public class Hand {
    public int rank;
    private int bidValue;
    private int handType;
    private int firstCard;
    private int secondCard;
    private int thirdCard;
    private int fourthCard;
    private int fifthCard;

    public Hand(int bidValue, int count, int firstCard, int secondCard, int thirdCard, int fourthCard, int fifthCard) {

        this.bidValue = bidValue;
        this.handType = determineHandType(count);
        this.firstCard=firstCard;
        this.secondCard=secondCard;
        this.thirdCard=thirdCard;
        this.fourthCard=fourthCard;
        this.fifthCard=fifthCard;
    }

    public String toString() {
        return "Rank:" + rank + " Bid Value:" + bidValue + " Hand Type:" + handType + " " + firstCard + ", " + secondCard + ", " + thirdCard + " ," + fourthCard + " ," + fifthCard;
    }

    public int determineHandType(int count) {
        if (count == 25) {
            handType = 7;
        }
        if (count == 17) {
            handType = 6;
        }
        if (count == 13) {
            handType = 5;
        }
        if (count == 11) {
            handType = 4;
        }
        if (count == 9) {
            handType = 3;
        }
        if (count == 7) {
            handType = 2;
        }
        if (count == 5) {
            handType = 1;
        }
        return handType;
    }

    public int returnHandType() {
        return handType;
    }
    public void setRank(int rank) {
        this.rank=rank;
    }
    public int returnRank(){
        return rank;
    }
    public int returnBid(){
        return bidValue;
    }

    public int returnFirstCard() {
        return firstCard;
    }
    public int returnSecondCard() {
        return secondCard;
    }
    public int returnThirdCard(){
        return thirdCard;
    }
    public int returnFourthCard(){
        return fourthCard;
    }
    public int returnFifthCard(){
        return fifthCard;
    }
}
