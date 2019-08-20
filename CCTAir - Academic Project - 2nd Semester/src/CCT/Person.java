package CCT;

/**
 *
 * @author Fermin
 * @author Fabricio
 * @author Aldana
 */
public class Person
{

    public String name;
    
    public Person() {}
    
    public Person(String name) 
    {
        this.name = name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public String toString() {
        return "Name" + name;
    }


}
