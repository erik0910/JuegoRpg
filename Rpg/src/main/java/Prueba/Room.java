package Prueba;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List; //Op

import javax.swing.JComponent;

public class Room {
	private static Fondo fondo;
	private static Player[] player = {null, new Player(1),new Player(2)};//, player2;
	private static Disparo disparo;
	public static List<Disparo> disparos = new ArrayList<Disparo>();
	private static boolean[] disp = {true, false, false};
	private static int tempdisp = -1, borrar = -1, fin = 0;	
	
	public Room() {
		fondo = new Fondo("/Prueba/Backgrounds/grassbg1.gif", 0.1);
		for(int i = 1; i <= 2; i++) {
			player[i] = new Player(i);
			player[i].setPosition(100*i, 100*i);
		}
	}
	
	public static void update() {for(int i = 1; i <= 2; i++) player[i].update();} //Llamar al update de los 2 jugadores
	
	public static void draw(Graphics2D g) {
		fondo.draw(g); //Pintar el fondo
		borrar = -1; //Resetear el index de borrado de la arraylist de disparos.
		for(int i = 1; i <= 2; i++) player[i].draw(g); //Pintar los 2 jugadores
		
		for(Disparo dispis: disparos) { //Recorrer disparos
			dispis.draw(g); //Pintar los disparos
			if(dispis.getX() > 320 || dispis.getX() < 0) borrar = disparos.indexOf(dispis); else dispis.update(); //Si hay un disparo fuera del campo almacenar su index.
			if(dispis.getF()){ //F es si el disparo ha entrado en colisión con el disparo, es decir, éste disparo debeía haber acabado y se debe restar hp del jugador.
				int obj = dispis.getPlayer()==1?2:1; //Almacenar el jugador al que está dirigido el ataque.
				player[obj].setHealth((player[obj].getHealth()-dispis.getDaño())); //Restarle la vida al jugador
				System.out.println("Vida del player"+obj+": "+player[obj].getHealth()); //Mostrar la vida
				if(player[obj].getHealth() <= 0) { //Si el pj ha muerto
					if(obj == 1) fin = 2; else fin = 1; //Fin almacena el personaje que ha ganado.
					System.out.println("Gana el player"+fin); //Mostrar el personaje ganador.
				}
				borrar = disparos.indexOf(dispis); //almacenar el index del disparo.
			}
		}
		if(borrar != -1) disparos.remove(borrar); //Borrar el disparo
	}
	
	public static void teclas() {
		player[1].setFalse();
		player[2].setFalse();
		
		//Player1=====================================================
		if(Juego.teclas.contains(KeyEvent.VK_LEFT)) player[1].setIzquierda(true);
		if(Juego.teclas.contains(KeyEvent.VK_RIGHT)) player[1].setDerecha(true);
		if(Juego.teclas.contains(KeyEvent.VK_DOWN)) player[1].setAbajo(true);
		if(Juego.teclas.contains(KeyEvent.VK_UP)) player[1].setSalto(true);
		if(Juego.teclas.contains(KeyEvent.VK_Q)) player[2].setPlaneo(true);
		if(Juego.teclas.contains(KeyEvent.VK_E)) disparo(2); else disp[2] = false;
		//======================================================
		//Player2=====================================================
		if(Juego.teclas.contains(KeyEvent.VK_A)) player[2].setIzquierda(true);
		if(Juego.teclas.contains(KeyEvent.VK_D)) player[2].setDerecha(true);
		if(Juego.teclas.contains(KeyEvent.VK_S)) player[2].setAbajo(true);
		if(Juego.teclas.contains(KeyEvent.VK_W)) player[2].setSalto(true);
		if(Juego.teclas.contains(KeyEvent.VK_K)) player[1].setPlaneo(true);
		if(Juego.teclas.contains(KeyEvent.VK_L)) disparo(1); else disp[1] = false;
		
		//============================================================
	}
	
	public static double playergetX(int p) {return player[p].getx();}
	public static double playergetY(int p) {return player[p].gety();}
	public static int playergetAncho(int p) {return player[p].getancho();}
	public static int playergetAlto(int p) {return (int) player[p].getAlto();}
	
	public static void disparo(int p) {
		System.out.println("Disparo "+p);
		if(!disp[p] && player[p].getMana() >= player[p].getManad1() && fin == 0) {
			player[p].setAtaque(true); 
			if(tempdisp == -1) disparo/*[numDisparos]*/ = new Disparo(player[p].getx(), player[p].gety(), player[p].getmDerecha(), p);
			else disparo/*[tempdisp]*/ = new Disparo(player[p].getx(), player[p].gety(), player[p].getmDerecha(), p);
			disparos.add(disparo);
			disp[p] = true;
			double mana = player[p].getMana();
			player[p].setMana(mana-=player[p].getManad1());
		}
	}
}













