package combate;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DisparoTest {
	private Disparo d;
	int player;
	private int danyo;
	private double x;
	
	@Before
	public void setUp() throws Exception {
		d = new Disparo(2.0,2,true,3);
		player = 3;
		x = 2.0;
		danyo = 10;
		d.setDanyo(10);
	}

	@Test
	public void testgetPlayer() {
		assertEquals(player, d.getPlayer());
	}
	@Test
	public void testgetDanyo() {
		assertEquals(danyo, d.getDanyo());
	}
//	@Test
//	public void testgetX() {
//		assertEquals(x, d.getX());
//	}
	@Test
	public void testgetF() {
		assertEquals(false, d.getF());
	}

}
