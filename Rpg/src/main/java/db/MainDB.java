package db;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.Query;
import javax.jdo.JDOHelper;
import javax.jdo.Transaction;
import javax.swing.JOptionPane;

import dinero.Monedero;

public class MainDB {

	private static PersistenceManagerFactory pmf;

	public MainDB() {
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}

	// Usar el void main para pruebas con la base de datos
	public static void main(String[] args) {
		System.out.println("DBManager inicializado");
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Monedero m = new Monedero();
			Partida partida = new Partida("PartidaEjemplo", 100, "caballero", 2, 2, 3, 3, m);
			System.out.println("Guardando partida " + partida.getNombrePartida());
			pm.makePersistent(partida);
			System.out.println("Devolviendo todas las partidas");
			Extent<Partida> e = pm.getExtent(Partida.class, true);
			Iterator<Partida> iter = e.iterator();

			while (iter.hasNext()) {
				Object obj = iter.next();
				System.out.println("> " + obj);
			}
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		System.out.println("DBManager finalizado");
		System.out.println("-----------------------------------------------------------------------");
	}

	// Metodo para guardar partida e insertar en la base de datos
	public void guardarPartida(Partida partida) {
		System.out.println("Guardando Partida");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			System.out.println("Guardando partida " + partida.getNombrePartida());
			pm.makePersistent(partida);
			tx.commit();
		} catch (Exception e){
			System.out.println("Excepcion guardando partida: " + e.getMessage());
			JOptionPane.showMessageDialog(null, "Nombre repetido, elija otro nombre para el guardado");
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		System.out.println("Guardado de partida completado");
		System.out.println("-----------------------------------------------------------------------");
	}

	// Metodo donde se da el nombre de la partida, se busca y se devuelve el objeto
	// Partida correspondiente
	@SuppressWarnings("unchecked")
	public String[] cargarPartida(String nombrePartida) {
		Partida p = new Partida();
		String[] info = new String[7];
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			System.out.println("Cargando partida con nombre " + nombrePartida);
//			Query<Partida> q = pm.newQuery("javax.jdo.query.SQL", "SELECT * FROM partida WHERE nombrePartida == " + nombrePartida);
//			q.setClass(Partida.class);
//			q.setUnique(true);
//			p = (Partida)q.execute();
			Extent<Partida> e = pm.getExtent(Partida.class);
			for (Partida partida: e) {
				if(partida.getNombrePartida().equals(nombrePartida)) {
					p = partida;
					System.out.println(p.toString());
				}
			}
			info[0] = p.getSkin();
			info[1] = Integer.toString(p.getX());
			info[2] = Integer.toString(p.getY());
			info[3] = Integer.toString(p.getX_dib());
			info[4] = Integer.toString(p.getY_dib());
			info[5] = Integer.toString(p.getMonedero().getDinero());
			info[6] = Integer.toString(p.getVida());
			tx.commit();
		} catch (Exception e) {
			System.out.println("Excepcion cargando partida: " + e.getMessage());
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		System.out.println("Finalizada la carga de partida");
		System.out.println("-----------------------------------------------------------------------");
		return info;
	}

	// Metodo para obtener la lista de partidas para luego mostrar en InterfazCargar
	public List<Partida> mostrarPartidas() {
		List<Partida> listPartidas = new ArrayList<Partida>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			System.out.println("Devolviendo todas las partidas");
			Extent<Partida> e = pm.getExtent(Partida.class);
			Iterator<Partida> iter = e.iterator();

			while (iter.hasNext()) {
				Partida p = iter.next();
				listPartidas.add(p);
				System.out.println("> " + p);
			}
			tx.commit();
		} catch (Exception e) {
			System.out.println("Excepcion con el muestreo de partidas: " + e.getMessage());
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		System.out.println("Finalizado metodo mostrarPartidas");
		System.out.println("-----------------------------------------------------------------------");
		return listPartidas;
	}

	// Limpieza de la base de datos y de todas las partidas
	public void borrarPartidas() {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			System.out.println("Borrado de partidas");
			Query<Partida> q = pm.newQuery(Partida.class);
			long numPartidasBorradas = q.deletePersistentAll();
			System.out.println("Borradas " + numPartidasBorradas + " partidas en total");
			tx.commit();
		}catch (Exception e) {
			System.out.println("Excepcion con el borrado de partidas: " + e.getMessage());
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		System.out.println("Borrado de partidas finalizado");
		System.out.println("-----------------------------------------------------------------------");
	}
}
