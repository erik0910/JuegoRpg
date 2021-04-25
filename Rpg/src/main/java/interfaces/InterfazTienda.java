package interfaces;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class InterfazTienda extends JFrame{
	public InterfazTienda() {
		getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("TIENDA");
		lblTitulo.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 50));
		lblTitulo.setBounds(449, 10, 191, 52);
		getContentPane().add(lblTitulo);
		
		JLabel lblEspada = new JLabel("");
		lblEspada.setIcon(new ImageIcon(InterfazTienda.class.getResource("/resources/Espada.png")));
		lblEspada.setBounds(10, 108, 250, 245);
		getContentPane().add(lblEspada);
		
		JLabel lblLanza = new JLabel("");
		lblLanza.setIcon(new ImageIcon(InterfazTienda.class.getResource("/resources/lanza.png")));
		lblLanza.setBounds(425, 108, 250, 250);
		getContentPane().add(lblLanza);
		
		JLabel lblMalla = new JLabel("");
		lblMalla.setIcon(new ImageIcon(InterfazTienda.class.getResource("/resources/malla.png")));
		lblMalla.setBounds(826, 105, 250, 250);
		getContentPane().add(lblMalla);
		
		JLabel lblEspada2 = new JLabel("");
		lblEspada2.setIcon(new ImageIcon(InterfazTienda.class.getResource("/resources/espada2.png")));
		lblEspada2.setBounds(10, 505, 250, 245);
		getContentPane().add(lblEspada2);
		
		JLabel lblLanza2 = new JLabel("");
		lblLanza2.setIcon(new ImageIcon(InterfazTienda.class.getResource("/resources/lanza 2.png")));
		lblLanza2.setBounds(397, 494, 256, 256);
		getContentPane().add(lblLanza2);
		
		JLabel lblMalla2 = new JLabel("");
		lblMalla2.setIcon(new ImageIcon(InterfazTienda.class.getResource("/resources/malla2.png")));
		lblMalla2.setBounds(820, 510, 256, 240);
		getContentPane().add(lblMalla2);
		
		JButton btnEspada = new JButton("COMPRAR ESPADA");
		btnEspada.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnEspada.setBounds(10, 404, 143, 33);
		getContentPane().add(btnEspada);
		
		JButton btnEspada2 = new JButton("COMPRAR ESPADA");
		btnEspada2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnEspada2.setBounds(10, 780, 143, 33);
		getContentPane().add(btnEspada2);
		
		JButton btnLanza = new JButton("COMPRAR LANZA");
		btnLanza.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnLanza.setBounds(409, 404, 137, 33);
		getContentPane().add(btnLanza);
		
		JButton btnLanza2 = new JButton("COMPRAR LANZA");
		btnLanza2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnLanza2.setBounds(409, 780, 137, 33);
		getContentPane().add(btnLanza2);
		
		JButton btnMalla = new JButton("COMPRAR MALLA");
		btnMalla.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnMalla.setBounds(826, 404, 137, 33);
		getContentPane().add(btnMalla);
		
		JButton btnMalla2 = new JButton("COMPRAR MALLA");
		btnMalla2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnMalla2.setBounds(826, 780, 137, 33);
		getContentPane().add(btnMalla2);
		
		JButton btnPropEspada = new JButton("PROPIEDADES");
		btnPropEspada.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnPropEspada.setBounds(163, 404, 115, 33);
		getContentPane().add(btnPropEspada);
		
		JButton btnPropEspada2 = new JButton("PROPIEDADES");
		btnPropEspada2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnPropEspada2.setBounds(163, 780, 115, 33);
		getContentPane().add(btnPropEspada2);
		
		JButton btnPropLanza = new JButton("PROPIEDADES");
		btnPropLanza.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnPropLanza.setBounds(560, 404, 115, 33);
		getContentPane().add(btnPropLanza);
		
		JButton btnPropLanza2 = new JButton("PROPIEDADES");
		btnPropLanza2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnPropLanza2.setBounds(560, 780, 115, 33);
		getContentPane().add(btnPropLanza2);
		
		JButton btnPropMalla = new JButton("PROPIEDADES");
		btnPropMalla.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnPropMalla.setBounds(973, 404, 115, 33);
		getContentPane().add(btnPropMalla);
		
		JButton btnPropMalla2 = new JButton("PROPIEDADES");
		btnPropMalla2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnPropMalla2.setBounds(974, 780, 115, 33);
		getContentPane().add(btnPropMalla2);	
		
		JButton btnSalida = new JButton("SALIR");
		btnSalida.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnSalida.setBounds(10, 10, 125, 52);
		getContentPane().add(btnSalida);
		
		btnSalida.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		btnEspada.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				InterfazTienda v1 = new InterfazTienda();
				v1.setVisible(true);
				
			}
		});
		
		btnEspada2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				InterfazTienda v2 = new InterfazTienda();
				v2.setVisible(true);
				
			}
		});
		
		btnLanza.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				InterfazTienda v3 = new InterfazTienda();
				v3.setVisible(true);
				
			}
		});
		btnLanza2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				InterfazTienda v4 = new InterfazTienda();
				v4.setVisible(true);
				
			}
		});
		btnMalla.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				InterfazTienda v5 = new InterfazTienda();
				v5.setVisible(true);
				
			}
		});
		btnMalla2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				InterfazTienda v6 = new InterfazTienda();
				v6.setVisible(true);
				
			}
		});
		
		btnPropEspada.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				InterfazTienda i1 = new InterfazTienda();
				i1.setVisible(true);
			}
		});
		btnPropEspada2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				InterfazTienda i2 = new InterfazTienda();
				i2.setVisible(true);
			}
		});
		btnPropLanza.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				InterfazTienda i3 = new InterfazTienda();
				i3.setVisible(true);
			}
		});
		btnPropLanza2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				InterfazTienda i4 = new InterfazTienda();
				i4.setVisible(true);
			}
		});
		btnPropMalla.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				InterfazTienda i5 = new InterfazTienda();
				i5.setVisible(true);
			}
		});
		btnPropMalla2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				InterfazTienda i6 = new InterfazTienda();
				i6.setVisible(true);
			}
		});
		}
}
