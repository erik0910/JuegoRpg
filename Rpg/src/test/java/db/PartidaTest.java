package db;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dinero.Monedero;

public class PartidaTest {
	
	private Partida prueba = new Partida();
	private Monedero m = new Monedero();
	
	@Before
	public void setUp() {
		prueba.setMonedero(m);
		prueba.setNombrePartida("PARTIDA");
		prueba.setSkin("caballero");
		prueba.setVida(100);
		prueba.setX(2);
		prueba.setY(2);
		prueba.setX_dib(3);
		prueba.setY_dib(3);
	}
	@Test
	public void testGetters() {
		assertEquals(prueba.getNombrePartida(),"PARTIDA");
		assertEquals(prueba.getMonedero(), m);
	}

}
