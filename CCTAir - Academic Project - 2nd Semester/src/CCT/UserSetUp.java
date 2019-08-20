package CCT;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Fermin
 * @author Fabricio
 * @author Aldana
 */
public class UserSetUp {

    Random rG = new Random();
    Scanner scan = new Scanner(System.in);
    Scanner scan2 = new Scanner(System.in);
    Flight f = new Flight();
    ListSetUp lsu = new ListSetUp();
    AirSetUp su = new AirSetUp();
    int numbFlightsUser = 5; //This variable defines the maximum number of flights allowed for user creation

    public UserSetUp() {}
    
     //Method to give the User a list of Pilots who are able to pilot the Flight the User is creating
    public ArrayList<Pilot> userCreationPilots(ArrayList<Pilot> listPilots, int ratingFlight) 
    {
        ArrayList<Pilot> listPilotsUser = new ArrayList();
        while (listPilotsUser.size() < 6) 
        {
            Pilot pilotRandom = listPilots.get(rG.nextInt(listPilots.size()));

            if (pilotRandom.getRating() == ratingFlight) 
            {
                listPilotsUser.add(pilotRandom);
            }
        }

        return listPilotsUser;

    }
    
    //This method is used to turn the changes made in the list of flights into an array of Strings which will be passed to the method "setListTotalFlights" that will be in charge of updating the text file: "totalflights.txt"
    public void saveChangesToFile(ArrayList<Flight> listFlights) throws FileNotFoundException, IOException 
    {
        String[] txtListFlights = new String[listFlights.size()];
        
        for (int i = 0; i < listFlights.size(); i++)
        {
            txtListFlights[i] = listFlights.get(i).toString();
        }
        lsu.setListTotalFlights(txtListFlights);

    }
    
    //This method is used to add Flights by the user to the list of Total Flights
    public void userFlightCreation(Data d, ListSetUp listSU) throws ParseException, IOException 
    {

        ArrayList<Airplane> listAirplanes = su.airplaneCreation(d);
        ArrayList<Pilot> listPilots = su.piCreation(d);
        ArrayList<Pilot> pilotOptions = new ArrayList();
        ArrayList<Flight> listFlightsTemp = d.getFlightsFromFile();

        System.out.println("\n Please, type in the number of flights you want to add (up to " + numbFlightsUser + "):");

        int nflight = -1;

        //Check if the user chose a valid option
        while (nflight == -1) 
        {
            nflight = scan.nextInt();
            if (nflight < 1 || nflight > numbFlightsUser) 
            {
                System.out.println("\nERROR MESSAGE: You chose and invalid option. Please chose an option between 1 and " + numbFlightsUser + ".");
                nflight = -1;
            }
        }

        String[] listCreatedByUser = new String[nflight];

        for (int counter = 0; counter < nflight; counter++) 
        {
            Flight fAux = new Flight();
            Airplane apAux = new Airplane();
            Pilot p = new Pilot();

            System.out.println("\nSelect one of the options below to create a new Flight\n\nYou are creating Flight Number " + (counter + 1) + ".");
            System.out.println("\nSelect the number corresponding to the Origin:");
            
            for (int i = 0; i < d.getOrigin().size(); i++) 
            {
                System.out.println("(" + (i + 1) + ") " + d.getOrigin().get(i));
            }
            int orig = -1;

            //Check if the user chose a valid option
            while (orig == -1) 
            {
                orig = scan.nextInt() - 1;
                if (orig < 0 || orig > d.getOrigin().size() - 1) 
                {
                    System.out.println("\nERROR MESSAGE: You chose and invalid option. Please chose an option between 1 and " + d.getOrigin().size() + ".");
                    orig = -1;
                }
            }
            String origin = d.getOrigin().get(orig);

            System.out.println("\nSelect the number corresponding to the Destination");
            for (int i = 0; i < d.getDestination().size(); i++) 
            {
                System.out.println("(" + (i + 1) + ") " + d.getDestination().get(i));
            }

            int dest = -1;

            //Check if the user chose a valid option
            while (dest == -1) 
            {
                dest = scan.nextInt() - 1;
                if (dest < 0 || dest > d.getDestination().size() - 1) 
                {
                    System.out.println("\nERROR MESSAGE: You chose and invalid option. Please chose an option between 1 and " + d.getDestination().size() + ".");
                    dest = -1;
                }
            }
            String destination = d.getDestination().get(dest);

            System.out.println("\nSelect the number corresponding to the date of Flight");
            for (int i = 0; i < d.getDatesUser().size(); i++) 
            {
                System.out.println("(" + (i + 1) + ") " + d.getDatesUser().get(i));
            }
            int dFlight = -1;

            //Check if the user chose a valid option
            while (dFlight == -1) 
            {
                dFlight = scan.nextInt() - 1;
                if (dFlight < 0 || dFlight > d.getDatesUser().size() - 1) 
                {
                    System.out.println("\nERROR MESSAGE: You chose and invalid option. Please chose an option between 1 and " + d.getDatesUser().size() + ".");
                    dFlight = -1;
                }
            }

            String dateFlight = d.getDatesUser().get(dFlight);

            System.out.println("\nSelect the number corresponding to the departure time");
            for (int i = 0; i < d.getDepartureTimes().size(); i++) 
            {
                System.out.println("(" + (i + 1) + ") " + d.getDepartureTimes().get(i));
            }

            int dTime = -1;

            //Check if the user chose a valid option
            while (dTime == -1) 
            {
                dTime = scan.nextInt() - 1;
                if (dTime < 0 || dTime > d.getDepartureTimes().size() - 1) {
                    System.out.println("\nERROR MESSAGE: You chose and invalid option. Please chose an option between 1 and " + d.getDepartureTimes().size() + ".");
                    dTime = -1;
                }
            }

            String depTime = d.getDepartureTimes().get(dTime);

            String arrTime = fAux.calculateArrivalTime(depTime, origin, destination, d);

            fAux.setOrigin(origin);
            fAux.setDestination(destination);
            fAux.setDateFlight(dateFlight);
            fAux.setDepartureTime(depTime);
            fAux.setArrivalTime(arrTime);

            String originDestination = origin + destination;
            int hoursFlight = d.getDurationFlight(originDestination, d.getFlightDuration());
            int ratingFlight = 0;

            //Check if the user chose a valid option
            while (ratingFlight == 0) 
            {

                Airplane airplaneRandom = listAirplanes.get(rG.nextInt(listAirplanes.size()));
                ratingFlight = fAux.assignFlightRating(airplaneRandom, hoursFlight);
                apAux = airplaneRandom;
                fAux.setAirplane(airplaneRandom);
            }

            pilotOptions = this.userCreationPilots(listPilots, ratingFlight);

            System.out.println("\nSelect the number corresponding to the Pilot you want to assign for this Flight:");
            for (int i = 0; i < pilotOptions.size(); i++) 
            {
                System.out.println("(" + (i + 1) + ") " + pilotOptions.get(i));
            }

            int uPilot = -1;

            //Check if the user chose a valid option
            while (uPilot == -1) 
            {
                uPilot = scan.nextInt() - 1;
                if (uPilot < 0 || uPilot > pilotOptions.size() - 1) 
                {
                    System.out.println("\nERROR MESSAGE: You chose and invalid option. Please chose an option between 1 and " + pilotOptions.size() + ".");
                    uPilot = -1;
                }
            }

            p = pilotOptions.get(uPilot);
            apAux.assignPilot(p);

            listCreatedByUser[counter] = fAux.toString();
            listFlightsTemp.add(fAux);
            System.out.println("\n------------------------------------------------");
            System.out.println("|Flight number " + (counter + 1) + " has been created succesfully    |");
            System.out.println("------------------------------------------------\n");
        }

        listSU.setListCreated(listCreatedByUser);
        listSU.getListCreated();
        this.saveChangesToFile(listFlightsTemp);

        System.out.println("\n-------------------------------------------------------------------");
        System.out.println("|        ALL YOUR FLIGHTS WERE SUCCESFULLY CREATED                |");
        System.out.println("-------------------------------------------------------------------");

    }

    //This method is called from the MAIN MENU to allow the user change the Arrival time of a flight.
    public void modifyArrivalTime(Data d) throws FileNotFoundException, IOException, ParseException 
    {

        ArrayList<Flight> listFlights = new ArrayList();
        d.generateStringFlightsFromFile();
        listFlights = d.getFlightsFromFile();

        for (int i = 0; i < listFlights.size(); i++) 
        {
            System.out.println("Flight ID: " + (i + 1) + listFlights.get(i).toString());
        }
        System.out.println("\nType in the ID from the Flight you want to change: ");

        int idFlight = -1;

        //Check if the user chose a valid option
        while (idFlight == -1) 
        {
            idFlight = scan.nextInt() - 1;
            if (idFlight < 0 || idFlight > listFlights.size() - 1) 
            {
                System.out.println("\nERROR MESSAGE: You chose and invalid flight. Please chose a Flight between 1 and " + listFlights.size() + ".");
                idFlight = -1;
            }
        }

        int showID = idFlight + 1;
        System.out.println("\nYou chose flight: \n" + "Flight ID: " + showID + listFlights.get(idFlight).toString());

        int test = 0;
        String newArriTime = null;

        //While loop if the user typed an arrival time that is earlier than the departure time. A method is useds to do the check.
        while (test == 0) 
        {
            System.out.println("\nWrite new Arrival time Format (hh:mm) (Previous Arrival Time: " + listFlights.get(idFlight).getArrivalTime() + ")");
            newArriTime = scan2.nextLine();
            String previousDepTime = listFlights.get(idFlight).getDepartureTime();
            test = f.checkTime(newArriTime, previousDepTime);//Method used to check if arrival time is earlier than the departure time
            if (test == 0) 
            {
                System.out.println("\nERROR MESSAGE: Please, type in an Arrival time later than Departure Time.");
            }
        }
        listFlights.get(idFlight).schedule(newArriTime);

        System.out.println("---------------------------------------------------");
        System.out.println("|          Arrival time has been changed           |");
        System.out.println("---------------------------------------------------");

        System.out.println("\nFlight ID: " + showID + listFlights.get(idFlight).toString());
        System.out.println("---------------------------------------------------");

        this.saveChangesToFile(listFlights);

    }

    //This method is called from the MAIN MENU to allow the user change the Departure and Arrival times of a flight.
    public void modifyDepartureArrivalTime(Data d) throws FileNotFoundException, IOException, ParseException 
    {

        ArrayList<Flight> listFlights = new ArrayList();
        d.generateStringFlightsFromFile();
        listFlights = d.getFlightsFromFile();

        for (int i = 0; i < listFlights.size(); i++) 
        {
            System.out.println("Flight ID: " + (i + 1) + listFlights.get(i).toString());
        }
        System.out.println("\nType in the ID from the Flight you want to change: ");
        int idFlight = -1;

        //Check if the user chose a valid option
        while (idFlight == -1) 
        {
            idFlight = scan.nextInt() - 1;
            if (idFlight < 0 || idFlight > listFlights.size() - 1) 
            {
                System.out.println("\nERROR MESSAGE: You chose and invalid flight. Please chose a Flight between 1 and " + listFlights.size() + ".");
                idFlight = -1;
            }
        }
        int showID = idFlight + 1;
        System.out.println("\nYou chose flight: \n" + "Flight ID: " + showID + listFlights.get(idFlight).toString() + "\n");
        System.out.println("\nWrite new Departure time Format (hh:mm) (Actual Departure Time: " + listFlights.get(idFlight).getDepartureTime() + ")");

        String newDepTime = scan2.nextLine();
        int test = 0;
        String newArriTime = null;

        //Check if the user chose a valid option
        while (test == 0) 
        {
            System.out.println("\nWrite new Arrival time Format (hh:mm) (Previous Arrival Time: " + listFlights.get(idFlight).getArrivalTime() + ")");
            newArriTime = scan2.nextLine();
            test = f.checkTime(newArriTime, newDepTime);
            if (test == 0) 
            {
                System.out.println("\nERROR MESSAGE: Please, type in an Arrival time later than Departure Time.");
            }
        }
        listFlights.get(idFlight).schedule(newArriTime, newDepTime);

        System.out.println("-------------------------------------------------------------------");
        System.out.println("|          Departure and Arrival times have been changed           |");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("\nFlight ID: " + showID + listFlights.get(idFlight).toString());
        System.out.println("---------------------------------------------------");

        this.saveChangesToFile(listFlights);

    }

    

    

   
}
