import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int numOfLines=0;
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
        Hand[] poker;
        poker=new Hand[numOfLines];
        for (String line : lines) {
            String[] numbers = line.split(",");
            String numberSplit = Arrays.toString(numbers);
            int barValue = numberSplit.indexOf("|");
            int bid=0;
            String bidValue= numberSplit.substring(barValue+1);
            if (bidValue.length()==3){
                bid =Integer.parseInt(numberSplit.substring(barValue+1, barValue+3));
            }
            if (bidValue.length()==4){
                bid =Integer.parseInt(numberSplit.substring(barValue+1, barValue+4));
            }
            numberSplit = numberSplit.substring(1, barValue);
            String[] cards = numberSplit.split(", ");

            for (int i = 0; i < cards.length; i++) {
                if (cards[i].equals("Ace")) {
                    cards[i] = "14";
                }
                if (cards[i].equals("King")) {
                    cards[i] = "13";
                }
                if (cards[i].equals("Queen")) {
                    cards[i] = "12";
                }
                if (cards[i].equals("Jack")) {
                    cards[i] = "11";
                }

            }

            for (int i=0; i<lines.length-1; i++){
                Hand firstHand=new Hand(3, bid,25);
                poker[i]=firstHand;
                Hand secondHand= new Hand(4,bid,17);
                poker[i+1]= secondHand;
            }

            int count = 0;
            for (String checker : cards) {
                for (String x:cards) {
                    if (x.equals(checker)) {
                        count++;
                    }
                }

            }if (count == 25) {
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
            System.out.println(Arrays.toString(poker));
//            firstHand.determineHandType(count);
//            firstHand.determineRank(numOfLines);
//            System.out.println(firstHand.toString());
        }
//        System.out.println("Five of a kind:" +fiveOfAKind);
//        System.out.println("Four of a kind: "+fourOfAKind);
//        System.out.println("Full House: "+fullHouse);
//        System.out.println("Three of a kind: "+threeOfAKind);
//        System.out.println("Double Pair: "+ doublePair);
//        System.out.println("Single Pair: "+singlePair);
//        System.out.println("High Card: "+highCard);
    }
}
