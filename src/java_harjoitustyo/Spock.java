package java_harjoitustyo;


public class Spock extends Choice {
   
    public int vs(int object) {
        io.print("chose Spock");
        if (object == 3) {
            io.print("Computer chose Scissors");
            io.print("Spock smashes Scissors");       //voitto
            return 1;
        } else if (object == 1) {
            io.print("Computer chose Rock");
            io.print("Spock vaporizes Rock");     //voitto
            return 1;
        } else if (object == 2) {
            io.print("Computer chose Paper");
            io.print("Paper disproves Spock");        //häviö
            return -1;
        } else if (object == 4) {
            io.print("Computer chose Lizard");
            io.print("Lizard poisons Spock");      //häviö
            return -1;
        } else {
            io.print("Computer chose Spock");
            io.print("It's a tie");           //tasapeli
            return 0;
        }
    } 
}
