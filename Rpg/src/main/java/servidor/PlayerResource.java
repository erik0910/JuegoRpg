package servidor;

import java.util.List;
import combate.Player;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("players")
public class PlayerResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Player> getUsers() {
    	PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		
		Query<Player> q = pm.newQuery(Player.class);
		q.setOrdering("surname desc");
		
		List<Player> users = q.executeList();

		pm.close();
		
		return users;
    }
}

