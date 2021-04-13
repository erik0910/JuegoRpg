package mapa;

import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import combate.*;
import dinero.Monedero;

public class Array extends JFrame implements KeyListener {

	static Tiles[][] mundo = new Tiles[50][50];
	static Tiles suelo = new Tiles("grass", true, true, true, true);
	static Tiles rio = new Tiles("river", false, false, false, false);
	static Tiles puente = new Tiles("bridg", true, true, true, true);
	static Tiles pared = new Tiles("walls", false, false, false, false);
	static Tiles pelea = new Tiles("fight", true, true, true, true);
	static int x = 5;
	static int y = 5;
	static int x_ant;
	static int y_ant;
	static int x_dib = 0;
	static int y_dib = 0;
	static String direccion = "RIGHT";
	private static String skin = interfaces.InterfazPersonalizacion.skin;
	// atributo moneda que contendra la mondeda que disponde el jugador en ese momento
	public static Monedero cartera= new Monedero();
	
	private static final long serialVersionUID = 1L;
	
	static final ClassLoader loader = Array.class.getClassLoader();

	public static JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Array frame = new Array();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Array() {
		addKeyListener(this);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		for (int i = 0; i < 50; i++) {
			for (int u = 0; u < 50; u++) {

				mundo[i][u] = suelo;

				if (i == 0) {

					mundo[i][u] = pared;

				}
				if (i == 49) {

					mundo[i][u] = pared;

				}
				if (u == 0) {

					mundo[i][u] = pared;

				}
				if (u == 49) {

					mundo[i][u] = pared;

				}

			}
		}

		for (int i = 25; i < 30; i++) {
			for (int u = 25; u < 30; u++) {

				mundo[i][u] = pared;

			}
		}

		mundo[27][25] = suelo;
		mundo[27][26] = suelo;
		mundo[27][28] = suelo;

		mundo[26][26] = suelo;
		mundo[28][26] = suelo;

		mundo[26][27] = suelo;
		mundo[28][27] = suelo;

		mundo[26][28] = suelo;
		mundo[28][28] = suelo;

		mundo[27][27] = pelea;

		// Vertical
		for (int y = 1; y < 49; y++) {

			mundo[y][5] = rio;
			mundo[y][4] = rio;
		}

		// Horizontal
		for (int y = 1; y < 49; y++) {

			mundo[45][y] = rio;
			mundo[44][y] = rio;
		}

		// Horizontales
		mundo[45][10] = puente;
		mundo[44][10] = puente;
		mundo[45][11] = puente;
		mundo[44][11] = puente;

		mundo[45][16] = puente;
		mundo[44][16] = puente;
		mundo[45][15] = puente;
		mundo[44][15] = puente;

		mundo[45][20] = puente;
		mundo[44][20] = puente;
		mundo[45][21] = puente;
		mundo[44][21] = puente;

		mundo[45][27] = puente;
		mundo[44][27] = puente;
		mundo[45][26] = puente;
		mundo[44][26] = puente;

		mundo[45][35] = puente;
		mundo[44][35] = puente;
		mundo[45][34] = puente;
		mundo[44][34] = puente;

		mundo[45][45] = puente;
		mundo[44][45] = puente;
		mundo[45][44] = puente;
		mundo[44][44] = puente;

		// Cruce
		mundo[45][4] = puente;
		mundo[44][4] = puente;
		mundo[43][4] = puente;
		mundo[43][5] = puente;
		mundo[45][5] = puente;
		mundo[45][6] = puente;
		mundo[44][6] = puente;
		mundo[45][3] = puente;
		mundo[44][3] = puente;
		mundo[44][5] = puente;
		mundo[46][4] = puente;
		mundo[46][5] = puente;

		// Verticales
		mundo[6][4] = puente;
		mundo[6][5] = puente;
		mundo[5][4] = puente;
		mundo[5][5] = puente;

		mundo[16][4] = puente;
		mundo[16][5] = puente;
		mundo[15][4] = puente;
		mundo[15][5] = puente;

		mundo[27][4] = puente;
		mundo[27][5] = puente;
		mundo[26][4] = puente;
		mundo[26][5] = puente;

		mundo[35][4] = puente;
		mundo[35][5] = puente;
		mundo[34][4] = puente;
		mundo[34][5] = puente;

		// Demos
		mundo[6][8] = pelea;
		mundo[8][3] = pelea;
		mundo[2][2] = pelea;
		mundo[2][7] = pelea;

		// Pelas de boss y secreta
		mundo[48][1] = pelea;
		mundo[47][2] = pared;

		for (int y = 7; y < 48; y++) {

			mundo[47][y] = pared;
		}

		dibujado();

	}

	public void dibujado() {

		repaint();

		if (mundo[x][y].getCode() == ("fight")) {
			contentPane.setFocusable(false);
			Ventana.cargarCombate();

		}
		repaint();

		// Visual
		this.getContentPane().removeAll();

		int pos_x = -12;

		int pos_y = -35;

		for (int i = 0; i < 10; i++) {

			pos_y = pos_y + 60;
			pos_x = -12;

			for (int u = 0; u < 10; u++) {

				JLabel mapa = new JLabel();
				JLabel perso = new JLabel();
				JLabel pelea = new JLabel();

				if (mundo[i + x_dib][u + y_dib].getCode().equals("grass")) {

					ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/hierba.png"));

					mapa.setIcon(imagenFondo);

				} else if (mundo[i + x_dib][u + y_dib].getCode().equals("walls")) {

					if ((u == 0 || u == 9) && (i != 0 && i != 9)) {
						
						ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/paredgirada.png"));

						mapa.setIcon(imagenFondo);

					} else {

						ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/pared.png"));

						mapa.setIcon(imagenFondo);
					}

				} else if (mundo[i + x_dib][u + y_dib].getCode().equals("river")) {

					ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/Agua.png"));

					mapa.setIcon(imagenFondo);

				} else if (mundo[i + x_dib][u + y_dib].getCode().equals("bridg")) {

					ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/bridge.png"));

					mapa.setIcon(imagenFondo);
					
				} else if (mundo[i + x_dib][u + y_dib].getCode().equals("fight")) {

					ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/hierba.png"));

					mapa.setIcon(imagenFondo);
					
					ImageIcon imagendelante = new ImageIcon(loader.getResource("mundo/calabera.png"));

					pelea.setIcon(imagendelante);

				} else {

					mapa.setBackground(Color.BLACK);
				}

				if (i == x - x_dib && u == y - y_dib) {

					// Personajes

					// Arquero
					if (skin.equals("Ezio, el Arquero Centenario")) {
						
						if (direccion.equals("UP")) {
							
							ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/arquero_detras_sf.png"));

							perso.setIcon(imagenFondo);
							

						} else if (direccion.equals("DOWN")) {

							ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/arquero_delante_sf.png"));

							perso.setIcon(imagenFondo);
						} else if (direccion.equals("RIGHT")) {

							ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/arquero.png"));

							perso.setIcon(imagenFondo);

						} else if (direccion.equals("LEFT")) {

							ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/arquero_girado_sf.png"));

							perso.setIcon(imagenFondo);

						}
					// Caballero (faltan los sprites para el movimiento)
					} else if(skin.equals("Geralt de Rivia")) {
						
						if (direccion.equals("UP")) {

							ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/caballero.png"));

							perso.setIcon(imagenFondo);

						} else if (direccion.equals("DOWN")) {

							ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/caballero.png"));

							perso.setIcon(imagenFondo);

						} else if (direccion.equals("RIGHT")) {

							ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/caballero.png"));

							perso.setIcon(imagenFondo);

						} else if (direccion.equals("LEFT")) {

							ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/caballero.png"));

							perso.setIcon(imagenFondo);

						}
					// Mago (sin completar las imagenes)
					} else if(skin.equals("Kalgar de Boria")) {
						
						if (direccion.equals("UP")) {

							ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/caballero.png"));

							perso.setIcon(imagenFondo);

						} else if (direccion.equals("DOWN")) {

							ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/caballero.png"));

							perso.setIcon(imagenFondo);

						} else if (direccion.equals("RIGHT")) {

							ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/caballero.png"));

							perso.setIcon(imagenFondo);

						} else if (direccion.equals("LEFT")) {

							ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/caballero.png"));

							perso.setIcon(imagenFondo);

						}
					// Default	
					} 
//					else {
//						
//						if (direccion.equals("UP")) {
//
//							perso.setIcon(new ImageIcon(Array.class.getResource("mundo/arquero_detras_sf.png")));
//
//						} else if (direccion.equals("DOWN")) {
//
//							perso.setIcon(new ImageIcon(Array.class.getResource("mundo/arquero_delante_sf.png")));
//
//						} else if (direccion.equals("RIGHT")) {
//
//							perso.setIcon(new ImageIcon(Array.class.getResource("mundo/arquero.png")));
//
//						} else if (direccion.equals("LEFT")) {
//
//							perso.setIcon(new ImageIcon(Array.class.getResource("mundo/arquero_girado_sf.png")));
//
//						}
//					}
					
				}

				pos_x = pos_x + 60;
				pelea.setBounds(pos_x, pos_y, 70, 70);
				contentPane.add(pelea);
				perso.setBounds(pos_x, pos_y, 70, 70);
				contentPane.add(perso);
				mapa.setBounds(pos_x, pos_y, 70, 70);
				contentPane.add(mapa);

			}
		}
		
		/**
		// Consola 
		System.out.println();
		for (int i = 0; i < 50; i++) {
			System.out.println();
			for (int u = 0; u < 50; u++) {
				if (i == x && u == y) {
					System.out.print("perso");
					System.out.print(" ");
				} else {
					System.out.print(mundo[i][u].getCode());
					System.out.print(" ");
				}
			}
		}
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
	**/
	}

	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_DOWN) {

			if (x <= 47) {

				if (mundo[x + 1][y].isDown()) {

					x = x + 1;
					if (x > 5 && x < 46) {
						x_dib = x_dib + 1;
					}
				}
				direccion = "DOWN";
				dibujado();
			}

		} else if (key == KeyEvent.VK_LEFT) {

			if (y >= 2) {

				if (mundo[x][y - 1].isLeft()) {

					y = y - 1;
					if (y > 4 && y < 45) {
						y_dib = y_dib - 1;
					}
				}
				direccion = "LEFT";
				dibujado();
			}

		} else if (key == KeyEvent.VK_RIGHT) {

			if (y <= 47) {

				if (mundo[x][y + 1].isRight()) {

					y = y + 1;
					if (y > 5 && y < 46) {
						y_dib = y_dib + 1;
					}

				}
				direccion = "RIGHT";
				dibujado();

			}

		} else if (key == KeyEvent.VK_UP) {

			if (x >= 2) {

				if (mundo[x - 1][y].isUp()) {

					x = x - 1;
					if (x < 45 && x > 4) {
						x_dib = x_dib - 1;
					}
				}

				direccion = "UP";
				dibujado();

			}

		}

	}

	public void keyReleased(KeyEvent arg0) {

	}

	public void keyTyped(KeyEvent arg0) {

	}

}
