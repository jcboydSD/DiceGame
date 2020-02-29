package dicegame;

/******************************************************************************
 * DiceGame.java 
 * Programmer: @author jcboyd
 *
 * This program simulates the rolling of dice and tests for odd & even 
 * and high & low
 *****************************************************************************/

import java.util.Scanner;

public class DiceGame {

    public static void main(String[] args) 
        {
        Scanner stdIn = new Scanner(System.in);
        //Declarations
        int dieSum; //sum of simulated rolled dice
        String highLowGuess;
        String evenOddGuess;
        boolean highLowResult;
        boolean evenOddResult;
        String playAgain; //default is to end game unless y or Y

        //Input, Processing, Output
        System.out.println("Dice Prediction Game by JC Boyd\n");

        do
        {
            System.out.print("Will the next total be High (H) or Low (L)? ");
            highLowGuess = stdIn.nextLine();
            System.out.print("Will the total be Even (E) or Odd (O)? ");
            evenOddGuess = stdIn.nextLine();
            dieSum = rollDiceSum();            
            highLowResult = highLowCheck(dieSum, highLowGuess); //call method to check high or low
            evenOddResult = evenOddCheck(dieSum, evenOddGuess); //call method to check even or odd            
            printResult(dieSum, highLowResult, evenOddResult); //call method to display win or lose msg 
            System.out.print("Do you want to play again? (y/n) ");
            playAgain = stdIn.nextLine();
        } while (playAgain.equals("y") || playAgain.equals("Y"));

    } //end main
    
    //*************************************************************************
    
    public static int rollDiceSum() //Returns sum of 2 simulated rolled dice
    {
        return ((int)(Math.random() * 6 + 1) + (int)(Math.random() * 6 + 1));                
    } //end rollDiceSum
    
    //*************************************************************************
                
    public static boolean highLowCheck(int dieSum, String highLowGuess)
    //Checks for high or low and compares user's guess to determine win or lose
    {
        if ((dieSum > 7) && (highLowGuess.equals("H") || highLowGuess.equals("h"))) 
        {
            return (boolean)(true);
        }
        else if ((dieSum < 7) && (highLowGuess.equals("L") || highLowGuess.equals("l")))
        {
            return (boolean)(true);
        }
        else //In case of wrong guess or when dieSum == 7
        {
            return (boolean)(false);
        } //end if        
    } //end highLowCheck
    
    //*************************************************************************            
                
    public static boolean evenOddCheck(int dieSum, String evenOddGuess)
    //Checks for even or odd and compares user's guess to determine win or lose
    {
        if ((dieSum % 2 == 0) && (evenOddGuess.equals("E") || evenOddGuess.equals("e"))) 
        {
            return (boolean)(true);
        }
        else if ((dieSum % 2 != 0) && (evenOddGuess.equals("O") || evenOddGuess.equals("o")))
        {
            return (boolean)(true);
        }
        else
        {
            return (boolean)(false);
        } //end if        
    } //end evenOddCheck
    
    //*************************************************************************            
                
    public static void printResult(int dieSum, boolean highLowResult, boolean evenOddResult)
    //Prints games results based on boolean results
    {
        System.out.printf("The total is %d\n", dieSum);
        if (dieSum == 7)
        {
            System.out.println("It's the dreaded 7, no way to win");
        }
        else if (highLowResult && evenOddResult)
        {
           System.out.println("You are totally correct!");
        }
        else if (highLowResult)
        {
            System.out.println("You didn't get the even/odd right");
        }
        else if (evenOddResult)
        {
            System.out.println("You didn't get the range right");
        }
        else
        {
            System.out.println("You are totally wrong!");
        } //end if
    } //end printResult
    
    //*************************************************************************

} //end class DiceGame
