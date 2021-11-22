/*
Tom Lazore
Project 4 Guessing Game
This program asks the user to input a number between a specific range until it enters the correct number.
Exceptions are used if user doesn't enter an integer or enters a value outside of the correct range.
*/

import java.util.*;//imports scanner, exceptions, and random function


class Guess{
   public static void main(String[]args){
      Scanner keyboard = new Scanner(System.in);      
      Random rand = new Random();
      //sets variables
      int min = 1;
      int max = 100;
      int newGuess = 1;
      int hiddenAnswer;
      int numGuesses = 0;
      int totalCount = 0;
      int validCount = 0;
      boolean valid = false;
      //creates random number
      hiddenAnswer = rand.nextInt(max) + min;
      
      System.out.println("Welcome to my number guessing game. I am thinking of a number between 1 and 100.");
      System.out.println("You job is to enter numbers between the correct range to find the secret number.");
      System.out.println("How many guesses will it take you to find the number?");
      System.out.println();

      //loop continues until valid is true and guess is between min and max
      while((!valid) && (newGuess >= min || newGuess <= max)){
         System.out.print("Pick a number between " + min + " and " + max + ": ");
         
         try{
            newGuess = keyboard.nextInt();//user inputs a number
            int result = high_or_low(hiddenAnswer,newGuess, min, max);//sends parameters to high_or_low method
            //runs if value is outside of the range
            if(newGuess < min || newGuess > max) {
               totalCount++;
               throw new Exception("Value outside of Range");
            }
            //keeps track of amount of guesses
            validCount++;
            totalCount++;
            //runs if user guess is lower than secret number
            if (result < 0){
               min = newGuess + 1;
               System.out.println("Guess is too low");
               }
            //runs if user guess is higher than number   
            else if (result > 0){
               max = newGuess - 1;
               System.out.println("Guess is too High");
               }
            //runs if user guess correctly
            else if (result == 0){
               System.out.println("You win! It took you " + validCount + " valid guesses and " + totalCount + " total guesses.");
               valid = true;//ends the loop
               System.out.println("Thanks for playing!");
               }
            
         }
         //runs if user inputs a value other than an integer
         catch (InputMismatchException e){
            System.out.println("Invalid Entry: Enter integers only.");
            totalCount++;
            keyboard.next();
         }
         //runs as a catch all exception
         catch (Exception e) { 
            totalCount++;
            System.out.println(e.getMessage());
         }
      
     
         }//end while
      
   }//end main
   
   public static int high_or_low(int hiddenAnswer, int newGuess, int min, int max){
      //returns new min and max parameters
      int result;
      if(hiddenAnswer > newGuess){
         result = newGuess - hiddenAnswer;
 
      }
      else if(hiddenAnswer < newGuess){
         result = newGuess - hiddenAnswer;
        
      }
      else{
         result = hiddenAnswer - newGuess;
      }
      return result;
      
   
   }// end high_or_low
   
  
}//end Class