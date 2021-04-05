package Code;

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

import Clases.Tiles;
import Clases.prueba;

public class Array extends JFrame implements KeyListener {

	static Tiles[][] mundo = new Tiles[50][50];
	static Tiles suelo = new Tiles("grass", true, true, true, true, "e");
	static Tiles rio = new Tiles("river", false, false, false, false, "e");
	static Tiles puente = new Tiles("bridg", true, true, true, true, "e");
	static Tiles parez = new Tiles("walls", false, false, false, false, "e");
	static Tiles pelea = new Tiles("fight", true, true, true, true, "e");
	static int x = 5;
	static int y = 5;
	static int x_ant;
	static int y_ant;
	static int x_dib = 0;
	static int y_dib = 0;
	static String direcccion = "UP";

	private static final long serialVersionUID = 1L;

	private static JPanel contentPane;

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

					mundo[i][u] = parez;

				}
				if (i == 49) {

					mundo[i][u] = parez;

				}
				if (u == 0) {

					mundo[i][u] = parez;

				}
				if (u == 49) {

					mundo[i][u] = parez;

				}

			}
		}

		for (int y = 0; y < 50; y++) {

			mundo[y][5] = rio;
			mundo[y][4] = rio;
		}

		mundo[6][4] = puente;
		mundo[6][5] = puente;
		mundo[5][4] = puente;
		mundo[5][5] = puente;

		mundo[6][8] = pelea;
		mundo[8][3] = pelea;
		mundo[2][2] = pelea;
		mundo[2][7] = pelea;

		dibujado();

	}

	public void dibujado() {

		repaint();

		if (mundo[x][y].getCode() == ("fight")) {

			JOptionPane.showMessageDialog(null, "Pelea");

			x = x_ant;
			y = y_ant;

		}

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

					mapa.setIcon(new ImageIcon(prueba.class.getResource("/Imagenes/hierba.png")));

				} else if (mundo[i + x_dib][u + y_dib].getCode().equals("walls")) {

					if ((u == 0 || u == 9) && (i != 0 && i != 9)) {
						mapa.setIcon(new ImageIcon(prueba.class.getResource("/Imagenes/paredgirada.png")));

					} else {

						mapa.setIcon(new ImageIcon(prueba.class.getResource("/Imagenes/pared.png")));
					}

				} else if (mundo[i + x_dib][u + y_dib].getCode().equals("river")) {

					// mapa.setIcon(new
					// ImageIcon("C:\\Users\\david\\OneDrive\\Escritorio\\UNI\\Proceso de
					// software\\water.gif"));

					mapa.setIcon(new ImageIcon(prueba.class.getResource("/Imagenes/Agua.png")));

				} else if (mundo[i + x_dib][u + y_dib].getCode().equals("bridg")) {

					mapa.setIcon(new ImageIcon(prueba.class.getResource("/Imagenes/bridge.png")));

				} else if (mundo[i + x_dib][u + y_dib].getCode().equals("fight")) {

					mapa.setIcon(new ImageIcon(prueba.class.getResource("/Imagenes/hierba.png")));
					pelea.setIcon(new ImageIcon(prueba.class.getResource("/Imagenes/calabera.png")));

				} else {

					mapa.setBackground(Color.BLACK);
				}

				if (i == x - x_dib && u == y - y_dib) {

					// Personajes

					// Caballero
					// perso.setIcon(new
					// ImageIcon(prueba.class.getResource("/Imagenes/caballero.png")));

					// Arquero
					if (direcccion.equals("UP")) {

						perso.setIcon(new ImageIcon(prueba.class.getResource("/Imagenes/arquero_detras_sf.png")));

					} else if (direcccion.equals("DOWN")) {

						perso.setIcon(new ImageIcon(prueba.class.getResource("/Imagenes/arquero_delante_sf.png")));

					} else if (direcccion.equals("RIGHT")) {

						perso.setIcon(new ImageIcon(prueba.class.getResource("/Imagenes/arquero.png")));

					} else if (direcccion.equals("LEFT")) {

						perso.setIcon(new ImageIcon(prueba.class.getResource("/Imagenes/arquero_girado_sf.png")));

					}

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
		 * // Consola System.out.println(); System.out.println(); System.out.println();
		 * System.out.println();
		 * 
		 * for (int i = 0; i < 50; i++) { System.out.println(); for (int u = 0; u < 50;
		 * u++) {
		 * 
		 * if (i == x && u == y) {
		 * 
		 * System.out.print("perso"); System.out.print(" ");
		 * 
		 * } else { System.out.print(mundo[i][u].getCode()); System.out.print(" "); }
		 * 
		 * } }
		 * 
		 * System.out.println(); System.out.println(); System.out.println();
		 * System.out.println(); System.out.println(); System.out.println();
		 **/
	}

	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_DOWN) {

			if (x <= 47) {

				if (mundo[x + 1][y].isDown()) {

					x_ant = x;
					y_ant = y;
					x = x + 1;
					if (x > 5 && x < 46) {
						x_dib = x_dib + 1;
					}
				}
				direcccion = "DOWN";
				dibujado();
			}

		} else if (key == KeyEvent.VK_LEFT) {

			if (y >= 2) {

				if (mundo[x][y - 1].isLeft()) {

					x_ant = x;
					y_ant = y;
					y = y - 1;
					if (y > 4 && y < 45) {
						y_dib = y_dib - 1;
					}
				}
				direcccion = "LEFT";
				dibujado();
			}

		} else if (key == KeyEvent.VK_RIGHT) {

			if (y <= 47) {

				if (mundo[x][y + 1].isRight()) {

					x_ant = x;
					y_ant = y;
					y = y + 1;
					if (y > 5 && y < 46) {
						y_dib = y_dib + 1;
					}

				}
				direcccion = "RIGHT";
				dibujado();

			}

		} else if (key == KeyEvent.VK_UP) {

			if (x >= 2) {

				if (mundo[x - 1][y].isUp()) {

					x_ant = x;
					y_ant = y;
					x = x - 1;
					if (x < 45 && x > 4) {
						x_dib = x_dib - 1;
					}
				}

				direcccion = "UP";
				dibujado();

			}

		}

	}

	public void keyReleased(KeyEvent arg0) {

	}

	public void keyTyped(KeyEvent arg0) {

	}

}
