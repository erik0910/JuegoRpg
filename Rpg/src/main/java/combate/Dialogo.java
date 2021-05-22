package combate;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.apache.log4j.helpers.Loader;

import interfaces.FondoIntInicial;
import interfaces.InterfazInicial;
import interfaces.InterfazPersonalizacion;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Dialogo extends JFrame {
	private FondoAnimacion contentPane;
	public Dialogo() {
		setTitle("rpg");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 520);
		contentPane = new FondoAnimacion();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Continuar");
		btnNewButton.setBounds(512, 411, 106, 23);
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBorder(null);
		btnNewButton.setOpaque(false);
		btnNewButton.setFont(new Font("Algerian", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana.cargarCombate();
				dispose();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		setVisible(true);
	}
	public static void main(String[] args) {
					Dialogo frame = new Dialogo();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
	}

}
