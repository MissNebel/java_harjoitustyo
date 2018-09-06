package java_harjoitustyo;


public class Scissors extends Choice {

            
    public int vs(int object) {
        io.print("You chose Scissors");
        if (object == 2) {
            io.print("Computer chose Paper");
            io.print("Scissors cuts Paper");      //voitto
            return 1;
        } else if (object == 4) {
            io.print("Computer chose Lizard");
            io.print("Scissors decapitates Lizard");  //voitto
            return 1;
        } else if (object == 1) {
            io.print("Computer chose Rock");
            io.print("Rock crushes Scissors");        //häviö
            return -1;
        } else if (object == 5) {
            io.print("Computer chose Spock");
            io.print("Spock smashes Scissors");       //häviö
            return -1;
        } else {
            io.print("Computer chose Scissors");
            io.print("It's a tie");       //tasapeli
            return 0;
        }
    } 
}
