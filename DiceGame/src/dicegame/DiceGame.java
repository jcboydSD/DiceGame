package dicegame;

/******************************************************************************
 * DiceGame.java 
 * Programmer: @author jcboyd
 * Version 1.3
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
        int diceSum; //sum of simulated rolled dice
        String highLowGuess;
        String evenOddGuess;
        boolean highLowResult;
        boolean evenOddResult;
        String playAgain; //default is to end game unless y or Y

        //Input, Processing, Output
        System.out.println("Dice Prediction Game by JC Boyd\n");

        do //repeat game if user enters y or Y
        {
            do //repeat until valid range guess
            {
                System.out.print("Will the next total be High (H) or Low (L)? ");
                highLowGuess = stdIn.nextLine();
            } while (!highLowGuess.matches("h|H|l|L")); //end do
            
            do //repeat until valid odd or even guess
            {
                System.out.print("Will the total be Even (E) or Odd (O)? ");
                evenOddGuess = stdIn.nextLine();
            } while (!evenOddGuess.matches("e|E|o|O")); //end do
            
            diceSum = rollDiceSum();            
            highLowResult = highLowCheck(diceSum, highLowGuess); //call method to check high or low
            evenOddResult = evenOddCheck(diceSum, evenOddGuess); //call method to check even or odd            
            printResult(diceSum, highLowResult, evenOddResult); //call method to display results 
            System.out.print("Do you want to play again? (y/n) ");
            playAgain = stdIn.nextLine();
        } while (playAgain.matches("y|Y")); //end do

    } //end main
    
    //*************************************************************************
    
    public static int rollDiceSum() //Returns sum of 2 simulated rolled dice
    {
        return ((int)(Math.random() * 6 + 1) + (int)(Math.random() * 6 + 1));                
    } //end rollDiceSum
    
    //*************************************************************************
                
    public static boolean highLowCheck(int diceSum, String highLowGuess)
    //Checks for high or low and compares user's guess to return result
    {
        if ((diceSum > 7) && (highLowGuess.equals("H") || highLowGuess.equals("h"))) 
        {
            return (boolean)(true);
        }
        else if ((diceSum < 7) && (highLowGuess.equals("L") || highLowGuess.equals("l")))
        {
            return (boolean)(true);
        }
        else //In case of wrong guess or when diceSum is 7
        {
            return (boolean)(false);
        } //end if        
    } //end highLowCheck
    
    //*************************************************************************            
                
    public static boolean evenOddCheck(int diceSum, String evenOddGuess)
    //Checks for even or odd and compares user's guess to return result
    {
        if ((diceSum % 2 == 0) && (evenOddGuess.equals("E") || evenOddGuess.equals("e"))) 
        {
            return (boolean)(true);
        }
        else if ((diceSum % 2 != 0) && (evenOddGuess.equals("O") || evenOddGuess.equals("o")))
        {
            return (boolean)(true);
        }
        else
        {
            return (boolean)(false);
        } //end if        
    } //end evenOddCheck
    
    //*************************************************************************            
                
    public static void printResult(int diceSum, boolean highLowResult, boolean evenOddResult)
    //Prints game results based on boolean results
    {
        System.out.printf("The total is %d\n", diceSum);
        if (diceSum == 7)
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
