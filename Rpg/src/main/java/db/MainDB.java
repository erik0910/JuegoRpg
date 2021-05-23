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
	}

	/** Metodo para guardar partida e insertar en la base de datos*/
	public boolean guardarPartida(Partida partida) {
		boolean res = false;
		System.out.println("Guardando Partida");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			System.out.println("Guardando partida " + partida.getNombrePartida());
			pm.makePersistent(partida);
			tx.commit();
			res = true;
		} catch (Exception e) {
			System.out.println("Excepcion guardando partida: " + e.getMessage());
			JOptionPane.showMessageDialog(null, "Nombre repetido, elija otro nombre para el guardado");
			res = false;
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		System.out.println("Guardado de partida completado");
		System.out.println("-----------------------------------------------------------------------");
		return res;
	}

	/**Metodo donde se da el nombre de la partida, se busca y se devuelve el objeto "Partida" correspondiente*/
	@SuppressWarnings("unchecked")
	public String[] cargarPartida(String nombrePartida) {
		Partida p = new Partida();
		String[] info = new String[9];
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
			for (Partida partida : e) {
				if (partida.getNombrePartida().equals(nombrePartida)) {
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
			info[7] = Integer.toString(p.getEnergia());
			info[8] = Integer.toString(p.getDanyoarma());
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

	/** Metodo para obtener la lista de partidas para luego mostrar en InterfazCargar*/
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

	/** Limpieza de la base de datos y de todas las partidas*/
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
		} catch (Exception e) {
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

	// Parte para las estadisticas
	
	/** Metodo para obtener la lista de estadisticas para luego mostrar en InterfazEstadisticas*/
	public List<Estadisticas> mostrarEstadisticas() {
		List<Estadisticas> listEstadisticas = new ArrayList<Estadisticas>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			System.out.println("Devolviendo todas las estadisticas de los jugadores");
			Extent<Estadisticas> e = pm.getExtent(Estadisticas.class);
			Iterator<Estadisticas> iter = e.iterator();

			while (iter.hasNext()) {
				Estadisticas est = iter.next();
				listEstadisticas.add(est);
				System.out.println("> " + est);
			}
			tx.commit();
		} catch (Exception e) {
			System.out.println("Excepcion con el muestreo de estadisticas: " + e.getMessage());
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		System.out.println("Finalizado metodo mostrarEstadisticas");
		System.out.println("-----------------------------------------------------------------------");
		return listEstadisticas;
	}
	/** Metodo para guardar estadisticas e insertar en la base de datos*/
	public boolean guardarEstadisticas(Estadisticas estadisticas) {
		boolean res = false;
		System.out.println("Guardando estadisticas...");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			System.out.println("Guardando estadisticas del jugador " + estadisticas.getNombreJugador());
			pm.makePersistent(estadisticas);
			tx.commit();
			res = true;
		} catch (Exception e) {
			System.out.println("Excepcion guardando estadisticas: " + e.getMessage());
			JOptionPane.showMessageDialog(null, "Nombre repetido, elija otro nombre para el guardado");
			res = false;
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		System.out.println("Guardado de estadisticas completado");
		System.out.println("-----------------------------------------------------------------------");
		return res;
	}
	/** Limpieza de la base de datos y de todas las estadisticas*/
	public void borrarEstadisticas() {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			System.out.println("Borrado de estadisticas");
			Query<Estadisticas> q = pm.newQuery(Estadisticas.class);
			long numEstadisticasBorradas = q.deletePersistentAll();
			System.out.println("Borradas " + numEstadisticasBorradas + " estadisticas en total");
			tx.commit();
		} catch (Exception e) {
			System.out.println("Excepcion con el borrado de estadisticas: " + e.getMessage());
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		System.out.println("Borrado de estadisticas finalizado");
		System.out.println("-----------------------------------------------------------------------");
	}
}
