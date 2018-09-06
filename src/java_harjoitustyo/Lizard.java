package java_harjoitustyo;


public class Lizard extends Choice {
    
    public int vs(int object) {
        io.print("You chose Scissors");
        if (object == 2) {
            io.print("Computer chose Paper");
            io.print("Lizard eats Paper");        //voitto
            return 1;
        } else if (object == 5) {
            io.print("Computer chose Spock");
            io.print("Lizard poisons Spock");     //voitto
            return 1;
        } else if (object == 1) {
            io.print("Computer chose Rock");
            io.print("Rock crushes Lizard");         //häviö
            return -1;
        } else if (object == 3) {
            io.print("Computer chose Scissors");
            io.print("Scissors decapitates Lizard");      //häviö
            return -1;
        } else {
            io.print("Computer chose Lizard");
            io.print("It's a tie");           //tasapeli
            return 0;
        }
    } 
    
}
