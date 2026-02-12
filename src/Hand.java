
public class Hand {
    public int rank;
    private int bidValue;
    private int handType;
    private int firstCard;
    private int secondCard;
    private int thirdCard;
    private int fourthCard;
    private int fifthCard;

    public Hand(int bidValue, int count, int firstCard) {

        this.bidValue = bidValue;
        this.handType = determineHandType(count);
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

    //    public void setRank()){
//        rank=highestNumber;
//    }
    public void determineRank(int highestRank) {
        rank = highestRank;
    }

    public void setFirstCard(int firstCard) {
        this.firstCard = firstCard;
    }
    public void setSecondCard(int secondCard) {
        this.secondCard = secondCard;
    }
    public void setThirdCard(int thirdCard){
        this.thirdCard=thirdCard;
    }
    public void setFourthCard(int fourthCard){
        this.fourthCard=fourthCard;
    }
    public void setFifthCard(int fifthCard){
        this.fifthCard=fifthCard;
    }
}


