package combate;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerBossTest {
	public Player jugador;
	public Boolean resultado;

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
}
