package pokemonhotel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 * @author Aldana
 * @author Fabricio
 * @author Fermin
 *
 */
public class Accomodation 
{

    private ArrayList<Pokemon> inList;  //Pokemon elegible to stay in the Hotel
    private ArrayList<Pokemon> outList; //Pokemon NON elegible to stay in the Hotel
    private ArrayList<Room> filledRooms;    //Rooms occupied        
    private ArrayList<Room> emptyRooms;     //Empty Rooms
    private Set<PersonalAssistant> assignedPa;  //We use a Set to store the Personal Assistant in order to avoid repetition (as they up to 5 Pokemon assigned) 
    private ArrayList<PersonalAssistant> unassignedPa;  //Personal Assistants that dont have any Pokemon assigned 
    SaveData saveData = new SaveData();
    MenuSetUp mSu = new MenuSetUp();
    PokemonSetUp pSu = new PokemonSetUp(); 

    public Accomodation() {}

    public Accomodation(ArrayList<Pokemon> inList, ArrayList<Pokemon> outList, ArrayList<Room> filledRooms, ArrayList<Room> emptyRooms, Set<PersonalAssistant> assignedPa, ArrayList<PersonalAssistant> unassignedPa) 
    {
        this.inList = inList;
        this.outList = outList;
        this.filledRooms = filledRooms;
        this.emptyRooms = emptyRooms;
        this.assignedPa = assignedPa;
        this.unassignedPa = unassignedPa;
    }

    //Check Pokemon elegible to stay, setting their room and Personal Assistant
    public Accomodation accomodate(LinkedHashSet<Pokemon> pokemonList, LinkedHashSet<Room> roomList, LinkedHashSet<PersonalAssistant> personalList) 
    {
        Iterator<Pokemon> itPoke = pokemonList.iterator();
        ArrayList<Pokemon> inListTemp = new ArrayList();
        ArrayList<Pokemon> outListTemp = new ArrayList();
        ArrayList<Room> filledRoomsTemp = new ArrayList();
        Set<PersonalAssistant> assignedPaTemp = new HashSet<>();

        PersonalAssistant tempPa = new PersonalAssistant();
        Pokemon tempPoke = new Pokemon();

        while (itPoke.hasNext()) 
        {
            tempPoke = itPoke.next();
            Iterator<Room> itRoom = roomList.iterator();
            Iterator<PersonalAssistant> itPa = personalList.iterator();
            int calc = ((tempPoke.getAttack() + tempPoke.getSpeed()) / 3);
            while (calc >= 7 || tempPoke.getExpert() > 6) 
            {
                outListTemp.add(tempPoke);
                itPoke.remove();
                if (!itPoke.hasNext()) 
                {
                    break;
                }
                tempPoke = itPoke.next();
                calc = ((tempPoke.getAttack() + tempPoke.getSpeed()) / 3);
            }
            while (itRoom.hasNext()) 
            {
                if (itRoom.next().getRating() > calc) 
                {
                    while (itPa.hasNext()) 
                    {
                        if (itPa.next().getExpert() >= tempPoke.getExpert()) 
                        {
                            Room tempRoom = itRoom.next();
                            tempPa = itPa.next();
                            tempRoom.setGuest(tempPoke);
                            tempPa.setOneGuest(tempPoke);
                            roomList.remove(tempRoom);
                            if (tempPa.getGuests().size() == 5) 
                            {
                                personalList.remove(tempPa);
                            }
                            inListTemp.add(tempPoke);
                            itPoke.remove();
                            filledRoomsTemp.add(tempRoom);
                            assignedPaTemp.add(tempPa);
                            break;
                        }
                    }
                    break;
                }
            }

        }

        ArrayList<Room> emptyRoomsTemp = new ArrayList(roomList);
        ArrayList<PersonalAssistant> unassignedPaTemp = new ArrayList(personalList);

        Accomodation accomodation = new Accomodation(inListTemp, outListTemp, filledRoomsTemp, emptyRoomsTemp, assignedPaTemp, unassignedPaTemp);

        return accomodation;

    }
    
    //Saving the data generated in this Class into files
    public void printAccomodation() throws IOException 
    {
        int counterAccPoke = 1;
        int counterNotAccPoke = 1;
        int counterFilledRooms = 1;
        int counterEmptyRooms = 1;
        int counterAssPA = 1;
        int counterUnassPA = 1;

        String[] getIn = new String[getInList().size()];
        for (int i = 0; i < this.getInList().size(); i++) 
        {
            String SGetIn = counterAccPoke + "\t" + this.getInList().get(i);
            getIn[i] = SGetIn;
            counterAccPoke++;
        }
        saveData.recordData(getIn, "getIn.txt");

        String[] getOut = new String[getOutList().size()];
        for (int i = 0; i < this.getOutList().size(); i++) 
        {
            String SGetOut = counterNotAccPoke + "\t" + this.getOutList().get(i);
            getOut[i] = SGetOut;
            counterNotAccPoke++;
        }
        saveData.recordData(getOut, "getOut.txt");

        String[] FilledRooms = new String[getFilledRooms().size()];
        for (int i = 0; i < this.getFilledRooms().size(); i++) 
        {
            String SFilledRooms = counterFilledRooms + "\t" + this.getFilledRooms().get(i);

            counterFilledRooms++;
            FilledRooms[i] = SFilledRooms;
        }
        saveData.recordData(FilledRooms, "getFilledRooms.txt");

        String[] EmptyRooms = new String[getEmptyRooms().size()];
        for (int i = 0; i < this.getEmptyRooms().size(); i++) 
        {
            String SEmptyRooms = counterEmptyRooms + "\t" + this.getEmptyRooms().get(i);

            counterEmptyRooms++;
            EmptyRooms[i] = SEmptyRooms;
        }
        saveData.recordData(EmptyRooms, "EmptyRooms.txt");

        Iterator<PersonalAssistant> itPa = assignedPa.iterator();
        String[] AssignedPAs = new String[assignedPa.size() + 2];
        while (itPa.hasNext()) 
        {
            String SAssignedPAs = counterAssPA + "\t" + itPa.next();

            counterAssPA++;
            AssignedPAs[counterAssPA] = SAssignedPAs;
        }
        saveData.recordData(AssignedPAs, "AssignedPAs.txt");

        String[] UnassignedPAs = new String[getUnassignedPa().size()];
        for (int i = 0; i < this.getUnassignedPa().size(); i++) 
        {
            String SUnassignedPAs = counterUnassPA + "\t" + this.getUnassignedPa().get(i);

            counterUnassPA++;
            UnassignedPAs[i] = SUnassignedPAs;
        }
        saveData.recordData(UnassignedPAs, "UnassignedPAs.txt");

    }

    //Method to get Personal Assistants ande their Assigned Pokemons
    public void perAssiPoke() throws IOException 
    {
        Iterator<PersonalAssistant> itPa = assignedPa.iterator(); //I need to go through a Set (assignedPa) 
        ArrayList<String> listPokeAssig = new ArrayList();          //a temporal ArrayList to store the Pokemons assigned & their rooms

        while (itPa.hasNext()) 
        {
            PersonalAssistant perAssi = new PersonalAssistant();
            perAssi = itPa.next();  //I am declaring wich Assistant I will use in order to make sure all the data is from it
            for (int i = 0; i < perAssi.getGuests().size(); i++) //Going trough the pokemons assigned to this Assistant  
            {
                Pokemon poke = new Pokemon();
                //Isolating the data of a particular Pokemon
                poke = perAssi.getGuests().get(i);
                String pokeName = poke.getName();
                String pokeType = poke.getType();
                //Calling the method to set Category
                String pokeCategory = pSu.category(poke);
                //Calling the method to find the room
                int pokeRoom = this.roomAssigned(poke);
                
                listPokeAssig.add(" "+(i + 1) + "> " + pokeName + " | Type: " + pokeType 
                                + " | Category: " + pokeCategory + " | Room n°: " + pokeRoom + "\n");
            }
            
            System.out.println("Personal Assistant "+perAssi.toString() + "\nAssigned Pokemons: \n");            
            for (int z = 0; z < listPokeAssig.size(); z++) 
            {
                System.out.println(listPokeAssig.get(z));

            }
            listPokeAssig.clear();  //Clearing the temporal Array List in order to go trhough another Personal Assistant  
        }
    }
    
    

    //Method to give the User the option to choose a Room
    public void displayFilledRoom() 
    {
        for (int i = 0; i < filledRooms.size(); i++) 
        {
            System.out.println("ID: " + (i + 1) + " | Room n°: " + filledRooms.get(i).getNumber());
        }
    }

    //Method to display the Room chosen with its Pokemon & Personal Assistant Assigned
    public void displayPartRoom(int choice) 
    {
        if(choice>filledRooms.size())
            {
                System.err.println("The ID you have chosen is INVALID.\nPlease, type a valid ID.");
                mSu.case8(this);
                
            }
        else
        {
        
            int roomChosen = filledRooms.get(choice - 1).getNumber();
            Pokemon partPoke = new Pokemon();
            partPoke = filledRooms.get(choice - 1).getGuest();

            //Calling a method to get the Personal Assistant
            String partAssName = this.paAssigned(partPoke).getName();
            System.out.println("\nIn the room n° " + roomChosen
                    + " stays the Pokemon:\n\n" + partPoke.toString() + "\n\n"
                    + "which personal Assistant is " + partAssName+ ".");
        }
    }

    //Method to give the user the opportunity to choose a Genetic Stamp 
    public void displayGeneticStamp() 
    {
        for (int i = 0; i < inList.size(); i++) //We use the ArrayList of Pokemon that are staying int the Hotel
        {
            System.out.println("ID: " + (i + 1) + " | Genetic Stamps: " + inList.get(i).getGenetic());
        }

    }

    //Method to give information about a Pokemon depending the Genetic Stamp chosen
    public void particularPoke(int choice) 
    {
        if(choice>inList.size())
            {
                System.err.println("The ID you have chosen is INVALID.\nPlease, type a valid ID.");
                mSu.case9(this);
                
            }
        else
            {
                Pokemon pokeChosen = new Pokemon();
                pokeChosen = inList.get(choice - 1);  //Declaring pokemon that User choose (depending on the Genetic Stamp chosen)
                //Isolating data I will use from the Pokemon chosen
                String pokeChosenName = pokeChosen.getName();
                int geneticStamp = pokeChosen.getGenetic();
                //Calling a method to get the Personal Assistant
                String paName = this.paAssigned(pokeChosen).getName();
                //Calling a method to get the Personal Assistant
                int pokeChosenRoom = this.roomAssigned(pokeChosen);

                System.out.println("\nThe Genetic Stamp Chosen (" + geneticStamp + ") corresponds to the Pokemon " + pokeChosenName+":"
                        + "\n   > Stays in the Room n°: " + pokeChosenRoom
                        + "\n   > " + "Assistant: " + paName+ ".");
            }
    }
    
    //Method to get the Personal Assistant Assigned to a certain Pokemon
    public PersonalAssistant paAssigned(Pokemon poke) 
    {
        PersonalAssistant paAssigned = new PersonalAssistant();
        Iterator<PersonalAssistant> itPa = assignedPa.iterator(); //I need to go through a Set (assignedPa) 

        while (itPa.hasNext() && paAssigned.getIDPerAssistant() == 0) //When the ID is different to 0, stop the while, as there is one Personal Assistan per Pokemon
        {
            PersonalAssistant pa = new PersonalAssistant();
            pa = itPa.next();
            //Finding the Personal Assistant
            for (int i = 0; i < pa.getGuests().size(); i++) 
            {
                Pokemon tempPoke = new Pokemon();   //Temporal Pokemon to compare with the Pokemon passed as Argument
                tempPoke = pa.getGuests().get(i);  //Making sure I am using the correct Pokemon depending on the Personal Assistant I am loking at the moment
                if (poke.getGenetic() == tempPoke.getGenetic()) 
                {
                    paAssigned = pa;
                    break;
                }

            }
        }

        return paAssigned;

    }
    
    public int roomAssigned (Pokemon poke)
    {
        int roomNum = 0;
        int geneticStamp = poke.getGenetic();
        //Finding the Pokemon room (compairing its Genetic Stamp
        for (int i = 0; i < filledRooms.size(); i++) 
        {
            if (filledRooms.get(i).getGuest().getGenetic() == geneticStamp) 
            {
                roomNum = filledRooms.get(i).getNumber();
                break;  //Stop Looking as there is One pokemon per room
            }
        }
    
        return roomNum;
        
    }

    public ArrayList<Pokemon> getInList() {
        return inList;
    }

    public ArrayList<Pokemon> getOutList() {
        return outList;
    }

    public ArrayList<Room> getFilledRooms() {
        return filledRooms;
    }

    public ArrayList<Room> getEmptyRooms() {
        return emptyRooms;
    }

    public Set<PersonalAssistant> getAssignedPa() {
        return assignedPa;
    }

    public ArrayList<PersonalAssistant> getUnassignedPa() {
        return unassignedPa;
    }

    public void setInList(ArrayList<Pokemon> inList) {
        this.inList = inList;
    }

    public void setOutList(ArrayList<Pokemon> outList) {
        this.outList = outList;
    }

    public void setFilledRooms(ArrayList<Room> filledRooms) {
        this.filledRooms = filledRooms;
    }

    public void setEmptyRooms(ArrayList<Room> emptyRooms) {
        this.emptyRooms = emptyRooms;
    }

    public void setAssignedPa(Set<PersonalAssistant> assignedPa) {
        this.assignedPa = assignedPa;
    }

    public void setUnassignedPa(ArrayList<PersonalAssistant> unassignedPa) {
        this.unassignedPa = unassignedPa;
    }

    @Override
    public String toString() {
        return "Accomodation{" + "inList=" + inList + ", outList=" + outList + ", filledRooms=" + filledRooms + ", emptyRooms=" + emptyRooms + ", assignedPa=" + assignedPa + ", unassignedPa=" + unassignedPa + '}';
    }

}
