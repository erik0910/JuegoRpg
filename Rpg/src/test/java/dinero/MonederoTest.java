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
@Required(max = 1200, average = 100)
public class MonederoTest {

	Monedero moneda;
	
	@Rule
	public ContiPerfRule rule = new ContiPerfRule();
	
	@Test
	public void test() {
		
		moneda = new Monedero();
		assertTrue(moneda.getDinero() == 1000);
	
	}
	
}
