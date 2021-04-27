package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

import db.MainDB;
import db.Partida;
import dinero.Monedero;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class InterfazGuardarPartida extends JFrame {

	private static final long serialVersionUID = 1L;
	private FondoIntOpciones contentPane;
	private JTextField textField;
	private MainDB DBManager = new MainDB();
	private String[] info = new String[7];
	
	public String[] getInfo() {
		return info;
	}

	public void setInfo(String[] info) {
		this.info = info;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazGuardarPartida frame = new InterfazGuardarPartida();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public InterfazGuardarPartida() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new FondoIntOpciones();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Introduzca nombre de la partida");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Algerian", Font.PLAIN, 16));
		lblTitulo.setBounds(76, 76, 281, 30);
		contentPane.add(lblTitulo);
		
		textField = new JTextField();
		textField.setFont(new Font("Algerian", Font.PLAIN, 13));
		textField.setBounds(76, 117, 281, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVolver.setOpaque(false);
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setFont(new Font("Algerian", Font.PLAIN, 14));
		btnVolver.setBorder(null);
		btnVolver.setBackground(Color.WHITE);
		btnVolver.setBounds(10, 227, 89, 23);
		contentPane.add(btnVolver);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Monedero m = new Monedero();
				System.out.println(info[5]);
				m.setDinero(Integer.parseInt(info[5]));
				
				Partida p = new Partida();
				p.setNombrePartida(textField.getText());
				p.setSkin(info[0]);
				p.setX(Integer.parseInt(info[1]));
				p.setY(Integer.parseInt(info[2]));
				p.setX_dib(Integer.parseInt(info[3]));
				p.setY_dib(Integer.parseInt(info[4]));
				p.setMonedero(m);
				p.setVida(Integer.parseInt(info[6]));
				System.out.println(p.toString());
				DBManager.guardarPartida(p);
			}
		});
		btnGuardar.setOpaque(false);
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setFont(new Font("Algerian", Font.PLAIN, 14));
		btnGuardar.setBorder(null);
		btnGuardar.setBackground(Color.WHITE);
		btnGuardar.setBounds(335, 227, 89, 23);
		contentPane.add(btnGuardar);
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_ESCAPE) {
			dispose();
		}
	}

}