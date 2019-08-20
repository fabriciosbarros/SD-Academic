package CCT;

/**
 *
 * @author Fermin
 * @author Fabricio
 * @author Aldana
 */
public class Helicopter extends Aircraft implements Carrier
{
    public Helicopter() {}

    public Helicopter(String make, String model, int capacity, Pilot pilot) 
    {
        super(make, model, capacity, pilot);
    }
        
    @Override
    public void add(Passenger p){}

    @Override
    public void remove(Passenger p){}

    @Override
    public void takeoff()
    {
        System.out.println("Helicopter is taking off");
    }

    @Override
    public void fly()
    {
        System.out.println("Helicopter is flying");
    }

    @Override
    public void land()
    {
        System.out.println("Helicopter is landing");
    }
}
