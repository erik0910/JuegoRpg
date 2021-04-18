package mapa;

import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Robot;
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
	private Tiles[][] extra = new Tiles[50][50];
	private Tiles[][] guardado = new Tiles[50][50];
	static Tiles suelo = new Tiles("grass", true, true, true, true);
	static Tiles rio = new Tiles("river", false, false, false, false);
	static Tiles puente = new Tiles("bridg", true, true, true, true);
	static Tiles pared = new Tiles("walls", false, false, false, false);
	static Tiles pelea = new Tiles("fight", true, true, true, true);
	
	private Tiles tejado = new Tiles("roofs", false, false, false, false);
	private Tiles puerta = new Tiles("doors", true, true, true, true);
	private Tiles madera = new Tiles("woods", true, true, true, true);
	private Tiles casa = new Tiles("house", false, false, false, false);
	private Tiles shop = new Tiles("shops", true, true, true, true);
	private Tiles tallgrass = new Tiles("talls", true, true, true, true);
	private Tiles camino = new Tiles("paths", true, true, true, true);
	
	public int vida;
	
	static int x = 5;
	static int y = 5;
	static int x_ant;
	static int y_ant;
	static int x_dib = 0;
	static int y_dib = 0;
	static String direccion = "RIGHT";
	private static String skin = "";
	boolean in = false;

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
	public void setSkin(String skin) {
		Array.skin = skin;
	}
	
	public Array() {
		addKeyListener(this);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 730);
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
		mundo[2][2] = pelea;
		mundo[2][7] = pelea;

		// Pelas de boss y secreta
		mundo[48][1] = pelea;
		mundo[47][2] = pared;

		for (int y = 7; y < 48; y++) {

			mundo[47][y] = pared;
		}

		mundo[10][11] = tejado;
		mundo[10][12] = tejado;
		mundo[10][13] = tejado;

		mundo[11][12] = casa;
		mundo[11][11] = casa;
		mundo[11][13] = casa;
		mundo[12][11] = casa;
		mundo[12][13] = casa;
		mundo[12][12] = puerta;
		mundo[13][11] = tallgrass;
		mundo[13][13] = tallgrass;
		
		mundo[5][6] = camino;
		mundo[6][6] = camino;
		
		mundo[5][7] = camino;
		mundo[6][7] = camino;
		
		mundo[5][8] = camino;
		mundo[6][8] = camino;
		
		mundo[5][9] = camino;
		mundo[6][9] = camino;
		
		mundo[7][8] = camino;
		mundo[7][9] = camino;
		
		mundo[8][8] = camino;
		mundo[8][9] = camino;
		
		mundo[9][8] = camino;
		mundo[9][9] = camino;
		
		mundo[10][8] = camino;
		mundo[10][9] = camino;
		
		mundo[11][8] = camino;
		mundo[11][9] = camino;
		
		mundo[12][8] = camino;
		mundo[12][9] = camino;
		
		mundo[13][8] = camino;
		mundo[13][9] = camino;
		
		mundo[14][8] = camino;
		mundo[14][9] = camino;
		
		mundo[15][8] = camino;
		mundo[15][9] = camino;
		
		mundo[14][10] = camino;
		mundo[14][11] = camino;
		mundo[15][10] = camino;
		mundo[15][11] = camino;
		
		mundo[14][12] = camino;
		mundo[14][11] = camino;
		mundo[15][12] = camino;
		mundo[15][13] = camino;
		
		mundo[14][14] = camino;
		mundo[14][13] = camino;
		mundo[15][14] = camino;
		
		for (int i = 0; i < 50; i++) {
			for (int u = 0; u < 50; u++) {

				guardado[i][u] = mundo[i][u];
			}
		}

		for (int i = 0; i < 50; i++) {
			for (int u = 0; u < 50; u++) {

				extra[i][u] = suelo;

				for (int t = 5; t < 12; t++) {
					for (int p = 9; p < 16; p++) {
						extra[t][p] = madera;
						extra[8][12] = shop;
						extra[13][11] = tallgrass;
						extra[13][13] = tallgrass;
					}
				}
			}
		}
			extra[8][8] = casa;

			extra[4][8] = casa;
			extra[5][8] = casa;
			extra[6][8] = casa;
			extra[7][8] = casa;

			extra[9][8] = casa;
			extra[10][8] = casa;
			extra[11][8] = casa;
			extra[12][8] = casa;

			extra[4][9] = casa;
			extra[4][10] = casa;
			extra[4][11] = casa;
			extra[4][12] = casa;
			extra[4][13] = casa;
			extra[4][14] = casa;
			extra[4][15] = casa;
			extra[4][16] = casa;

			extra[12][9] = casa;
			extra[12][10] = casa;
			extra[12][11] = casa;
			extra[12][12] = puerta;
			extra[12][13] = casa;
			extra[12][14] = casa;
			extra[12][15] = casa;
			extra[12][16] = casa;

			extra[4][16] = casa;
			extra[5][16] = casa;
			extra[6][16] = casa;
			extra[7][16] = casa;
			extra[8][16] = casa;
			extra[9][16] = casa;
			extra[10][16] = casa;
			extra[11][16] = casa;
			extra[12][16] = casa;
				
		dibujado();

	}

	public void dibujado() {

		repaint();

		if (mundo[x][y].getCode() == ("fight")) {
			contentPane.setFocusable(false);
			Ventana.cargarCombate();

		}
		if (mundo[x][y].getCode() == ("shops")) {

			JOptionPane.showMessageDialog(null, "Tienda");

		}

		if (mundo[x][y].getCode() == ("doors")) {

			cargar();

		}
		repaint();

		// Visual
		this.getContentPane().removeAll();

		int pos_x = -70;

		int pos_y = -70;

		for (int i = 0; i < 10; i++) {

			pos_y = pos_y + 70;
			pos_x = -70;

			for (int u = 0; u < 10; u++) {

				JLabel mapa = new JLabel();
				JLabel perso = new JLabel();
				JLabel pelea = new JLabel();
				JLabel path = new JLabel();

				if (mundo[i + x_dib][u + y_dib].getCode().equals("grass")) {

					ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/hierba.png"));

					mapa.setIcon(imagenFondo);

				} else if (mundo[i + x_dib][u + y_dib].getCode().equals("walls")) {
						
					ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/pared.png"));

					mapa.setIcon(imagenFondo);

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
					
				} else if (mundo[i + x_dib][u + y_dib].getCode().equals("doors")) {

					ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/puerta.png"));

					mapa.setIcon(imagenFondo);

				} else if (mundo[i + x_dib][u + y_dib].getCode().equals("woods")) {
					
					ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/madera.png"));

					mapa.setIcon(imagenFondo);

				} else if (mundo[i + x_dib][u + y_dib].getCode().equals("roofs")) {

					ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/tejado.png"));

					mapa.setIcon(imagenFondo);

				} else if (mundo[i + x_dib][u + y_dib].getCode().equals("house")) {

					ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/casa_pared.png"));

					mapa.setIcon(imagenFondo);
					
				} else if (mundo[i + x_dib][u + y_dib].getCode().equals("shops")) {
					
					ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/madera.png"));

					mapa.setIcon(imagenFondo);
					
					ImageIcon imagenFondos = new ImageIcon(loader.getResource("mundo/Shop.png"));

					path.setIcon(imagenFondos);
					
				} else if (mundo[i + x_dib][u + y_dib].getCode().equals("talls")) {
					
					ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/hierba.png"));

					mapa.setIcon(imagenFondo);
					
					ImageIcon imagenFondos = new ImageIcon(loader.getResource("mundo/arbusto.png"));

					pelea.setIcon(imagenFondos);
					
				} else if (mundo[i + x_dib][u + y_dib].getCode().equals("paths")) {
					
					ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/grabilla.png"));

					mapa.setIcon(imagenFondo);
					
					ImageIcon imagenFondos = new ImageIcon(loader.getResource("mundo/camino.png"));

					path.setIcon(imagenFondos);

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

							ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/caballerodetras.png"));

							perso.setIcon(imagenFondo);

						} else if (direccion.equals("DOWN")) {

							ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/caballerodefrente.png"));

							perso.setIcon(imagenFondo);

						} else if (direccion.equals("RIGHT")) {

							ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/caballeroderecha.png"));

							perso.setIcon(imagenFondo);

						} else if (direccion.equals("LEFT")) {

							ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/caballeroizquierda.png"));

							perso.setIcon(imagenFondo);

						}
					// Mago (sin completar las imagenes)
					} else if(skin.equals("Kalgar de Boria")) {
						
						if (direccion.equals("UP")) {

							ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/magodetras.png"));

							perso.setIcon(imagenFondo);

						} else if (direccion.equals("DOWN")) {

							ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/magodelante.png"));

							perso.setIcon(imagenFondo);

						} else if (direccion.equals("RIGHT")) {

							ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/magoderecha.png"));

							perso.setIcon(imagenFondo);

						} else if (direccion.equals("LEFT")) {

							ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/magoizquierda.png"));

							perso.setIcon(imagenFondo);

						}
					
					} 
					
				}

				pos_x = pos_x + 70;
				pelea.setBounds(pos_x, pos_y, 70, 70);
				contentPane.add(pelea);
				perso.setBounds(pos_x, pos_y, 70, 70);
				contentPane.add(perso);
				path.setBounds(pos_x, pos_y, 70, 70);
				contentPane.add(path);
				mapa.setBounds(pos_x, pos_y, 70, 70);
				contentPane.add(mapa);
				repaint();
			}
		}

	}

	
	public void cargar() {

		try {
			Robot robot = new Robot();

			if (x > x_ant) {

				robot.keyPress(KeyEvent.VK_DOWN);
				robot.keyRelease(KeyEvent.VK_DOWN);

			} else if (x < x_ant) {

				robot.keyPress(KeyEvent.VK_UP);
				robot.keyRelease(KeyEvent.VK_UP);

			} else if (y > y_ant) {

				robot.keyPress(KeyEvent.VK_RIGHT);
				robot.keyRelease(KeyEvent.VK_RIGHT);

			} else if (y < y_ant) {

				robot.keyPress(KeyEvent.VK_LEFT);
				robot.keyRelease(KeyEvent.VK_LEFT);

			}

		} catch (Exception e) {

		}

		if (in == false) {

			for (int i = 0; i < 50; i++) {
				for (int u = 0; u < 50; u++) {

					mundo[i][u] = extra[i][u];

				}
			}

			in = true;

		} else if (in == true) {

			for (int i = 0; i < 50; i++) {
				for (int u = 0; u < 50; u++) {

					mundo[i][u] = guardado[i][u];

				}
			}

			in = false;
		}

		repaint();

	}
	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_DOWN) {

			if (x <= 47) {

				if (mundo[x + 1][y].isDown()) {
					
					y_ant = y;
					x_ant = x;
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
					
					y_ant = y;
					x_ant = x;
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

					y_ant = y;
					x_ant = x;
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

					y_ant = y;
					x_ant = x;
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
