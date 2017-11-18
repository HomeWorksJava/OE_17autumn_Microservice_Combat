package hu.szum7.combatjerseyservice.dummyresources;

import hu.szum7.combatjerseyservice.dummymodels.Location;
import java.util.ArrayList;

/**
 *
 * @author szum7
 */
public class LocationResource {

    public static ArrayList<Location> getDummyLocations() {
        return new ArrayList<Location>() {
            {
                add(new Location(1, "New York", "Always New York."));
                add(new Location(2, "Switzerland", "Ja."));
                add(new Location(3, "Deutschland", "Nein."));
                add(new Location(4, "Vazul néni kamrája", "99% lekvár"));
                add(new Location(5, "A Pólus Center látványpéksége", "Nem tudom mitől látvány."));
            }
        };
    }
    
    public static Location getDummyLocation(int id){
        ArrayList<Location> arr = LocationResource.getDummyLocations();
        int i = 0;
        while (i < arr.size() && arr.get(i).getId() != id)
            i++;
        
        if(i < arr.size())
            return arr.get(i);
        return new Location(-1, "your Mind", "always there.");
    }
}
