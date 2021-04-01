package Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;

public class InterfazCargar extends JFrame {

	private FondoIntCargar contentPane;

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
		setTitle("Rpg");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 539);
		contentPane = new FondoIntCargar();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JList listPartidas = new JList();
		listPartidas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listPartidas.setFixedCellHeight(30);
		listPartidas.setFont(new Font("Algerian", Font.PLAIN, 15));
		listPartidas.setOpaque(false);
		listPartidas.setBackground(new Color(0,0,0,0));
		listPartidas.setBounds(163, 117, 317, 277);
		contentPane.add(listPartidas);
		
		//Añadir partidas guardadas
		DefaultListModel modelo = new DefaultListModel();
		modelo.addElement("1ºPartida");
		modelo.addElement("2ºPartida");
		modelo.addElement("3ºPartida");
		listPartidas.setModel(modelo);
		
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
				//Cargar partida
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
