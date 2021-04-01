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
import javax.swing.SwingConstants;

public class InterfazPersonalizacion extends JFrame {

	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private FondoIntPers MainPanel;
	private String[] rutasSprite = new String[2];
	private String[] nombresPersonajes = new String[2];
	int contador = 0;
	private JLabel lblSkin;
	private JLabel lblNombrePersonaje;
	
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
		
		rutasSprite[0] = "/Resources/SpritesSkins/1Personaje.png";
		rutasSprite[1] = "/Resources/SpritesSkins/2Personaje.png";
		
		nombresPersonajes[0] = "Geralt de Rivia";
		nombresPersonajes[1] = "Ezio, el Caballero Blanco";
		
		
		setResizable(false);
		setTitle("Rpg");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 900);
		MainPanel = new FondoIntPers();
		MainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(MainPanel);
		
	    lblSkin = new JLabel("");
		lblSkin.setIcon(new ImageIcon(InterfazPersonalizacion.class.getResource(rutasSprite[contador])));
		lblSkin.setBounds(187, 99, 369, 569);
		MainPanel.add(lblSkin);
		
		lblNombrePersonaje = new JLabel(nombresPersonajes[contador]);
		lblNombrePersonaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombrePersonaje.setForeground(Color.WHITE);
		lblNombrePersonaje.setFont(new Font("Algerian", Font.PLAIN, 33));
		lblNombrePersonaje.setBounds(67, 678, 537, 47);
		MainPanel.add(lblNombrePersonaje);
		
		JButton btnFlechaIzq = new JButton("");
		btnFlechaIzq.setIcon(new ImageIcon(InterfazPersonalizacion.class.getResource("/Resources/arrow-2.png")));
		btnFlechaIzq.setBounds(12, 380, 97, 25);
		btnFlechaIzq.setOpaque(false); 
		btnFlechaIzq.setBorder(null);
		btnFlechaIzq.setBackground(new Color(0,0,0,0));
		btnFlechaIzq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(contador>0) {
				contador--;
				lblNombrePersonaje.setText(nombresPersonajes[contador]);
				lblSkin.setIcon(new ImageIcon(InterfazPersonalizacion.class.getResource(rutasSprite[contador])));
				}
			}
		});
		MainPanel.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Seleccione su personaje");
		lblTitulo.setBounds(177, 52, 348, 36);
		lblTitulo.setForeground(new Color(0, 0, 0));
		lblTitulo.setFont(new Font("Algerian", Font.PLAIN, 27));
		MainPanel.add(lblTitulo);
		MainPanel.add(btnFlechaIzq);
		
		JButton btnFlechaDrch = new JButton("");
		btnFlechaDrch.setBounds(566, 380, 97, 25);
		btnFlechaDrch.setIcon(new ImageIcon(InterfazPersonalizacion.class.getResource("/Resources/arrow-1.png")));
		btnFlechaDrch.setOpaque(false);
		btnFlechaDrch.setBorder(null);
		btnFlechaDrch.setBackground(new Color(0, 0, 0, 0));
		btnFlechaDrch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(contador<1) {
				contador++;
				lblNombrePersonaje.setText(nombresPersonajes[contador]);
				lblSkin.setIcon(new ImageIcon(InterfazPersonalizacion.class.getResource(rutasSprite[contador])));
				}
			}	
		});
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
