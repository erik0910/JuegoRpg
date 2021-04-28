package combate;

import static org.junit.Assert.*;

import org.junit.Test;

public class RoomTest {
	Room room;
	Boolean resultado;
	// funcionamento de los getters y setters player 1
	@Test
	public void funcionamineto() {
	Room room = new Room();
	resultado=room.playergetX(1)==25?true:false;// el valor establecido por el player 1 es 25 en el x
	assertTrue(resultado);
	resultado=room.playergetY(1)==100?true:false;// EL VALOR deberia de ser 50
	assertTrue(resultado);
	}
	
	@Test
	public void funcionaminetoJugador2() {
	Room room = new Room();
	resultado=room.playergetX(2)==50?true:false;// el valor establecido por el player 1 es 25 en el x
	assertTrue(resultado);
	resultado=room.playergetY(2)==200?true:false;// EL VALOR deberia de ser 50
	assertTrue(resultado);
	}
	
	@Test
	public void funcionaminetoJugador3() {
	room.variosEnemigos(true);
	room = new Room();	
	resultado=room.playergetX(3)==100?true:false;// el valor establecido por el player 1 es 25 en el x
	assertTrue(resultado);
	resultado=room.playergetY(3)==100?true:false;// EL VALOR deberia de ser 50
	assertTrue(resultado);
	}
	

}
