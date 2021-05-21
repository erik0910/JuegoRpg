package db;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import db.Partida;
import dinero.Monedero;

import org.junit.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class MainDBTest {
	
	private static MainDB db = new MainDB();
	private static Partida partida = new Partida();
	private static Partida partida2 = new Partida();
	private static Estadisticas e1 = new Estadisticas();
	private static Estadisticas e2 = new Estadisticas();
	
	@BeforeClass
	public static void setUp() throws Exception {
		db.borrarPartidas();
		db.borrarEstadisticas();
		Monedero m = new Monedero();
		partida.setNombrePartida("Example");
		partida.setSkin("Ezio, el Arquero Centenario");
		partida.setVida(100);
		partida.setX(8);
		partida.setY(8);
		partida.setX_dib(3);
		partida.setY_dib(3);
		partida.setMonedero(m);
		partida.setEnergia(100);
		partida.setDanyoarma(50);
		db.guardarPartida(partida);
		
		partida2.setNombrePartida("Example2");
		partida2.setSkin("Ezio, el Arquero Centenario");
		partida2.setVida(100);
		partida2.setX(8);
		partida2.setY(8);
		partida2.setX_dib(3);
		partida2.setY_dib(3);
		partida2.setMonedero(m);
		partida2.setEnergia(100);
		partida2.setDanyoarma(50);
		
		e1.setDanyoarma(50);
		e1.setNombreJugador("Jugador1");
		e1.setEnergia(100);
		e1.setSkin("Ezio, el Arquero Centenario");
		e1.setVida(100);
		db.guardarEstadisticas(e1);
		
		e2.setDanyoarma(50);
		e2.setNombreJugador("Jugador2");
		e2.setEnergia(100);
		e2.setSkin("Ezio, el Arquero Centenario");
		e2.setVida(100);
	}
	
	@Before
	public void setUp2() {
		Monedero m = new Monedero();
		partida.setNombrePartida("Example");
		partida.setSkin("Ezio, el Arquero Centenario");
		partida.setVida(100);
		partida.setX(8);
		partida.setY(8);
		partida.setX_dib(3);
		partida.setY_dib(3);
		partida.setMonedero(m);
		partida.setEnergia(100);
		partida.setDanyoarma(50);
		
		partida2.setNombrePartida("Example2");
		partida2.setSkin("Ezio, el Arquero Centenario");
		partida2.setVida(100);
		partida2.setX(8);
		partida2.setY(8);
		partida2.setX_dib(3);
		partida2.setY_dib(3);
		partida2.setMonedero(m);
		partida2.setEnergia(100);
		partida2.setDanyoarma(50);
	}

	@Test
	public void testGuardarPartida() {
		boolean res = false; 
		res = db.guardarPartida(partida2);
		assertTrue(res);
	}
	
	@Test
	public void testCargarPartida() {
		String[] p = new String[9];
		p = db.cargarPartida("Example");
		assertEquals("Ezio, el Arquero Centenario", p[0]);
		assertEquals("8", p[1]);
		assertEquals("8", p[2]);
		assertEquals("3", p[3]);
		assertEquals("3", p[4]);
		assertEquals("1000", p[5]);
		assertEquals("100", p[6]);
		assertEquals("100", p[7]);
		assertEquals("50", p[8]);
		
	}
	
//	@Test
//	public void testMostrarPartidas() {
//		System.out.println(partida.toString());
//		System.out.println(partida2.toString());
//		List<Partida> lista = new ArrayList<Partida>();
//		lista.add(partida);
//		lista.add(partida2);
//		
//		assertEquals(lista, db.mostrarPartidas());
//	}
	
	@Test
	public void testGuardarEstadisticas() {
		boolean res = false; 
		res = db.guardarEstadisticas(e2);
		assertTrue(res);
	}
	
	@After
	public void limpiezaTest() {
		db.borrarEstadisticas();
		db.borrarPartidas();
	}
}
