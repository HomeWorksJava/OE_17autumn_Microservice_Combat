package hu.szum7.combatjerseyservice.models;

import hu.szum7.combatjerseyservice.dummymodels.Hero;
import hu.szum7.combatjerseyservice.dummymodels.Location;
import hu.szum7.combatjerseyservice.dummymodels.Skill;
import hu.szum7.combatjerseyservice.dummyresources.HeroResource;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author szum7
 */
public class Combat {
    
    // Properties
    private Hero hero;
    private Location location;
    private CombatResult combatResult;

    // Contructor
    public Combat(Hero hero, Location location) {
        this.hero = hero;
        this.location = location;
        this.combatResult = new CombatResult();
    }

    // Methods
    private ArrayList<Hero> getDefenderHeroes(Hero h) {
        
        ArrayList<Hero> hs = HeroResource.getDummyHeroes();

        int i = 0;
        while (i < hs.size() && hs.get(i).getId() != h.getId()) {
            i++;
        }
        if (i < hs.size()) {
            hs.remove(i);
        }
        return hs;
    }

    public void fight() {

        ArrayList<Hero> antagonists = getDefenderHeroes(this.hero);
        int i = 0;
        int proHitPointPercent = 100;
        int antaHitPointPercent = 100;
        while (i < antagonists.size() && proHitPointPercent > 0) {

            CombatLog cl = new CombatLog();

            // Heroes
            cl.setProtagonist(this.hero);
            cl.setAntagonist(antagonists.get(i));

            // Hit point
            cl.setProHitPoints(proHitPointPercent);
            cl.setAntaHitPoints(antaHitPointPercent);

            // Skills used
            // TODO get skills based on some(?) logic
            cl.setProSkill(new Skill("Confident look!"));
            cl.setAntaSkill(new Skill("Menacing look!"));

            // Hit point losses (or gains)
            // TODO calculate hit point delta based on some(?) logic
            int damageToPro = ThreadLocalRandom.current().nextInt(0, 50);
            int damageToAnta = ThreadLocalRandom.current().nextInt(0, 80);
            cl.setProHitPointDelta(damageToPro);
            cl.setAntaHitPointDelta(damageToAnta);

            // Set hit points
            proHitPointPercent -= damageToPro;
            antaHitPointPercent -= damageToAnta;
            if (antaHitPointPercent <= 0) {
                this.combatResult.getDeaths().add(antagonists.get(i));
                antaHitPointPercent = 100;
                i++;
            }

            // Add the log to the results
            this.combatResult.getCombatLog().add(cl);
        }
        
        this.combatResult.setLocation(this.location);

        if (i < antagonists.size()) {
            this.combatResult.setWinner(antagonists.get(i));
            this.combatResult.getDeaths().add(this.hero);
        } else {
            this.combatResult.setWinner(this.hero);
        }
    }

    // Getters, setters
    public Hero getHero() {
        return hero;
    }

    public Location getLocation() {
        return location;
    }

    public CombatResult getCombatResult() {
        return this.combatResult;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setCombatResult(CombatResult combatResult) {
        this.combatResult = combatResult;
    }
}
