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
public class PersonalSetUp 
{

//Expert level: Randomly generated from 1 to 6 (must be greater than or equal to the Pokemon expert level).
//Pokemon type : max of two (limited to 2 types of Pokemon, randomly assigned)
//Pokemon guests : max of 5. (limited to 5 Pokemon)
    private final int initRangePerAssis = 10000;
    private final int finalRangePerAssis = 19999;
    private Random rd = new Random();

    //DEFAULT CONSTRUCTOR
    public PersonalSetUp() {}

    //METHOD TO CREATE PERSONAL ASSISTANT
    public LinkedHashSet<PersonalAssistant> personalCreation(String PersonalNames, String typesFile, int production) throws IOException {
        LinkedHashSet<PersonalAssistant> personalAssistant = new LinkedHashSet();
        FileInputStream fs = new FileInputStream(PersonalNames);
        FileInputStream fs2 = new FileInputStream(typesFile);
        BufferedReader br = new BufferedReader(new InputStreamReader(fs));
        BufferedReader br2 = new BufferedReader(new InputStreamReader(fs2));
        ArrayList<String> names = new ArrayList();
        ArrayList<String> types = new ArrayList();
        Set<Integer> idList = new TreeSet();
        int rName = 0;
        int rType1 = 0;
        int rType2 = 0;
        int expert = 0;
        int IDPerAssistant = 0;
        int nPerAssistant = 0;

        String line;
        while ((line = br.readLine()) != null) {
            names.add(line);
        }

        String line2;
        while ((line2 = br2.readLine()) != null) {
            types.add(line2);
        }

        while (idList.size() < production) {
            int rID = rd.nextInt((finalRangePerAssis - initRangePerAssis) + 1) + initRangePerAssis;
            idList.add(rID);
        }

        Iterator itId = idList.iterator();
        int counterName = 0;
        while (itId.hasNext()) {
            nPerAssistant = nPerAssistant + 1;
            IDPerAssistant = Integer.parseInt(itId.next().toString());
            rType1 = rd.nextInt(types.size());
            //to avoid repetion between type 1 and type 2
            do {
                rType2 = rd.nextInt(types.size());
            } while (rType2 == rType1);
            expert = rd.nextInt(6) + 1;
            String name = names.get(counterName);
            String type1 = types.get(rType1);
            String type2 = types.get(rType2);
            PersonalAssistant perAssist = new PersonalAssistant(IDPerAssistant, name, expert, type1, type2);
            personalAssistant.add(perAssist);
            counterName++;
        }
        return personalAssistant;
    }

}
