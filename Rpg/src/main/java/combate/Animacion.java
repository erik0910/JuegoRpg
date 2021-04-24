package combate;
import java.awt.image.BufferedImage;

public class Animacion {
	private BufferedImage[] frames;
	private static BufferedImage[] swords;
	private int frameActual;
	private static int frameArma;
	private static long tiempoArma,delayArma;
	private long tiempoInicial,delay;//para que no exista problema entre las espada y el personaje
	
	public void setAnimacion(BufferedImage[] frames) { //Mandas una imagen y la cambias a la animaci�n privada del objeto que la ha llamado.
		this.frames = frames; //Cambiar las imagenes
		frameActual = 0;
		tiempoInicial = System.nanoTime();
	}
	public static void setAnimacionEspada(BufferedImage[] sword) { //Mandas una imagen y la cambias a la animaci�n privada del objeto que la ha llamado.
		swords= sword; //Cambiar las imagenes
		frameArma = 0;
		tiempoArma = System.nanoTime();
	}
	
	public void setDelay(long d) { delay = d; }
	//metodo para actuar en el buffrered teniendo en cuenta el tiempo de delay establecido
	public static void espadaUpdate() {
		if(delayArma == -1) return;
		long elapsed = (System.nanoTime() - tiempoArma) / 1000000;
		if(elapsed > delayArma) {
			frameArma++;
			tiempoArma = System.nanoTime();
		}
		if(frameArma == swords.length) frameArma = 0;
	}
	public void update() {
		if(delay == -1) return;
		long elapsed = (System.nanoTime() - tiempoInicial) / 1000000;
		if(elapsed > delay) {
			frameActual++;
			tiempoInicial = System.nanoTime();
		}
		if(frameActual == frames.length) frameActual = 0;
	}
	// getters y setter staticos y para el objeto animación
	public static int getFramespada() {return frameArma;}
	public static BufferedImage imagenArma() {return swords[frameArma];}
	public int getFrame() { return frameActual; }
	public BufferedImage getImage() { return frames[frameActual]; }
	public static void setDelayArma(long delay) {	delayArma=delay;}
	

}
