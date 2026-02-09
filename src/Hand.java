public class Hand {
    private int rank;
    private int bidValue;
    private int handType;
    public Hand (int rank, int bidValue, int count) {
        this.rank = rank;
        this.bidValue =bidValue;
        this.handType=determineHandType(count);


    }
    public String toString(){
        return "Rank:"+rank+" Bid Value:"+bidValue+" Hand Type:"+handType;
    }
    public int determineHandType(int count){
        if (count == 25){
            handType=7;
        }
        if (count == 17){
            handType=6;
        }
        if (count == 13){
            handType=5;
        }
        if (count == 11){
            handType=4;
        }
        if (count == 9){
            handType=3;
        }
        if (count == 7){
            handType=2;
        }
        if (count == 5){
            handType=1;
        }
        return handType;
    }
    public void determineRank(int highestRank){
        rank=highestRank;
    }
}
