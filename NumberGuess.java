import java.util.*;

public class NumberGuess 
{

    public static void main(String args[]) 
    {
        
        
    
        Scanner sc = new Scanner(System.in);

        int no = 1 + (int) (100 * Math.random());// To generate a random number

        int x = 5;
        int i, guess;
        System.out.println("A number has been chosen between 1 to 100.");
        System.out.println("You have 5 chances to guess the number!");

        // 5 chances to guess the number
        for (i = 0; i < x; i++) {
            System.out.println("Guess the number:- ");
            // Taking input from user.
            guess = sc.nextInt();

            if (no == guess) {
                System.out.println("Congratulations! You have guessed it right!");
                break;
            } else if (no > guess && i != x - 1) {
                System.out.println("Wrong Guess! The number is greater than " + guess);
            } else if (no < guess && i != x - 1) {
                System.out.println("Wrong Guess! The number is less than " + guess);
            }
        }
        if (i == x)
            System.out.println("You have exhausted all your chances.");
        System.out.println("The number was:-" + no);
        
    }

}

   
