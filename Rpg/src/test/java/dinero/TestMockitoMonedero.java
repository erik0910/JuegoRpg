package dinero;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;



@RunWith(MockitoJUnitRunner.class)
public class TestMockitoMonedero {

	Monedero monedero;
	
	
	CalculatorService calculatorService;

	@Mock
	private Monedas moneda;
	
	@Test
	public void testComprobarDinero() {
		
//		 when(moneda.MonedasActuales()).thenReturn(1000);
//		 when(calculatorService.getDiner()).thenReturn(1000);
//	     assertEquals(1000, calculatorService.getDiner());
		
	}

}
