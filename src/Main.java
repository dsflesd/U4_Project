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
        for (int i=0; i<lines.length; i++) {
            String[] numbers = lines[i].split(",");
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
            Hand firstHand=new Hand(bid,count);
            poker[i]=firstHand;
        }
        int handTypeOneCount=0;
        int handTypeTwoCount=0;
        int handTypeThreeCount=0;
        int handTypeFourCount=0;
        int handTypeFiveCount=0;
        int handTypeSixCount=0;
        int handTypeSevenCount=0;
        for (Hand hands:poker){
            if (hands.returnHandType()==1){
                handTypeOneCount++;
            }
            if (hands.returnHandType()==2){
                handTypeTwoCount++;
            }
            if (hands.returnHandType()==3){
                handTypeThreeCount++;
            }
            if (hands.returnHandType()==4){
                handTypeFourCount++;
            }
            if (hands.returnHandType()==5){
                handTypeFiveCount++;
            }
            if (hands.returnHandType()==6){
                handTypeSixCount++;
            }
            if (hands.returnHandType()==7){
                handTypeSevenCount++;
            }
        }
        Hand[] poker1;
        poker1=new Hand[handTypeOneCount];
        Hand[] poker2;
        poker2=new Hand[handTypeTwoCount];
        Hand[] poker3;
        poker3=new Hand[handTypeThreeCount];
        Hand[] poker4;
        poker4=new Hand[handTypeFourCount];
        Hand[] poker5;
        poker5=new Hand[handTypeFiveCount];
        Hand[] poker6;
        poker6=new Hand[handTypeSixCount];
        Hand[] poker7;
        poker7=new Hand[handTypeSevenCount];
        for (int x=0; x<poker.length; x++){
        for (int i=0; i<poker1.length; i++) {
            if (poker[i].returnHandType() == 1) {
                poker1[i] = poker[i];
            }
        }
        for (int i=0; i<poker2.length; i++) {
            if (poker[i].returnHandType() == 2) {
                poker2[i] = poker[i];
            }
        }
        for (int i=0; i<poker3.length; i++){
            if (poker[i].returnHandType()==3){
                poker3[i]=poker[i];
            }
        }
        for (int i=0; i<poker4.length; i++) {
            if (poker[i].returnHandType() == 4) {
                poker4[i] = poker[i];
            }
        }
        for (int i=0; i<poker5.length; i++) {
            if (poker[i].returnHandType() == 5) {
               poker5[i] = poker[i];
            }
        }
        for (int i=0; i<poker6.length; i++) {
            if (poker[i].returnHandType() == 6) {
                poker6[i] = poker[i];
            }
        }
        for (int i=0; i<poker7.length; i++) {
            if (poker[i].returnHandType() == 7) {
                poker7[i] = poker[i];
             }
         }
        }
        System.out.println(handTypeOneCount);
        System.out.println(Arrays.toString(poker1));
        System.out.println(Arrays.toString(poker2));
        System.out.println(Arrays.toString(poker3));
        System.out.println(Arrays.toString(poker4));
        System.out.println(Arrays.toString(poker5));
        System.out.println(Arrays.toString(poker6));
        System.out.println(Arrays.toString(poker7));
//        for (int y = 0; y <poker.length-1; y++){
//            int currentRank=poker[y+1].returnHandType();
//            if (currentRank<(poker[y].returnHandType()));{
//                poker[y].rank=numOfLines;


//          firstHand.determineRank(numOfLines);
//            System.out.println(firstHand.toString());
            }


//    System.out.println("Five of a kind:" +fiveOfAKind);
//    System.out.println("Four of a kind: "+fourOfAKind);
//    System.out.println("Full House: "+fullHouse);
//    System.out.println("Three of a kind: "+threeOfAKind);
//    System.out.println("Double Pair: "+ doublePair);
//    System.out.println("Single Pair: "+singlePair);
//    System.out.println("High Card: "+highCard);
        }
//        System.out.println(Arrays.toString(poker));



