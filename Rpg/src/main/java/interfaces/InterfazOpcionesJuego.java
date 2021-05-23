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
import java.awt.event.KeyEvent;
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

public class InterfazOpcionesJuego extends JFrame {

	private static final long serialVersionUID = 1L;
	private FondoIntOpciones contentPane;
	private String[] infoJuego = new String[9];
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazOpcionesJuego frame = new InterfazOpcionesJuego();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public String[] getInfoJuego() {
		return infoJuego;
	}

	public void setInfoJuego(String[] infoJuego) {
		this.infoJuego = infoJuego;
	}
	/**Describe la interfaz, sus componentes y su funcionalidad, ademas hace lectura del archivo txt de opciones*/
	public InterfazOpcionesJuego() {
		
		int i = 0;
		List<String> arrayList = new ArrayList<String>();
		
		//Lectura de la configuracion
		File file = new File(".\\src\\main\\java\\resources\\Opciones.txt");
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
		setBounds(100, 100, 619, 450);
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
		lblMusica.setBounds(273, 237, 64, 45);
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
		
		cbCancion.setBounds(31, 314, 208, 22);
		contentPane.add(cbCancion);
		
		JLabel lblSeleccionarCancion = new JLabel("Seleccione canción");
		lblSeleccionarCancion.setForeground(Color.WHITE);
		lblSeleccionarCancion.setFont(new Font("Algerian", Font.PLAIN, 13));
		lblSeleccionarCancion.setBounds(72, 273, 131, 30);
		contentPane.add(lblSeleccionarCancion);
		
		JLabel lblVolumen = new JLabel("Volumen");
		lblVolumen.setForeground(Color.WHITE);
		lblVolumen.setFont(new Font("Algerian", Font.PLAIN, 13));
		lblVolumen.setBounds(436, 273, 64, 30);
		contentPane.add(lblVolumen);
		
		final JSlider slider = new JSlider();
		slider.setForeground(Color.WHITE);
		slider.setFont(new Font("Algerian", Font.PLAIN, 12));
		slider.setBackground(Color.WHITE);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(20);
		slider.setBounds(358, 310, 227, 40);
		slider.setOpaque(false);
		
		if(data[4]!=null) {
			int valueVolumen;
			slider.setValue(valueVolumen = Integer.parseInt(data[4]));
		}
		
		contentPane.add(slider);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setForeground(SystemColor.text);
		btnVolver.setBackground(Color.WHITE);
		btnVolver.setBorder(null);
		btnVolver.setOpaque(false);
		btnVolver.addActionListener(new ActionListener() {
			/**Cierra la ventana*/
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVolver.setFont(new Font("Algerian", Font.PLAIN, 14));
		btnVolver.setBounds(105, 379, 89, 23);
		contentPane.add(btnVolver);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setForeground(SystemColor.text);
		btnGuardar.setBackground(Color.WHITE);
		btnGuardar.setBorder(null);
		btnGuardar.setOpaque(false);
		btnGuardar.setFont(new Font("Algerian", Font.PLAIN, 14));
		btnGuardar.setBounds(241, 379, 131, 23);
		
		final ButtonGroup bgMostrar = new ButtonGroup();
		
		final ButtonGroup bgMax = new ButtonGroup();
		
		
		JLabel lblFps = new JLabel("FPS");
		lblFps.setForeground(Color.WHITE);
		lblFps.setFont(new Font("Algerian", Font.PLAIN, 18));
		lblFps.setBounds(288, 89, 31, 30);
		contentPane.add(lblFps);
		
		JLabel lblMostarFps = new JLabel("Mostrar FPS");
		lblMostarFps.setForeground(Color.WHITE);
		lblMostarFps.setFont(new Font("Algerian", Font.PLAIN, 13));
		lblMostarFps.setBounds(70, 124, 121, 30);
		contentPane.add(lblMostarFps);
		
		JRadioButton rdbtnSi = new JRadioButton("si");
		rdbtnSi.setActionCommand("si");
		rdbtnSi.setOpaque(false);
		rdbtnSi.setForeground(Color.WHITE);
		rdbtnSi.setFont(new Font("Algerian", Font.PLAIN, 14));
		rdbtnSi.setBorder(null);
		rdbtnSi.setBounds(68, 169, 109, 23);
		bgMostrar.add(rdbtnSi);
		contentPane.add(rdbtnSi);
		
		JRadioButton rdbtnNo = new JRadioButton("no", true);
		rdbtnNo.setActionCommand("no");
		rdbtnNo.setOpaque(false);
		rdbtnNo.setForeground(Color.WHITE);
		rdbtnNo.setFont(new Font("Algerian", Font.PLAIN, 14));
		rdbtnNo.setBorder(null);
		rdbtnNo.setBounds(68, 203, 109, 23);
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
		lblMaxFps.setBounds(434, 124, 64, 30);
		contentPane.add(lblMaxFps);
		
		JRadioButton rdbtn30 = new JRadioButton("30");
		rdbtn30.setActionCommand("30");
		rdbtn30.setOpaque(false);
		rdbtn30.setForeground(Color.WHITE);
		rdbtn30.setFont(new Font("Algerian", Font.PLAIN, 14));
		rdbtn30.setBorder(null);
		rdbtn30.setBounds(356, 169, 50, 23);
		bgMax.add(rdbtn30);
		contentPane.add(rdbtn30);
		
		JRadioButton rdbtn60 = new JRadioButton("60", true);
		rdbtn60.setActionCommand("60");
		rdbtn60.setOpaque(false);
		rdbtn60.setForeground(Color.WHITE);
		rdbtn60.setFont(new Font("Algerian", Font.PLAIN, 14));
		rdbtn60.setBorder(null);
		rdbtn60.setBounds(448, 169, 50, 23);
		bgMax.add(rdbtn60);
		contentPane.add(rdbtn60);
		
		JRadioButton rdbtn144 = new JRadioButton("144");
		rdbtn144.setActionCommand("144");
		rdbtn144.setOpaque(false);
		rdbtn144.setForeground(Color.WHITE);
		rdbtn144.setFont(new Font("Algerian", Font.PLAIN, 14));
		rdbtn144.setBorder(null);
		rdbtn144.setBounds(533, 169, 50, 23);
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
		
		
		btnGuardar.addActionListener(new ActionListener() {
			/**Cierra la ventana y abre la interfaz para guardar la partida*/
			public void actionPerformed(ActionEvent e) {
				contentPane.setFocusable(false);
				InterfazGuardarPartida inter = new InterfazGuardarPartida();
				inter.setInfo(infoJuego);
				inter.setVisible(true);
				inter.setLocationRelativeTo(null);
			}
		});
		contentPane.add(btnGuardar);
		
		JButton btnSalir = new JButton("Salir");
		/**Cierra toda la aplicacion*/
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setOpaque(false);
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setFont(new Font("Algerian", Font.PLAIN, 14));
		btnSalir.setBorder(null);
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setBounds(420, 379, 89, 23);
		contentPane.add(btnSalir);
		
	}
	/**Cierra la ventana pulsando el boton "ESC"*/
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_ESCAPE) {
			dispose();
		}
	}
}

