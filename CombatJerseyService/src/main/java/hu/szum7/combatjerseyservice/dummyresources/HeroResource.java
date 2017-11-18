package hu.szum7.combatjerseyservice.dummyresources;

import hu.szum7.combatjerseyservice.dummymodels.Hero;
import java.util.ArrayList;

/**
 *
 * @author szum7
 */
public class HeroResource {

    public static ArrayList<Hero> getDummyHeroes() {
        return new ArrayList<Hero>() {
            {
                add(new Hero(1, "Batman", "", true));
                add(new Hero(2, "Pepsiman", "", false));
                add(new Hero(3, "Superman", "", true));
                add(new Hero(4, "Supergrill", "", true));
                add(new Hero(5, "Batgrill", "", false));
                add(new Hero(6, "Aquaman", "", false));
            }
        };
    }
    
    public static Hero getDummyHero(int id){
        ArrayList<Hero> arr = HeroResource.getDummyHeroes();
        int i = 0;
        while (i < arr.size() && arr.get(i).getId() != id)
            i++;
        
        if(i < arr.size())
            return arr.get(i);
        return new Hero(-1, "Clean Up Lady", "always ready to work.", true);
    }
}
