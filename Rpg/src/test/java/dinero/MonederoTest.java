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

public class MonederoTest {

	Monedero moneda;

	

	@Rule
	public ContiPerfRule rule = new ContiPerfRule();

	@Test
	@PerfTest(invocations = 150)
	@Required(max = 5, average = 1)
	public void RendiTestMoneda() {

		moneda = new Monedero();
		assertTrue(moneda.getDinero() == 1000);

	}

	@Test
	@PerfTest(invocations = 125)
	@Required(max = 5, average = 1)
	public void RendiTestGanar() {
		moneda = new Monedero();
		moneda.ganar();
		assertTrue(moneda.getDinero() == 1100);

	}

	@Test
	@PerfTest(invocations = 115)
	@Required(max = 5, average = 1)
	public void RendiTestPerder() {
		moneda = new Monedero();
		moneda.perder();
		assertTrue(moneda.getDinero() == 900);

	}
	
	@Test
	@PerfTest(invocations = 200)
	@Required(max = 5, average = 1)
	public void compra() {
		moneda = new Monedero();
		moneda.compra(100);
		assertTrue(moneda.getDinero() == 900);		
	}

}
