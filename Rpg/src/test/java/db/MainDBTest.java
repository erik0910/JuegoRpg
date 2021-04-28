//package db;
//
//import static org.junit.Assert.*;
//
//import java.util.Iterator;
//
//import javax.jdo.Extent;
//import javax.jdo.JDOHelper;
//import javax.jdo.PersistenceManager;
//import javax.jdo.PersistenceManagerFactory;
//import javax.jdo.Transaction;
//
//import db.Partida;
//import dinero.Monedero;
//
//import org.junit.*;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.Mock;
//
//public class MainDBTest {
//	@Mock
//	static MainDB db;
//	static PersistenceManagerFactory pmf;
//	static Partida partida = new Partida();
//	
//	@BeforeClass
//	public static void setUp() throws Exception {
//		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
//		PersistenceManager pm = pmf.getPersistenceManager();
//		Transaction tx = pm.currentTransaction();
//		
//		Monedero m = new Monedero();
//		partida.setNombrePartida("Example");
//		partida.setSkin("Ezio, el Arquero Centenario");
//		partida.setVida(100);
//		partida.setX(8);
//		partida.setY(8);
//		partida.setX_dib(3);
//		partida.setY_dib(3);
//		partida.setMonedero(m);
//		
//		try {
//			tx.begin();
//			db.guardarPartida(partida);
//			tx.commit();
//		} finally {
//			if (tx.isActive()) {
//				tx.rollback();
//			}
//			pm.close();
//		}
//	}
//
//	@Test
//	public void testGuardarPartida() {
//		
//	}
//	
//	@Test
//	public void testCargarPartida() {
//		Partida p = new Partida();
//		PersistenceManager pm = pmf.getPersistenceManager();
//		Transaction tx = pm.currentTransaction();
//		try {
//			tx.begin();
//			Extent<Partida> e = pm.getExtent(Partida.class);
//			for (Partida partida: e) {
//				if(partida.getNombrePartida().equals("Example")) {
//					p = partida;
//					System.out.println(p.toString());
//				}
//			}
//			tx.commit();
//		} catch (Exception e) {
//			System.out.println("Excepcion cargando partida: " + e.getMessage());
//		} finally {
//			if (tx.isActive()) {
//				tx.rollback();
//			}
//			pm.close();
//		}
//		assertEquals(partida, p);
//	}
//	
//	@Test
//	public void testMostrarPartidas() {
//	}
//
//}
