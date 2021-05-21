package db;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EstadisiticasTest {

	private Estadisticas estadisticas;
	private Estadisticas est1;
	
	@Before
	public void setUp() throws Exception {
		est1 = new Estadisticas("Jugador 1", 200, "skin 1", 100, 100);
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
		assertEquals(estadisticas.toString(), est1.toString());
	}

}
