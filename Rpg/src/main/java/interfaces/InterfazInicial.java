package interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

public class InterfazInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private FondoIntInicial contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazInicial frame = new InterfazInicial();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public InterfazInicial() {
		setTitle("rpg");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 539);
		contentPane = new FondoIntInicial();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewGame = new JButton("Nueva Partida");
		btnNewGame.setBounds(196, 171, 220, 27);
		btnNewGame.setForeground(SystemColor.text);
		btnNewGame.setBackground(Color.WHITE);
		btnNewGame.setBorder(null);
		btnNewGame.setOpaque(false);
		btnNewGame.setFont(new Font("Algerian", Font.PLAIN, 18));
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				InterfazPersonalizacion interfaz = new InterfazPersonalizacion();
				interfaz.setVisible(true);
				interfaz.setLocationRelativeTo(null);
				
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewGame);
		
		JButton btnLoadGame = new JButton("Cargar Partida");
		btnLoadGame.setBounds(196, 247, 220, 27);
		btnLoadGame.setFont(new Font("Algerian", Font.PLAIN, 18));
		btnLoadGame.setForeground(SystemColor.text);
		btnLoadGame.setBackground(Color.WHITE);
		btnLoadGame.setBorder(null);
		btnLoadGame.setOpaque(false);
		btnLoadGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				InterfazCargar interfaz = new InterfazCargar();
				interfaz.setVisible(true);
				interfaz.setLocationRelativeTo(null);
			}
		});
		contentPane.add(btnLoadGame);
		
		JButton btnOptions = new JButton("Opciones");
		btnOptions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				InterfazOpciones inter = new InterfazOpciones();
				inter.setVisible(true);
				inter.setLocationRelativeTo(null);
			}
		});
		btnOptions.setForeground(SystemColor.text);
		btnOptions.setBackground(Color.WHITE);
		btnOptions.setBorder(null);
		btnOptions.setOpaque(false);
		btnOptions.setBounds(196, 326, 220, 27);
		btnOptions.setFont(new Font("Algerian", Font.PLAIN, 18));
		contentPane.add(btnOptions);
		
		JLabel lblTitulo = new JLabel("After-Age");
		lblTitulo.setForeground(new Color(102, 0, 0));
		lblTitulo.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 30));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(196, 32, 220, 38);
		contentPane.add(lblTitulo);
	}
}
