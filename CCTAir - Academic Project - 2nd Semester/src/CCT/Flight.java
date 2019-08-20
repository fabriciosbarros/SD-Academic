package CCT;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Fermin
 * @author Fabricio
 * @author Aldana
 */
public class Flight
{
    private String origin;
    private String destination;
    private String dateFlight;
    private String departureTime;
    private String arrivalTime;
    private int ratingFlight;
    
    private Airplane airplane;

    public Flight(){}

    public Flight(String origin, String destination ,String dateFlight, String departureTime, String arrivalTime, Airplane airplane)
    {
        this.origin = origin;
        this.destination = destination;
        this.dateFlight = dateFlight;
        this.departureTime=departureTime;
        this.arrivalTime=arrivalTime;
        this.airplane=airplane;
        
    }
    
    public Flight(String origin, String destination ,String dateFlight, String departureTime, Airplane airplane)
    {
        this.origin = origin;
        this.destination = destination;
        this.dateFlight = dateFlight;
        this.departureTime = departureTime;        
        this.airplane = airplane;
        
    }
    
    //Method to assign a Rating to the flight in order to match with the Pilot rating, to assign them to an Airplane
    public int assignFlightRating(Airplane airplane, int hours)
    {
        int capacity = airplane.getCapacity();
        
        if(hours < 3 && capacity <= 200)
        {
            return 1;
        }else if(hours >= 3 && capacity <= 200)
        {
            return 2;
        }else if(hours < 3 && capacity > 200)
        {
            return 3;
        }else if (hours >= 3 && capacity > 200)
        {
            return 4;
        }else
        {
            return 0; // Keep looking for the correct Airplane
        }
    }
   
    //Method to calculate the Arrival Time: getting the duration of the flight from the data file)and taking the departure time assigned
    public String calculateArrivalTime(String depTime, String origin, String destination, Data d) throws ParseException
    {
        String arrTime;
        SimpleDateFormat dateFormat = new SimpleDateFormat("H:m");
        Date depFormatted = dateFormat.parse(depTime);
        int initHour = depFormatted.getHours();
        int initMin = depFormatted.getMinutes();
        int finalHour = 0;
        String originDestination = origin+destination;
        int hoursFlight = d.getDurationFlight(originDestination, d.getFlightDuration());
        
        finalHour = initHour+hoursFlight;
        arrTime = finalHour+":"+initMin; 
        
        return arrTime;
    }
    
    public int checkTime(String arrTime, String depTime) throws ParseException 
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date DepFormatted = dateFormat.parse(depTime);
        Date ArrFormatted = dateFormat.parse(arrTime);
        int DepHour = DepFormatted.getHours();
        int ArrHour = ArrFormatted.getHours();
        int DepMin = DepFormatted.getMinutes();
        int ArrMin = ArrFormatted.getMinutes();
        
        if (DepHour < ArrHour) 
        {
            this.schedule(arrTime, depTime);
            return 1;
        } else if (DepHour == ArrHour) 
        {
            if (DepMin < ArrMin) 
            {
                return 1;
            } else 
            {
                return 0;
            }
        } else 
        {
            return 0;
        }
    }

    public void setOrigin(String origin)
    {
        this.origin = origin;
    }

    public String getOrigin()
    {
        return origin;
    }

    public void setDestination(String destination)
    {
        this.destination = destination;
    }

    public String getDestination()
    {
        return destination;
    }

    public void setDepartureTime(String departureTime)
    {
        this.departureTime = departureTime;
    }

    public String getDepartureTime()
    {
        return departureTime;
    }

    public void setArrivalTime(String arrivalTime)
    {
        this.arrivalTime = arrivalTime;
    }

    public String getArrivalTime()
    {
        return arrivalTime;
    }

    public void setDateFlight(String dateFlight)
    {
        this.dateFlight = dateFlight;
    }

    public String getdateFlight()
    {
        return dateFlight;
    }

    public void schedule(String arrivalTime)
    {
        this.arrivalTime = arrivalTime;
    }

    public void schedule(String arrivalTime, String departureTime)
    {
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    public void setAirplane(Airplane a)
    {
        this.airplane = a;
    }

    public Airplane getAirplane()
    {
        return airplane;
    }

    public int getRatingFlight() {
        return ratingFlight;
    }

    public void setRatingFlight(int ratingFlight) {
        this.ratingFlight = ratingFlight;
    }

    @Override
    public String toString()
    {
  
        return " | Origin: " + origin + " |  Destination: " + destination + " | Date of the flight: " + dateFlight +  " | Departure time: " + departureTime + " | Arrival time: " + arrivalTime + airplane;
    }

}
