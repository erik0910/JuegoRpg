package Interface;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfazOpciones extends JFrame {

	private static final long serialVersionUID = 1L;
	private FondoIntOpciones contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazOpciones frame = new InterfazOpciones();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public InterfazOpciones() {
		
		setResizable(false);
		setTitle("Rpg");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 580);
		contentPane = new FondoIntOpciones();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Opciones");
		lblTitulo.setFont(new Font("Algerian", Font.PLAIN, 25));
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setBounds(249, 33, 115, 45);
		contentPane.add(lblTitulo);
		
		JLabel lblMusica = new JLabel("Música");
		lblMusica.setForeground(Color.WHITE);
		lblMusica.setFont(new Font("Algerian", Font.PLAIN, 18));
		lblMusica.setBounds(274, 360, 64, 45);
		contentPane.add(lblMusica);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Algerian", Font.PLAIN, 11));
		comboBox.addItem("1ºCancion");
		comboBox.addItem("2ºCancion");
		comboBox.addItem("3ºCancion");
		comboBox.setBounds(32, 437, 208, 22);
		contentPane.add(comboBox);
		
		JLabel lblSeleccionarCancion = new JLabel("Seleccione canción");
		lblSeleccionarCancion.setForeground(Color.WHITE);
		lblSeleccionarCancion.setFont(new Font("Algerian", Font.PLAIN, 13));
		lblSeleccionarCancion.setBounds(73, 396, 131, 30);
		contentPane.add(lblSeleccionarCancion);
		
		JLabel lblVolumen = new JLabel("Volumen");
		lblVolumen.setForeground(Color.WHITE);
		lblVolumen.setFont(new Font("Algerian", Font.PLAIN, 13));
		lblVolumen.setBounds(437, 396, 64, 30);
		contentPane.add(lblVolumen);
		
		JSlider slider = new JSlider();
		slider.setFont(new Font("Algerian", Font.PLAIN, 11));
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(10);
		slider.setBounds(359, 433, 227, 40);
		contentPane.add(slider);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setForeground(Color.WHITE);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				InterfazInicial inter = new InterfazInicial();
				inter.setVisible(true);
				inter.setLocationRelativeTo(null);
			}
		});
		btnSalir.setFont(new Font("Algerian", Font.PLAIN, 14));
		btnSalir.setBounds(181, 517, 89, 23);
		contentPane.add(btnSalir);
		
		JButton btnGuardarYSalir = new JButton("Guardar y Salir");
		btnGuardarYSalir.setForeground(Color.WHITE);
		btnGuardarYSalir.setFont(new Font("Algerian", Font.PLAIN, 14));
		btnGuardarYSalir.setBounds(316, 517, 131, 23);
		btnGuardarYSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				InterfazInicial inter = new InterfazInicial();
				inter.setVisible(true);
				inter.setLocationRelativeTo(null);
				
				//Guardar configuracion seleccionada 
				
			}
		});
		contentPane.add(btnGuardarYSalir);
	}
}

