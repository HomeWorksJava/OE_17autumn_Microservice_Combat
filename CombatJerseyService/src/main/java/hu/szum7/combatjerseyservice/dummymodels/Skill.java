package hu.szum7.combatjerseyservice.dummymodels;

/**
 *
 * @author szum7
 */
public class Skill {
    
    private String name;
    // ...
    
    public Skill(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString(){
        return this.name;
    }
}
