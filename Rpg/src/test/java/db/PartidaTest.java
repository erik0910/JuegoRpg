package db;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dinero.Monedero;

public class PartidaTest {
	
	private Partida prueba = new Partida();
	private Partida prueba2;
	private Monedero m = new Monedero();
	
	@Before
	public void setUp() {
		prueba2 = new Partida("PARTIDA", 100, "caballero", 2, 2, 3, 3, m, 50, 100);
		prueba.setMonedero(m);
		prueba.setNombrePartida("PARTIDA");
		prueba.setSkin("caballero");
		prueba.setVida(100);
		prueba.setX(2);
		prueba.setY(2);
		prueba.setX_dib(3);
		prueba.setY_dib(3);
		prueba.setDanyoarma(50);
		prueba.setEnergia(100);
	}
	@Test
	public void testGetters() {
		assertEquals(prueba.getNombrePartida(),"PARTIDA");
		assertEquals(prueba.getMonedero(), m);
		assertEquals(prueba.getSkin(), "caballero");
		assertEquals(prueba.getVida(), 100);
		assertEquals(prueba.getX(), 2);
		assertEquals(prueba.getY(), 2);
		assertEquals(prueba.getX_dib(), 3);
		assertEquals(prueba.getY_dib(), 3);
		assertEquals(prueba.getDanyoarma(), 50);
		assertEquals(prueba.getEnergia(), 100);
	}
	@Test 
	public void testConstructor() {
		assertEquals(prueba2.toString(), prueba.toString());
	}
	@Test
	public void testSetters() {
		prueba.setMonedero(m);
		prueba.setNombrePartida("PARTIDA");
		prueba.setSkin("caballero");
		prueba.setVida(100);
		prueba.setX(2);
		prueba.setY(2);
		prueba.setX_dib(3);
		prueba.setY_dib(3);
		prueba.setDanyoarma(50);
		prueba.setEnergia(100);
		assertEquals(prueba.getNombrePartida(),"PARTIDA");
		assertEquals(prueba.getMonedero(), m);
		assertEquals(prueba.getSkin(), "caballero");
		assertEquals(prueba.getVida(), 100);
		assertEquals(prueba.getX(), 2);
		assertEquals(prueba.getY(), 2);
		assertEquals(prueba.getX_dib(), 3);
		assertEquals(prueba.getY_dib(), 3);
		assertEquals(prueba.getDanyoarma(), 50);
		assertEquals(prueba.getEnergia(), 100);
	}

}
