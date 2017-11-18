package hu.szum7.combatjerseyservice.resources;

import hu.szum7.combatjerseyservice.dummymodels.Hero;
import hu.szum7.combatjerseyservice.dummymodels.Location;
import hu.szum7.combatjerseyservice.dummyresources.HeroResource;
import hu.szum7.combatjerseyservice.dummyresources.LocationResource;
import hu.szum7.combatjerseyservice.models.Combat;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import hu.szum7.combatjerseyservice.models.CombatResult;

/**
 *
 * @author szum7
 */
@Path("combat")
public class CombatResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";CHARSET=UTF8")
    @Path("{proId}/{locId}")
    public CombatResult getCombatResult(@PathParam("proId") int proId, @PathParam("locId") int locId) {
        
        Hero h = HeroResource.getDummyHero(proId);
        Location l = LocationResource.getDummyLocation(locId);
        Combat c = new Combat(h, l);
        
        c.fight();
        
        return c.getCombatResult();
    }
}
