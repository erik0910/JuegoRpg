package interfaces;

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
	static final ClassLoader loader = InterfazPersonalizacion.class.getClassLoader();
	public static String skin;
	private FondoIntPers MainPanel;
	private String[] rutasSprite = new String[3];
	private String[] nombresPersonajes = new String[3];
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
	/**Describe la interfaz, sus componentes y su funcionalidad*/
	public InterfazPersonalizacion() {
		
		rutasSprite[0] = "spritesSkins/Caballero.png";
		rutasSprite[1] = "spritesSkins/Arquero.png";
		rutasSprite[2] = "spritesSkins/Mago.png";
		
		nombresPersonajes[0] = "Geralt de Rivia";
		nombresPersonajes[1] = "Ezio, el Arquero Centenario";
		nombresPersonajes[2] = "Kalgar de Boria";
		
		
		setResizable(false);
		setTitle("rpg");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 900);
		MainPanel = new FondoIntPers();
		MainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(MainPanel);
		
	    lblSkin = new JLabel("");
		lblSkin.setIcon(new ImageIcon(loader.getResource(rutasSprite[contador])));
		lblSkin.setBounds(187, 99, 369, 569);
		MainPanel.add(lblSkin);
		
		lblNombrePersonaje = new JLabel(nombresPersonajes[contador]);
		lblNombrePersonaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombrePersonaje.setForeground(Color.WHITE);
		lblNombrePersonaje.setFont(new Font("Algerian", Font.PLAIN, 33));
		lblNombrePersonaje.setBounds(67, 678, 537, 47);
		MainPanel.add(lblNombrePersonaje);
		
		JButton btnFlechaIzq = new JButton("");
		btnFlechaIzq.setIcon(new ImageIcon(loader.getResource("menus/arrow-2.png")));
		btnFlechaIzq.setBounds(12, 380, 97, 25);
		btnFlechaIzq.setOpaque(false); 
		btnFlechaIzq.setBorder(null);
		btnFlechaIzq.setBackground(new Color(0,0,0,0));
		btnFlechaIzq.addActionListener(new ActionListener() {
			/**Cambia la skin en pantalla hacia la anterior*/
			public void actionPerformed(ActionEvent e) {
				if(contador>0) {
				contador--;
				lblNombrePersonaje.setText(nombresPersonajes[contador]);
				lblSkin.setIcon(new ImageIcon(loader.getResource(rutasSprite[contador])));
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
		btnFlechaDrch.setIcon(new ImageIcon(loader.getResource("menus/arrow-1.png")));
		btnFlechaDrch.setOpaque(false);
		btnFlechaDrch.setBorder(null);
		btnFlechaDrch.setBackground(new Color(0, 0, 0, 0));
		btnFlechaDrch.addActionListener(new ActionListener() {
			/**Cambia la skin en pantalla hacia la siguiente*/
			public void actionPerformed(ActionEvent e) {
				if(contador<2) {
				contador++;
				lblNombrePersonaje.setText(nombresPersonajes[contador]);
				lblSkin.setIcon(new ImageIcon(loader.getResource(rutasSprite[contador])));
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
			/**Cierra la ventana y abre la ventana inicial*/
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
			/**Cierra la ventana y abre el juego*/
			public void actionPerformed(ActionEvent e) {
				mapa.Array inter = new mapa.Array();
				inter.setSkin(lblNombrePersonaje.getText());
				dispose();
				inter.setVisible(true);
				inter.setLocationRelativeTo(null);
				
			}
		});
		MainPanel.add(btnContinuar);
		
		
		
		
	}
}
