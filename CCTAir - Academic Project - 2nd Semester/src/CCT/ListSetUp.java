package CCT;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Fermin
 * @author Fabricio
 * @author Aldana
 */
public class ListSetUp
{
    // This is the method to write the information from the flights created by the system into the file: "Flights.txt" using UTF-8.
    public void setList(String[] list) throws FileNotFoundException, IOException 
    {

        Writer out = null;
        try 
        {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Flights.txt"), "UTF-8"));

            // Write each line in the file
            for (String linea : list) 
            {
                try 
                {
                    out.write(linea + "\n");
                } catch (IOException ex) 
                {
                    System.out.println("Exception message writing in the file: " + ex.getMessage());
                }
            }

        } catch (UnsupportedEncodingException | FileNotFoundException ex2) 
        {
            System.out.println("Error: " + ex2.getMessage());
        } finally 
        {
            try 
            {
                out.close();
            } catch (IOException ex3)
            {
                System.out.println("Error message closing the file: " + ex3.getMessage());
            }
        }
    }
    
     // This method is used to print to the terminal the information retrieved from the system's flights file line by line 
    public void getList() throws FileNotFoundException, IOException 
    {
        ArrayList<String> listFlights = new ArrayList();
        try (Scanner s = new Scanner(new File("Flights.txt"))) 
        {
            while (s.hasNextLine()) 
            {
                listFlights.add(s.nextLine());
            }
        }
        for (int i = 0; i < listFlights.size(); i++) 
        {
            System.out.println("Flight ID: " + (i + 1) + listFlights.get(i));
        }

        System.out.println("------------------------------------");
        System.out.println("|          SUCCESFUL                |");
        System.out.println("------------------------------------");
    }
        
    //This is the method to put the system flights and the flights created by the user in the same list
    public String[] generateTotalFlights(String[] listSystem, String[] listUser)
    {
        
        String[] listTotal = new String[(listSystem.length+listUser.length)];
        
        for (int i=0;i<listSystem.length;i++)
        {
            listTotal[i]=listSystem[i];
        }
        
        for (int i =listSystem.length;i<listTotal.length;i++)
        {
            listTotal[i]=listUser[(listTotal.length-i)];
        }
        
        return listTotal;
    }
    
    //This is the method that saves an array of strings containing information of flights in each line and save to a text file
    public void setListTotalFlights(String[] list) throws FileNotFoundException, IOException 
    {

        Writer out = null;
        try 
        {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("totalflights.txt"), "UTF-8"));

            // Write each line in the file
            for (String linea : list) 
            {
                try 
                {
                    out.write(linea + "\n");
                } catch (IOException ex) 
                {
                    System.out.println("Exception message writing in the file: " + ex.getMessage());
                }
            }

        } catch (UnsupportedEncodingException | FileNotFoundException ex2) 
        {
            System.out.println("Error: " + ex2.getMessage());
        } finally 
        {
            try 
            {
                out.close();
            } catch (IOException ex3)
            {
                System.out.println("Error message closing the file: " + ex3.getMessage());
            }
        }
    }

    //This method outputs the content of the file containing all the flights
    public void getTotalList() throws FileNotFoundException, IOException
    {
        ArrayList<String> listFlights = new ArrayList();
        try (Scanner s = new Scanner(new File("totalflights.txt"))) 
        {
            while (s.hasNextLine())
            {
                listFlights.add(s.nextLine());
            }
        for (int i=0;i<listFlights.size();i++)
        {
            System.out.println("Flight ID: "+(i+1)+listFlights.get(i));
        }
        }
    }

    // This is the method to write the information from the flights created by the user into the file: "FlightsCreated.txt" using UTF-8.
    public void setListCreated(String[] list) throws FileNotFoundException, IOException 
    {

        Writer out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("FlightsCreated.txt"), "UTF-8"));

            // Write the file line by line
            for (String linea : list) 
            {
                try {
                    out.write(linea + "\n");
                } catch (IOException ex) {
                    System.out.println("Exception message writing in the file: " + ex.getMessage());
                }
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
    
// This method is used to print to the terminal the information retrieved from the user's flights file line by line 
    public void getListCreated() throws FileNotFoundException, IOException 
    {
        File file = new File("FlightsCreated.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null)
        {
            System.out.println(st);
        }

    }
    //This method gets the Flights created by the user as an array of strings and add with the previous list of total flights that are saved in a text file
    public void addUserFlights(String[] listFlightsCreated) throws FileNotFoundException, IOException 
    {
        ArrayList<String> listFlights = new ArrayList();

        try (Scanner s = new Scanner(new File("totalflights.txt"))) 
        {
            while (s.hasNextLine()) 
            {
                listFlights.add(s.nextLine());
            }
        }
        
        for (int i = 0; i < listFlightsCreated.length; i++) 
        {
            listFlights.add(listFlightsCreated[i]);
        }
        String[] finalList = new String[listFlights.size()];
        
        for (int i = 0; i < listFlights.size(); i++)
        {
            finalList[i] = listFlights.get(i);
        }

        this.setListTotalFlights(finalList);
    }
    
    // This method is used to retrieve and print to the terminal the specific line with the information from the flight chosen by the user
    public String modlistCreated(int IDFlight) throws FileNotFoundException, IOException 
    {
        String StringLine = null;
        if (IDFlight < 30) 
        {
            FileInputStream fs = new FileInputStream("Flights.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fs));
            for (int i = 0; i < (IDFlight - 1); ++i) 
            {
                br.readLine();
            }
            StringLine = br.readLine();
            
        }
        
        if (IDFlight > 30) 
        {
            FileInputStream fs = new FileInputStream("FlightsCreated.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fs));
            for (int i = 0; i < (IDFlight - 1 - 30); ++i) 
            {
                br.readLine();
            }
            StringLine = br.readLine();

        }
        return StringLine;

    }

    //This method is used to overwrite the specific line with the flight information modified by the user
    public static void modifyFile(String filePath, String oldString, String newString) 
    {
        File fileToBeModified = new File(filePath);

        String oldContent = "";

        BufferedReader reader = null;

        FileWriter writer = null;

        try 
        {
            reader = new BufferedReader(new FileReader(fileToBeModified));

            //Reading all the lines of previous content
            String line = reader.readLine();

            while (line != null) 
            {
                oldContent = oldContent + line + System.lineSeparator();

                line = reader.readLine();
            }

            String newContent = oldContent.replaceAll(oldString, newString);

            //Replacing the specific line with new data 
            writer = new FileWriter(fileToBeModified);

            writer.write(newContent);
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally 
        {
            try 
            {

                reader.close();

                writer.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
    
    
    

}