
package java_harjoitustyo;

//importit luokan ulkopuolelle
import java.util.*;
import java.util.concurrent.ThreadLocalRandom; // Javan valmis luokka random numeroita varten
import java.util.Scanner;
import java.util.List; 

public class Java_harjoitustyo {
    
      private static Scanner reader = new Scanner(System.in);
  
    //luokista tehdään oliot (MUISTA! Kakkureseptin kakkua ei voi syödä ennen kuin kakku on tehty)
    private static IO io = new Impl_IO();
    //              ^              ^
    //            luokka       konstruktori
   //tässä laitetaan taulukkoon Choice-luokasta perivät oliot. Näin voi tehdä, koska perintä.
    private static Choice[] choices = {new Rock(),new Paper(),new Scissors(),new Lizard(),new Spock()};
    //                         ^
    //                     atribuutti
    //luokan muuttujat jotka näkyvät myös aliohjelmille
    private static int randomNum1 = 0;
    private static int randomNum2 = 0;
    private static int correct = 0;
    private static int wrong = 0;
    private static int win = 0;
    private static int lose = 0;
    private static int tie = 0;
    //käytetty listoja koska taulukolle tulee määrittää koko etukäteen
    private static List totalCorrect = new ArrayList();
    private static List totalWrong = new ArrayList();
    private static List totalWin = new ArrayList();
    private static List totalLose = new ArrayList();
    private static List totalTie = new ArrayList();

    public static void main(String[] args) {
       Choice.io = io;
        boolean gameOn = true;
        while (gameOn) {
            //io.print käyttää tulostamiseen tarkoitettua metodia nimeltä Print() joka on esitetty IO-interfacessa ja tehty Impl_IO-luokassa 
            io.print("Game menu");
            io.print("Which game do you want to play?");
            io.print("1. Addition");
            io.print("2. Subtraction");
            io.print("3. Multiplication");
            io.print("4. RockPaperScissorsLizardSpock");
            io.print("0. Quit");
            int userChoice = io.userChoice(0,4); //palautusarvo menee tonne
            if (userChoice == 1) {
                addition();
            } else if (userChoice == 2) {
                subtraction();
            } else if (userChoice == 3) {
                multiplication();
            } else if (userChoice == 4) {
                rockPaperScissorsLizardSpock();
            } else if (userChoice == 0) {
                io.print("Thank you for playing");
                io.print("Here's your total scores:");
                io.print("Correct answers in math games: " + totalCorrect);
                io.print("Wrong answers in math games: " + totalWrong);
                io.print("Wins: " + totalWin.toString() + " and losses: " + totalLose + " in RockPaperScissorsLizardSpock");
                gameOn = false;
            }

        }
    }

     // generoi yhteenlaskuja
    public static void addition() {
        // luuppi jotta ohjelma tekee kymmenen laskua
        for (int answers = 0; answers < 10; answers++) {
            // generoidaan numerot randomNum muuttujiin
            randomNum1 = ThreadLocalRandom.current().nextInt(1, 10 + 1);
            // +1 koska maximinumero on eksklusiivinen, jotta saadaan suurimmaksi numeroksi 10, pitää sen oikeasti olla 11
            randomNum2 = ThreadLocalRandom.current().nextInt(1, 10 + 1);
            io.print("How much is " + (randomNum1) + " + " + (randomNum2) + "?");

            int answer = io.answer();
            // lasketaan oikea vastaus random
            int correctAnswer = randomNum1 + randomNum2;
            // kerätään oikeiden vastausten määrä
            if (correctAnswer == answer) {
                correct++;
            } else {
                wrong++;
            }

        }
        io.print("Scores: " + correct + " correct answers and " + wrong + " wrong answers in this round");
        totalCorrect.add(correct); //lisätään oikeat vastaukset totalCorrect-listaan
        totalWrong.add(wrong);  //lisätään väärät vastaukset totalWrong-listaan
        correct = 0;
        wrong = 0;
    }

    public static void subtraction() {
        for (int answers = 0; answers < 10; answers++) {
            randomNum1 = ThreadLocalRandom.current().nextInt(1, 10 + 1);
            randomNum2 = ThreadLocalRandom.current().nextInt(1, 10 + 1);
            while (randomNum1 < randomNum2) { //tämä estää ettei tule laskuja joissa -merkkinen vastaus
                randomNum1 = ThreadLocalRandom.current().nextInt(1, 10 + 1);
                randomNum2 = ThreadLocalRandom.current().nextInt(1, 10 + 1);
            } 
            io.print("How much is " + (randomNum1) + " - " + (randomNum2) + "?");

            int answer = io.answer();

            int correctAnswer = randomNum1 - randomNum2;

            if (correctAnswer == answer) {
                correct++;
            } else {
                wrong++;
            }
            
        }
        io.print("Scores: " + correct + " correct answers and " + wrong + " wrong answers in this round");
        totalCorrect.add(correct);
        totalWrong.add(wrong);
        correct = 0;
        wrong = 0;
    }

    public static void multiplication() {
        for (int answers = 0; answers < 10; answers++) {
            randomNum1 = ThreadLocalRandom.current().nextInt(1, 10 + 1);
            randomNum2 = ThreadLocalRandom.current().nextInt(1, 10 + 1);
            io.print("How much is " + (randomNum1) + " * " + (randomNum2) + "?");

            int answer = io.answer();

            int correctAnswer = randomNum1 * randomNum2;

            if (correctAnswer == answer) {
                correct++;
            } else {
                wrong++;
            }

        }
        io.print("Scores: " + correct + " correct answers and " + wrong + " wrong answers in this round");
        totalCorrect.add(correct);
        totalWrong.add(wrong);
        correct = 0;
        wrong = 0;
    }
    
    public static void rockPaperScissorsLizardSpock() {
        io.print("How many games you want to play?");
        int games = reader.nextInt();
        int playedGames = 0;
       
        do {
            System.out.println("1. Rock 2. Paper 3. Scissors 4. Lizard 5. Spock");
            int userChoice = io.userChoice(1,5);
             int computerChoice = ThreadLocalRandom.current().nextInt(1, 5 + 1);
             int winOrLose = 0;
             
            //tässä asetetaan winOrLose-muuttujaan choices-taulukko-oliosta käyttäjän valinnan mukainen olio
            winOrLose = choices[userChoice-1].vs(computerChoice);
            
            if (winOrLose == 1) {
                win++;
            } else if (winOrLose == -1) {
                lose++;
            } else {
                tie++;
            }
           
                playedGames++; //lisää pelattuihin peleihin kierroksen
                
        } while(playedGames < games); //vertaa pelattuja yhteispelimäärään
            io.print("Wins: " + win + " Losses: " + lose + " Ties: " + tie);
            totalWin.add(win);  //lisätään voitot totalWin-listaan
            totalLose.add(lose);    //lisätään häviöt totalLose-listaan
            totalTie.add(tie);
            win = 0;
            lose = 0;
            tie = 0;
            
    
    }
        
    }
    
