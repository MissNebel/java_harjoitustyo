package java_harjoitustyo;


public class Rock extends Choice {
    

   public int vs(int object) {
        io.print("You chose Rock");
        if (object == 3) {
            io.print("Computer chose Scissors");
            io.print("Rock crushes Scissors");    //voitto
            return 1;
        } else if (object == 4) {
            io.print("Computer chose Lizard");
            io.print("Rock crushes Lizard");      //voito 
            return 1;
        } else if (object == 2) {
            io.print("Computer chose Paper");
            io.print("Paper covers Rock");        //häviö
            return -1;
        } else if (object == 5) {
            io.print("Computer chose Spock");
            io.print("Spock vaporizes Rock");     //häviö
            return -1;
        } else {
            io.print("Computer chose Rock");
            io.print("It's a tie");       //tasapeli
            return 0;
        }
    } 
    
}
