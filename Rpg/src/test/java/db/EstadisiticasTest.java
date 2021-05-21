package db;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EstadisiticasTest {

	private Estadisticas estadisticas;
	
	@Before
	public void setUp() throws Exception {
		estadisticas = new Estadisticas();
		estadisticas.setDanyoarma(100);
		estadisticas.setEnergia(100);
		estadisticas.setSkin("skin 1");
		estadisticas.setVida(200);
		estadisticas.setNombreJugador("Jugador 1");
	}

	@Test
	public void testGetters() {
		assertEquals(estadisticas.getNombreJugador(),"Jugador 1");
		assertEquals(estadisticas.getDanyoarma(), 100);
		assertEquals(estadisticas.getSkin(), "skin 1");
		assertEquals(estadisticas.getVida(), 200);
		assertEquals(estadisticas.getEnergia(), 100);
	}

}
