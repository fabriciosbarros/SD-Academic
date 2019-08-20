package pokemonhotel;

import java.util.ArrayList;

/**
 * @author Aldana
 * @author Fabricio
 * @author Fermin
 *
 */

public class PersonalAssistant {

    private int IDPerAssistant;
    private String name;
    private int expert;
    private String type1;
    private String type2;
    private ArrayList<Pokemon> guests = new ArrayList();

    public PersonalAssistant() {}

    public PersonalAssistant(int IDPerAssistant, String name, int expert, String type1, String type2) 
    {
        this.IDPerAssistant = IDPerAssistant;
        this.name = name;
        this.expert = expert;
        this.type1 = type1;
        this.type2 = type2;
    }

    public PersonalAssistant(int IDPerAssistant, String name, int expert, String type1, String type2, ArrayList<Pokemon> guests) 
    {
        this.IDPerAssistant = IDPerAssistant;
        this.name = name;
        this.expert = expert;
        this.type1 = type1;
        this.type2 = type2;
        this.guests = guests;
    }

    //Getter
    public int getIDPerAssistant() {
        return IDPerAssistant;
    }

    public String getName() {
        return name;
    }

    public int getExpert() {
        return expert;
    }

    public String getType1() {
        return type1;
    }

    public String getType2() {
        return type2;
    }

    public ArrayList<Pokemon> getGuests() {
        return guests;
    }

    //Setter
    public void setIDPerAssistant(int IDPerAssistant) {
        this.IDPerAssistant = IDPerAssistant;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExpert(int expert) {
        this.expert = expert;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public void setGuests(ArrayList<Pokemon> guests) {
        this.guests = guests;
    }

    public void setOneGuest(Pokemon pokemon) {
        this.guests.add(pokemon);
    }

    @Override
    public String toString() {
        return String.format("%-20s%-30s%-20s%-20s", "ID: " + IDPerAssistant, " | Name: " + name, " | Expert Level: " + expert, " | Type: " + type1 + " , " + type2);
    }

}
