package db;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import dinero.Monedero;
import junit.framework.JUnit4TestAdapter;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(MockitoJUnitRunner.Silent.class)
public class MainDBTest {

	@Rule
	public ContiPerfRule rule = new ContiPerfRule();
	
	@Mock
	MainDB databaseMock;
	
	private static Partida partida = new Partida();
	private static Partida partida2 = new Partida();
	private static Estadisticas e1 = new Estadisticas();
	private static Estadisticas e2 = new Estadisticas();

	final static Logger logger = LoggerFactory.getLogger(MainDBTest.class);
	static int iteration = 0;
	
	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(MainDBTest.class);
	}
	
	@Before
	public void setUp2() {
		logger.info("Entering setUp: ");
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
		databaseMock.guardarPartida(partida);

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
		databaseMock.guardarEstadisticas(e1);

		e2.setDanyoarma(50);
		e2.setNombreJugador("Jugador2");
		e2.setEnergia(100);
		e2.setSkin("Ezio, el Arquero Centenario");
		e2.setVida(100);
//		db.guardarEstadisticas(e2);
		logger.info("Leaving setUp");
	}

	@BeforeClass
	public static void setUp() throws Exception {
		logger.info("Entering setUp before each test: {}", iteration++);
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

		e1.setDanyoarma(50);
		e1.setNombreJugador("Jugador1");
		e1.setEnergia(100);
		e1.setSkin("Ezio, el Arquero Centenario");
		e1.setVida(100);

		e2.setDanyoarma(50);
		e2.setNombreJugador("Jugador2");
		e2.setEnergia(100);
		e2.setSkin("Ezio, el Arquero Centenario");
		e2.setVida(100);
	}

	@Test
	public void testGuardarPartida() {
		logger.info("Starting testGuardarPartida");
		Mockito.lenient().when(databaseMock.guardarPartida(partida2)).thenReturn(true);
		logger.debug("Finishing testGuardarPartida");
	}

	@Test
	public void testGuardarEstadisticas() {
		logger.info("Starting testGuardarEstadisticas");
		Mockito.lenient().when(databaseMock.guardarEstadisticas(e2)).thenReturn(true);
		logger.debug("Finishing testGuardarEstadisticas");
	}

	@Test
	@PerfTest(invocations = 100, threads = 40)
	public void testCargarPartida() {
		logger.info("Starting testCargarPartida");
		String[] p = new String[9];
		p[0] = "Ezio, el Arquero Centenario"; p[1] = "8"; p[2] = "8"; p[3] = "3"; p[4] = "3"; p[5] = "1000"; p[6] = "100"; p[7] = "100"; p[8] = "50";
		when(databaseMock.cargarPartida("Example")).thenReturn(p);
		logger.debug("Finishing testCargarPartida");
	}

	@Test
	@PerfTest(invocations = 100, threads = 40)
	public void testMostrarPartidas() {
		logger.info("Starting testMostrarPartidas");
		List<Partida> listaExpected = new ArrayList<Partida>();
		listaExpected.add(partida);
		listaExpected.add(partida2);
		
		when(databaseMock.mostrarPartidas()).thenReturn(listaExpected);
		logger.debug("Finishing testMostrarPartidas");
	}

	@Test
	@PerfTest(invocations = 100, threads = 40)
	public void testMostrarEstadisticas() {
		logger.info("Starting testMostrarEstadisticas");
		List<Estadisticas> listaExpected = new ArrayList<Estadisticas>();
		listaExpected.add(e1);
		listaExpected.add(e2);
		
		when(databaseMock.mostrarEstadisticas()).thenReturn(listaExpected);
		logger.debug("Finishing testMostrarEstadisticas");
	}

}
