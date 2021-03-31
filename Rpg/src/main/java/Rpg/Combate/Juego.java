package Rpg.Combate;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
	public class Juego extends JPanel 
		implements Runnable, KeyListener{
		
		/*Ventana============================*/
		public static final int ANCHO = 320,ALTO = 240,SCALE = 2;
		/*===================================*/
		public static ArrayList<Integer> teclas = new ArrayList<Integer>();
		/*Limitador de FPS===================*/
		private Thread thread;
		private boolean running;
		private int FPS = 60;
		private long tiempo = 1000 / FPS;
		/*===================================*/
		
		/*Im�genes===========================*/
		private BufferedImage img;
		private Graphics2D g;
		/*===================================*/
		
		/*Constructor========================*/
		public Juego() {
			super();
			setPreferredSize(
					new Dimension(613, 477));
			setFocusable(true);
			requestFocus();	
		}
		/*====================================*/
		
		public void addNotify() {
			super.addNotify();
			if(thread == null) {
				thread = new Thread(this);
				addKeyListener(this);
				thread.start();
			}
		}
		
		private void init() {
			img = new BufferedImage(ANCHO, ALTO,BufferedImage.TYPE_INT_RGB);
			g = (Graphics2D) img.getGraphics();
			running = true;
			// new Room();
		}
		
		public void run() {
			init();
			long start, elapsed, wait;
			/*Bucle mort�l===============================*/
			while(running) {
				start = System.nanoTime(); //Tiempo inicial
				// Room.teclas();
				// update();
				// draw();
				pintarPantalla();
				elapsed = System.nanoTime() - start;
				wait = tiempo - elapsed / 1000000;
				if(wait < 0) wait = 5;
				try {Thread.sleep(wait);}
				catch(Exception e) {e.printStackTrace();}
			}
			/*===========================================*/
		}
		
		/*Room===========================================*/
		// private void update() {Room.update();}
		// private void draw() {Room.draw(g);}
		/*==============================================*/
		private void pintarPantalla() {
			Graphics g2 = getGraphics();
			g2.drawImage(img, 0, 0,ANCHO * SCALE, ALTO * SCALE,null);
			g2.dispose();
		}
		
		public void keyTyped(KeyEvent key) {}

		public void keyPressed(KeyEvent k){
		    if(!teclas.contains(k.getKeyCode())){
		        teclas.add(k.getKeyCode());
		    }
		}

		public void keyReleased(KeyEvent k){
		    if(teclas.contains(k.getKeyCode())){
		        teclas.remove(teclas.indexOf(k.getKeyCode()));
		    }
		}

	
}

