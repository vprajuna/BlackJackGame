import java.util.Scanner;

public class Blackjack {

    public static void main (String[] args) {
        Scanner userInput = new Scanner(System.in); //declare once
        P1Random randNum = new P1Random(); //declare once

        // this is a comment for Lab 6!
        // this is a second comment for Lab 6. 

        int valueHand = 0; // value of the player's hand
        int menuInput = 1; // user input of menu options (1 to 4)
        int countGame = 0; // keeps count of games played
        int valueCard = 0; // value of the randomly drawn card (1 to 13)
        int winsPlayer = 0; // keeps count of player's wins
        int winsDealer = 0; // keeps count of dealer's wins
        int valueHandDealer = 0; // value of the dealer's hand (16 to 26)
        int countTies = 0; // keeps count of ties between the dealer and player
        double percentage = 0; // percentage of player wins to the total number games played
        boolean gameOver = true; // value will be true if when winner is determined
        int totalGames = 0; // total games played

        do {
            if (gameOver == true) {
                countGame++;
                gameOver = false;
                System.out.println("START GAME #" + countGame); // prints the corresponding game number
                System.out.println("");
            }
            if (menuInput == 1) {
                valueCard = randNum.nextInt(13) + 1; // sets valueCard to a random number from 1 to 13
                if (valueCard == 1) {
                    System.out.println("Your card is a ACE!"); // The card ace is a worth a value of 1
                    valueHand += 1;
                } else if (valueCard == 2) {
                    System.out.println("Your card is a 2!"); // The card 2 is a worth a value of 2
                    valueHand += 2;
                } else if (valueCard == 3) {
                    System.out.println("Your card is a 3!"); // The card 3 is a worth a value of 3
                    valueHand += 3;
                } else if (valueCard == 4) {
                    System.out.println("Your card is a 4!"); // The card 4 is a worth a value of 4
                    valueHand += 4;
                } else if (valueCard == 5) {
                    System.out.println("Your card is a 5!"); // The card 5 is a worth a value of 5
                    valueHand += 5;
                } else if (valueCard == 6) {
                    System.out.println("Your card is a 6!"); // The card 6 is a worth a value of 6
                    valueHand += 6;
                } else if (valueCard == 7) {
                    System.out.println("Your card is a 7!"); // The card 7 is a worth a value of 7
                    valueHand += 7;
                } else if (valueCard == 8) {
                    System.out.println("Your card is a 8!"); // The card 8 is a worth a value of 8
                    valueHand += 8;
                } else if (valueCard == 9) {
                    System.out.println("Your card is a 9!"); // The card 9 is a worth a value of 9
                    valueHand += 9;
                } else if (valueCard == 10) {
                    System.out.println("Your card is a 10!"); // The card 10 is a worth a value of 10
                    valueHand += 10;
                } else if (valueCard == 11) {
                    System.out.println("Your card is a JACK!"); // The card jack is a worth a value of 10
                    valueHand += 10;
                } else if (valueCard == 12) {
                    System.out.println("Your card is a QUEEN!"); // The card queen is a worth a value of 10
                    valueHand += 10;
                } else {
                    System.out.println("Your card is a KING!"); // The card king is a worth a value of 10
                    valueHand += 10;
                }
                System.out.println("Your hand is: " + valueHand);
                System.out.println("");
                if (valueHand == 21) {
                    System.out.println("BLACKJACK! You win!"); // if hand value reaches 21, player wins!
                    System.out.println("");
                    gameOver = true;  // restarts the game
                    valueHand = 0;
                    winsPlayer++; // increments player's wins
                    totalGames++; // increment count of total games
                    continue;
                }
                if (valueHand > 21) {
                    System.out.println("You exceeded 21! You lose."); // if hand value exceeds 21, dealer wins.
                    System.out.println("");
                    gameOver = true; // restarts the game
                    valueHand = 0;
                    winsDealer++; // increments dealer's wins
                    totalGames++; // increment count of total games
                    continue;
                }
                System.out.println("1. Get another card\n2. Hold hand\n3. Print statistics\n4. Exit\n");
                System.out.print("Choose an option: ");
                menuInput = userInput.nextInt();
                System.out.println("");
            }

            if (menuInput == 3) {
                System.out.println("Number of Player wins: " + winsPlayer);
                System.out.println("Number of Dealer wins: " + winsDealer);
                System.out.println("Number of tie games: " + countTies);
                System.out.println("Total # of games played is: " + totalGames);
                double winsPlayerDouble = winsPlayer; // converts winsPlayer to double before finding percentage
                percentage = (winsPlayerDouble / totalGames) * 100; // percentage of player wins to the total number games played
                System.out.print("Percentage of Player wins: ");
                System.out.printf("%.1f", percentage);
                System.out.println("%\n");
                System.out.println("1. Get another card\n2. Hold hand\n3. Print statistics\n4. Exit\n");
                System.out.print("Choose an option: ");
                menuInput = userInput.nextInt();
                System.out.println("");
            }

            if (menuInput == 2) {
                valueHandDealer = randNum.nextInt(11) + 16; // sets valueHandDealer to a random number from 16 to 26
                if (valueHandDealer > 21) {
                    System.out.println("Dealer's hand: " + valueHandDealer);
                    System.out.println("Your hand is: " + valueHand);
                    System.out.println("");
                    System.out.println("You win!\n");
                    winsPlayer++; // dealer's hand exceeded 21, so increment player's wins
                    totalGames++; // increment count of total games
                    gameOver = true; // restarts the game
                    valueHand = 0;
                }
                else if (valueHandDealer == valueHand) {
                    System.out.println("Dealer's hand: " + valueHandDealer);
                    System.out.println("Your hand is: " + valueHand);
                    System.out.println("");
                    System.out.println("It's a tie! No one wins!\n");
                    countTies++; // tie between dealer and player, so increment count of ties
                    totalGames++; // increment count of total games
                    gameOver = true; // restarts the game
                    valueHand = 0;
                }
                else if (valueHandDealer > valueHand && valueHandDealer <= 21) {
                    System.out.println("Dealer's hand: " + valueHandDealer);
                    System.out.println("Your hand is: " + valueHand);
                    System.out.println("");
                    System.out.println("Dealer wins!\n");
                    winsDealer++; // increments dealer's wins
                    totalGames++; // increment count of total games
                    gameOver = true;// restarts the game
                    valueHand = 0;
                }
                else if (valueHandDealer < valueHand) {
                    System.out.println("Dealer's hand: " + valueHandDealer);
                    System.out.println("Your hand is: " + valueHand);
                    System.out.println("");
                    System.out.println("You win!\n");
                    winsPlayer++; // increments player's wins
                    totalGames++; // increment count of total games
                    gameOver = true; // restarts the game
                    valueHand = 0;
                }
                menuInput = 1;
            }

            while (menuInput != 1 && menuInput != 2 && menuInput != 3 && menuInput != 4) {
                System.out.println("Invalid input!\nPlease enter an integer value between 1 and 4.\n");
                System.out.println("1. Get another card\n2. Hold hand\n3. Print statistics\n4. Exit\n");
                System.out.print("Choose an option: ");
                menuInput = userInput.nextInt();
                System.out.println("");
            }
        } while (menuInput != 4);
    }
}