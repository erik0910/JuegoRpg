package Interface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import java.awt.SystemColor;

public class InterfazPersonalizacion extends JFrame {

	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private FondoIntPers MainPanel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazPersonalizacion frame = new InterfazPersonalizacion();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public InterfazPersonalizacion() {
		setResizable(false);
		setTitle("Rpg");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 900);
		MainPanel = new FondoIntPers();
		MainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(MainPanel);
		
		JButton btnFlechaIzq = new JButton("");
		btnFlechaIzq.setIcon(new ImageIcon(InterfazPersonalizacion.class.getResource("/Resources/arrow-2.png")));
		btnFlechaIzq.setBounds(12, 380, 97, 25);
		btnFlechaIzq.setOpaque(false); 
		btnFlechaIzq.setBorder(null);
		btnFlechaIzq.setBackground(new Color(0,0,0,0));
		btnFlechaIzq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		MainPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seleccione su personaje");
		lblNewLabel.setBounds(177, 52, 348, 36);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Algerian", Font.PLAIN, 27));
		MainPanel.add(lblNewLabel);
		MainPanel.add(btnFlechaIzq);
		
		JButton btnFlechaDrch = new JButton("");
		btnFlechaDrch.setBounds(566, 380, 97, 25);
		btnFlechaDrch.setIcon(new ImageIcon(InterfazPersonalizacion.class.getResource("/Resources/arrow-1.png")));
		btnFlechaDrch.setOpaque(false);
		btnFlechaDrch.setBorder(null);
		btnFlechaDrch.setBackground(new Color(0, 0, 0, 0));
		MainPanel.add(btnFlechaDrch);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setForeground(SystemColor.text);
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setBorder(null);
		btnSalir.setOpaque(false);
		btnSalir.setFont(new Font("Algerian", Font.PLAIN, 18));
		btnSalir.setBounds(12, 815, 97, 23);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				InterfazInicial inter = new InterfazInicial();
				inter.setVisible(true);
				inter.setLocationRelativeTo(null);
			}
		});
		MainPanel.add(btnSalir);
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.setForeground(SystemColor.text);
		btnContinuar.setBackground(Color.WHITE);
		btnContinuar.setBorder(null);
		btnContinuar.setOpaque(false);
		btnContinuar.setFont(new Font("Algerian", Font.PLAIN, 18));
		btnContinuar.setBounds(566, 815, 97, 23);
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Iniciar mundo y guardar seleccion
				
			}
		});
		MainPanel.add(btnContinuar);
	}
}
