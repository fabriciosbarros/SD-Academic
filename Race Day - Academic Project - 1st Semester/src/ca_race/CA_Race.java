package ca_race;
import java.util.Scanner;
import java.util.Random;

public class CA_Race 
{
    public static void main(String[] args)
    {
        // Creating Scanner and Random items to be used further
        Scanner nameInput = new Scanner(System.in);
        Scanner numberInput = new Scanner(System.in);
        Random randGen = new Random();
        
        
        // Declaring initial value for the variables used for Players' names
        String playerOne = " ";
        String playerTwo = " ";
        String playerThree = " ";
        String playerFour = " ";
        
        // Declaring initial value for the variables used for Players' chosen number
        int numOne = 0;
        int numTwo = 0;
        int numThree = 0;
        int numFour = 0;
        
        // Declaring initial value for the variables used for Players' scores
        int scoreOne = 0;
        int scoreTwo = 0;
        int scoreThree = 0;
        int scoreFour = 0;
        
        //Declaring initial value for Player's operator randomically chosen
        int randOpOne = 0;
        int randOpTwo = 0;
        int randOpThree = 0;
        int randOpFour = 0;
        
        //Declaring initial value for Player's random number
        int randOne = 0;
        int randTwo = 0;
        int randThree = 0;
        int randFour = 0;
        
        //Declaring initial value for Leaderboard'' scores
        int firstPlaceScore = 0;
        int secondPlaceScore = 0;
        int thirdPlaceScore = 0;
        int fourthPlaceScore = 0;
                
        //Declaring initial value for Leaderboard's names
        String firstPlaceName = " ";
        String secondPlaceName = " ";
        String thirdPlaceName = " ";
        String fourthPlaceName = " ";
                
        //Declaring a variable that will be the race position for each Player
        final String position = ".";
        
        //Declaring variables to be used to randomically choose a number in case of draw
        int randDrawOne = 0;
        int randDrawTwo = 0;
        int randDrawThree = 0;
        int randDrawFour = 0;
        
        // Welcome message and get Players names
        System.out.println("Welcome to the 4 Players Race!");
        System.out.println(" "); //This lines are used to just create a space line between the previous content and the next content
        
        
        System.out.println("Please, type in each Player's name.");
        System.out.println(" ");
        
        
        System.out.println("Please, type in Player 1 name:");
        playerOne = nameInput.nextLine();
        System.out.println("Please, type in Player 2 name:");
        playerTwo = nameInput.nextLine();
        System.out.println("Please, type in Player 3 name:");
        playerThree = nameInput.nextLine();
        System.out.println("Please, type in Player 4 name:");
        playerFour = nameInput.nextLine();
        System.out.println(" ");
        
        // Instructions for each player choose a number and get each chosen number for each player
        System.out.println("Thank you! Now, to begin the race, each Player needs to enter a number between 1 and 10.");
        System.out.println(" ");
        
        
        System.out.println(playerOne+", please, type in a number from 1 to 10:");
        numOne = numberInput.nextInt();
        System.out.println(playerTwo+", please, type in a number from 1 to 10:");
        numTwo = numberInput.nextInt();
        System.out.println(playerThree+", please, type in a number from 1 to 10:");
        numThree = numberInput.nextInt();
        System.out.println(playerFour+", please, type in a number from 1 to 10:");
        numFour = numberInput.nextInt();
        
        /* Generation of random operation to compose the calculation for each Player's Score.
        addition = 1;
        substraction = 2;
        multiplication = 3;*/
        randOpOne = randGen.nextInt(3)+1;
        randOpTwo = randGen.nextInt(3)+1;
        randOpThree = randGen.nextInt(3)+1;
        randOpFour = randGen.nextInt(3)+1;
        
        
        // Check if the number chosen is equal to 1 before generating random number to automatically assign "1" because if the operator is "-", the result would be "0", which is an invalid number for the game.
        
        if (numOne == 1)
        {
            scoreOne = 1;
        }
        
        else
        {
            randOne = randGen.nextInt(numOne-1)+1;
            
            switch(randOpOne)
            {
                case 1 : scoreOne = numOne + randOne;
                break;
                
                case 2 : scoreOne = numOne - randOne;
                break;
                
                case 3 : scoreOne = numOne * randOne;
                break;
                
                default: System.out.println("Invalid input");
            }
        }
       
        if (numTwo == 1)
        {
            scoreTwo = 1;
        }
        
        else
        {
            randTwo = randGen.nextInt(numTwo-1)+1;
            
            switch(randOpTwo)
            {
                case 1 : scoreTwo = numTwo + randTwo;
                break;
                
                case 2 : scoreTwo = numTwo - randTwo;
                break;
                
                case 3 : scoreTwo = numTwo * randTwo;
                break;
                
                default: System.out.println("Invalid input");
            }
        }
        
        if (numThree == 1)
        {
            scoreThree = 1;
        }
        
        else
        {
            randThree = randGen.nextInt(numThree-1)+1;
          
            switch(randOpThree)
            {
                case 1 : scoreThree = numThree + randThree;
                break;
                
                case 2 : scoreThree = numThree - randThree;
                break;
                
                case 3 : scoreThree = numThree * randThree;
                break;

                default: System.out.println("Invalid input");
            }
        }
        
        if (numFour == 1)
        {
            scoreFour = 1;
        }
        
        else
        {
            randFour = randGen.nextInt(numFour-1)+1;
          
            switch(randOpFour)
            {
                case 1 : scoreFour = numFour + randFour;
                break;
                
                case 2 : scoreFour = numFour - randFour;
                break;
                
                case 3 : scoreFour = numFour * randFour;
                break;
                
                default: System.out.println("Invalid input");
            }
        }
        
        //Draw treatment. When a draw occurs, a new number from 1 to 10 will be randomically generated and added to each score until there's no more draw
        
        while(scoreOne==scoreTwo || scoreOne == scoreThree || scoreOne == scoreFour || scoreTwo == scoreThree || scoreTwo == scoreFour        || scoreThree == scoreFour)
        {
            
            randDrawOne = randGen.nextInt(10-1)+1;
            randDrawTwo = randGen.nextInt(10-1)+1;
            randDrawThree = randGen.nextInt(10-1)+1;
            randDrawFour = randGen.nextInt(10-1)+1;
        
            scoreOne = scoreOne + randDrawOne;
            scoreTwo = scoreTwo + randDrawTwo;
            scoreThree = scoreThree + randDrawThree;
            scoreFour = scoreFour + randDrawFour;
        
        }
        
        System.out.println(" ");
        System.out.println("Here's the final race position for each player:");
        System.out.println(" ");
      
        // Check the final score for each Player and add 1 chosen character (e.g.: ".") for each point scored by each player
        for (int i=0; i < scoreOne;i++)
        {
            System.out.print(position);
        }
        
        System.out.println(" "+playerOne+" "+scoreOne);
      
        for (int i=0; i < scoreTwo;i++)
        {
            System.out.print(position);
        }
      
        System.out.println(" "+playerTwo+" "+scoreTwo);
      
        for (int i=0; i < scoreThree;i++)
        {
            System.out.print(position);
        }
      
        System.out.println(" "+playerThree+" "+scoreThree);
      
        for (int i=0; i < scoreFour;i++)
        {
            System.out.print(position);
        }
      
        System.out.println(" "+playerFour+" "+scoreFour);
        System.out.println(" ");
      
        //Creating Leaderboard
        
        //First Place:
        
        if (scoreOne > firstPlaceScore)
        {
            firstPlaceScore = scoreOne;
            firstPlaceName = playerOne;
        }
        
        if (scoreTwo > firstPlaceScore)
        {
            firstPlaceScore = scoreTwo;
            firstPlaceName = playerTwo;
        }
        
        if (scoreThree > firstPlaceScore)
        {
            firstPlaceScore = scoreThree;
            firstPlaceName = playerThree;
        }
        
        if (scoreFour > firstPlaceScore)
        {
            firstPlaceScore = scoreFour;
            firstPlaceName = playerFour;
        }
        
        //Second Place
        if (scoreOne > secondPlaceScore && scoreOne < firstPlaceScore)
        {
            secondPlaceScore = scoreOne;
            secondPlaceName = playerOne;
        }
        
        if (scoreTwo > secondPlaceScore && scoreTwo < firstPlaceScore)
        {
            secondPlaceScore = scoreTwo;
            secondPlaceName = playerTwo;
        }
        
        if (scoreThree > secondPlaceScore && scoreThree < firstPlaceScore)
        {
            secondPlaceScore = scoreThree;
            secondPlaceName = playerThree;
        }
        
        if (scoreFour > secondPlaceScore && scoreFour < firstPlaceScore)
        {
            secondPlaceScore = scoreFour;
            secondPlaceName = playerFour;
        }
        
        //Third Place
        if (scoreOne > thirdPlaceScore && scoreOne < secondPlaceScore)
        {
            thirdPlaceScore = scoreOne;
            thirdPlaceName = playerOne;
        }
        
        if (scoreTwo > thirdPlaceScore && scoreTwo < secondPlaceScore)
        {
            thirdPlaceScore = scoreTwo;
            thirdPlaceName = playerTwo;
        }
        
        if (scoreThree > thirdPlaceScore && scoreThree < secondPlaceScore)
        {
            thirdPlaceScore = scoreThree;
            thirdPlaceName = playerThree;
        }
        
        if (scoreFour > thirdPlaceScore && scoreFour < secondPlaceScore)
        {
            thirdPlaceScore = scoreFour;
            thirdPlaceName = playerFour;
        }
        
        //Fourth Place
        if (scoreOne > fourthPlaceScore && scoreOne < thirdPlaceScore)
        {
            fourthPlaceScore = scoreOne;
            fourthPlaceName = playerOne;
        }
        
        if (scoreTwo > fourthPlaceScore && scoreTwo < thirdPlaceScore)
        {
            fourthPlaceScore = scoreTwo;
            fourthPlaceName = playerTwo;
        }
        
        if (scoreThree > fourthPlaceScore && scoreThree < thirdPlaceScore)
        {
            fourthPlaceScore = scoreThree;
            fourthPlaceName = playerThree;
        }
        
        if (scoreFour > fourthPlaceScore && scoreFour < thirdPlaceScore)
        {
            fourthPlaceScore = scoreFour;
            fourthPlaceName = playerFour;
        }
        
        //Showing first and second places
        System.out.println("Winner: "+firstPlaceName+" with "+firstPlaceScore+" steps");
        System.out.println("Runner up: "+secondPlaceName+" with "+secondPlaceScore+" steps");
        System.out.println(" ");
        
        //Showing Leaderboard
        System.out.println("LEADERBOARD:");
        System.out.println("1st: "+firstPlaceName+" "+firstPlaceScore+" steps");
        System.out.println("2nd: "+secondPlaceName+" "+secondPlaceScore+" steps");
        System.out.println("3rd: "+thirdPlaceName+" "+thirdPlaceScore+" steps");
        System.out.println("4th: "+fourthPlaceName+" "+fourthPlaceScore+" steps");
        System.out.println(" ");
        
        //Welcome message to the final round
        System.out.println("Now welcome to the final round: "+firstPlaceName+" vs "+secondPlaceName);
        System.out.println(" ");
        
        //Final Round
        System.out.println(firstPlaceName+", please, type in a number from 1 to 10:");
        firstPlaceScore = numberInput.nextInt();
        System.out.println(secondPlaceName+", please, type in a number from 1 to 10:");
        secondPlaceScore = numberInput.nextInt();
        System.out.println(" ");
        
        /*Generating random operation for the final Round
        addition = 1;
        substraction = 2;
        multiplication = 3;*/
        randOpOne = randGen.nextInt(3)+1;
        randOpTwo = randGen.nextInt(3)+1;
        
        // Check if the number chosen is equal to 1 before generating random number to automatically assign "1" because if the operator is "-", the result would be "0", which is an invalid number for the game.
        
        if (firstPlaceScore == 1)
        {
            firstPlaceScore = 1;
        }
        
        else
        {
            randOne = randGen.nextInt(firstPlaceScore-1)+1;
            
            switch(randOpOne)
            {
                case 1 : firstPlaceScore = firstPlaceScore + randOne;
                break;
                
                case 2 : firstPlaceScore = firstPlaceScore - randOne;
                break;
                
                case 3 : firstPlaceScore = firstPlaceScore * randOne;
                break;
                
                default: System.out.println("Invalid input");
            }
        }
       
        if (secondPlaceScore == 1)
        {
            secondPlaceScore = 1;
        }
        
        else
        {
            randTwo = randGen.nextInt(secondPlaceScore-1)+1;
            
            switch(randOpTwo)
            {
                case 1 : secondPlaceScore = secondPlaceScore + randTwo;
                break;
                
                case 2 : secondPlaceScore = secondPlaceScore - randTwo;
                break;
                
                case 3 : secondPlaceScore = secondPlaceScore * randTwo;
                break;
                
                default: System.out.println("Invalid input");
            }
        }
        
        //Draw treatment. When a draw occurs, a new number from 1 to 10 will be randomically generated and added to each score until there's no more draw
        
        for(int i=0;firstPlaceScore==secondPlaceScore;i++)
        {
            randDrawOne = randGen.nextInt(10-1)+1;
            randDrawTwo = randGen.nextInt(10-1)+1;
        
            firstPlaceScore = firstPlaceScore + randDrawOne;
            secondPlaceScore = secondPlaceScore + randDrawTwo;
        
        }
        
        // Check the final score for each Player and add 1 chosen character (e.g.: ".") for each point scored by each player
        
        System.out.println(" ");
        System.out.println("Here's the final race position for each player:");
        System.out.println(" ");
        for (int i=0; i<firstPlaceScore;i++)
        {
            System.out.print(position);
        }
        
        System.out.println(" "+firstPlaceName+" "+firstPlaceScore);
      
        for (int i=0; i<secondPlaceScore;i++)
        {
            System.out.print(position);
        }
      
        System.out.println(" "+secondPlaceName+" "+secondPlaceScore);
      
        
        System.out.println(" ");
      

        //Showing first and second places
        
        if (secondPlaceScore>firstPlaceScore)
        {
            System.out.println("Winner: "+secondPlaceName+" with "+secondPlaceScore+" steps");
            System.out.println("Runner up: "+firstPlaceName+" with "+firstPlaceScore+" steps");
            System.out.println(" ");
        }
        
        else
        {
            System.out.println("Winner: "+firstPlaceName+" with "+firstPlaceScore+" steps");
            System.out.println("Runner up: "+secondPlaceName+" with "+secondPlaceScore+" steps");
            System.out.println(" ");
        }
       
    }
}
