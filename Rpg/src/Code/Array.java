package Code;

import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.EventQueue;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.Polygon;
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

	static Tiles[][] map = new Tiles[10][10];
	static Tiles suelo = new Tiles("grass", true, true, true, true, "e");
	static Tiles rio = new Tiles("river", false, false, false, false, "e");
	static Tiles puente = new Tiles("bridg", true, true, true, true, "e");
	static Tiles parez = new Tiles("walls", false, false, false, false, "e");
	static Tiles pelea = new Tiles("fight", true, true, true, true, "e");
	static int x = 5;
	static int y = 1;
	static int x_ant;
	static int y_ant;
	

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
		// setBounds(100, 100, 1200, 589);
		setBounds(100, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		for (int i = 0; i < 10; i++) {
			for (int u = 0; u < 10; u++) {

				map[i][u] = suelo;

			}
		}

		for (int p = 0; p < 10; p++) {

			map[0][p] = parez;
			map[9][p] = parez;
			map[p][0] = parez;
			map[p][9] = parez;

		}

		for (int y = 0; y < 10; y++) {

			map[y][5] = rio;
			map[y][4] = rio;
		}

		map[6][4] = puente;
		map[6][5] = puente;
		map[5][4] = puente;
		map[5][5] = puente;
		;

		map[6][8] = pelea;
		map[8][3] = pelea;
		map[2][2] = pelea;
		map[2][7] = pelea;

		// Consola
		for (int i = 0; i < 10; i++) {
			System.out.println();
			for (int u = 0; u < 10; u++) {

				if (i == x && u == y) {

					System.out.print("perso");
					System.out.print("  ");

				} else {
					System.out.print(map[i][u].getCode());
					System.out.print("  ");
				}

			}
		}

		dibujado();

	}

	/**
	 * public void paint(Graphics g) { super.paint(g); int count = 0; Graphics2D g2
	 * = (Graphics2D) g; // .drawLine(int x1, int y1, int x2, int y2)
	 * 
	 * for (int i = 0; i < 10; i++) {
	 * 
	 * for (int u = 0; u < 10; u++) {
	 * 
	 * if (i == x && u == y) {
	 * 
	 * Polygon polygon = new Polygon(); polygon.addPoint((50 + (145 * u + count)) /
	 * 2, (-50 + (100 * (10 - i))) / 2); polygon.addPoint((195 + (145 * u + count))
	 * / 2, (-50 + (100 * (10 - i))) / 2);
	 * 
	 * polygon.addPoint((95 + (145 * u + count)) / 2, (50 + (100 * (10 - i))) / 2);
	 * polygon.addPoint((-50 + (145 * u + count)) / 2, (50 + (100 * (10 - i))) / 2);
	 * 
	 * g2.setColor(Color.RED); g2.fillPolygon(polygon);
	 * 
	 * } else if (map[i][u].getCode().equals("grass")) {
	 * 
	 * Polygon polygon = new Polygon(); polygon.addPoint((50 + (145 * u + count)) /
	 * 2, (-50 + (100 * (10 - i))) / 2); polygon.addPoint((195 + (145 * u + count))
	 * / 2, (-50 + (100 * (10 - i))) / 2);
	 * 
	 * polygon.addPoint((95 + (145 * u + count)) / 2, (50 + (100 * (10 - i))) / 2);
	 * polygon.addPoint((-50 + (145 * u + count)) / 2, (50 + (100 * (10 - i))) / 2);
	 * 
	 * g2.setColor(Color.GREEN); g2.fillPolygon(polygon);
	 * 
	 * } else if (map[i][u].getCode().equals("river")) {
	 * 
	 * Polygon polygon = new Polygon(); polygon.addPoint((50 + (145 * u + count)) /
	 * 2, (-50 + (100 * (10 - i))) / 2); polygon.addPoint((195 + (145 * u + count))
	 * / 2, (-50 + (100 * (10 - i))) / 2);
	 * 
	 * polygon.addPoint((95 + (145 * u + count)) / 2, (50 + (100 * (10 - i))) / 2);
	 * polygon.addPoint((-50 + (145 * u + count)) / 2, (50 + (100 * (10 - i))) / 2);
	 * 
	 * g2.setColor(Color.BLUE); g2.fillPolygon(polygon);
	 * 
	 * } else if (map[i][u].getCode().equals("bridg")) {
	 * 
	 * Polygon polygon = new Polygon(); polygon.addPoint((50 + (145 * u + count)) /
	 * 2, (-50 + (100 * (10 - i))) / 2); polygon.addPoint((195 + (145 * u + count))
	 * / 2, (-50 + (100 * (10 - i))) / 2);
	 * 
	 * polygon.addPoint((95 + (145 * u + count)) / 2, (50 + (100 * (10 - i))) / 2);
	 * polygon.addPoint((-50 + (145 * u + count)) / 2, (50 + (100 * (10 - i))) / 2);
	 * 
	 * g2.setColor(Color.YELLOW); g2.fillPolygon(polygon);
	 * 
	 * } else if (map[i][u].getCode().equals("walls")) {
	 * 
	 * Polygon polygon = new Polygon(); polygon.addPoint((50 + (145 * u + count)) /
	 * 2, (-50 + (100 * (10 - i))) / 2); polygon.addPoint((195 + (145 * u + count))
	 * / 2, (-50 + (100 * (10 - i))) / 2);
	 * 
	 * polygon.addPoint((95 + (145 * u + count)) / 2, (50 + (100 * (10 - i))) / 2);
	 * polygon.addPoint((-50 + (145 * u + count)) / 2, (50 + (100 * (10 - i))) / 2);
	 * 
	 * g2.setColor(Color.GRAY); g2.fillPolygon(polygon);
	 * 
	 * } else if (map[i][u].getCode().equals("fight")) {
	 * 
	 * Polygon polygon = new Polygon(); polygon.addPoint((50 + (145 * u + count)) /
	 * 2, (-50 + (100 * (10 - i))) / 2); polygon.addPoint((195 + (145 * u + count))
	 * / 2, (-50 + (100 * (10 - i))) / 2);
	 * 
	 * polygon.addPoint((95 + (145 * u + count)) / 2, (50 + (100 * (10 - i))) / 2);
	 * polygon.addPoint((-50 + (145 * u + count)) / 2, (50 + (100 * (10 - i))) / 2);
	 * 
	 * g2.setColor(Color.MAGENTA); g2.fillPolygon(polygon);
	 * 
	 * } else {
	 * 
	 * Polygon polygon = new Polygon(); polygon.addPoint((50 + (145 * u + count)) /
	 * 2, (-50 + (100 * (10 - i))) / 2); polygon.addPoint((195 + (145 * u + count))
	 * / 2, (-50 + (100 * (10 - i))) / 2);
	 * 
	 * polygon.addPoint((95 + (145 * u + count)) / 2, (50 + (100 * (10 - i))) / 2);
	 * polygon.addPoint((-50 + (145 * u + count)) / 2, (50 + (100 * (10 - i))) / 2);
	 * 
	 * g2.setColor(Color.BLACK); g2.fillPolygon(polygon);
	 * 
	 * }
	 * 
	 * g2.setColor(Color.BLACK);
	 * 
	 * // Recta superior g2.drawLine((50 + (145 * u + count)) / 2, (-50 + (100 * (10
	 * - i))) / 2, (195 + (145 * u + count)) / 2, (-50 + (100 * (10 - i))) / 2);
	 * 
	 * // Recta inferior g2.drawLine((-50 + (145 * u + count)) / 2, (50 + (100 * (10
	 * - i))) / 2, (95 + (145 * u + count)) / 2, (50 + (100 * (10 - i))) / 2);
	 * 
	 * // Diagonal izquierda g2.drawLine((50 + (145 * u + count)) / 2, (-50 + (100 *
	 * (10 - i))) / 2, (-50 + (145 * u + count)) / 2, (50 + (100 * (10 - i))) / 2);
	 * 
	 * // Diagonal derecha g2.drawLine((195 + (145 * u + count)) / 2, (-50 + (100 *
	 * (10 - i))) / 2, (95 + (145 * u + count)) / 2, (50 + (100 * (10 - i))) / 2);
	 * 
	 * } count = count + 100; }
	 * 
	 * }
	 **/

	public void dibujado() {

		repaint();

		if (map[x][y].getCode() == ("fight")) {

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
				

				if (map[i][u].getCode().equals("grass")) {

					mapa.setIcon(new ImageIcon(prueba.class.getResource("/Imagenes/hierba.png")));

				} else if (map[i][u].getCode().equals("walls")) {

					if (u == 0 || u == 9) {

						mapa.setIcon(new ImageIcon(prueba.class.getResource("/Imagenes/paredgirada.png")));

					} else {

						mapa.setIcon(new ImageIcon(prueba.class.getResource("/Imagenes/pared.png")));
					}

				} else if (map[i][u].getCode().equals("river")) {

					//mapa.setIcon(new ImageIcon("C:\\Users\\david\\OneDrive\\Escritorio\\UNI\\Proceso de software\\water.gif"));
					
					mapa.setIcon(new ImageIcon(prueba.class.getResource("/Imagenes/Agua.png")));

				} else if (map[i][u].getCode().equals("bridg")) {

					mapa.setIcon(new ImageIcon(prueba.class.getResource("/Imagenes/bridge.png")));

				} else if (map[i][u].getCode().equals("fight")) {

					mapa.setIcon(new ImageIcon(prueba.class.getResource("/Imagenes/hierba.png")));
					pelea.setIcon(new ImageIcon(prueba.class.getResource("/Imagenes/calabera.png")));

				} else {

					mapa.setBackground(Color.BLACK);
				}

				if (i == x && u == y) {

					perso.setIcon(new ImageIcon(prueba.class.getResource("/Imagenes/transparente.png")));
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

		// Consola
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

		for (int i = 0; i < 10; i++) {
			System.out.println();
			for (int u = 0; u < 10; u++) {

				if (i == x && u == y) {

					System.out.print("perso");
					System.out.print("  ");

				} else {
					System.out.print(map[i][u].getCode());
					System.out.print("  ");
				}

			}
		}

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
	}

	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_DOWN) {

			if (x < 8) {

				if (map[x + 1][y].isDown()) {

					x_ant = x;
					y_ant = y;
					x = x + 1;
					dibujado();
				}

			}

		} else if (key == KeyEvent.VK_LEFT) {

			if (y > 1) {

				if (map[x][y - 1].isLeft()) {

					x_ant = x;
					y_ant = y;
					y = y - 1;
					dibujado();
				}

			}

		} else if (key == KeyEvent.VK_RIGHT) {

			if (y < 8) {

				if (map[x][y + 1].isRight()) {

					x_ant = x;
					y_ant = y;
					y = y + 1;
					dibujado();
				}

			}

		} else if (key == KeyEvent.VK_UP) {

			if (x > 1) {

				if (map[x - 1][y].isUp()) {

					x_ant = x;
					y_ant = y;
					x = x - 1;
					dibujado();
				}

			}

		}

	}

	public void keyReleased(KeyEvent arg0) {

	}

	public void keyTyped(KeyEvent arg0) {

	}

}
