package combate;

import static org.junit.Assert.*;

import java.awt.Graphics;
import java.awt.Graphics2D;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;
import org.junit.Test;

public class PlayerBossTest {
	public Player jugador;
	public Boolean resultado;
	@Rule
	public ContiPerfRule rule = new ContiPerfRule();
	@SuppressWarnings("deprecation")
	// funcionamineto de los metodos de vida del jugador
	@Test
	public void pruebaFuncionamineto() {
		jugador = new Player(1);// inincialiazamos el jugador 
		jugador.setHealth(100);
		// metodos para getters y setter de la parte vida
		resultado = jugador.getHealth()==100?true:false;
		assertTrue(resultado);
		// metodos para mana
		jugador.setMana(100);
		resultado = jugador.getMana()==100?true:false;
		assertTrue(resultado);
		// metodos para vida
		jugador.setHealth(100);
		resultado = jugador.getHealth()==100?true:false;
		assertTrue(resultado);
	}
	
	// comprobar que funciona correctamente el método set false
	@Test
	public void setfalse() {
	jugador = new Player(1);
	jugador.setFalse();// aplicamos el método set false
	if(jugador.abajo==false && jugador.arriba== false && jugador.derecha== false&& jugador.izquierda==false) {
		assertTrue(true);
	}else {
		assertTrue(false);
	}
}
	// comprobación del método cambiar estdo de la clase player
	@Test
	public void cambiarEstado() {
		jugador = new Player(1);
		jugador.cambiarEstado();
		resultado= jugador.estado==2?true:false;// tiene que cambier el estado a 2
		assertTrue(resultado);
		jugador.cambiarEstado();
		resultado= jugador.estado==0?true:false;// tiene que cambiar el estado a 0
		assertTrue(resultado);
	}
	// metodo ataque
	@Test
	public void ataque() {
		jugador = new Player(1);
		jugador.setAtaque(true);
		assertTrue(jugador.ataque);
	}
	//funcionamiento del rendimiento de la clase usando los métodos prinxipales
	@Test
	@PerfTest(invocations = 100)// instanciamos 100 veces las clase para ver como funcionnaria al instanciar a muchos  jugadores en el juego
	@Required(max = 600, average = 100)
	public void Rendimientoclase() {
		jugador=new Player(2);
		jugador.animacion();
		jugador.cambiarEstado();
		jugador.checkSuelo();
		jugador.update();
		assertTrue(true);
	}
}
