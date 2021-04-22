package Combate;

import static org.junit.Assert.*;

import org.junit.Test;

import combate.Armas;
import combate.ColisionDisparos;

public class ColisionDisparosTest {
	

	@Test
	public void test() {
		//probamos la funcinalidad de la clase y como funciona con sus metodos a implementar
		ColisionDisparos nueva =new ColisionDisparos(10, 10, 20, 20);
		double x=10, y=10 ,alto=20 ,ancho=20;
		Boolean resultado=nueva.Colision(x, y, (int)alto, (int)ancho);
		assertTrue(resultado);//deberia de dar true ya que existela colision
	}
	//metodo para porbar como es la funcionalidad de la colision con la armas
 @Test
  public void armaPrueba() {
	 //Armas arma = new Armas(10, 10, 10, 10, 20, 25, 100, 30, null);
	//Boolean resultado= arma.ataque(20, 25, 100, 30);//deberia de dar true el ataque ya  que nos encontramos en la misma ubicación 
	 //assertTrue(resultado);
 }
}
