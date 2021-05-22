package combate;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ArmaTest {

	Armas test = new Armas(20, 10, 5);
	
	@Test
	public void getDanyo() {
		assertEquals(test.getDanyo(),20);
	}
	@Test
	public void getX() {
		assertEquals(test.getX(),10);
	}
	@Test
	public void getY() {
		assertEquals(test.getY(),5);
	}
	
}
