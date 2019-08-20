package pokemonhotel;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashSet;



/**
 * @author Aldana
 * @author Fabricio
 * @author Fermin
 *
 */

public class PokemonHotel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
    
        int pokemonProduction = 80;
        int totalRooms = 100;
        String fileSetUpNames = "pokemon.txt";
        String fileSetUpTypes = "poke_types.txt";
        PokemonSetUp psu = new PokemonSetUp();
        RoomSetUp rsu = new RoomSetUp();
        int personalAssisProduction = 20;
        String fileSetUpNamesPA = "personalAssistant.txt";
        PersonalSetUp pasu = new PersonalSetUp();
        SaveData saveData=new SaveData();
        
        LinkedHashSet<Pokemon> pokemonList = psu.pokemonCreation(fileSetUpNames, fileSetUpTypes, pokemonProduction);
        
        LinkedHashSet<PersonalAssistant> personalAssisList = pasu.personalCreation(fileSetUpNamesPA, fileSetUpTypes, personalAssisProduction);
        
        LinkedHashSet<Room> roomList = rsu.roomGeneration(totalRooms);
        
        Iterator itPoke = pokemonList.iterator();
        int counterPoke = 1;
        String[] PokemonL = new String[pokemonList.size()+2];
        while (itPoke.hasNext()){
            String SPokemon="ID: "+counterPoke+"\t"+itPoke.next();
            counterPoke++;
            PokemonL[counterPoke]=SPokemon;
        }
        saveData.recordData(PokemonL,"PokemonAccommodated.txt");
 
        Accomodation acc = new Accomodation();
        acc = acc.accomodate(pokemonList, roomList, personalAssisList);
        Menu Menu=new Menu();
        Menu.MyMenu(acc);      

        acc.printAccomodation();
       
       
       
        
    }
    
}
