package dinero;

import static org.junit.Assert.*;

import org.junit.Test;

import dinero.Monedero;
import junit.framework.JUnit4TestAdapter;

import org.junit.Before;
import org.junit.Rule;
import org.databene.contiperf.Required;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.databene.contiperf.report.EmptyReportModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@PerfTest(invocations = 5)
@Required(max = 1200, average = 250)
public class MonederoTest {
//funcionamineto de la clase monedero
	Monedero moneda;
	static int iteration = 0;

//@Rule 
//public ContiPerfRule rule = new ContiPerfRule();
	@Before
	public void cargar() {
		iteration++;
		moneda = new Monedero();

	}

	// probaremos el rendiemiento de la aplicacion
	@Test
	@PerfTest(invocations = 1000, threads = 20)
	@Required(max = 120, average = 30)
	public void test() {
		moneda = new Monedero();// este array deberia de poner en 1000 el mondero actual
		assertTrue(moneda.getDinero() == 1000);// deberia de dar true para que funcione
		moneda.ganar();
		assertTrue(moneda.getDinero() == 1100);// ya que el metodo ganar nos incrementa 100 deberia de dar 1100 el total
		moneda.perder();
		assertTrue(moneda.getDinero() == 1000);
		moneda.compra(500);
		assertTrue(moneda.getDinero() == 500);// una vez comprado se le restara esa compra
		try {
			Thread.sleep(121);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
