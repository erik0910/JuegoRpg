package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import combate.Player;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Mejoras extends JFrame {
	static final ClassLoader loader = Mejoras.class.getClassLoader();
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

//	public static void main(String[] args) {
//		iniciar();
//	}

	public static void iniciar() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mejoras frame = new Mejoras();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Mejoras() {
		this.setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 300, 500, 124);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnDefensa = new JButton("");
		btnDefensa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mejoras.this.dispose();
			}
		});
		btnDefensa.setBackground(new Color(0, 102, 255));
    ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/escudo.png"));
		btnDefensa.setIcon(imagenFondo);
		btnDefensa.setBounds(10, 10, 100, 100);
		contentPane.add(btnDefensa);

		JButton btnAtaque = new JButton("");
		btnAtaque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mejoras.this.dispose();
			}
		});
		btnAtaque.setBackground(Color.RED);
		ImageIcon imagenFondo1 = new ImageIcon(loader.getResource("mundo/espada.png"));
		btnAtaque.setIcon(imagenFondo1);
		btnAtaque.setBounds(194, 10, 100, 100);
		contentPane.add(btnAtaque);

		JButton btnEnergia = new JButton("");
		btnEnergia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mejoras.this.dispose();
			}
		});
		btnEnergia.setBackground(Color.YELLOW);
		ImageIcon imagenFondo2  = new ImageIcon(loader.getResource("mundo/rayo.png"));
		btnEnergia.setIcon(imagenFondo2);
		btnEnergia.setBounds(375, 10, 100, 100);
		contentPane.add(btnEnergia);
		
	}
}
