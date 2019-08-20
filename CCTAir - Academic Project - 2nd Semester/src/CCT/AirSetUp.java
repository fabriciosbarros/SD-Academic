package CCT;

import java.io.IOException;
import java.text.ParseException;
import java.util.Random;
import java.util.ArrayList;

/**
 *
 * @author Fermin
 * @author Fabricio
 * @author Aldana
 */
public class AirSetUp 
{
    Random rG = new Random();
    
    
    //Method to create Airplanes using the data file 
    public ArrayList<Airplane> airplaneCreation(Data d)
    {    
        //Array list to store the list of Airplanes created
        ArrayList<Airplane> listAirplanes = new ArrayList();

        //Creation of 30 airplanes, setting randomly their make, model and capacity (respectevly)  
        for (int i = 0; i < 30; i++) 
        {
            Airplane ap = new Airplane();
            
            //Creation of a String Variable, to get the airplane make (it gets randomly from data file)
            String airMake = d.getMake().get(rG.nextInt(d.getMake().size()));
            ap.setMake(airMake);                   
                      
            //IF statement to set the model and capacity of each plane taking into account its make
            if("Airbus".equals(airMake))
            {
                int listNumber = rG.nextInt(d.getAirbusModels().size());
                ap.setModel(d.getAirbusModels().get(listNumber));
                ap.setCapacity(Integer.parseInt(d.getAirbusCapacity().get(listNumber)));
            }else //if it is Boeing 
            {                     
                int listNumber = rG.nextInt(d.getBoeingModels().size());
                ap.setModel(d.getBoeingModels().get(listNumber));
                ap.setCapacity(Integer.parseInt(d.getBoeingCapacity().get(listNumber)));                
            }
            listAirplanes.add(ap);
        }
            return listAirplanes;
    }


    //Method to create Pilots using the data file
    public ArrayList<Pilot> piCreation(Data d)
    {
        //Array list to store the list of Pilots created      
        ArrayList<Pilot> listPilots = new ArrayList();

        //Creation of 100 Pilots, setting randomly their name and rating
        for (String pilot1 : d.getPilotsNames()) {
            Pilot p = new Pilot();
            p.setName(pilot1);
            int rating = Integer.parseInt(d.getPilotsRatings().get(rG.nextInt(d.getPilotsRatings().size())));
            p.setRating(rating);
            listPilots.add(p);
        }

        return listPilots;
    }
    
    
    //Method to create Flights with the Planes and Pilots created, and also using the data file
    public Flight fill(Flight f, ArrayList<Airplane> listAirplanes, ArrayList<Pilot> listPilots, Data d) throws ParseException
    {
        int hoursFlight = -1; //This flag is going to be used until we get a random time with the correct Departure and Arrival hours. At the same time it will show the hours of difference.
        int ratingFlight = 0;//This flag is going to be use until we get a random Airplane with the correct Capacity and the corresponding hours for flight.

        //If doesnt find any origin, sets one randomically from data file
        if (f.getOrigin() == null) 
        {
            f.setOrigin(d.getOrigin().get(rG.nextInt(d.getOrigin().size())));
        }
        
        //If doesnt find any destination, sets one randomically from data file
        if (f.getDestination() == null) 
        {
            f.setDestination(d.getDestination().get(rG.nextInt(d.getDestination().size())));
        }

        //Loop to get the time of the Flights
        while (hoursFlight == -1) 
        {
            String depTime = f.getDepartureTime();
            
            //If doesnt find any departure time, sets one randomically from data file
            if (f.getDepartureTime() == null) 
            {
                depTime = d.getDepartureTimes().get(rG.nextInt(d.getDepartureTimes().size()));
                f.setDepartureTime(depTime);
            }

            //If doesnt find any arrival time, sets one 
            if (f.getArrivalTime() == null) 
            {
                String originDestination = f.getOrigin()+f.getDestination();
                hoursFlight = d.getDurationFlight(originDestination, d.getFlightDuration());
                //calculates the arrival time 
                String arrTime = f.calculateArrivalTime(depTime, f.getOrigin(), f.getDestination(), d);
                f.setArrivalTime(arrTime);
            }
            
        }
        
        //If doesnt find any origin, sets one randomically from data file
        if (f.getdateFlight() == null) 
        {
            f.setDateFlight(d.getDatesSystem().get(rG.nextInt(d.getDatesSystem().size())));
        }

        //Loop to assigne a Pilot which has to match with the flight rating
        while (ratingFlight == 0) 
        {
            Airplane airplaneRandom = listAirplanes.get(rG.nextInt(listAirplanes.size()));
            ratingFlight = f.assignFlightRating(airplaneRandom, hoursFlight);
            if (ratingFlight != 0) 
            {
                Pilot pilotRandom = listPilots.get(rG.nextInt(listPilots.size()));
                for (int i = 0; i < listPilots.size(); i++) 
                {
                    if (airplaneRandom.getPilot() == null) 
                    {
                        if (ratingFlight == 1) 
                        {
                            airplaneRandom.assignPilot(pilotRandom);
                        } else if (ratingFlight == pilotRandom.getRating()) 
                        {
                            airplaneRandom.assignPilot(pilotRandom);
                        } else 
                        {
                            pilotRandom = listPilots.get(rG.nextInt(listPilots.size()));
                        }
                    }
                }
            f.setAirplane(airplaneRandom);
            }
        }    
            return f;
    }
    
    
    //Method to create the initial flights(Created by the programme) and store them in a text file
    public void systemFlightCreation(Data d, ListSetUp listSU) throws ParseException, IOException
    {
        int numberInitialFlights = 30;
        String[] listSystemInit = new String[numberInitialFlights];
        String[] listUserInit = new String[0];//As we have a different repository for flights created by user, this is an initial list of user flights with 0 flights.
        ArrayList<Airplane> listAirplanes = this.airplaneCreation(d);
        ArrayList<Pilot> listPilots = this.piCreation(d);

        for (int i = 0; i < numberInitialFlights; i++) 
        {
            Flight flightSetUp = new Flight();
            this.fill(flightSetUp, listAirplanes, listPilots, d);
            listSystemInit[i] = flightSetUp.toString();
        }
        //Storing the flights created in a text file
        listSU.setList(listSystemInit);
        listSU.setListCreated(listUserInit);
        String[] totalListInit = listSU.generateTotalFlights(listSystemInit, listUserInit);
        listSU.setListTotalFlights(totalListInit);
    }
}
