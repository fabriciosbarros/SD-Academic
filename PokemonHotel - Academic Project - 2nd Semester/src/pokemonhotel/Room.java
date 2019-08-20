package pokemonhotel;

/**
 * @author Aldana
 * @author Fabricio
 * @author Fermin
 *
 */

public class Room {
    
    private int number;
    private int rating;
    private Pokemon guest;

    public Room() {}

    public Room(int number, int rating, Pokemon guest) 
    {
        this.number = number;
        this.rating = rating;
        this.guest = guest;
    }

    public Room(int number, int rating) 
    {
        this.number = number;
        this.rating = rating;
    }
    
    //Method to check pokemon Elegible to stay
    public boolean pokemonCheck(Room room, Pokemon pokemon)
    {
        boolean approved = false;
        
        int calc = (pokemon.getAttack() + pokemon.getSpeed())/3;
        
        if(room.getRating()>calc){
            approved = true;
        }
        
        return approved;
        
    }   

    public int getNumber() {
        return number;
    }

    public int getRating() {
        return rating;
    }

    public Pokemon getGuest() {
        return guest;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setGuest(Pokemon guest) {
        this.guest = guest;
    }
    
    
    @Override
    public String toString() {
        return String.format("%-20s%-30s", " | Room Number: " + number, " | Room Rating: " + rating);
    }
    
    
}
