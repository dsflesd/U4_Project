import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int numOfLines = 0;
        String fileData = "";
        try {
            File f = new File("src/data");
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                fileData += line + "\n";
                numOfLines++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        String[] lines = fileData.split("\n");
        int fiveOfAKind = 0;
        int fourOfAKind = 0;
        int fullHouse = 0;
        int threeOfAKind = 0;
        int doublePair = 0;
        int singlePair = 0;
        int highCard = 0;
        int totalBid=0;
        Hand[] poker;
        poker = new Hand[numOfLines];
        for (int i = 0; i < lines.length; i++) {
            String[] numbers = lines[i].split(",");
            String numberSplit = Arrays.toString(numbers);
            int barValue = numberSplit.indexOf("|");
            int bid = 0;
            String bidValue = numberSplit.substring(barValue + 1);
            if (bidValue.length() == 3) {
                bid = Integer.parseInt(numberSplit.substring(barValue + 1, barValue + 3));
            }
            if (bidValue.length() == 4) {
                bid = Integer.parseInt(numberSplit.substring(barValue + 1, barValue + 4));
            }
            numberSplit = numberSplit.substring(1, barValue);
            String[] cards = numberSplit.split(", ");
            for (int x = 0; x < cards.length; x++) {
                if (cards[x].equals("Ace")) {
                    cards[x] = "14";
                }
                if (cards[x].equals("King")) {
                    cards[x] = "13";
                }
                if (cards[x].equals("Queen")) {
                    cards[x] = "12";
                }
                if (cards[x].equals("Jack")) {
                    cards[x] = "11";
                }

            }
            int count = 0;
            for (String checker : cards) {
                for (String x : cards) {
                    if (x.equals(checker)) {
                        count++;
                    }
                }
            }
            if (count == 25) {
                fiveOfAKind++;
            }
            if (count == 17) {
                fourOfAKind++;
            }
            if (count == 13) {
                fullHouse++;
            }
            if (count == 11) {
                threeOfAKind++;
            }
            if (count == 9) {
                doublePair++;
            }
            if (count == 7) {
                singlePair++;
            }
            if (count == 5) {
                highCard++;
            }
            Hand firstHand = new Hand(bid, count,Integer.parseInt(cards[0]), Integer.parseInt(cards[1]), Integer.parseInt(cards[2]),Integer.parseInt(cards[3]),Integer.parseInt(cards[4]));
            poker[i] = firstHand;
        }
        for (int i=0; i<poker.length;i++) {
            int rank = 1;
            for (int x = 0; x < poker.length; x++) {
                boolean isStronger = false;
                if (poker[i].returnHandType() > poker[x].returnHandType()) {
                    isStronger = true;
                } else if (poker[i].returnHandType() == poker[x].returnHandType()) {
                    if (poker[i].returnFirstCard() > poker[x].returnFirstCard()) {
                        isStronger = true;
                    } else if (poker[i].returnFirstCard() == poker[x].returnFirstCard()) {
                        if (poker[i].returnSecondCard() > poker[x].returnSecondCard()) {
                            isStronger = true;
                        } else if (poker[i].returnSecondCard() == poker[x].returnSecondCard()) {
                            if (poker[i].returnThirdCard() > poker[x].returnThirdCard()) {
                                isStronger = true;
                            } else if (poker[i].returnThirdCard() == poker[x].returnThirdCard()) {
                                if (poker[i].returnFourthCard() > poker[x].returnFourthCard()) {
                                    isStronger = true;
                                } else if (poker[i].returnFourthCard() == poker[x].returnFourthCard()) {
                                    if (poker[i].returnFifthCard() > poker[x].returnFifthCard()) {
                                        isStronger = true;
                                    }
                                }
                            }
                        }
                    }
                }if (isStronger){
                    rank++;
                }
            }
            poker[i].setRank(rank);
        }
        System.out.println(Arrays.toString(poker));
        for (Hand hand : poker) {
            totalBid += hand.returnRank() * hand.returnBid();
        }

        System.out.println("Five of a kind:" +fiveOfAKind);
        System.out.println("Four of a kind: "+fourOfAKind);
        System.out.println("Full House: "+fullHouse);
        System.out.println("Three of a kind: "+threeOfAKind);
        System.out.println("Double Pair: "+ doublePair);
        System.out.println("Single Pair: "+singlePair);
        System.out.println("High Card: "+highCard);
        System.out.println("Total Bud: :"+totalBid);
    }
}
