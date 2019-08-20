package CCT;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Fermin
 * @author Fabricio
 * @author Aldana
 */

public class Data 
{
    private final ArrayList<String> pilotsNames = new ArrayList();
    private final ArrayList<String> pilotsRatings = new ArrayList();
    private final ArrayList<String> airplaneMake = new ArrayList();
    private final ArrayList<String> airbusModels = new ArrayList();
    private final ArrayList<String> boeingModels = new ArrayList();
    private final ArrayList<String> airbusCapacity = new ArrayList();
    private final ArrayList<String> boeingCapacity = new ArrayList();
    private final ArrayList<String> citiesOrigin = new ArrayList(); 
    private final ArrayList<String> citiesDestination = new ArrayList();
    private final ArrayList<String> flightDuration = new ArrayList();
    private final ArrayList<String> datesAvailableSystem = new ArrayList();
    private final ArrayList<String> datesAvailableUser = new ArrayList();
    private final ArrayList<String> departureTimes = new ArrayList();
    private final ArrayList<Pilot> pilotsAssigned = new ArrayList();
    private final ArrayList<String> textFlightsFromFile = new ArrayList();
    
    
    public Data(){}
    
    //This method is used to generate all the data that will support the system
    public void generateAllData()throws FileNotFoundException
    {
        generatePilotsNames();
        generatePilotsRatings();
        generateMake();
        generateAirbusModels();
        generateBoeingModels();
        generateAirbusCapacity();
        generateBoeingCapacity();
        generateOrigins();
        generateDestinations();
        generateFlightDuration();
        generateDatesSystem();
        generateDatesUser();
        generateDepartureTimes();
        
    }
    
    //This method is used to get the duration of a flight from the file according to the combination of "Origin" and "Destination" of the flight
    public int getDurationFlight(String originDestination, ArrayList<String> durations) 
    {
        String duration = "";
        boolean found = false;
        Iterator<String> iter = durations.iterator();
        String curItem = "";
        int pos = 0;

        while (iter.hasNext() == true) 
        {
            pos = pos + 1;
            curItem = (String) iter.next();
            if (curItem.equals(originDestination)) 
            {
                found = true;
                break;
            }
        }

        if (found == false) 
        {
            pos = 0;
        }

        if (pos != 0) 
        {
            duration = durations.get(pos);
            return Integer.parseInt(duration);
        } else {
            return 0;
        }
    }
    
    //This method gets the information about flights stored in a text file as strings and output an ArrayList of Flight objects
    public ArrayList<Flight> getFlightsFromFile() throws FileNotFoundException 
    {
        ArrayList<String> txtFlights = new ArrayList();
        ArrayList<Flight> listFlightsTemp = new ArrayList();

        try (Scanner s = new Scanner(new File("totalflights.txt"))) 
        {
            while (s.hasNextLine()) 
            {
                txtFlights.add(s.nextLine());
            }
        }

        for (int i = 0; i < txtFlights.size(); i++) 
        {
            int sOrig = txtFlights.get(i).indexOf("Origin");
            int sDest = txtFlights.get(i).indexOf("Destination");
            int sDate = txtFlights.get(i).indexOf("Date");
            int sDFlight = txtFlights.get(i).indexOf("Departure");
            int SDepar = txtFlights.get(i).indexOf("Arrival");
            int sArrival = txtFlights.get(i).indexOf("make");
            int sMake = txtFlights.get(i).indexOf("model");
            int sModel = txtFlights.get(i).indexOf("Capacity");
            int sCapacity = txtFlights.get(i).indexOf("seats");
            int sPilot = txtFlights.get(i).indexOf("rating");

            String origin = txtFlights.get(i).substring(sOrig + 8, sDest - 4);
            String destination = txtFlights.get(i).substring(sDest + 13, sDate - 3);
            String dFlight = txtFlights.get(i).substring(sDate + 20, sDFlight - 3);
            String dDepar = txtFlights.get(i).substring(sDFlight + 16, SDepar - 3);
            String dArri = txtFlights.get(i).substring(SDepar + 14, sArrival - 12);
            String make = txtFlights.get(i).substring(sArrival + 6, sMake - 11);
            String model = txtFlights.get(i).substring(sMake + 7, sModel - 1);
            int capacity = Integer.parseInt(txtFlights.get(i).substring(sModel + 10, sCapacity - 1));
            String pilot = txtFlights.get(i).substring(sCapacity + 20, sPilot - 9);
            int rating = Integer.parseInt(txtFlights.get(i).substring(sPilot + 8));
            Pilot p = new Pilot(pilot, rating);
            Airplane a = new Airplane(make, model, capacity, p);
            Flight f = new Flight(origin, destination, dFlight, dDepar, dArri, a);
            listFlightsTemp.add(f);
        }
        return listFlightsTemp;
    }
    
    public void getPilotsAssigned() 
    {

        for (int i = 0; i < this.textFlightsFromFile.size(); i++) 
        {
            Pilot auxP = new Pilot();
            int initialIndex = this.textFlightsFromFile.get(i).indexOf("seats");
            int indexRating = this.textFlightsFromFile.get(i).indexOf("rating");
            String auxPilotName = this.textFlightsFromFile.get(i).substring(initialIndex + 19, indexRating - 9);
            int auxRating = Integer.parseInt(this.textFlightsFromFile.get(i).substring(indexRating + 8));
            auxP.setName(auxPilotName);
            auxP.setRating(auxRating);
            this.pilotsAssigned.add(auxP);
        }
        for (int i = 0; i < this.pilotsAssigned.size(); i++) 
        {
            System.out.println("Pilot ID: " + (i + 1) + " Pilot name: " + this.pilotsAssigned.get(i).getName() + " Rating: " + pilotsAssigned.get(i).getRating());
        }

    }
    
    //All methods starting with the word "generate" are used to get the data from a text file and create an ArrayList that will be used by the other classes in order to create objects.
    
    public void generatePilotsNames() throws FileNotFoundException 
    {
        try (Scanner s = new Scanner(new File("names.txt"))) 
        {
            while (s.hasNextLine()) 
            {
                pilotsNames.add(s.nextLine());
            }
        }
    }
   
    public ArrayList<String> getPilotsNames()
    {
        return pilotsNames;
    }
    
    public void generatePilotsRatings() throws FileNotFoundException
    {
        try (Scanner s = new Scanner(new File("pilotratings.txt"))) 
        {
            while (s.hasNextLine())
            {
                pilotsRatings.add(s.nextLine());
            }
        }
    }
    
    public ArrayList<String> getPilotsRatings()
    {
        
        return pilotsRatings;
    }
    
    public void generateMake() throws FileNotFoundException
    {
        try (Scanner s = new Scanner(new File("makes.txt"))) 
        {
            while (s.hasNextLine())
            {
                airplaneMake.add(s.nextLine());
            }
        }
    }

    public ArrayList<String> getMake()
    {
        return airplaneMake;
    } 
    
    public void generateAirbusModels() throws FileNotFoundException
    {
        try (Scanner s = new Scanner(new File("airbusmodels.txt"))) 
        {
            while (s.hasNextLine()){
                airbusModels.add(s.nextLine());
            }
        }
    }
    
    public ArrayList<String> getAirbusModels(){
        
        return airbusModels;
    }     
    
    public void generateBoeingModels() throws FileNotFoundException
    {
        try (Scanner s = new Scanner(new File("boeingmodels.txt"))) 
        {
            while (s.hasNextLine())
            {
                boeingModels.add(s.nextLine());
            }
        }
    }
    
    public ArrayList<String> getBoeingModels()
    {
        
        return boeingModels;
    }    
    
    public void generateAirbusCapacity() throws FileNotFoundException
    {
        try (Scanner s = new Scanner(new File("airbuscapacity.txt"))) 
        {
            while (s.hasNextLine())
            {
                airbusCapacity.add(s.nextLine());
            }
        }
    }
    
    public ArrayList<String> getAirbusCapacity(){
        
        return airbusCapacity;
    }    

    public void generateBoeingCapacity() throws FileNotFoundException
    {
        try (Scanner s = new Scanner(new File("boeingcapacity.txt"))) 
        {
            while (s.hasNextLine())
            {
                boeingCapacity.add(s.nextLine());
            }
        }
    }
    
    public ArrayList<String> getBoeingCapacity()
    {
        return boeingCapacity;
    }    


    public void generateOrigins() throws FileNotFoundException 
    {
        try (Scanner s = new Scanner(new File("citiesorigin.txt"))) 
        {
            while (s.hasNextLine())
            {
                citiesOrigin.add(s.nextLine());
            }
        }
    }
    
    public ArrayList<String> getOrigin()
    {
        return citiesOrigin;
    } 
    
    public void generateDestinations() throws FileNotFoundException 
    {
        try (Scanner s = new Scanner(new File("citiesdestination.txt")))
        {
            while (s.hasNextLine())
            {
                citiesDestination.add(s.nextLine());
            }
        }
    }
    
    public ArrayList<String> getDestination()
    {
        return citiesDestination;
    }
    
    public void generateFlightDuration() throws FileNotFoundException 
    {
        try (Scanner s = new Scanner(new File("flightduration.txt"))) 
        {
            while (s.hasNextLine())
            {
                flightDuration.add(s.nextLine());
            }
        }
    }
    
    public ArrayList<String> getFlightDuration()
    {
        return flightDuration;
    }

    //This method generates dates available for the System to use when creating Flights.
    public void generateDatesSystem() throws FileNotFoundException
    {
        try (Scanner s = new Scanner(new File("datesavailablesystem.txt"))) 
        {
            while (s.hasNextLine())
            {
                datesAvailableSystem.add(s.nextLine());
            }
        }
    }
    
    public ArrayList<String> getDatesSystem(){
        
        return datesAvailableSystem;
    }

    //This method generates dates available for the User to use when creating Flights.
    public void generateDatesUser() throws FileNotFoundException
    {
        try (Scanner s = new Scanner(new File("datesavailableuser.txt"))) {
            while (s.hasNextLine()){
                datesAvailableUser.add(s.nextLine());
            }
        }
    }
    
    public ArrayList<String> getDatesUser(){
        
        return datesAvailableUser;
    }

    public void generateDepartureTimes() throws FileNotFoundException
    {
        try (Scanner s = new Scanner(new File("departuretimes.txt"))) {
            while (s.hasNextLine()){
                departureTimes.add(s.nextLine());
            }
        }
    }
    
    public ArrayList<String> getDepartureTimes(){
        
        return departureTimes;
    }
    
    public void generateStringFlightsFromFile() throws FileNotFoundException
    {
        try (Scanner s = new Scanner(new File("totalflights.txt"))) {
            while (s.hasNextLine()){
                textFlightsFromFile.add(s.nextLine());
            }
        }    
    }
    
    public ArrayList<String> getTextFlightsFromFile() throws FileNotFoundException{
        this.generateStringFlightsFromFile();
        return textFlightsFromFile;
    }
    
    
 
    

}