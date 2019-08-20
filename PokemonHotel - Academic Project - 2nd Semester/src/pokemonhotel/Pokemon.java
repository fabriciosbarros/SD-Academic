package pokemonhotel;

/**
 * @author Aldana
 * @author Fabricio
 * @author Fermin
 *
 */

public class Pokemon 
{
    private String name;
    private int genetic;
    private String type;   
    private int attack;
    private int speed;
    private int expert;

    public Pokemon() {}

    public Pokemon(String name, int genetic, String type, int special, int speed, int expert) 
    {
        this.name = name;
        this.genetic = genetic;
        this.type = type;
        this.attack = special;
        this.speed = speed;
        this.expert = expert;
    }

   
    public String getName() {
        return name;
    }

    public int getGenetic() {
        return genetic;
    }

    public String getType() {
        return type;
    }

    public int getAttack() {
        return attack;
    }

    public int getSpeed() {
        return speed;
    }

    public int getExpert() {
        return expert;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGenetic(int genetic) {
        this.genetic = genetic;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setExpert(int expert) {
        this.expert = expert;
    }

    @Override
    public String toString() {
        return String.format("%-20s%-30s%-20s%-31s%-22s%-28s", " | Name: " + name, " | Genetic Stamp: " + genetic, " | Type: " + type, " | Special Attack Rating: " + attack, " | Speed Rating: " + speed, " | Expert Level: " + expert);
    }
    
    
}
