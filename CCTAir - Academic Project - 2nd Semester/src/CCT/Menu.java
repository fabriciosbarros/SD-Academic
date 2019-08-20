package CCT;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;
/**
 *
 * @author Fermin
 * @author Fabricio
 * @author Aldana
 */
public class Menu {
    

    public Menu(Data d, AirSetUp su, ListSetUp listSU) throws ParseException, FileNotFoundException, IOException 
    {

        String choice = null;
        Scanner scan = new Scanner(System.in);
        UserSetUp usu = new UserSetUp();

        System.out.println("Welcome to CCtAir Co. \nMENU\n");
        System.out.println("\nSelect one option:");
        System.out.println("(1) Show the initially created flights");
        System.out.println("(2) Add new flights");
        System.out.println("(3) Change Arrival Time for a flight");
        System.out.println("(4) Change Arrival and Departure Times for a flight");
        System.out.println("(5) Show all the flights");
        System.out.println("(6) Show all the pilots available");
        System.out.println("(7) Quit");

        do {
            choice = scan.nextLine();
            switch (choice) 
            {
                case "1": 
                {
                    listSU.getList();
                    new Menu(d, su, listSU);
                    break;
                }
                case "2": 
                {
                    usu.userFlightCreation(d, listSU);
                    new Menu(d, su, listSU);
                    break;
                }
                case "3": 
                {
                    usu.modifyArrivalTime(d);
                    new Menu(d, su, listSU);
                    break;
                }
                case "4": 
                {
                    usu.modifyDepartureArrivalTime(d);
                    new Menu(d, su, listSU);
                    break;
                }
                case "5": 
                {
                    listSU.getTotalList();
                    new Menu(d, su, listSU);
                    break;
                }
                case "6": 
                {
                    d.generateStringFlightsFromFile();
                    d.getPilotsAssigned();
                    new Menu(d, su, listSU);
                    break;
                }
                case "7": 
                {
                    System.exit(0);
                }
                default: 
                {
                    System.out.println("\nERROR MESSAGE: You chose and invalid option. Please, try again.\n");
                    new Menu(d, su, listSU);
                    break;
                }

            } // end of switch

        } while (!choice.equals("7")); // end of loop do-while

    }

}
