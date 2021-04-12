package interfaces;
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
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

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
		
		int i = 0;
		List<String> arrayList = new ArrayList<String>();
		
		//Lectura de la configuracion
		File file = new File(".\\src\\main\\java\\Resources\\Opciones.txt");
		if(file.length()!=0) {
			try {
			      Scanner myReader = new Scanner(file);
			      while (myReader.hasNextLine()) {
			        arrayList.add(myReader.nextLine());
			        i++;
			      }
			      myReader.close();
			} catch (FileNotFoundException e1) {
			      System.out.println("An error occurred.");
			      e1.printStackTrace();
			}
			
		}
		String[] data = arrayList.toArray(new String[5]);
//		System.out.println(new File(".").getAbsoluteFile());
		
		
		setResizable(false);
		setTitle("rpg");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 580);
		contentPane = new FondoIntOpciones();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Opciones");
		lblTitulo.setFont(new Font("Algerian", Font.BOLD, 25));
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setBounds(246, 33, 121, 45);
		contentPane.add(lblTitulo);
		
		JLabel lblMusica = new JLabel("Música");
		lblMusica.setForeground(Color.WHITE);
		lblMusica.setFont(new Font("Algerian", Font.PLAIN, 18));
		lblMusica.setBounds(274, 360, 64, 45);
		contentPane.add(lblMusica);
		
		final JComboBox cbCancion = new JComboBox();
		cbCancion.setOpaque(false);
		cbCancion.setFont(new Font("Algerian", Font.PLAIN, 11));
		//Agregar canciones
		cbCancion.addItem("1Cancion");
		cbCancion.addItem("2Cancion");
		cbCancion.addItem("3Cancion");
		
		if(data[3]!=null) {
			cbCancion.setSelectedItem(data[3]);	
		}
		
		cbCancion.setBounds(32, 437, 208, 22);
		contentPane.add(cbCancion);
		
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
		
		final JSlider slider = new JSlider();
		slider.setForeground(Color.WHITE);
		slider.setFont(new Font("Algerian", Font.PLAIN, 12));
		slider.setBackground(Color.WHITE);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(20);
		slider.setBounds(359, 433, 227, 40);
		slider.setOpaque(false);
		
		if(data[4]!=null) {
			int valueVolumen;
			slider.setValue(valueVolumen = Integer.parseInt(data[4]));
		}
		
		contentPane.add(slider);
		
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
		btnSalir.setFont(new Font("Algerian", Font.PLAIN, 14));
		btnSalir.setBounds(181, 510, 89, 23);
		contentPane.add(btnSalir);
		
		JButton btnGuardarYSalir = new JButton("Guardar y Salir");
		btnGuardarYSalir.setForeground(SystemColor.text);
		btnGuardarYSalir.setBackground(Color.WHITE);
		btnGuardarYSalir.setBorder(null);
		btnGuardarYSalir.setOpaque(false);
		btnGuardarYSalir.setFont(new Font("Algerian", Font.PLAIN, 14));
		btnGuardarYSalir.setBounds(316, 510, 131, 23);
		
		JLabel lblDificultad = new JLabel("Dificultad");
		lblDificultad.setForeground(Color.WHITE);
		lblDificultad.setFont(new Font("Algerian", Font.PLAIN, 18));
		lblDificultad.setBounds(256, 89, 99, 45);
		contentPane.add(lblDificultad);
		
		final ButtonGroup bgDificultad = new ButtonGroup();
		
		final ButtonGroup bgMostrar = new ButtonGroup();
		
		final ButtonGroup bgMax = new ButtonGroup();
		
		JRadioButton rdbtnFacil = new JRadioButton("facil");
		rdbtnFacil.setActionCommand("facil");
		rdbtnFacil.setBorder(null);
		rdbtnFacil.setForeground(Color.WHITE);
		rdbtnFacil.setOpaque(false);
		rdbtnFacil.setFont(new Font("Algerian", Font.PLAIN, 14));
		rdbtnFacil.setBounds(45, 142, 109, 23);
		bgDificultad.add(rdbtnFacil);
		contentPane.add(rdbtnFacil);
		
		JRadioButton rdbtnNormal = new JRadioButton("normal",true);
		rdbtnNormal.setActionCommand("normal");
		rdbtnNormal.setBorder(null);
		rdbtnNormal.setOpaque(false);
		rdbtnNormal.setForeground(Color.WHITE);
		rdbtnNormal.setFont(new Font("Algerian", Font.PLAIN, 14));
		rdbtnNormal.setBounds(266, 145, 109, 23);
		bgDificultad.add(rdbtnNormal);
		contentPane.add(rdbtnNormal);
		
		JRadioButton rdbtnDificil = new JRadioButton("dificil");
		rdbtnDificil.setActionCommand("dificil");
		rdbtnDificil.setBorder(null);
		rdbtnDificil.setOpaque(false);
		rdbtnDificil.setForeground(Color.WHITE);
		rdbtnDificil.setFont(new Font("Algerian", Font.PLAIN, 14));
		rdbtnDificil.setBounds(494, 142, 109, 23);
		bgDificultad.add(rdbtnDificil);
		contentPane.add(rdbtnDificil);
		
		if(data[0]!=null) {
			switch (data[0]) {
			case "facil":
				bgDificultad.clearSelection();
				rdbtnFacil.setSelected(true);
				break;
			case "normal":
				bgDificultad.clearSelection();
				rdbtnNormal.setSelected(true);
				break;
			case "dificil":
				bgDificultad.clearSelection();
				rdbtnDificil.setSelected(true);
				break;
			}
		}
		
		
		JLabel lblFps = new JLabel("FPS");
		lblFps.setForeground(Color.WHITE);
		lblFps.setFont(new Font("Algerian", Font.PLAIN, 18));
		lblFps.setBounds(286, 194, 40, 30);
		contentPane.add(lblFps);
		
		JLabel lblMostarFps = new JLabel("Mostrar FPS");
		lblMostarFps.setForeground(Color.WHITE);
		lblMostarFps.setFont(new Font("Algerian", Font.PLAIN, 13));
		lblMostarFps.setBounds(73, 229, 121, 30);
		contentPane.add(lblMostarFps);
		
		JRadioButton rdbtnSi = new JRadioButton("si");
		rdbtnSi.setActionCommand("si");
		rdbtnSi.setOpaque(false);
		rdbtnSi.setForeground(Color.WHITE);
		rdbtnSi.setFont(new Font("Algerian", Font.PLAIN, 14));
		rdbtnSi.setBorder(null);
		rdbtnSi.setBounds(71, 274, 109, 23);
		bgMostrar.add(rdbtnSi);
		contentPane.add(rdbtnSi);
		
		JRadioButton rdbtnNo = new JRadioButton("no", true);
		rdbtnNo.setActionCommand("no");
		rdbtnNo.setOpaque(false);
		rdbtnNo.setForeground(Color.WHITE);
		rdbtnNo.setFont(new Font("Algerian", Font.PLAIN, 14));
		rdbtnNo.setBorder(null);
		rdbtnNo.setBounds(71, 308, 109, 23);
		bgMostrar.add(rdbtnNo);
		contentPane.add(rdbtnNo);
		
		if(data[1]!=null) {
			switch (data[1]) {
			case "no":
				bgMostrar.clearSelection();
				rdbtnNo.setSelected(true);
				break;
			case "si":
				bgMostrar.clearSelection();
				rdbtnSi.setSelected(true);
				break;
			}
		}
		
		JLabel lblMaxFps = new JLabel("Max. FPS");
		lblMaxFps.setForeground(Color.WHITE);
		lblMaxFps.setFont(new Font("Algerian", Font.PLAIN, 13));
		lblMaxFps.setBounds(437, 229, 64, 30);
		contentPane.add(lblMaxFps);
		
		JRadioButton rdbtn30 = new JRadioButton("30");
		rdbtn30.setActionCommand("30");
		rdbtn30.setOpaque(false);
		rdbtn30.setForeground(Color.WHITE);
		rdbtn30.setFont(new Font("Algerian", Font.PLAIN, 14));
		rdbtn30.setBorder(null);
		rdbtn30.setBounds(359, 274, 50, 23);
		bgMax.add(rdbtn30);
		contentPane.add(rdbtn30);
		
		JRadioButton rdbtn60 = new JRadioButton("60", true);
		rdbtn60.setActionCommand("60");
		rdbtn60.setOpaque(false);
		rdbtn60.setForeground(Color.WHITE);
		rdbtn60.setFont(new Font("Algerian", Font.PLAIN, 14));
		rdbtn60.setBorder(null);
		rdbtn60.setBounds(451, 274, 50, 23);
		bgMax.add(rdbtn60);
		contentPane.add(rdbtn60);
		
		JRadioButton rdbtn144 = new JRadioButton("144");
		rdbtn144.setActionCommand("144");
		rdbtn144.setOpaque(false);
		rdbtn144.setForeground(Color.WHITE);
		rdbtn144.setFont(new Font("Algerian", Font.PLAIN, 14));
		rdbtn144.setBorder(null);
		rdbtn144.setBounds(536, 274, 50, 23);
		bgMax.add(rdbtn144);
		contentPane.add(rdbtn144);
		
		if(data[2]!=null) {
			switch (data[2]) {
			case "30":
				bgMax.clearSelection();
				rdbtn30.setSelected(true);
				break;
			case "60":
				bgMax.clearSelection();
				rdbtn60.setSelected(true);
				break;
			case "144":
				bgMax.clearSelection();
				rdbtn144.setSelected(true);
				break;
			}
		}
		
		
		btnGuardarYSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				InterfazInicial inter = new InterfazInicial();
				inter.setVisible(true);
				inter.setLocationRelativeTo(null);
				
				//Guardar configuracion seleccionada 
				try {
				    //create a temporary file
				    File logFile=new File(".\\src\\main\\java\\Resources\\Opciones.txt");

				    BufferedWriter writer = new BufferedWriter(new FileWriter(logFile));
				    writer.write(bgDificultad.getSelection().getActionCommand() + "\n" + 
				    bgMostrar.getSelection().getActionCommand() + "\n" + 
				    bgMax.getSelection().getActionCommand() + "\n" +
				    cbCancion.getSelectedItem() + "\n" + 
				    slider.getValue());
				    

				    //Close writer
				    writer.close();
				} catch(Exception e2) {
				    e2.printStackTrace();
				}
			}
		});
		contentPane.add(btnGuardarYSalir);
		
	}
}

