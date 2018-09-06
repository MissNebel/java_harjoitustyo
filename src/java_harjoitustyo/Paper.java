package java_harjoitustyo;


public class Paper extends Choice {
    

    public int vs(int object) {
        io.print("You chose Paper");
        if (object == 1) {
            io.print("Computer chose Rock");
            io.print("Paper covers Rock");        //voitto
            return 1;
        } else if (object == 5) {
            io.print("Computer chose Spock");
            io.print("Paper disproves Spock");    //voitto
            return 1;
        } else if (object == 3) {
            io.print("Computer chose Scissors");
            io.print("Scissors cuts Paper");      //häviö
            return -1;
        } else if (object == 4) {
            io.print("Computer chose Lizard");
            io.print("Lizard eats Paper");        //häviö
            return -1;
        } else {
            io.print("Computer chose Paper");
            io.print("It's a tie");           //tasapeli
            return 0;
        }
    } 
    
}
