package hu.szum7.combatjerseyservice.models;

import hu.szum7.combatjerseyservice.dummymodels.Hero;
import hu.szum7.combatjerseyservice.dummymodels.Location;
import java.util.ArrayList;

/**
 *
 * @author szum7
 */
public class CombatResult {
    
    // Properties
    private Hero winner;
    private Location location;
    private ArrayList<Hero> deaths;
    private ArrayList<CombatLog> combatLog;
    
    // Constructor
    public CombatResult(){
        this.combatLog = new ArrayList<>();
        this.deaths = new ArrayList<>();
    }

    // Methods
    
    
    // Getters, Setters
    public void setWinner(Hero winner) {
        this.winner = winner;
    }

    public void setLog(ArrayList<CombatLog> combatLog) {
        this.combatLog = combatLog;
    }

    public void setDeaths(ArrayList<Hero> deaths) {
        this.deaths = deaths;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Hero getWinner() {
        return this.winner;
    }

    public ArrayList<CombatLog> getCombatLog() {
        return this.combatLog;
    }

    public ArrayList<Hero> getDeaths() {
        return this.deaths;
    }

    public Location getLocation() {
        return location;
    }
}
