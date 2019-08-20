package pokemonhotel;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Aldana
 * @author Fabricio
 * @author Fermin
 *
 */

public class PokemonSetUp {

    private final int initRangeStamp = 1000000;

    private final int finalRangeStamp = 1999999;

    private Random rd = new Random();

    public PokemonSetUp() {
    }

//METHOD TO CREATE POKEMONS
    public LinkedHashSet<Pokemon> pokemonCreation(String namesFile, String typesFile, int production) throws IOException {
        LinkedHashSet<Pokemon> pokemons = new LinkedHashSet();
        FileInputStream fs = new FileInputStream(namesFile);
        FileInputStream fs2 = new FileInputStream(typesFile);
        BufferedReader br = new BufferedReader(new InputStreamReader(fs));
        BufferedReader br2 = new BufferedReader(new InputStreamReader(fs2));
        Set<Integer> geneticStamps = new TreeSet();
        ArrayList<String> names = new ArrayList();
        ArrayList<String> types = new ArrayList();
        int rName = 0;
        int rType = 0;
        String pokeCategory = "";
        while (geneticStamps.size() < production) {
            int rID = rd.nextInt((finalRangeStamp - initRangeStamp) + 1) + initRangeStamp;
            geneticStamps.add(rID);
        }

        String line;
        while ((line = br.readLine()) != null) {
            names.add(line);
        }

        String line2;
        while ((line2 = br2.readLine()) != null) {
            types.add(line2);
        }

        Iterator itStamp = geneticStamps.iterator();

        while (itStamp.hasNext()) {
            int genetic = Integer.parseInt(itStamp.next().toString());
            rName = rd.nextInt(names.size());
            rType = rd.nextInt(types.size());
            int attack = rd.nextInt((15 - 5) + 1) + 5;
            int speed = rd.nextInt((15 - 5) + 1) + 5;
            int expert = rd.nextInt((10 - 1) + 1) + 1;
            String name = names.get(rName);
            String type = types.get(rType);
            
            Pokemon pokeTemp = new Pokemon(name, genetic, type, attack, speed, expert);
            pokemons.add(pokeTemp);
        }

        return pokemons;
    }
    
    //Method to set the Category to the Pokemon
    public String category (Pokemon poke)
    {
        String pokeCategory = "";
        String type = poke.getType();
        
        if (type == "Normal" || type == "Grass" || type == "Fighting" || type == "Poison" || type == "Ground" || type == "Rock" || type == "Steel") 
        {
                pokeCategory = "Land";
            } else if (type == "Water" || type == "Ice" || type == "Dark") {
                pokeCategory = "Water";
            } else {
                pokeCategory = "Air";
            }
        return pokeCategory;
        
        
    }

}
