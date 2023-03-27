import java.util.Scanner;

public class Blackjack {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        P1Random rng = new P1Random();

        //Variables
        int option = 0;
        int numGame = 1;
        int myHand = 0;
        int myCard = 0;
        int dealerHand = 0;
        int gamesTot = 0;
        int dWin = 0;
        int pWin = 0;
        int tGame = 0;

        //First game introduction
        System.out.println("\nSTART GAME #" + numGame);
        myCard = rng.nextInt(13) + 1;
        myHand = myCard;
        System.out.println("\nYour card is a " + myCard + "!");
        System.out.println("Your hand is: " + myHand);

        //Game menu
        while (option != 4) {
            System.out.println("\n1. Get another card\n2. Hold hand\n3. Print statistics\n4. Exit\n\nChoose an option:");
            option = scnr.nextInt();
            System.out.println();

            while (option != 4) {
                //Menu options
                if (option == 1) {
                    myCard = rng.nextInt(13) + 1;
                    //Face cards given names instead of numerical value
                    if (myCard == 1) {
                        System.out.println("Your card is a ACE!");
                    } else if (myCard > 1 && myCard < 11) {
                        System.out.println("Your card is a " + myCard + "!");
                    } else if (myCard == 11) {
                        System.out.println("Your card is a JACK!");
                        myCard = 10;
                    } else if (myCard == 12) {
                        System.out.println("Your card is a QUEEN!");
                        myCard = 10;
                    } else if (myCard == 13) {
                        System.out.println("Your card is a KING!");
                        myCard = 10;
                    }
                    myHand += myCard;
                    System.out.println("Your hand is: " + myHand);
                    //Player win or lose scenarios
                    if (myHand > 21) {
                        System.out.println("\nYou exceeded 21! You lose.");
                        numGame++;
                        dWin++;
                        System.out.println("\nSTART GAME #" + numGame + "\n");
                        gamesTot++;
                        myHand = 0;
                        continue;
                    } else if (myHand == 21) {
                        System.out.println("\nBLACKJACK! You win!");
                        numGame++;
                        System.out.println("\nSTART GAME #" + numGame + "\n");
                        gamesTot++;
                        pWin++;
                        myHand = 0;
                        continue;
                    } else if (myHand < 21) {
                        break;
                    }
                    //Dealer scenarios
                } else if (option == 2) {
                    dealerHand = rng.nextInt(11) + 16;
                    System.out.println("Dealer's hand: " + dealerHand);
                    System.out.println("Your hand is: " + myHand);

                    if (dealerHand > 21 || dealerHand < myHand) {
                        System.out.println("\nYou win!");
                        numGame++;
                        System.out.println("\nSTART GAME #" + numGame + "\n");
                        gamesTot++;
                        pWin++;
                        myHand = 0;
                        option = 1;
                        continue;
                    } else if (dealerHand == 21 || dealerHand > myHand) {
                        System.out.println("\nDealer wins!");
                        numGame++;
                        System.out.println("\nSTART GAME #" + numGame + "\n");
                        gamesTot++;
                        dWin++;
                        myHand = 0;
                        option = 1;
                        continue;
                        //Tie scenario
                    } else if (dealerHand == myHand) {
                        System.out.println("It's a tie! No one wins!");
                        numGame++;
                        System.out.println("\nSTART GAME #" + numGame + "\n");
                        gamesTot++;
                        tGame++;
                        myHand = 0;
                        option = 1;
                        continue;
                    }
                    //Game statistics
                } else if (option == 3) {
                    System.out.println("Number of Player wins: " + pWin);
                    System.out.println("Number of Dealer wins: " + dWin);
                    System.out.println("Number of tie games: " + tGame);
                    System.out.println("Total # of games played is: " + gamesTot);
                    System.out.printf("Percentage of Player wins: %.1f%%\n", (pWin * 1.0 / gamesTot) * 100);
                    break;
                } else if (option == 4) {
                    System.exit(0);
                } else {
                    System.out.print("Invalid input!\nPlease enter an integer value between 1 and 4.");
                    break;
                }
            }
        }
    }
}















