package Rpg.Combate;


import javax.swing.JFrame;
/*
Importante esta clase solo va a ser el molde para la clase ventanaComate por lo tanto solo tendra la dimesion del campo
*/

public class Ventana {
	public static void main(String[] args) {
		JFrame window = new JFrame("Boss Battle");
		window.setContentPane(new Juego());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.pack();
		window.setVisible(true);
	}
}

