package servidor;

import java.util.List;
import combate.Player;
import db.Estadisticas;
import db.MainDB;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("estadisticas")
public class EstadisticasResource {
	
	MainDB db = new MainDB();
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Estadisticas> getEstadisticas() {

		List<Estadisticas> est = db.mostrarEstadisticas();

		return est;
    }
}

