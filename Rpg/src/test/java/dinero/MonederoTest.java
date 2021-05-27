package dinero;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mock;
import org.mockito.Mockito;

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

import categories.IntegrationTest;
import db.MainDBTest;


public class MonederoTest {

	
	Monedero moneda;
	
	final static Logger logger = LoggerFactory.getLogger(MonederoTest.class);
	
	
	
	@Rule
	public ContiPerfRule rule = new ContiPerfRule();

	
	
	
	@Test
	@PerfTest(invocations = 150)
	@Required(max = 20, average = 1)
	public void RendiTestMoneda() {
		logger.info("Starting RendiTestMoneda");
		moneda = new Monedero();
		assertTrue(moneda.getDinero() == 1000);
		logger.debug("Finishing RendiTestMoneda");
	}

	@Test
	@PerfTest(invocations = 125)
	@Required(max = 20, average = 1)
	public void RendiTestGanar() {
		logger.debug("Starting RendiTestGanar");
		moneda = new Monedero();
		moneda.ganar();
		assertTrue(moneda.getDinero() == 1100);
		logger.debug("Finishing RendiTestGanar");

	}

	@Test
	@PerfTest(invocations = 115)
	@Required(max = 20, average = 1)
	public void RendiTestPerder() {
		logger.debug("Starting RendiTestPerder");
		moneda = new Monedero();
		moneda.perder();
		assertTrue(moneda.getDinero() == 900);
		logger.debug("Finishing RendiTestPerder");

	}
	
	@Test
	@PerfTest(invocations = 200)
	@Required(max = 20, average = 1)
	public void compra() {
		logger.debug("Starting RendiTestCompra");
		moneda = new Monedero();
		moneda.compra(100);
		assertTrue(moneda.getDinero() == 900);	
		logger.debug("Finishing RendiTestCompra");
		
		
	}

}
