package pokemonhotel;

import java.util.LinkedHashSet;
import java.util.Random;


/**
 * @author Aldana
 * @author Fabricio
 * @author Fermin
 *
 */

public class RoomSetUp {

    private Random rd = new Random();
    
    public RoomSetUp() {}
    
    public LinkedHashSet<Room> roomGeneration(int totalRooms){
        LinkedHashSet<Room> rooms = new LinkedHashSet();
        
        int roomNumber = 1;
        
        while(rooms.size() < totalRooms){
            int rating = (rd.nextInt((7 - 3) + 1) + 3);
            Room tempRoom = new Room(roomNumber, rating);
            rooms.add(tempRoom);
            roomNumber++;
        }
        
        return rooms;
        
    }
   
    
}
