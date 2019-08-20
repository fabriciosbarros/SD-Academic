package pokemonhotel;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

/**
 * @author Aldana
 * @author Fabricio
 * @author Fermin
 *
 */

public class SaveData
{
    public void recordData(String[] list,String FileTxt) throws FileNotFoundException, IOException
    {

        
        Writer out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FileTxt), "UTF-8"));

            // Write each line in the file
            for (String linea : list) {
                if (linea!=null ){
                try {
                    out.write(linea + "\n");
                } catch (IOException ex) {
                    System.out.println("Exception message writing in the file: " + ex.getMessage());
                }}
            }

        } catch (UnsupportedEncodingException | FileNotFoundException ex2) {
            System.out.println("Error: " + ex2.getMessage());
        } finally {
            try {
                out.close();
            } catch (IOException ex3) {
                System.out.println("Error message closing the file: " + ex3.getMessage());
            }
        }
    }
 
}
