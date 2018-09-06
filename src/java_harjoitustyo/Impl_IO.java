package java_harjoitustyo;


//tämä on Javan valmis luokka joka puskee virheilmoituksen väärästä inputista
import java.util.InputMismatchException; 
import java.util.Scanner;
public class Impl_IO implements IO {
    
    private Scanner reader = new Scanner(System.in);
    
    @Override
    public void print(String text) { // metodi tulostamista varten
        System.out.println(text);
    }
    
  
    @Override
    public int userChoice(int min, int max) { // metodi jolla kerätään käyttäjältä 
        int choice;
        while(true) {
            try { //virheenkäsittely
                choice = reader.nextInt();
                if (choice <= max && choice >= min) {
                    break;
                } else {
                     print("Please pick only " + min + "-" + max);
                }
                        
                
            } catch (InputMismatchException exception) {
               print("Only numbers, please.");
                reader.nextLine();
            }
            
        }
        reader.nextLine();
        return choice;
    }
    
     @Override
    public int answer() { 
        int answer;
        while(true) {
            try { 
                answer = reader.nextInt();
                break;
            } catch (InputMismatchException exception) {
                print("Only numbers");
                reader.nextLine();
            }
        }
        reader.nextLine();
        return answer;
    
}

    
}
