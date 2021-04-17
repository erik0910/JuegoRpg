package db;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import java.util.Iterator;

import javax.jdo.Extent;
import javax.jdo.Query;
import javax.jdo.JDOHelper;
import javax.jdo.Transaction;


public class MainDB {

	private static PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	
	// Usar el void main para pruebas con la base de datos
	public static void main(String[] args) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
//		Partida partida = new Partida();
//		partida.setNombrePartida("PartidaEjemplo");
//		partida.setSkin("caballero");
//		partida.setVida(100);
//		partida.setX(2);
//		partida.setX_dib(2);
//		partida.setY(3);
//		partida.setY_dib(3);
		try {
			tx.begin();
			Partida partida = new Partida("PartidaEjemplo", 100, "caballero",2,2,3,3);
			System.out.println("Guardando partida " + partida.getNombrePartida());
			pm.makePersistent(partida);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		System.out.println("");
	}

	// Metodo para guardar partida e insertar en la base de datos
	public void guardarPartida(Partida partida) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			System.out.println("Guardando partida " + partida.getNombrePartida());
			pm.makePersistent(partida);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		System.out.println("");
	}

	// Metodo donde se da el nombre de la partida, se busca y se devuelve el objeto
	// Partida correspondiente
	public void cargarPartida(String nombrePartida) {

	}

	// Metodo para obtener la lista de partidas para luego mostrar en InterfazCargar
	public void mostrarPartidas() {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			System.out.println("Devolviendo todas las partidas");
			Extent<Partida> e = pm.getExtent(Partida.class, true);
			Iterator<Partida> iter = e.iterator();

			while (iter.hasNext()) {
				Object obj = iter.next();
				System.out.println("> " + obj);
			}
			tx.commit();
		} catch (Exception e) {
			System.out.println("Exception thrown during retrieval of Extent : " + e.getMessage());
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		System.out.println("");
	}

	// Limpieza de la base de datos y de todas las partidas
	public void borrarPartidas() {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			System.out.println("Borrado de partidas");
//			Query<Partida> q = pm.newQuery(Partida.class);
//			long numPartidasBorradas = q.deletePersistentAll();
//			System.out.println("Borradas " + numPartidasBorradas + " partidas en total");
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}
}
