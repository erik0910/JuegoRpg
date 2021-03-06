package combate;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import javax.swing.JPanel;

import interfaces.Mejoras;
import mapa.Array;


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
		private int FPS;
		private long tiempo;
		/*===================================*/
		
		/*Im�genes===========================*/
		private BufferedImage img;
		private Graphics2D g;
		/*===================================*/
		
		/*Constructor========================*/
		/**constructor de la clase juego*/
		public Juego() {
			super();
			
			setPreferredSize(
					new Dimension(613, 477));
			setFocusable(true);
			requestFocus();	
		}
		/*====================================*/
		/**Inicializa el thread para el juego */
		public void addNotify() {
			super.addNotify();
			if(thread == null) {
				thread = new Thread(this);
				addKeyListener(this);
				thread.start();
			}
		}
		/**Iniciador de la clase para cargar las variables */
		private void init() {
			img = new BufferedImage(ANCHO, ALTO,BufferedImage.TYPE_INT_RGB);
			g = (Graphics2D) img.getGraphics();
			running = true;
			new Room();
		}
		/**El hilo principal del programa */
		public void run() {
		
			int i = 0;
			List<String> arrayList = new ArrayList<String>();
			
			//Lectura de la configuracion
			File file = new File(".\\src\\main\\java\\Resources\\Opciones.txt");
			if(file.length()!=0) {
				try {
				      Scanner myReader = new Scanner(file);
				      while (myReader.hasNextLine()) {
				        arrayList.add(myReader.nextLine());
				        i++;
				      }
				      myReader.close();
				} catch (FileNotFoundException e1) {
				     
				}
				
			}
			String[] data = arrayList.toArray(new String[5]);
			int newFPS = Integer.parseInt(data[2]);
			this.FPS = newFPS;
			this.tiempo = 1000/this.FPS; 
			
			init();
			long start, elapsed, wait;
			/*                Bucle mortal                    */
			while(running) {
				start = System.nanoTime(); //Tiempo inicial
				Room.teclas();
				update();
				draw();
				pintarPantalla();
				//Arranque de las dos ias
				Room.bossIa();
				if(Room.enemigo()) {Room.bossIa1();}
				if(Room.finalizar) {
					//metodo que comprobara que el jugador haya ganado o no y de recompensa o quite en base a ello
					if(Room.estado) {
					Array.cartera.ganar();
					Array.sonido.stop();
					if(Room.jugadores) {Array.cartera.setDinero(2000);}// cuando se gana a un boss se obtiene una recompensa grande por parte del jugador
					if(Room.enemigos) {Array.cartera.setDinero(500);}// un incremento de dinero por enfrentarse a diversos jugadores
					}else {
						Array.cartera.perder();
						Array.sonido.stop();
					}
					Array.cont ++;
					Array.contentPane.setFocusable(true);
					Room.finalizar=false;
					running = false;
					Ventana.window.dispose();
					//fase de mejora de arma si conseguimos ganar 3 partidas
					if(Array.cont==3) {
						Array.cont=0;
						Mejoras.iniciar();
						}
				}
				elapsed = System.nanoTime() - start;
				wait = tiempo - elapsed / 1000000;
				if(wait < 0) wait = 5;
				try {Thread.sleep(wait);}
				catch(Exception e) {
				
				}
			}
			/*===========================================*/
		}
		
		
		/*Room===========================================*/
		/**actualización del estado*/
		private void update() {Room.update();}
		/**metodo de pintado */
		private void draw() {Room.draw(g);}
		/*==============================================*/
		/**metodo para pintar el mapa */
		private void pintarPantalla() {
			Graphics g2 = getGraphics();
			g2.drawImage(img, 0, 0,ANCHO * SCALE, ALTO * SCALE,null);
			g2.dispose();
		}
		/**metodo para teclas */
		public void keyTyped(KeyEvent key) {}
		/**metodo para teclas*/
		public void keyPressed(KeyEvent k){
		    if(!teclas.contains(k.getKeyCode())){
		        teclas.add(k.getKeyCode());
		    }
		}
		/**metodo para teclas */
		public void keyReleased(KeyEvent k){
		    if(teclas.contains(k.getKeyCode())){
		        teclas.remove(teclas.indexOf(k.getKeyCode()));
		    }
		}

	
}

