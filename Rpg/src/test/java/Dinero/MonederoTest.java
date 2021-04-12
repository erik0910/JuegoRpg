package Dinero;

import static org.junit.Assert.*;

import org.junit.Test;

import dinero.Monedero;

public class MonederoTest {
//funcionamineto de la clase monedero
	@Test
	public void test() {
		Monedero mondeda= new Monedero();// este array deberia de poner en 1000 el mondero actual
		assertTrue(mondeda.getDinero()==1000);//deberia de dar true para que funcione
		mondeda.ganar();
		assertTrue(mondeda.getDinero()==1100);// ya que el metodo ganar nos incrementa 100 deberia de dar 1100 el total
		mondeda.perder();
		assertTrue(mondeda.getDinero()==1000);
		mondeda.compra(500);
		assertTrue(mondeda.getDinero()==500);// una vez comprado se le restara esa compra 
	}

}
