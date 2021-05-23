package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.Estadisticas;
import db.MainDB;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import servidor.Server;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class InterfazEstadisticas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Client client = ClientBuilder.newClient();

	final WebTarget appTarget = client.target("http://localhost:8080/rpg");
	final WebTarget usersTarget = appTarget.path("estadisticas");
	
	private FondoIntPers contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazEstadisticas frame = new InterfazEstadisticas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**Describe la interfaz, sus componentes y su funcionalidad*/
	public InterfazEstadisticas() {
		
		//Pruebas para las estadisticas
//		Estadisticas e1 = new Estadisticas();
//		e1.setDanyoarma(100);
//		e1.setNombreJugador("Jugador 1");
//		e1.setVida(100);
//		e1.setEnergia(100);
//		e1.setSkin("Ezio");
//		MainDB dao = new MainDB();
//		dao.guardarEstadisticas(e1);
		
		//Iniciar Servidor
		Server.startServer();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 880, 531);
		contentPane = new FondoIntPers();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Estadisticas de los jugadores");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setBounds(236, 49, 392, 33);
		contentPane.add(lblNewLabel);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			/**Cierra esta ventana y abre la inicial*/
			public void actionPerformed(ActionEvent e) {
				dispose();
				InterfazInicial inter = new InterfazInicial();
				inter.setVisible(true);
				inter.setLocationRelativeTo(null);
			}
		});
		btnSalir.setOpaque(false);
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setFont(new Font("Algerian", Font.PLAIN, 15));
		btnSalir.setBorder(null);
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setBounds(387, 458, 89, 23);
		contentPane.add(btnSalir);
		
		
		//JList para mostrar estadisticas
		final DefaultListModel<Estadisticas> estadisticasListModel = new DefaultListModel<>();
		JList<Estadisticas> estadisticasJList = new JList<>(estadisticasListModel);
		estadisticasJList.setEnabled(false);
		estadisticasJList.setForeground(Color.WHITE);
		estadisticasJList.setOpaque(true);
		estadisticasJList.setFont(new Font("Algerian", Font.PLAIN, 20));
		
		JScrollPane scrollPane = new JScrollPane(estadisticasJList);
		scrollPane.setBounds(241, 84, 487, 349);
		scrollPane.setOpaque(true);
		contentPane.add(scrollPane);
		
		GenericType<List<Estadisticas>> genericType = new GenericType<List<Estadisticas>>() {};
		List<Estadisticas> estadisticas = usersTarget.request(MediaType.APPLICATION_JSON).get(genericType);
		for (Estadisticas estadistica : estadisticas) {
			estadisticasListModel.addElement(estadistica);
		}
	}
}
