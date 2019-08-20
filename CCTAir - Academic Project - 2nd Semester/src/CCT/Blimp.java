package CCT;

/**
 *
 * @author Fermin
 * @author Fabricio
 * @author Aldana
 */
public class Blimp extends Aircraft implements Carrier
{

    public Blimp(){}

    public Blimp(String make, String model, int capacity, Pilot pilot) 
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
        System.out.println("Blimp is taking off");
    }

    @Override
    public void fly()
    {
        System.out.println("Blimp is flying");
    }

    @Override
    public void land()
    {
        System.out.println("Blimp is landing");
    }

}
