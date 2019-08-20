package CCT;
/**
 *
 * @author Fermin
 * @author Fabricio
 * @author Aldana
 */

public class Aircraft
{
    private String make;
    private String model;
    private int capacity;
    private Pilot pilot;
    
    public Aircraft(){}
    
    public Aircraft(String make, String model, int capacity, Pilot pilot) 
    {
        this.make = make;
        this.model = model;
        this.capacity = capacity;
        this.pilot = pilot;
    }  

    public void takeoff() 
    {
        System.out.println("aircraft is taking off");
    }

    public void fly() 
    {
        System.out.println("aircraft is flying");
    }

    public void land() 
    {
        System.out.println("aircraft is landing");
    }
    
    public String getMake() 
    {
        return make;
    }

    public void setMake(String make) 
    {
        this.make = make;
    }

    public String getModel() 
    {
        return model;
    }

    public void setModel(String model) 
    {
        this.model = model;
    }

    public int getCapacity() 
    {
        return capacity;
    }

    public void setCapacity(int capacity) 
    {
        this.capacity = capacity;
    }

    public Pilot getPilot() 
    {
        return pilot;
    }

    public void assignPilot(Pilot pilot) 
    {
        this.pilot = pilot;
    }
        
    @Override
    public String toString() 
    {
        return "Aircraft{" + "make=" + make + ", model=" + model + ", capacity=" + capacity + ", pilot=" + pilot + '}';
    }
    
    
}
