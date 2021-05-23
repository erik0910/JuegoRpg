package combate;

import static org.junit.Assert.*;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;
import org.junit.Test;

public class RoomTest {
	Room room;
	Boolean resultado;
	@Rule
	public ContiPerfRule rule = new ContiPerfRule();
	// funcionamento de los getters y setters player 1
	@Test
	public void funcionamineto() {
	Room.jugadores=false;
	Room.enemigos=true;
	Room room = new Room();
	resultado=room.playergetX(1)==25?true:false;// el valor establecido por el player 1 es 25 en el x
	assertTrue(resultado);
	resultado=room.playergetY(1)==100?true:false;// EL VALOR deberia de ser 50
	assertTrue(resultado);
	}
	
	@Test
	@PerfTest(invocations = 10)
	@Required(max = 90, average = 80)
	public void funcionaminetoJugador2() {
	Room.jugadores=false;
	Room.enemigos=true;
	Room room = new Room();
	resultado=room.playergetX(2)==50?true:false;// el valor establecido por el player 1 es 25 en el x
	assertTrue(resultado);
	resultado=room.playergetY(2)==200?true:false;// EL VALOR deberia de ser 50
	assertTrue(resultado);
	}
	
	@Test
	@PerfTest(invocations = 10)
	@Required(max = 90, average = 80)
	public void funcionaminetoenemigo3() {
	Room.jugadores=false;
	Room.enemigos=true;
	room = new Room();	
	resultado=room.playergetX(3)==100?true:false;// el valor establecido por el player 1 es 25 en el x
	assertTrue(resultado);
	resultado=room.playergetY(3)==100?true:false;// EL VALOR deberia de ser 50
	assertTrue(resultado);
	}
	@Test
	@PerfTest(invocations = 10)
	@Required(max = 90, average = 80)
	public void funcionaminetoJugador3() {
	Room.enemigos=false;
	Room.jugadores=true;
	room = new Room();	
	resultado=room.playergetX(3)==120?true:false;// el valor establecido por el player 1 es 25 en el x
	assertTrue(resultado);
	resultado=room.playergetY(3)==100?true:false;// EL VALOR deberia de ser 50
	assertTrue(resultado);
	}
	//parece que tiene un buen rendimineto la ia del primer personaje
	@Test
	@PerfTest(invocations = 100)//mas invocaciones para ver como funciona cuando tiene que cambiar de derecha a izquierda
	@Required(max = 90, average = 80)
	public void funcionaminetoia1() {
	Room.enemigos=false;
	Room.jugadores=false;
	room = new Room();	
	Room.bossIa();// relizamos la ia
	assertTrue(true);
	}
	//medimos el funcionamiento de la segunda ia en el juego para ver el funcionamiento
	@Test
	@PerfTest(invocations = 100)//mas invocaciones para ver como funciona cuando tiene que cambiar de derecha a izquierda
	@Required(max = 90, average = 80)
	public void funcionaminetoia2() {
	Room.enemigos=true;
	Room.jugadores=false;
	room = new Room();	
	Room.bossIa1();// relizamos la ia
	assertTrue(true);
	}
	//medimos el funcionamiento de todas la ias para ver como rinden
	@Test
	@PerfTest(invocations = 100)//mas invocaciones para ver como funciona cuando tiene que cambiar de derecha a izquierda
	@Required(max = 110, average = 90)// un poco mas de media por que puede ser mas pesado
	public void funcionaminetoias() {
	Room.enemigos=true;
	Room.jugadores=false;
	room = new Room();	
	Room.bossIa();// relizamos la ia
	Room.bossIa1();
	assertTrue(true);
	}
	// comprobamos la funcionalidad de estos métodos 
	@Test
	public void funcionaminetoiasTest() {
	Room.enemigos=true;
	Room.jugadores=false;
	room = new Room();	
	Room.bossIa();
	Room.bossIa1();
	resultado=Room.derecha&&Room.derecha1;
	assertTrue(resultado);
	}
}
