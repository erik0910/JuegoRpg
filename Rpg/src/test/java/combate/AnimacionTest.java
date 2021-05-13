package combate;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;

import org.junit.Before;
import org.junit.Test;

public class AnimacionTest {
	
	private Animacion a;
	private BufferedImage[] frames;
	private static BufferedImage[] swords;
	private int frameActual;
	private static int frameArma;
	private static long tiempoArma,delayArma;
	private long tiempoInicial;
	private long delay = 1000;
	
	@Before
	public void setUp() throws Exception {
		a = new Animacion();
	}

	@Test
	public void testgetFramespada() {
		assertEquals(frameArma, a.getFramespada());
	}
	@Test
	public void testgetFrame() {
		assertEquals(frameActual, a.getFrame());
	}

}
