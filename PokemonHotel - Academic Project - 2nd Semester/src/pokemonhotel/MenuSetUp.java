package pokemonhotel;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author Aldana
 * @author Fabricio
 * @author Fermin
 *
 */

//This class manages the subMenus 
public class MenuSetUp  
{
    ReadData readData=new ReadData();
    Scanner scan = new Scanner(System.in);
    
    public void case1() throws IOException, IOException
    {
        System.out.println("\n\n");
        System.out.println("POKEMON GROUP SEEKING ROOMS:");
        readData.getData("PokemonAccommodated.txt");
    }
    
    public void case2() throws IOException
    {
        System.out.println("\n\n");
        System.out.println("POKEMON GROUP ACCOMMODATED:");
        readData.getData("getIn.txt");
    }
    
    public void case3() throws IOException
    {
        System.out.println("\n\n");
        System.out.println("POKEMON GROUP NO ACCOMODATED:");
        readData.getData("getOut.txt");
    }
    
    public void case4() throws IOException
    {
        System.out.println("\n\n");
        System.out.println("POKEMON ASSISTENT ASIGNED:");
        readData.getData("assignedPAs.txt");
    }
    
    public void case5() throws IOException
    {
        System.out.println("\n\n");
        System.out.println("POKEMON ASSISTENT NO ASIGNED:");
        readData.getData("unassignedPAs.txt");
    }
    
    public void case6() throws IOException
    {
        System.out.println("\n\n");
        System.out.println("ROOMS FILLED:");
        readData.getData("getFilledRooms.txt");
    }
    
    public void case7(Accomodation acc) throws IOException
    {
        System.out.println("\n\n");
        System.out.println("PERSONAL ASSISTANTS & POKEMON ASSIGNED:");
        acc.perAssiPoke();
    }
    
    public void case8(Accomodation acc)
    {
        System.out.println("\n\n");
        System.out.println("ROOMS OCCUPIED:");
        acc.displayFilledRoom();
        System.out.print("Please choose the ID corresponding to the room you want to check:");
        int optionChosen = scan.nextInt();
        acc.displayPartRoom(optionChosen);
    }
    
    public void case9(Accomodation acc)
    {
        System.out.println("\n\n");
        System.out.println("GENETIC STAMPS:");
        acc.displayGeneticStamp();
        System.out.print("Please choose the ID corresponding to the genetic stamp you want to check:");
        int optionChosen2 = scan.nextInt();
        acc.particularPoke(optionChosen2);
    }
    
    public void turnDown()
    {
        System.out.println("\n\n");
        System.out.println("TURN DOWN");
        System.exit(0);
    }
    
    public void error()
    {
        System.out.println("\n\n============================================================");
        System.err.println("You have chosen an ivalid option. Please, try again.");
    }
}
