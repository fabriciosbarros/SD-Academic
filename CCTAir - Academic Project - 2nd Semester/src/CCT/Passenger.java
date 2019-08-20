package CCT;

/**
 *
 * @author Fermin
 * @author Fabricio
 * @author Aldana
 */
public class Passenger extends Person
{
    private String passport;

    public Passenger(){ }

    public Passenger(String name, String passport)
    {
        super(name);
        this.passport = passport;
    }

    public void setPassport(String passport)
    {
        this.passport = passport;
    }

    public String getPassport()
    {
        return passport;
    }

    @Override
    public String toString() {
        return "Passenger: " + super.getName() + "passport" + passport ;
    }
    
    
}
