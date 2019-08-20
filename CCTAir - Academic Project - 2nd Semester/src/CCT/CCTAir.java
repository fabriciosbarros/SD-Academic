package CCT;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.io.IOException;


        
public class CCTAir
{

    public static void main(String[] args) throws ParseException, FileNotFoundException, IOException
    {
       
        //Objects creation 
        Data d = new Data();
        d.generateAllData();
        d.generateStringFlightsFromFile();
        AirSetUp suAuto = new AirSetUp();
        ListSetUp listSU = new ListSetUp();
        
        suAuto.systemFlightCreation(d, listSU);
        
        //MENU CALL
        Menu menu = new Menu(d, suAuto, listSU);
    }

}
