package interfaces;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import mapa.Array;

public class InterfazTienda extends JFrame {

	static final ClassLoader loader = InterfazTienda.class.getClassLoader();
	public static FondoTiendaCargar contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazTienda frame = new InterfazTienda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public InterfazTienda() {
		contentPane = new FondoTiendaCargar();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		setBounds(100, 100, 700, 700);
		setResizable(false);
		getContentPane().setLayout(null);

		JLabel lblTitulo = new JLabel("TIENDA");
		lblTitulo.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 40));
		lblTitulo.setBounds(270, 0, 156, 39);
		getContentPane().add(lblTitulo);

		JButton btnEspada = new JButton("COMPRAR");
		btnEspada.setBackground(new Color(205, 133, 63));
		btnEspada.setForeground(new Color(0, 0, 0));
		btnEspada.setFont(new Font("Algerian", Font.PLAIN, 10));
		btnEspada.setBounds(25, 329, 93, 33);
		getContentPane().add(btnEspada);

		JButton btnEspada2 = new JButton("COMPRAR");
		btnEspada2.setBackground(new Color(205, 133, 63));
		btnEspada2.setFont(new Font("Algerian", Font.PLAIN, 10));
		btnEspada2.setBounds(25, 629, 93, 33);
		getContentPane().add(btnEspada2);

		JButton btnLanza = new JButton("COMPRAR");
		btnLanza.setBackground(new Color(205, 133, 63));
		btnLanza.setFont(new Font("Algerian", Font.PLAIN, 10));
		btnLanza.setBounds(263, 329, 92, 33);
		getContentPane().add(btnLanza);

		JButton btnLanza2 = new JButton("COMPRAR");
		btnLanza2.setBackground(new Color(205, 133, 63));
		btnLanza2.setFont(new Font("Algerian", Font.PLAIN, 10));
		btnLanza2.setBounds(263, 629, 92, 33);
		getContentPane().add(btnLanza2);

		JButton btnMalla = new JButton("COMPRAR\r\n");
		btnMalla.setBackground(new Color(205, 133, 63));
		btnMalla.setFont(new Font("Algerian", Font.PLAIN, 10));
		btnMalla.setBounds(492, 329, 93, 33);
		getContentPane().add(btnMalla);

		JButton btnMalla2 = new JButton("COMPRAR");
		btnMalla2.setBackground(new Color(205, 133, 63));
		btnMalla2.setFont(new Font("Algerian", Font.PLAIN, 10));
		btnMalla2.setBounds(492, 629, 93, 33);
		getContentPane().add(btnMalla2);

		JButton btnPropEspada = new JButton("STATS");
		btnPropEspada.setBackground(new Color(205, 133, 63));
		btnPropEspada.setFont(new Font("Algerian", Font.PLAIN, 10));
		btnPropEspada.setBounds(128, 329, 77, 33);
		getContentPane().add(btnPropEspada);

		JButton btnPropEspada2 = new JButton("STATS");
		btnPropEspada2.setBackground(new Color(205, 133, 63));
		btnPropEspada2.setFont(new Font("Algerian", Font.PLAIN, 10));
		btnPropEspada2.setBounds(128, 629, 77, 33);
		getContentPane().add(btnPropEspada2);

		JButton btnPropLanza = new JButton("STATS");
		btnPropLanza.setBackground(new Color(205, 133, 63));
		btnPropLanza.setFont(new Font("Algerian", Font.PLAIN, 10));
		btnPropLanza.setBounds(365, 329, 77, 33);
		getContentPane().add(btnPropLanza);

		JButton btnPropLanza2 = new JButton("STATS");
		btnPropLanza2.setBackground(new Color(205, 133, 63));
		btnPropLanza2.setFont(new Font("Algerian", Font.PLAIN, 10));
		btnPropLanza2.setBounds(365, 629, 77, 33);
		getContentPane().add(btnPropLanza2);

		JButton btnPropMalla = new JButton("STATS");
		btnPropMalla.setBackground(new Color(205, 133, 63));
		btnPropMalla.setFont(new Font("Algerian", Font.PLAIN, 10));
		btnPropMalla.setBounds(595, 328, 77, 34);
		getContentPane().add(btnPropMalla);

		JButton btnPropMalla2 = new JButton("STATS");
		btnPropMalla2.setBackground(new Color(205, 133, 63));
		btnPropMalla2.setFont(new Font("Algerian", Font.PLAIN, 10));
		btnPropMalla2.setBounds(595, 629, 77, 33);
		getContentPane().add(btnPropMalla2);

		JButton btnSalida = new JButton("SALIR");
		btnSalida.setBackground(new Color(210, 105, 30));
		btnSalida.setFont(new Font("Algerian", Font.PLAIN, 12));
		btnSalida.setBounds(10, 12, 83, 33);
		getContentPane().add(btnSalida);

		JLabel lblNewLabel = new JLabel("Espada nivel 1: 1200$");
		lblNewLabel.setFont(new Font("Algerian", Font.PLAIN, 15));
		lblNewLabel.setBounds(46, 73, 159, 29);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Lanza nivel 1: 1500$");
		lblNewLabel_1.setFont(new Font("Algerian", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(283, 73, 143, 29);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Malla nivel 1: 1400$");
		lblNewLabel_2.setFont(new Font("Algerian", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(518, 73, 145, 29);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Espada nivel 2: 2500$");
		lblNewLabel_3.setFont(new Font("Algerian", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(46, 372, 159, 29);
		getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("Lanza nivel 2: 2000$");
		lblNewLabel_3_1.setFont(new Font("Algerian", Font.PLAIN, 15));
		lblNewLabel_3_1.setBounds(283, 372, 143, 29);
		getContentPane().add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_1_1 = new JLabel("Malla nivel 2: 2100$");
		lblNewLabel_3_1_1.setFont(new Font("Algerian", Font.PLAIN, 15));
		lblNewLabel_3_1_1.setBounds(518, 372, 145, 29);
		getContentPane().add(lblNewLabel_3_1_1);

		JLabel lblEspada = new JLabel("");
		lblEspada.setBounds(46, 128, 150, 150);
		contentPane.add(lblEspada);
		ImageIcon imagenIcono = new ImageIcon(loader.getResource("tienda/espada.png"));
		lblEspada.setIcon(imagenIcono);

		JLabel lblLanza = new JLabel("");
		lblLanza.setBounds(283, 142, 150, 150);
		contentPane.add(lblLanza);
		ImageIcon imagenLanza = new ImageIcon(loader.getResource("tienda/lanza.png"));
		lblLanza.setIcon(imagenLanza);

		JLabel lblMalla = new JLabel("");
		lblMalla.setBounds(513, 142, 150, 150);
		contentPane.add(lblMalla);
		ImageIcon imagenMalla = new ImageIcon(loader.getResource("tienda/malla.png"));
		lblMalla.setIcon(imagenMalla);

		JLabel lblEspada2 = new JLabel("");
		lblEspada2.setBounds(46, 434, 150, 150);
		contentPane.add(lblEspada2);
		ImageIcon imagenEspada2 = new ImageIcon(loader.getResource("tienda/espada2.png"));
		lblEspada2.setIcon(imagenEspada2);

		JLabel lblLanza2 = new JLabel("");
		lblLanza2.setBounds(270, 434, 150, 150);
		contentPane.add(lblLanza2);
		ImageIcon imagenLanza2 = new ImageIcon(loader.getResource("tienda/lanza2.png"));
		lblLanza2.setIcon(imagenLanza2);

		JLabel lblMalla2 = new JLabel("");
		lblMalla2.setBounds(518, 434, 150, 150);
		contentPane.add(lblMalla2);
		ImageIcon imagenMalla2 = new ImageIcon(loader.getResource("tienda/malla2.png"));
		lblMalla2.setIcon(imagenMalla2);

		btnSalida.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		btnEspada.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Array.danyoarma = Array.danyoarma + 5;

				JOptionPane.showMessageDialog(null, "Espada nivel 1 comprada!");

			}
		});

		btnEspada2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Array.danyoarma = Array.danyoarma + 12;
				JOptionPane.showMessageDialog(null, "Espada nivel 2 comprada!");

			}
		});

		btnLanza.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Array.energia = Array.energia + 6;
				JOptionPane.showMessageDialog(null, "Lanza nivel 1 comprada!");

			}
		});
		btnLanza2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Array.energia = Array.energia + 11;
				JOptionPane.showMessageDialog(null, "Lanza nivel 2 comprada!");
			}
		});
		btnMalla.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Array.health = Array.health + 10;
				JOptionPane.showMessageDialog(null, "Malla nivel 1 comprada!");

			}
		});
		btnMalla2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Array.health = Array.health + 17;
				JOptionPane.showMessageDialog(null, "Malla nivel 2 comprada!");
			}
		});

		btnPropEspada.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Daño: +5");
			}
		});
		btnPropEspada2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Daño: +12");

			}
		});
		btnPropLanza.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Energia: +6");

			}
		});
		btnPropLanza2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Energia: +11");

			}
		});
		btnPropMalla.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Vida: +10");
			}
		});
		btnPropMalla2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Vida: +17");

			}
		});
	}
}

