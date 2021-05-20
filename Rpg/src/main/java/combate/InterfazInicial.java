package combate;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import interfaces.InterfazCargar;
import interfaces.InterfazOpciones;
import interfaces.InterfazPersonalizacion;

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
		setBounds(100, 100, 619, 520);
		contentPane = new FondoIntInicial();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	
		JButton btnNewButton = new JButton("Continuar");
		btnNewButton.setBounds(512, 411, 106, 23);
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBorder(null);
		btnNewButton.setOpaque(false);
		btnNewButton.setFont(new Font("Algerian", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana.cargarCombate();
				dispose();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
	}
}
