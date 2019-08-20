package CCT;

/**
 *
 * @author Fermin
 * @author Fabricio
 * @author Aldana
 */
public class Airplane extends Aircraft implements Carrier
{

    public Airplane(){}

    public Airplane(String make, String model, int capacity, Pilot pilot)
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
        System.out.println("Airplane is taking off");
    }

    @Override
    public void fly()
    {
        System.out.println("Airplane is flying");
    }

    @Override
    public void land()
    {
        System.out.println("Airplane is landing");
    }
    
    @Override
    public String toString()
    {
        return " | Airplain make: " + super.getMake() + " | Airplain model: " + super.getModel() + " Capacity: " + super.getCapacity() + " seats"+ this.getPilot();   
    }

}
