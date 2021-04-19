package interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import db.MainDB;
import db.Partida;
import dinero.Monedero;

import javax.swing.JList;
import javax.swing.JLabel;

public class InterfazCargar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FondoIntCargar contentPane;
	private JList<String> listPartidas;
	private MainDB DBManager = new MainDB();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazCargar frame = new InterfazCargar();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public InterfazCargar() {
		setTitle("rpg");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 539);
		contentPane = new FondoIntCargar();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		listPartidas = new JList<String>();
		listPartidas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listPartidas.setFixedCellHeight(30);
		listPartidas.setFont(new Font("Algerian", Font.PLAIN, 15));
		listPartidas.setOpaque(false);
		listPartidas.setBackground(new Color(0,0,0,0));
		listPartidas.setBounds(163, 117, 317, 277);
		contentPane.add(listPartidas);
		
//		Añadir partidas guardadas
//		Monedero m = new Monedero();
//		Partida partida = new Partida();
//		partida.setNombrePartida("Example");
//		partida.setSkin("Ezio, el Arquero Centenario");
//		partida.setVida(100);
//		partida.setX(8);
//		partida.setY(8);
//		partida.setX_dib(3);
//		partida.setY_dib(3);
//		partida.setMonedero(m);
//		DBManager.guardarPartida(partida);
	
		DefaultListModel<String> modelo = new DefaultListModel<String>();
		List<Partida> listaPartidas = new ArrayList<Partida>();
		listaPartidas = DBManager.mostrarPartidas();
		for(int num=0; num<listaPartidas.size(); num++) {
			Partida p = new Partida();
			p = listaPartidas.get(num);
			modelo.addElement(p.getNombrePartida());
		}
		listPartidas.setModel(modelo);
//		DBManager.borrarPartidas();
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setForeground(SystemColor.text);
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setBorder(null);
		btnSalir.setOpaque(false);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				InterfazInicial inter = new InterfazInicial();
				inter.setVisible(true);
				inter.setLocationRelativeTo(null);
			}
		});
		btnSalir.setFont(new Font("Algerian", Font.PLAIN, 15));
		btnSalir.setBounds(121, 405, 89, 23);
		contentPane.add(btnSalir);
		
		JButton btnCargar = new JButton("Cargar");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Cargar partida e introducir datos en la ventana
				String[] info = DBManager.cargarPartida(listPartidas.getSelectedValue());
				System.out.println("Skin = " + info[0] + "; X = " + info[1] + "; Y = " + info[2] + 
						"; X_dib = " + info[3] + "; Y_dib = " + info[4] + "; Dinero = " + info[5] + 
						"; Vida = " + info[6]);
				mapa.Array inter = new mapa.Array();
				inter.setSkin(info[0]);
				inter.setX(Integer.parseInt(info[1]));
				inter.setY(Integer.parseInt(info[2]));
				inter.setX_dib(Integer.parseInt(info[3]));
				inter.setY_dib(Integer.parseInt(info[4]));
				Monedero m = new Monedero();
				m.setDinero(Integer.parseInt(info[5]));
				inter.setCartera(m);
				inter.setVida(Integer.parseInt(info[6]));
				
				dispose();
				inter.setVisible(true);
				inter.setLocationRelativeTo(null);
			}
		});
		btnCargar.setOpaque(false);
		btnCargar.setForeground(Color.WHITE);
		btnCargar.setFont(new Font("Algerian", Font.PLAIN, 15));
		btnCargar.setBorder(null);
		btnCargar.setBackground(Color.WHITE);
		btnCargar.setBounds(424, 405, 89, 23);
		contentPane.add(btnCargar);
		
		JLabel lblTitulo = new JLabel("Seleccione Partida");
		lblTitulo.setForeground(Color.BLACK);
		lblTitulo.setFont(new Font("Algerian", Font.BOLD, 20));
		lblTitulo.setBounds(213, 83, 218, 23);
		contentPane.add(lblTitulo);
	}
}
