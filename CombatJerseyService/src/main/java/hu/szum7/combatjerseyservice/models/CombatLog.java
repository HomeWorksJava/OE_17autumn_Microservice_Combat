package hu.szum7.combatjerseyservice.models;

import hu.szum7.combatjerseyservice.dummymodels.Hero;
import hu.szum7.combatjerseyservice.dummymodels.Location;
import hu.szum7.combatjerseyservice.dummymodels.Skill;

/**
 *
 * @author szum7
 */
public class CombatLog {
    
    private Hero protagonist;
    private Hero antagonist;
    private Location location;
    private Skill proSkill;
    private Skill antaSkill;
    private int proHitPoints;
    private int antaHitPoints;
    private int proHitPointDelta;
    private int antaHitPointDelta;
    
    public CombatLog(){
    }
    
    public CombatLog(Hero protagonist, Hero antagonist, Location location, Skill proSkill, Skill antaSkill, int proHitPointDelta, int antaHitPointDelta){
        this.protagonist = protagonist;
        this.antagonist = antagonist;
        this.location = location;
        this.proSkill = proSkill;
        this.antaSkill = antaSkill;
        this.proHitPointDelta = proHitPointDelta;
        this.antaHitPointDelta = antaHitPointDelta;
    }

    public Hero getProtagonist() {
        return protagonist;
    }

    public Hero getAntagonist() {
        return antagonist;
    }

    public Location getLocation() {
        return location;
    }

    public Skill getProSkill() {
        return proSkill;
    }

    public Skill getAntaSkill() {
        return antaSkill;
    }

    public int getProHitPoints() {
        return proHitPoints;
    }

    public int getAntaHitPoints() {
        return antaHitPoints;
    }

    public int getProHitPointDelta() {
        return proHitPointDelta;
    }

    public int getAntaHitPointDelta() {
        return antaHitPointDelta;
    }

    public void setProtagonist(Hero protagonist) {
        this.protagonist = protagonist;
    }

    public void setAntagonist(Hero antagonist) {
        this.antagonist = antagonist;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setProSkill(Skill proSkill) {
        this.proSkill = proSkill;
    }

    public void setAntaSkill(Skill antaSkill) {
        this.antaSkill = antaSkill;
    }

    public void setProHitPointDelta(int proHitPointDelta) {
        this.proHitPointDelta = proHitPointDelta;
    }

    public void setAntaHitPointDelta(int antaHitPointDelta) {
        this.antaHitPointDelta = antaHitPointDelta;
    }

    public void setProHitPoints(int proHitPoints) {
        this.proHitPoints = proHitPoints;
    }

    public void setAntaHitPoints(int antaHitPoints) {
        this.antaHitPoints = antaHitPoints;
    }
    
    @Override
    public String toString(){
        return this.protagonist + " " + this.antagonist + " " + this.proHitPoints + " " + this.antaHitPoints + " " + this.proHitPointDelta + " " + this.antaHitPointDelta + " " + this.proSkill + " " + this.antaSkill;
    }
    
}
