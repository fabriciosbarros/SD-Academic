package pokemonhotel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Aldana
 * @author Fabricio
 * @author Fermin
 *
 */

public class ReadData
{
    // This method is used to print to the terminal the information retrieved from the system's Unique file line by line 
    public void getData(String FileTxt) throws FileNotFoundException, IOException
    {
        ArrayList<String> List = new ArrayList();
        try (Scanner s = new Scanner(new File(FileTxt))) {
            while (s.hasNextLine()){
                List.add(s.nextLine());
            }
        }
        for (int i=0;i<List.size();i++){
            System.out.println(List.get(i));
        }

        System.out.println("------------------------------------");
        System.out.println("|          SUCCESFUL                |");
        System.out.println("------------------------------------");
    }
}
