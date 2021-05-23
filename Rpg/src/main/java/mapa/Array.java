package mapa;

import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Robot;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import combate.*;
import dinero.Monedero;
import interfaces.InterfazOpciones;
import interfaces.InterfazOpcionesJuego;
import interfaces.InterfazTienda;
import interfaces.Mejoras;


import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Array extends JFrame implements KeyListener {
	public static int cont=1;// contador de partidas
	public static int danyoarma=0,health=0,energia=0;
	static Tiles[][] mundo = new Tiles[50][50];
	private Tiles[][] extra = new Tiles[50][50];
	private Tiles[][] guardado = new Tiles[50][50];
	static Tiles suelo = new Tiles("grass", true, true, true, true);
	static Tiles rio = new Tiles("river", false, false, false, false);
	static Tiles puente = new Tiles("bridg", true, true, true, true);
	static Tiles pared = new Tiles("walls", false, false, false, false);
	static Tiles pelea = new Tiles("fight", true, true, true, true);

	private Tiles tejado = new Tiles("roofs", false, false, false, false);
	private Tiles puerta = new Tiles("doors", true, true, true, true);
	private Tiles casa = new Tiles("house", false, false, false, false);
	private Tiles shop = new Tiles("shops", true, true, true, true);
	private Tiles tallgrass = new Tiles("talls", true, true, true, true);
	private Tiles camino = new Tiles("paths", true, true, true, true);
	private Tiles NPC = new Tiles("NPC", true, true, true, true);
	private Tiles chest = new Tiles("chest", true, true, true, true);
	
	public int vida;
	
	public static Clip sonido;
	
	public String zona;
	
	private boolean fight = false;
	
	private static int x = 5;
	private static int y = 5;
	private static int x_ant;
	private static int y_ant;
	private static int x_dib = 0;
	private static int y_dib = 0;
	static String direccion = "RIGHT";
	private static String skin = "";
	boolean in = false;
	
	/** Aumenta el daño del arma*/
	public static void mejora() {
		danyoarma +=10;
	}
	
	/**Aumenta la vida*/
	public static void mejoraVida() {
		health +=10;
	}
	
	/** Aumenta el mana*/
	public static void mejorarMana() {
		energia +=10;
	}
	// atributo moneda que contendra la mondeda que disponde el jugador en ese momento
	public static Monedero cartera= new Monedero();
	
	private static final long serialVersionUID = 1L;
	
	static final ClassLoader loader = Array.class.getClassLoader();

	public static JPanel contentPane;

	/** Obtiene la vida*/
	public int getVida() {
		return vida;
	}
	
	/** Pone la vida a un número exacto*/
	public void setVida(int vida) {
		this.vida = vida;
	}
	
	/** Obtiene la X*/
	public int getX() {
		return x;
	}
	
	/** Cambia la X*/
	public static void setX(int x) {
		Array.x = x;
	}
	
	/** Obtiene la Y*/
	public int getY() {
		return y;
	}
	
	/** Cambia la Y*/
	public static void setY(int y) {
		Array.y = y;
	}
	
	/** Obtiene la X del dibujado del mapa*/
	public static int getX_dib() {
		return x_dib;
	}
	
	/** Cambia la X del dibujado del mapa*/
	public static void setX_dib(int x_dib) {
		Array.x_dib = x_dib;
	}
	
	/** Obtiene la Y del diujado del mapa*/
	public static int getY_dib() {
		return y_dib;
	}
	
	/** Cambia la Y del dibujado del mapa*/
	public static void setY_dib(int y_dib) {
		Array.y_dib = y_dib;
	}
	
	/** Obtiene el oro de la cartera*/
	public static Monedero getCartera() {
		return cartera;
	}
	
	/** Cambia la el dinero de la cartera*/
	public static void setCartera(Monedero cartera) {
		Array.cartera = cartera;
	}
	
	/** Obtiene la skin del personaje*/
	public static String getSkin() {
		return skin;
	}
	
	/** Cambia la skin del personaje*/
	public void setSkin(String skin) {
		Array.skin = skin;
	}
	
	/** Obtiene el daño del arma*/
	public static int getDanyoarma() {
		return danyoarma;
	}
	
	/** Cambia el daño del arma*/
	public static void setDanyoarma(int danyoarma) {
		Array.danyoarma = danyoarma;
	}
	
	/** Obtiene la energia*/
	public static int getEnergia() {
		return energia;
	}
	
	/** Cambia la energia*/
	public static void setEnergia(int energia) {
		Array.energia = energia;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Array frame = new Array();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/** Se usa para seleccionar la musica*/
	public void musica() {
		
		try {
		
		 // Se obtiene un Clip de sonido
        sonido = AudioSystem.getClip();
        
        if(fight == true){
     				
		sonido.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/mundo/peleas.wav")));
		
        }else if(y < 22 && x <= 22  && in == false) {
			         
         // Se carga con un fichero wav
         sonido.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/mundo/Grass.wav")));     
         zona = "grass";
			
		}else if(y > 26 && x <= 22  && in == false) {
				
	         // Se carga con un fichero wav
	        sonido.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/mundo/Sand.wav")));
	        zona = "sand";	
	         
		}else if(y > 26 && x > 27  && in == false) {
				
			// Se carga con un fichero wav
	         sonido.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/mundo/Ice.wav")));
	         zona = "ice";
	         
		}else if(y < 22 && x > 27  && in == false) {

	         // Se carga con un fichero wav
	         sonido.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/mundo/Fire.wav")));
	         zona = "fire";
	         
		}else if( in == true ){
		
	         // Se carga con un fichero wav
	         sonido.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/mundo/Dungeon.wav")));
	         zona = "dungeon";
	         
		}else if( x == 1 && y == 24 || x == 25 && y == 1 || x == 25 && y == 48 || x == 48 && y == 24){
			
	         // Se carga con un fichero wav
	         sonido.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/mundo/Secret.wav")));
	         zona = "secret";
	         
		}else {

	         // Se carga con un fichero wav
	         sonido.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/mundo/Secret.wav")));
	         zona = "secret";
		}
		 
        sonido.start();	
            
        } catch (Exception e) {
            System.out.println("" + e);
        }

	}
	
	/** Inicia el juego principal*/
	public Array() {
		
		musica();
		
		
		javax.swing.Timer timer = new javax.swing.Timer(1, new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent ae) {
				
				if(sonido.isRunning()) {	
					
					if(y < 22 && x <= 22 && zona != "grass"  && in == false) {
						  
					sonido.stop();
			        musica();
			        zona = "grass";
						
					}else if(y > 26 && x <= 22 && zona != "sand"  && in == false) {
						
					sonido.stop();
					musica();
				    zona = "sand";	
				         
					}else if(y > 26 && x > 27 && zona != "ice"  && in == false) {
						
					sonido.stop();	
					musica();
				    zona = "ice";
				         
					}else if(y < 22 && x > 27 && zona != "fire"  && in == false) {
					
					sonido.stop();
					musica();  
				    zona = "fire";
				         
					}else if(in == true && zona != "dungeon") {
						
					sonido.stop();
					musica();  
					zona = "dungeon";
					
					}
					
				}else{
					
					musica();
				
				}

			}
		});
		timer.start();
		
		addKeyListener(this);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 730);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		for (int i = 0; i < 50; i++) {
			for (int u = 0; u < 50; u++) {

				mundo[i][u] = suelo;
			}
		}

		for (int i = 0; i < 50; i++) {
			for (int u = 0; u < 50; u++) {

				extra[i][u] = suelo;
				
			}
		}
		extra[0][0] =pared;
		extra[0][1] =pared;
		extra[0][2] =pared;
		extra[0][3] =pared;
		extra[0][4] =pared;
		extra[0][5] =pared;
		extra[0][6] =pared;
		extra[0][7] =pared;
		extra[0][8] =pared;
		extra[0][9] =pared;
		extra[0][10] =pared;
		extra[0][11] =pared;
		extra[0][12] =pared;
		extra[0][13] =pared;
		extra[0][14] =pared;
		extra[0][15] =pared;
		extra[0][16] =pared;
		extra[0][17] =pared;
		extra[0][18] =pared;
		extra[0][19] =pared;
		extra[0][20] =pared;
		extra[0][21] =pared;
		extra[0][22] =pared;
		extra[0][23] =pared;
		extra[0][24] =pared;
		extra[0][25] =pared;
		extra[0][26] =pared;
		extra[0][27] =pared;
		extra[0][28] =pared;
		extra[0][29] =pared;
		extra[0][30] =pared;
		extra[0][31] =pared;
		extra[0][32] =pared;
		extra[0][33] =pared;
		extra[0][34] =pared;
		extra[0][35] =pared;
		extra[0][36] =pared;
		extra[0][37] =pared;
		extra[0][38] =pared;
		extra[0][39] =pared;
		extra[0][40] =pared;
		extra[0][41] =pared;
		extra[0][42] =pared;
		extra[0][43] =pared;
		extra[0][44] =pared;
		extra[0][45] =pared;
		extra[0][46] =pared;
		extra[0][47] =pared;
		extra[0][48] =pared;
		extra[0][49] =pared;
		extra[1][0] =pared;
		extra[1][1] =pared;
		extra[1][2] =pared;
		extra[1][3] =pared;
		extra[1][4] =pared;
		extra[1][5] =pared;
		extra[1][6] =pared;
		extra[1][7] =pared;
		extra[1][8] =pared;
		extra[1][9] =pared;
		extra[1][10] =pared;
		extra[1][11] =pared;
		extra[1][12] =pared;
		extra[1][13] =pared;
		extra[1][14] =pared;
		extra[1][15] =pared;
		extra[1][16] =pared;
		extra[1][17] =pared;
		extra[1][18] =pared;
		extra[1][19] =pared;
		extra[1][20] =pared;
		extra[1][21] =pared;
		extra[1][22] =pared;
		extra[1][23] =pared;
		extra[1][27] =pared;
		extra[1][28] =pared;
		extra[1][29] =pared;
		extra[1][30] =pared;
		extra[1][31] =pared;
		extra[1][32] =pared;
		extra[1][33] =pared;
		extra[1][34] =pared;
		extra[1][35] =pared;
		extra[1][36] =pared;
		extra[1][37] =pared;
		extra[1][38] =pared;
		extra[1][39] =pared;
		extra[1][40] =pared;
		extra[1][41] =pared;
		extra[1][42] =pared;
		extra[1][43] =pared;
		extra[1][44] =pared;
		extra[1][45] =pared;
		extra[1][46] =pared;
		extra[1][47] =pared;
		extra[1][48] =pared;
		extra[1][49] =pared;
		extra[2][0] =pared;
		extra[2][1] =pelea;
		extra[2][11] =pelea;
		extra[2][22] =pelea;
		extra[2][23] =pared;
		extra[2][25] =pelea;
		extra[2][27] =pared;
		extra[2][28] =pared;
		extra[2][29] =pared;
		extra[2][30] =pared;
		extra[2][31] =pared;
		extra[2][34] =pared;
		extra[2][35] =pared;
		extra[2][36] =pared;
		extra[2][37] =pared;
		extra[2][38] =pared;
		extra[2][39] =pared;
		extra[2][40] =pared;
		extra[2][41] =pared;
		extra[2][43] =pared;
		extra[2][44] =pared;
		extra[2][45] =pared;
		extra[2][46] =pared;
		extra[2][47] =pared;
		extra[2][48] =pared;
		extra[2][49] =pared;
		extra[3][0] =pared;
		extra[3][1] =pared;
		extra[3][2] =pared;
		extra[3][3] =pared;
		extra[3][4] =pared;
		extra[3][6] =pared;
		extra[3][7] =pared;
		extra[3][8] =pared;
		extra[3][9] =pared;
		extra[3][10] =pared;
		extra[3][11] =pared;
		extra[3][12] =pared;
		extra[3][13] =pared;
		extra[3][14] =pared;
		extra[3][15] =pared;
		extra[3][16] =pared;
		extra[3][17] =pared;
		extra[3][18] =tallgrass;
		extra[3][19] =pared;
		extra[3][20] =pared;
		extra[3][21] =pared;
		extra[3][22] =pared;
		extra[3][23] =pared;
		extra[3][27] =pared;
		extra[3][28] =pared;
		extra[3][29] =pared;
		extra[3][33] =pared;
		extra[3][34] =pared;
		extra[3][35] =pared;
		extra[3][36] =pared;
		extra[3][37] =pared;
		extra[3][38] =pared;
		extra[3][39] =pared;
		extra[3][40] =pared;
		extra[3][41] =pared;
		extra[3][43] =pared;
		extra[3][44] =pared;
		extra[3][45] =pared;
		extra[3][46] =pared;
		extra[3][48] =pared;
		extra[3][49] =pared;
		extra[4][0] =pared;
		extra[4][7] =pared;
		extra[4][8] =pelea;
		extra[4][14] =pelea;
		extra[4][15] =pared;
		extra[4][23] =pared;
		extra[4][24] =pared;
		extra[4][25] =pared;
		extra[4][27] =pared;
		extra[4][28] =pared;
		extra[4][31] =pared;
		extra[4][32] =pared;
		extra[4][33] =pared;
		extra[4][34] =pared;
		extra[4][44] =pared;
		extra[4][45] =pared;
		extra[4][46] =pared;
		extra[4][48] =pared;
		extra[4][49] =pared;
		extra[5][0] =pared;
		extra[5][1] =pared;
		extra[5][2] =pared;
		extra[5][3] =tallgrass;
		extra[5][4] =pared;
		extra[5][5] =pared;
		extra[5][6] =pared;
		extra[5][7] =pared;
		extra[5][8] =pared;
		extra[5][9] =pared;
		extra[5][10] =pared;
		extra[5][12] =pared;
		extra[5][13] =pared;
		extra[5][14] =pared;
		extra[5][15] =pared;
		extra[5][16] =pared;
		extra[5][17] =pared;
		extra[5][18] =pared;
		extra[5][19] =pared;
		extra[5][20] =pared;
		extra[5][21] =tallgrass;
		extra[5][22] =pared;
		extra[5][23] =pared;
		extra[5][24] =pared;
		extra[5][27] =pared;
		extra[5][28] =pared;
		extra[5][30] =pared;
		extra[5][31] =pared;
		extra[5][32] =pared;
		extra[5][33] =pared;
		extra[5][37] =pared;
		extra[5][38] =pared;
		extra[5][39] =pared;
		extra[5][40] =pared;
		extra[5][42] =pared;
		extra[5][46] =pared;
		extra[5][48] =pared;
		extra[5][49] =pared;
		extra[6][0] =pared;
		extra[6][9] =pared;
		extra[6][14] =pared;
		extra[6][18] =pared;
		extra[6][23] =pared;
		extra[6][24] =pared;
		extra[6][26] =pared;
		extra[6][27] =pared;
		extra[6][28] =pared;
		extra[6][30] =pared;
		extra[6][31] =pared;
		extra[6][32] =pared;
		extra[6][35] =pared;
		extra[6][37] =pared;
		extra[6][38] =pared;
		extra[6][39] =pared;
		extra[6][40] =pared;
		extra[6][42] =pared;
		extra[6][43] =pared;
		extra[6][44] =pared;
		extra[6][46] =pared;
		extra[6][48] =pared;
		extra[6][49] =pared;
		extra[7][0] =pared;
		extra[7][1] =pared;
		extra[7][3] =pared;
		extra[7][4] =pared;
		extra[7][5] =pared;
		extra[7][6] =tallgrass;
		extra[7][7] =pared;
		extra[7][8] =pared;
		extra[7][9] =pared;
		extra[7][10] =pared;
		extra[7][11] =pared;
		extra[7][13] =pared;
		extra[7][14] =pared;
		extra[7][15] =pared;
		extra[7][16] =tallgrass;
		extra[7][17] =pared;
		extra[7][18] =pared;
		extra[7][19] =pared;
		extra[7][21] =pared;
		extra[7][22] =pared;
		extra[7][23] =pared;
		extra[7][24] =pared;
		extra[7][26] =pared;
		extra[7][27] =pared;
		extra[7][28] =pared;
		extra[7][30] =pared;
		extra[7][34] =pared;
		extra[7][35] =pared;
		extra[7][39] =pared;
		extra[7][40] =pared;
		extra[7][42] =pared;
		extra[7][43] =pared;
		extra[7][44] =pared;
		extra[7][48] =pared;
		extra[7][49] =pared;
		extra[8][0] =pared;
		extra[8][1] =pelea;
		extra[8][3] =pared;
		extra[8][8] =pared;
		extra[8][9] =pelea;
		extra[8][14] =pared;
		extra[8][23] =pared;
		extra[8][24] =pared;
		extra[8][27] =pared;
		extra[8][32] =pared;
		extra[8][34] =pared;
		extra[8][35] =pared;
		extra[8][36] =pared;
		extra[8][37] =pared;
		extra[8][40] =pared;
		extra[8][43] =pared;
		extra[8][44] =pared;
		extra[8][46] =pared;
		extra[8][47] =pared;
		extra[8][48] =pared;
		extra[8][49] =pared;
		extra[9][0] =pared;
		extra[9][1] =pared;
		extra[9][2] =pared;
		extra[9][3] =pared;
		extra[9][5] =pared;
		extra[9][6] =pared;
		extra[9][7] =pared;
		extra[9][8] =pared;
		extra[9][9] =pared;
		extra[9][10] =pared;
		extra[9][12] =pared;
		extra[9][13] =pared;
		extra[9][14] =pared;
		extra[9][15] =pared;
		extra[9][16] =pared;
		extra[9][17] =pared;
		extra[9][18] =pared;
		extra[9][19] =pared;
		extra[9][20] =tallgrass;
		extra[9][21] =pared;
		extra[9][22] =pared;
		extra[9][23] =pared;
		extra[9][24] =pared;
		extra[9][25] =pared;
		extra[9][29] =pared;
		extra[9][30] =pared;
		extra[9][31] =pared;
		extra[9][32] =pared;
		extra[9][36] =pared;
		extra[9][37] =pared;
		extra[9][38] =pared;
		extra[9][40] =pared;
		extra[9][41] =pared;
		extra[9][42] =pared;
		extra[9][43] =pared;
		extra[9][44] =pared;
		extra[9][46] =pared;
		extra[9][47] =pared;
		extra[9][48] =pared;
		extra[9][49] =pared;
		extra[10][0] =pared;
		extra[10][6] =pelea;
		extra[10][7] =pared;
		extra[10][11] =pelea;
		extra[10][18] =pared;
		extra[10][23] =pared;
		extra[10][24] =pared;
		extra[10][25] =pared;
		extra[10][26] =pared;
		extra[10][27] =pared;
		extra[10][28] =pared;
		extra[10][29] =pared;
		extra[10][30] =pared;
		extra[10][31] =pared;
		extra[10][32] =pared;
		extra[10][33] =pared;
		extra[10][34] =pared;
		extra[10][35] =pared;
		extra[10][36] =pared;
		extra[10][37] =pared;
		extra[10][38] =pared;
		extra[10][39] =pared;
		extra[10][40] =pared;
		extra[10][41] =pared;
		extra[10][42] =pared;
		extra[10][43] =pared;
		extra[10][46] =pared;
		extra[10][47] =pared;
		extra[10][48] =pared;
		extra[10][49] =pared;
		extra[11][0] =pared;
		extra[11][1] =pared;
		extra[11][3] =pared;
		extra[11][4] =pared;
		extra[11][5] =pared;
		extra[11][6] =pared;
		extra[11][7] =pared;
		extra[11][8] =tallgrass;
		extra[11][9] =pared;
		extra[11][10] =pared;
		extra[11][11] =pared;
		extra[11][12] =pared;
		extra[11][13] =pared;
		extra[11][14] =pared;
		extra[11][15] =pared;
		extra[11][17] =pared;
		extra[11][18] =pared;
		extra[11][19] =pared;
		extra[11][20] =pared;
		extra[11][21] =tallgrass;
		extra[11][22] =pared;
		extra[11][23] =pared;
		extra[11][24] =pared;
		extra[11][25] =pared;
		extra[11][26] =pared;
		extra[11][27] =pared;
		extra[11][28] =pared;
		extra[11][29] =pared;
		extra[11][30] =pared;
		extra[11][31] =pared;
		extra[11][32] =pared;
		extra[11][33] =pared;
		extra[11][34] =pared;
		extra[11][35] =pared;
		extra[11][36] =pared;
		extra[11][37] =pared;
		extra[11][38] =pared;
		extra[11][39] =pared;
		extra[11][41] =pared;
		extra[11][42] =pared;
		extra[11][43] =pared;
		extra[11][45] =pared;
		extra[11][46] =pared;
		extra[11][47] =pared;
		extra[11][48] =pared;
		extra[11][49] =pared;
		extra[12][0] =pared;
		extra[12][4] =pared;
		extra[12][10] =pared;
		extra[12][16] =pelea;
		extra[12][23] =pared;
		extra[12][24] =pared;
		extra[12][25] =pared;
		extra[12][26] =pared;
		extra[12][27] =pared;
		extra[12][28] =pared;
		extra[12][29] =pared;
		extra[12][30] =pared;
		extra[12][31] =pared;
		extra[12][32] =pared;
		extra[12][33] =pared;
		extra[12][34] =pared;
		extra[12][35] =puerta;
		extra[12][39] =pared;
		extra[12][45] =pared;
		extra[12][46] =pared;
		extra[12][48] =pared;
		extra[12][49] =pared;
		extra[13][0] =pared;
		extra[13][1] =pared;
		extra[13][2] =tallgrass;
		extra[13][3] =pared;
		extra[13][4] =pared;
		extra[13][5] =pared;
		extra[13][6] =pared;
		extra[13][7] =pared;
		extra[13][8] =pared;
		extra[13][9] =pared;
		extra[13][10] =pared;
		extra[13][11] =puerta;
		extra[13][12] =pared;
		extra[13][13] =pared;
		extra[13][14] =pared;
		extra[13][15] =pared;
		extra[13][16] =pared;
		extra[13][17] =pared;
		extra[13][18] =pared;
		extra[13][19] =pared;
		extra[13][20] =pared;
		extra[13][21] =pared;
		extra[13][22] =pared;
		extra[13][23] =pared;
		extra[13][24] =pared;
		extra[13][25] =pared;
		extra[13][33] =pared;
		extra[13][34] =pared;
		extra[13][35] =pared;
		extra[13][36] =pared;
		extra[13][38] =pared;
		extra[13][39] =pared;
		extra[13][40] =pared;
		extra[13][42] =pared;
		extra[13][44] =pared;
		extra[13][45] =pared;
		extra[13][46] =pared;
		extra[13][48] =pared;
		extra[13][49] =pared;
		extra[14][0] =pared;
		extra[14][1] =pelea;
		extra[14][5] =tallgrass;
		extra[14][10] =pared;
		extra[14][11] =pared;
		extra[14][12] =pared;
		extra[14][15] =pelea;
		extra[14][16] =pared;
		extra[14][22] =pared;
		extra[14][23] =pared;
		extra[14][24] =pared;
		extra[14][26] =pared;
		extra[14][28] =pared;
		extra[14][30] =pared;
		extra[14][32] =pared;
		extra[14][34] =pared;
		extra[14][35] =pared;
		extra[14][36] =pared;
		extra[14][38] =pared;
		extra[14][39] =pared;
		extra[14][40] =pared;
		extra[14][42] =pared;
		extra[14][45] =pared;
		extra[14][48] =pared;
		extra[14][49] =pared;
		extra[15][0] =pared;
		extra[15][1] =pared;
		extra[15][3] =pared;
		extra[15][4] =pared;
		extra[15][5] =pared;
		extra[15][6] =pared;
		extra[15][7] =pared;
		extra[15][8] =tallgrass;
		extra[15][9] =pared;
		extra[15][10] =pared;
		extra[15][14] =pared;
		extra[15][15] =pared;
		extra[15][16] =pared;
		extra[15][18] =pared;
		extra[15][19] =pared;
		extra[15][20] =pared;
		extra[15][21] =pelea;
		extra[15][22] =pared;
		extra[15][23] =pared;
		extra[15][24] =pared;
		
		extra[15][29] =pelea;//boss final
		
		extra[15][34] =pared;
		extra[15][35] =pared;
		extra[15][38] =pared;
		extra[15][39] =pared;
		extra[15][42] =pared;
		extra[15][43] =pared;
		extra[15][45] =pared;
		extra[15][47] =pared;
		extra[15][48] =pared;
		extra[15][49] =pared;
		extra[16][0] =pared;
		extra[16][5] =pared;
		extra[16][10] =pared;
		extra[16][12] =pared;
		extra[16][14] =pared;
		extra[16][18] =pared;
		extra[16][20] =pared;
		extra[16][21] =pared;
		extra[16][22] =pared;
		extra[16][23] =pared;
		extra[16][24] =pared;
		extra[16][26] =pared;
		extra[16][28] =pared;
		extra[16][30] =pared;
		extra[16][32] =pared;
		extra[16][34] =pared;
		extra[16][35] =pared;
		extra[16][36] =pared;
		extra[16][38] =pared;
		extra[16][39] =pared;
		extra[16][41] =pared;
		extra[16][42] =pared;
		extra[16][43] =pared;
		extra[16][45] =pared;
		extra[16][47] =pared;
		extra[16][48] =pared;
		extra[16][49] =pared;
		extra[17][0] =pared;
		extra[17][1] =pared;
		extra[17][2] =pared;
		extra[17][3] =pared;
		extra[17][5] =pared;
		extra[17][6] =pared;
		extra[17][7] =pared;
		extra[17][8] =pared;
		extra[17][9] =tallgrass;
		extra[17][10] =pared;
		extra[17][12] =pared;
		extra[17][13] =pared;
		extra[17][14] =pared;
		extra[17][15] =pelea;
		extra[17][16] =pared;
		extra[17][18] =pared;
		extra[17][20] =pelea;
		extra[17][21] =pared;
		extra[17][22] =pared;
		extra[17][23] =pared;
		extra[17][24] =pared;
		extra[17][34] =pared;
		extra[17][35] =pared;
		extra[17][36] =pared;
		extra[17][41] =pared;
		extra[17][47] =pared;
		extra[17][48] =pared;
		extra[17][49] =pared;
		extra[18][0] =pared;
		extra[18][1] =pelea;
		extra[18][6] =pelea;
		extra[18][7] =pared;
		extra[18][10] =pared;
		extra[18][14] =pared;
		extra[18][15] =pared;
		extra[18][16] =pared;
		extra[18][18] =pared;
		extra[18][20] =pared;
		extra[18][21] =pared;
		extra[18][22] =pelea;
		extra[18][23] =pared;
		extra[18][24] =pared;
		extra[18][26] =pared;
		extra[18][28] =pared;
		extra[18][30] =pared;
		extra[18][32] =pared;
		extra[18][34] =pared;
		extra[18][35] =pared;
		extra[18][36] =pared;
		extra[18][38] =pared;
		extra[18][39] =pared;
		extra[18][40] =pared;
		extra[18][41] =pared;
		extra[18][43] =pared;
		extra[18][44] =pared;
		extra[18][46] =pared;
		extra[18][47] =pared;
		extra[18][48] =pared;
		extra[18][49] =pared;
		extra[19][0] =pared;
		extra[19][1] =pared;
		extra[19][2] =pared;
		extra[19][3] =pared;
		extra[19][4] =pared;
		extra[19][5] =pared;
		extra[19][6] =pared;
		extra[19][7] =pared;
		extra[19][8] =pared;
		extra[19][9] =tallgrass;
		extra[19][10] =pared;
		extra[19][11] =pared;
		extra[19][12] =pared;
		extra[19][23] =pared;
		extra[19][24] =pared;
		extra[19][34] =pared;
		extra[19][35] =pared;
		extra[19][38] =pared;
		extra[19][39] =pared;
		extra[19][40] =pared;
		extra[19][41] =pared;
		extra[19][42] =pared;
		extra[19][43] =pared;
		extra[19][44] =pared;
		extra[19][46] =pared;
		extra[19][47] =pared;
		extra[19][48] =pared;
		extra[19][49] =pared;
		extra[20][0] =pared;
		extra[20][10] =pared;
		extra[20][11] =pelea;
		extra[20][12] =pared;
		extra[20][14] =pared;
		extra[20][17] =pared;
		extra[20][19] =pared;
		extra[20][21] =pared;
		extra[20][22] =pared;
		extra[20][23] =pared;
		extra[20][24] =pared;
		extra[20][26] =pared;
		extra[20][28] =pared;
		extra[20][30] =pared;
		extra[20][32] =pared;
		extra[20][34] =pared;
		extra[20][35] =pared;
		extra[20][36] =pared;
		extra[20][38] =pared;
		extra[20][39] =pared;
		extra[20][40] =pared;
		extra[20][43] =pared;
		extra[20][44] =pared;
		extra[20][45] =pared;
		extra[20][46] =pared;
		extra[20][47] =pared;
		extra[20][49] =pared;
		extra[21][0] =pared;
		extra[21][1] =pared;
		extra[21][2] =pared;
		extra[21][3] =tallgrass;
		extra[21][4] =pared;
		extra[21][5] =pared;
		extra[21][6] =pared;
		extra[21][7] =pared;
		extra[21][8] =pared;
		extra[21][9] =pared;
		extra[21][10] =pared;
		extra[21][12] =pared;
		extra[21][13] =pared;
		extra[21][14] =pared;
		extra[21][16] =pared;
		extra[21][17] =pared;
		extra[21][18] =pelea;
		extra[21][19] =pared;
		extra[21][20] =pared;
		extra[21][21] =pared;
		extra[21][34] =pared;
		extra[21][35] =pared;
		extra[21][36] =pared;
		extra[21][38] =pared;
		extra[21][39] =pared;
		extra[21][42] =pared;
		extra[21][43] =pared;
		extra[21][44] =pared;
		extra[21][45] =pared;
		extra[21][46] =pared;
		extra[21][49] =pared;
		extra[22][0] =pared;
		extra[22][5] =pared;
		extra[22][10] =pared;
		extra[22][17] =pared;
		extra[22][18] =pared;
		extra[22][19] =pared;
		extra[22][21] =pared;
		extra[22][23] =pared;
		extra[22][24] =pared;
		extra[22][26] =pared;
		extra[22][28] =pared;
		extra[22][30] =pared;
		extra[22][32] =pared;
		extra[22][34] =pared;
		extra[22][35] =pared;
		extra[22][48] =pared;
		extra[22][49] =pared;
		extra[23][0] =pared;
		extra[23][5] =tallgrass;
		extra[23][8] =pelea;
		extra[23][10] =pared;
		extra[23][11] =pared;
		extra[23][13] =pared;
		extra[23][14] =pared;
		extra[23][15] =pared;
		extra[23][17] =pared;
		extra[23][23] =pared;
		extra[23][24] =pared;
		extra[23][25] =pared;
		extra[23][33] =pared;
		extra[23][34] =pared;
		extra[23][35] =pared;
		extra[23][37] =pared;
		extra[23][38] =pared;
		extra[23][39] =pared;
		extra[23][40] =pared;
		extra[23][41] =pared;
		extra[23][42] =pared;
		extra[23][44] =pared;
		extra[23][45] =pared;
		extra[23][47] =pared;
		extra[23][48] =pared;
		extra[23][49] =pared;
		extra[24][0] =pared;
		extra[24][5] =pared;
		extra[24][10] =pared;
		extra[24][14] =pelea;
		extra[24][15] =pared;
		extra[24][19] =pared;
		extra[24][21] =pared;
		extra[24][22] =pared;
		extra[24][23] =pared;
		extra[24][24] =pared;
		extra[24][25] =pared;
		extra[24][26] =pared;
		extra[24][27] =pared;
		extra[24][28] =pared;
		extra[24][29] =pared;
		extra[24][30] =pared;
		extra[24][31] =pared;
		extra[24][32] =pared;
		extra[24][33] =pared;
		extra[24][34] =pared;
		extra[24][35] =pared;
		extra[24][38] =pared;
		extra[24][39] =pared;
		extra[24][40] =pared;
		extra[24][41] =pared;
		extra[24][44] =pared;
		extra[24][45] =pared;
		extra[24][49] =pared;
		extra[25][0] =pared;
		extra[25][1] =pared;
		extra[25][2] =pared;
		extra[25][3] =pared;
		extra[25][4] =pared;
		extra[25][5] =pared;
		extra[25][6] =pared;
		extra[25][7] =pared;
		extra[25][8] =pared;
		extra[25][9] =pared;
		extra[25][10] =pared;
		extra[25][11] =pared;
		extra[25][12] =pared;
		extra[25][13] =pared;
		extra[25][14] =pared;
		extra[25][15] =pared;
		extra[25][16] =pared;
		extra[25][17] =puente;
		extra[25][18] =pared;
		extra[25][19] =pared;
		extra[25][20] =pared;
		extra[25][21] =pared;
		extra[25][22] =pared;
		extra[25][23] =pared;
		extra[25][24] =puerta;
		extra[25][26] =suelo;
		extra[25][27] =pared;
		extra[25][28] =pared;
		extra[25][29] =pared;
		extra[25][30] =pared;
		extra[25][31] =pared;
		extra[25][32] =pared;
		extra[25][33] =pared;
		extra[25][34] =pared;
		extra[25][35] =pared;
		extra[25][36] =pared;
		extra[25][37] =pared;
		extra[25][38] =pared;
		extra[25][39] =pared;
		extra[25][40] =pared;
		extra[25][41] =pared;
		extra[25][42] =pared;
		extra[25][43] =pared;
		extra[25][44] =pared;
		extra[25][45] =pared;
		extra[25][46] =pared;
		extra[25][47] =pared;
		extra[25][48] =pared;
		extra[25][49] =pared;
		extra[26][0] =pared;
		extra[26][3] =rio;
		extra[26][4] =rio;
		extra[26][5] =rio;
		extra[26][6] =rio;
		extra[26][7] =rio;
		extra[26][8] =rio;
		extra[26][12] =pared;
		extra[26][14] =puente;
		extra[26][16] =rio;
		extra[26][18] =puente;
		extra[26][20] =puente;
		extra[26][22] =rio;
		extra[26][23] =pared;
		extra[26][24] =pared;
		extra[26][37] =pared;
		extra[26][49] =pared;
		extra[27][0] =pared;
		extra[27][3] =rio;
		extra[27][4] =rio;
		extra[27][5] =rio;
		extra[27][6] =rio;
		extra[27][7] =rio;
		extra[27][8] =rio;
		extra[27][12] =pared;
		extra[27][13] =puente;
		extra[27][14] =rio;
		extra[27][15] =puente;
		extra[27][16] =rio;
		extra[27][17] =rio;
		extra[27][18] =rio;
		extra[27][19] =rio;
		extra[27][20] =rio;
		extra[27][21] =puente;
		extra[27][22] =rio;
		extra[27][23] =rio;
		extra[27][24] =pared;
		extra[27][25] =pelea;
		extra[27][27] =pelea;
		extra[27][29] =pelea;
		extra[27][31] =pelea;
		extra[27][33] =pelea;
		extra[27][35] =pelea;
		extra[27][37] =pared;
		extra[27][39] =pelea;
		extra[27][43] =pelea;
		extra[27][47] =pelea;
		extra[27][49] =pared;
		extra[28][0] =pared;
		extra[28][4] =rio;
		extra[28][5] =rio;
		extra[28][6] =rio;
		extra[28][7] =rio;
		extra[28][12] =pared;
		extra[28][14] =rio;
		extra[28][16] =rio;
		extra[28][18] =puente;
		extra[28][20] =puente;
		extra[28][22] =rio;
		extra[28][23] =rio;
		extra[28][24] =pared;
		extra[28][37] =pared;
		extra[28][49] =pared;
		extra[29][0] =pared;
		extra[29][2] =rio;
		extra[29][3] =puente;
		extra[29][4] =rio;
		extra[29][5] =rio;
		extra[29][6] =rio;
		extra[29][7] =rio;
		extra[29][8] =rio;
		extra[29][9] =rio;
		extra[29][12] =pared;
		extra[29][13] =puente;
		extra[29][14] =rio;
		extra[29][15] =puente;
		extra[29][16] =rio;
		extra[29][17] =puente;
		extra[29][18] =rio;
		extra[29][19] =rio;
		extra[29][20] =rio;
		extra[29][21] =rio;
		extra[29][22] =rio;
		extra[29][23] =rio;
		extra[29][24] =pared;
		extra[29][26] =pelea;
		extra[29][28] =pelea;
		extra[29][30] =pelea;
		extra[29][32] =pelea;
		extra[29][34] =pelea;
		extra[29][36] =pelea;
		extra[29][37] =pared;
		extra[29][40] =pelea;
		extra[29][46] =pelea;
		extra[29][49] =pared;
		extra[30][0] =pared;
		extra[30][1] =rio;
		extra[30][2] =rio;
		extra[30][5] =rio;
		extra[30][9] =rio;
		extra[30][10] =rio;
		extra[30][12] =pared;
		extra[30][14] =rio;
		extra[30][16] =rio;
		extra[30][18] =puente;
		extra[30][20] =rio;
		extra[30][22] =puente;
		extra[30][37] =pared;
		extra[30][43] =pelea;
		extra[30][49] =pared;
		extra[31][0] =pared;
		extra[31][1] =rio;
		extra[31][4] =rio;
		extra[31][5] =rio;
		extra[31][6] =rio;
		extra[31][7] =rio;
		extra[31][10] =rio;
		extra[31][11] =puente;
		extra[31][12] =pared;
		extra[31][13] =puente;
		extra[31][14] =rio;
		extra[31][15] =puente;
		extra[31][16] =rio;
		extra[31][17] =rio;
		extra[31][18] =rio;
		extra[31][19] =puente;
		extra[31][20] =rio;
		extra[31][21] =puente;
		extra[31][22] =rio;
		extra[31][23] =rio;
		extra[31][24] =pared;
		extra[31][25] =pelea;
		extra[31][27] =pelea;
		extra[31][29] =pelea;
		extra[31][31] =pelea;
		extra[31][33] =pelea;
		extra[31][35] =pelea;
		extra[31][37] =pared;
		extra[31][40] =pelea;
		extra[31][49] =pared;
		extra[32][0] =pared;
		extra[32][4] =rio;
		extra[32][7] =rio;
		extra[32][8] =rio;
		extra[32][12] =pared;
		extra[32][14] =rio;
		extra[32][16] =puente;
		extra[32][18] =rio;
		extra[32][20] =rio;
		extra[32][22] =rio;
		extra[32][23] =rio;
		extra[32][24] =pared;
		extra[32][37] =pared;
		extra[32][46] =pelea;
		extra[32][49] =pared;
		extra[33][0] =pared;
		extra[33][3] =rio;
		extra[33][4] =rio;
		extra[33][8] =rio;
		extra[33][12] =pared;
		extra[33][13] =puente;
		extra[33][14] =rio;
		extra[33][15] =rio;
		extra[33][16] =rio;
		extra[33][17] =puente;
		extra[33][18] =rio;
		extra[33][19] =puente;
		extra[33][20] =rio;
		extra[33][21] =puente;
		extra[33][22] =rio;
		extra[33][23] =rio;
		extra[33][24] =pared;
		extra[33][26] =pelea;
		extra[33][28] =pelea;
		extra[33][30] =pelea;
		extra[33][32] =pelea;
		extra[33][34] =pelea;
		extra[33][36] =pelea;
		extra[33][37] =pared;
		extra[33][43] =pelea;
		extra[33][49] =pared;
		extra[34][0] =pared;
		extra[34][3] =rio;
		extra[34][8] =rio;
		extra[34][12] =pared;
		extra[34][14] =puente;
		extra[34][16] =rio;
		extra[34][18] =puente;
		extra[34][20] =rio;
		extra[34][22] =rio;
		extra[34][23] =rio;
		extra[34][24] =pared;
		extra[34][37] =pared;
		extra[34][40] =pelea;
		extra[34][47] =pelea;
		extra[34][49] =pared;
		extra[35][0] =pared;
		extra[35][3] =rio;
		extra[35][7] =pelea;
		extra[35][8] =puente;
		extra[35][12] =pared;
		extra[35][13] =rio;
		extra[35][14] =rio;
		extra[35][15] =puente;
		extra[35][16] =rio;
		extra[35][17] =rio;
		extra[35][18] =rio;
		extra[35][19] =rio;
		extra[35][20] =rio;
		extra[35][21] =puente;
		extra[35][22] =rio;
		extra[35][23] =rio;
		extra[35][24] =pared;
		extra[35][25] =pelea;
		extra[35][27] =pelea;
		extra[35][29] =pelea;
		extra[35][31] =pelea;
		extra[35][33] =pelea;
		extra[35][35] =pared;
		extra[35][36] =pared;
		extra[35][37] =pared;
		extra[35][42] =pelea;
		extra[35][49] =pared;
		extra[36][0] =pared;
		extra[36][2] =rio;
		extra[36][3] =rio;
		extra[36][6] =rio;
		extra[36][7] =rio;
		extra[36][8] =rio;
		extra[36][12] =pared;
		extra[36][13] =pared;
		extra[36][14] =rio;
		extra[36][16] =puente;
		extra[36][18] =puente;
		extra[36][20] =puente;
		extra[36][22] =rio;
		extra[36][23] =pared;
		extra[36][24] =pared;
		extra[36][25] =pared;
		extra[36][26] =pared;
		extra[36][27] =pared;
		extra[36][28] =pared;
		extra[36][29] =pared;
		extra[36][30] =pared;
		extra[36][31] =pared;
		extra[36][32] =pared;
		extra[36][33] =pared;
		extra[36][34] =pared;
		extra[36][35] =pared;
		extra[36][36] =puerta;
		extra[36][37] =pared;
		extra[36][49] =pared;
		extra[37][0] =pared;
		extra[37][1] =rio;
		extra[37][2] =rio;
		extra[37][3] =rio;
		extra[37][5] =rio;
		extra[37][6] =rio;
		extra[37][8] =rio;
		extra[37][9] =rio;
		extra[37][12] =puerta;
		extra[37][13] =pared;
		extra[37][14] =rio;
		extra[37][15] =rio;
		extra[37][16] =rio;
		extra[37][17] =rio;
		extra[37][18] =rio;
		extra[37][19] =rio;
		extra[37][20] =rio;
		extra[37][21] =rio;
		extra[37][22] =rio;
		extra[37][23] =pared;
		extra[37][38] =pelea;
		extra[37][41] =pelea;
		extra[37][45] =pelea;
		extra[37][49] =pared;
		extra[38][0] =pared;
		extra[38][1] =rio;
		extra[38][3] =rio;
		extra[38][5] =rio;
		extra[38][9] =rio;
		extra[38][12] =pared;
		extra[38][13] =pared;
		extra[38][14] =pared;
		extra[38][15] =pared;
		extra[38][16] =pared;
		extra[38][17] =pared;
		extra[38][18] =pared;
		extra[38][19] =pared;
		extra[38][20] =pared;
		extra[38][21] =pared;
		extra[38][22] =pared;
		extra[38][23] =pared;
		extra[38][25] =pelea;
		extra[38][29] =pelea;
		extra[38][34] =pelea;
		extra[38][48] =pelea;
		extra[38][49] =pared;
		extra[39][0] =pared;
		extra[39][3] =rio;
		extra[39][5] =rio;
		extra[39][6] =rio;
		extra[39][9] =rio;
		extra[39][12] =rio;
		extra[39][13] =rio;
		extra[39][18] =rio;
		extra[39][19] =rio;
		extra[39][23] =pared;
		extra[39][27] =pelea;
		extra[39][31] =pelea;
		extra[39][38] =pelea;
		extra[39][42] =pelea;
		extra[39][49] =pared;
		extra[40][0] =pared;
		extra[40][2] =pelea;
		extra[40][3] =puente;
		extra[40][6] =rio;
		extra[40][7] =rio;
		extra[40][9] =rio;
		extra[40][10] =rio;
		extra[40][11] =rio;
		extra[40][12] =rio;
		extra[40][15] =pelea;
		extra[40][18] =puente;
		extra[40][19] =pelea;
		extra[40][21] =rio;
		extra[40][22] =puente;
		extra[40][23] =pared;
		extra[40][25] =pelea;
		extra[40][49] =pared;
		extra[41][0] =pared;
		extra[41][3] =rio;
		extra[41][7] =rio;
		extra[41][9] =rio;
		extra[41][14] =rio;
		extra[41][15] =puente;
		extra[41][16] =rio;
		extra[41][17] =rio;
		extra[41][18] =rio;
		extra[41][20] =rio;
		extra[41][21] =rio;
		extra[41][23] =pared;
		extra[41][32] =pelea;
		extra[41][35] =pelea;
		extra[41][43] =pelea;
		extra[41][46] =pelea;
		extra[41][49] =pared;
		extra[42][0] =pared;
		extra[42][2] =rio;
		extra[42][3] =rio;
		extra[42][4] =rio;
		extra[42][9] =rio;
		extra[42][10] =rio;
		extra[42][11] =rio;
		extra[42][12] =rio;
		extra[42][13] =rio;
		extra[42][14] =rio;
		extra[42][18] =rio;
		extra[42][19] =rio;
		extra[42][20] =rio;
		extra[42][23] =pared;
		extra[42][26] =pelea;
		extra[42][28] =pelea;
		extra[42][38] =pelea;
		extra[42][40] =pelea;
		extra[42][49] =pared;
		extra[43][0] =pared;
		extra[43][2] =rio;
		extra[43][4] =rio;
		extra[43][5] =rio;
		extra[43][6] =rio;
		extra[43][7] =rio;
		extra[43][8] =rio;
		extra[43][9] =rio;
		extra[43][12] =rio;
		extra[43][18] =rio;
		extra[43][22] =pelea;
		extra[43][23] =pared;
		extra[43][31] =pelea;
		extra[43][49] =pared;
		extra[44][0] =pared;
		extra[44][2] =rio;
		extra[44][5] =rio;
		extra[44][8] =rio;
		extra[44][9] =rio;
		extra[44][12] =rio;
		extra[44][18] =rio;
		extra[44][23] =pared;
		extra[44][24] =pelea;
		extra[44][34] =pelea;
		extra[44][44] =pelea;
		extra[44][49] =pared;
		extra[45][0] =pared;
		extra[45][2] =rio;
		extra[45][5] =rio;
		extra[45][6] =rio;
		extra[45][9] =rio;
		extra[45][10] =rio;
		extra[45][12] =rio;
		extra[45][13] =rio;
		extra[45][18] =rio;
		extra[45][19] =rio;
		extra[45][20] =rio;
		extra[45][21] =rio;
		extra[45][23] =pared;
		extra[45][26] =pelea;
		extra[45][37] =pelea;
		extra[45][41] =pelea;
		extra[45][49] =pared;
		extra[46][0] =pared;
		extra[46][2] =rio;
		extra[46][3] =rio;
		extra[46][6] =rio;
		extra[46][7] =rio;
		extra[46][10] =rio;
		extra[46][13] =rio;
		extra[46][14] =rio;
		extra[46][15] =pelea;
		extra[46][18] =rio;
		extra[46][21] =rio;
		extra[46][23] =pared;
		extra[46][30] =pelea;
		extra[46][47] =pelea;
		extra[46][49] =pared;
		extra[47][0] =pared;
		extra[47][3] =rio;
		extra[47][7] =puente;
		extra[47][8] =pelea;
		extra[47][10] =rio;
		extra[47][11] =rio;
		extra[47][14] =rio;
		extra[47][15] =puente;
		extra[47][16] =rio;
		extra[47][17] =rio;
		extra[47][18] =rio;
		extra[47][19] =rio;
		extra[47][21] =rio;
		extra[47][22] =rio;
		extra[47][23] =pared;
		extra[47][26] =pelea;
		extra[47][33] =pelea;
		extra[47][39] =pelea;
		extra[47][44] =pelea;
		extra[47][49] =pared;
		extra[48][0] =pared;
		extra[48][3] =puente;
		extra[48][4] =pelea;
		extra[48][7] =rio;
		extra[48][11] =puente;
		extra[48][12] =pelea;
		extra[48][19] =rio;
		extra[48][22] =rio;
		extra[48][23] =pared;
		extra[48][49] =pared;
		extra[49][0] =pared;
		extra[49][1] =pared;
		extra[49][2] =pared;
		extra[49][3] =pared;
		extra[49][4] =pared;
		extra[49][5] =pared;
		extra[49][6] =pared;
		extra[49][7] =pared;
		extra[49][8] =pared;
		extra[49][9] =pared;
		extra[49][10] =pared;
		extra[49][11] =pared;
		extra[49][12] =pared;
		extra[49][13] =pared;
		extra[49][14] =pared;
		extra[49][15] =pared;
		extra[49][16] =pared;
		extra[49][17] =pared;
		extra[49][18] =pared;
		extra[49][19] =pared;
		extra[49][20] =pared;
		extra[49][21] =pared;
		extra[49][22] =pared;
		extra[49][23] =pared;
		extra[49][24] =pared;
		extra[49][25] =pared;
		extra[49][26] =pared;
		extra[49][27] =pared;
		extra[49][28] =pared;
		extra[49][29] =pared;
		extra[49][30] =pared;
		extra[49][31] =pared;
		extra[49][32] =pared;
		extra[49][33] =pared;
		extra[49][34] =pared;
		extra[49][35] =pared;
		extra[49][36] =pared;
		extra[49][37] =pared;
		extra[49][38] =pared;
		extra[49][39] =pared;
		extra[49][40] =pared;
		extra[49][41] =pared;
		extra[49][42] =pared;
		extra[49][43] =pared;
		extra[49][44] =pared;
		extra[49][45] =pared;
		extra[49][46] =pared;
		extra[49][47] =pared;
		extra[49][48] =pared;
		extra[49][49] =pared;


		

		mundo[0][0] =pared;
		mundo[0][1] =pared;
		mundo[0][2] =pared;
		mundo[0][3] =pared;
		mundo[0][4] =pared;
		mundo[0][5] =pared;
		mundo[0][6] =pared;
		mundo[0][7] =pared;
		mundo[0][8] =pared;
		mundo[0][9] =pared;
		mundo[0][10] =pared;
		mundo[0][11] =pared;
		mundo[0][12] =pared;
		mundo[0][13] =pared;
		mundo[0][14] =pared;
		mundo[0][15] =pared;
		mundo[0][16] =pared;
		mundo[0][17] =pared;
		mundo[0][18] =pared;
		mundo[0][19] =pared;
		mundo[0][20] =pared;
		mundo[0][21] =pared;
		mundo[0][22] =pared;
		mundo[0][23] =pared;
		mundo[0][24] =pared;
		mundo[0][25] =pared;
		mundo[0][26] =pared;
		mundo[0][27] =pared;
		mundo[0][28] =pared;
		mundo[0][29] =pared;
		mundo[0][30] =pared;
		mundo[0][31] =pared;
		mundo[0][32] =pared;
		mundo[0][33] =pared;
		mundo[0][34] =pared;
		mundo[0][35] =pared;
		mundo[0][36] =pared;
		mundo[0][37] =pared;
		mundo[0][38] =pared;
		mundo[0][39] =pared;
		mundo[0][40] =pared;
		mundo[0][41] =pared;
		mundo[0][42] =pared;
		mundo[0][43] =pared;
		mundo[0][44] =pared;
		mundo[0][45] =pared;
		mundo[0][46] =pared;
		mundo[0][47] =pared;
		mundo[0][48] =pared;
		mundo[0][49] =pared;
		mundo[1][0] =pared;
		mundo[1][5] =tejado;
		mundo[1][6] =tejado;
		mundo[1][7] =tejado;
		mundo[1][10] =tejado;
		mundo[1][11] =tejado;
		mundo[1][12] =tejado;
		mundo[1][15] =tejado;
		mundo[1][16] =tejado;
		mundo[1][17] =tejado;
		mundo[1][22] =pared;
		mundo[1][24] =shop;
		mundo[1][26] =pared;
		mundo[1][49] =pared;
		mundo[2][0] =pared;
		mundo[2][3] =tallgrass;
		mundo[2][5] =casa;
		mundo[2][6] =casa;
		mundo[2][7] =casa;
		mundo[2][10] =casa;
		mundo[2][11] =casa;
		mundo[2][12] =casa;
		mundo[2][15] =casa;
		mundo[2][16] =casa;
		mundo[2][17] =casa;
		mundo[2][20] =tallgrass;
		mundo[2][22] =pared;
		mundo[2][26] =pared;
		mundo[2][49] =pared;
		mundo[3][0] =pared;
		mundo[3][5] =casa;
		mundo[3][6] =casa;
		mundo[3][7] =casa;
		mundo[3][10] =casa;
		mundo[3][11] =casa;
		mundo[3][12] =casa;
		mundo[3][15] =casa;
		mundo[3][16] =casa;
		mundo[3][17] =casa;
		mundo[3][49] =pared;
		mundo[4][0] =pared;
		mundo[4][6] =camino;
		mundo[4][11] =camino;
		mundo[4][16] =camino;
		mundo[4][29] =NPC;
		mundo[4][49] =pared;
		mundo[5][0] =pared;
		mundo[5][6] =camino;
		mundo[5][7] =camino;
		mundo[5][8] =camino;
		mundo[5][9] =camino;
		mundo[5][10] =camino;
		mundo[5][11] =camino;
		mundo[5][12] =camino;
		mundo[5][13] =camino;
		mundo[5][14] =camino;
		mundo[5][15] =camino;
		mundo[5][16] =camino;
		mundo[5][17] =NPC;
		mundo[5][22] =pared;
		mundo[5][26] =pared;
		mundo[5][31] =pared;
		mundo[5][32] =pared;
		mundo[5][33] =pelea;
		mundo[5][35] =pelea;
		mundo[5][37] =pelea;
		mundo[5][39] =pelea;
		mundo[5][41] =pelea;
		mundo[5][43] =pelea;
		mundo[5][45] =pelea;
		mundo[5][46] =pared;
		mundo[5][47] =pared;
		mundo[5][49] =pared;
		mundo[6][0] =pared;
		mundo[6][6] =camino;
		mundo[6][11] =camino;
		mundo[6][16] =camino;
		mundo[6][19] =tallgrass;
		mundo[6][22] =pared;
		mundo[6][26] =pared;
		mundo[6][31] =pared;
		mundo[6][32] =pared;
		mundo[6][34] =pelea;
		mundo[6][36] =pelea;
		mundo[6][38] =pelea;
		mundo[6][40] =pelea;
		mundo[6][42] =pelea;
		mundo[6][44] =pelea;
		mundo[6][46] =pared;
		mundo[6][47] =pared;
		mundo[6][49] =pared;
		mundo[7][0] =pared;
		mundo[7][5] =tejado;
		mundo[7][6] =tejado;
		mundo[7][7] =tejado;
		mundo[7][10] =tejado;
		mundo[7][11] =tejado;
		mundo[7][12] =tejado;
		mundo[7][15] =tejado;
		mundo[7][16] =tejado;
		mundo[7][17] =tejado;
		mundo[7][22] =pared;
		mundo[7][23] =pared;
		mundo[7][25] =pared;
		mundo[7][26] =pared;
		mundo[7][31] =pelea;
		mundo[7][33] =pelea;
		mundo[7][35] =pelea;
		mundo[7][37] =pelea;
		mundo[7][39] =pelea;
		mundo[7][41] =pelea;
		mundo[7][43] =pelea;
		mundo[7][45] =pelea;
		mundo[7][47] =pelea;
		mundo[7][49] =pared;
		mundo[8][0] =pared;
		mundo[8][2] =tallgrass;
		mundo[8][5] =casa;
		mundo[8][6] =casa;
		mundo[8][7] =casa;
		mundo[8][10] =casa;
		mundo[8][11] =casa;
		mundo[8][12] =casa;
		mundo[8][15] =casa;
		mundo[8][16] =casa;
		mundo[8][17] =casa;
		mundo[8][22] =pared;
		mundo[8][26] =pared;
		mundo[8][32] =pelea;
		mundo[8][34] =pelea;
		mundo[8][35] =pared;
		mundo[8][36] =pared;
		mundo[8][37] =pared;
		mundo[8][38] =pared;
		mundo[8][39] =pared;
		mundo[8][40] =pared;
		mundo[8][41] =pared;
		mundo[8][42] =pared;
		mundo[8][43] =pared;
		mundo[8][44] =pelea;
		mundo[8][46] =pelea;
		mundo[8][49] =pared;
		mundo[9][0] =pared;
		mundo[9][5] =casa;
		mundo[9][6] =casa;
		mundo[9][7] =casa;
		mundo[9][10] =casa;
		mundo[9][11] =casa;
		mundo[9][12] =casa;
		mundo[9][15] =casa;
		mundo[9][16] =casa;
		mundo[9][17] =casa;
		mundo[9][22] =pared;
		mundo[9][26] =pared;
		mundo[9][31] =pelea;
		mundo[9][33] =pelea;
		mundo[9][35] =pared;
		mundo[9][36] =pared;
		mundo[9][37] =pared;
		mundo[9][38] =pared;
		mundo[9][39] =pared;
		mundo[9][40] =pared;
		mundo[9][41] =pared;
		mundo[9][42] =pared;
		mundo[9][43] =pared;
		mundo[9][45] =pelea;
		mundo[9][47] =pelea;
		mundo[9][49] =pared;
		mundo[10][0] =pared;
		mundo[10][8] =tallgrass;
		mundo[10][22] =pared;
		mundo[10][26] =pared;
		mundo[10][32] =pelea;
		mundo[10][34] =pelea;
		mundo[10][35] =pared;
		mundo[10][36] =pared;
		mundo[10][37] =pared;
		mundo[10][38] =pared;
		mundo[10][39] =pared;
		mundo[10][40] =pared;
		mundo[10][41] =pared;
		mundo[10][42] =pared;
		mundo[10][43] =pared;
		mundo[10][44] =pelea;
		mundo[10][46] =pelea;
		mundo[10][49] =pared;
		mundo[11][0] =pared;
		mundo[11][4] =tallgrass;
		mundo[11][19] =pelea;
		mundo[11][21] =tallgrass;
		mundo[11][22] =pared;
		mundo[11][23] =pared;
		mundo[11][24] =pared;
		mundo[11][25] =pared;
		mundo[11][26] =pared;
		mundo[11][31] =pelea;
		mundo[11][33] =pelea;
		mundo[11][35] =pared;
		mundo[11][36] =pared;
		mundo[11][37] =pared;
		mundo[11][38] =pared;
		mundo[11][39] =pared;
		mundo[11][40] =pared;
		mundo[11][41] =pared;
		mundo[11][42] =pared;
		mundo[11][43] =pared;
		mundo[11][45] =pelea;
		mundo[11][47] =pelea;
		mundo[11][49] =pared;
		mundo[12][0] =pared;
		mundo[12][10] =pared;
		mundo[12][11] =pared;
		mundo[12][12] =pared;
		mundo[12][14] =tallgrass;
		mundo[12][22] =pared;
		mundo[12][26] =pared;
		mundo[12][32] =pelea;
		mundo[12][34] =pelea;
		mundo[12][35] =puerta;
		mundo[12][36] =pared;
		mundo[12][37] =pared;
		mundo[12][38] =pared;
		mundo[12][39] =pared;
		mundo[12][40] =pared;
		mundo[12][41] =pared;
		mundo[12][42] =pared;
		mundo[12][43] =pared;
		mundo[12][44] =pelea;
		mundo[12][46] =pelea;
		mundo[12][49] =pared;
		mundo[13][0] =pared;
		mundo[13][5] =pelea;
		mundo[13][10] =pared;
		mundo[13][11] =puerta;
		mundo[13][12] =pared;
		mundo[13][22] =pared;
		mundo[13][26] =pared;
		mundo[13][31] =pelea;
		mundo[13][33] =pelea;
		mundo[13][35] =pared;
		mundo[13][36] =pared;
		mundo[13][37] =pared;
		mundo[13][38] =pared;
		mundo[13][39] =pared;
		mundo[13][40] =pared;
		mundo[13][41] =pared;
		mundo[13][42] =pared;
		mundo[13][43] =pared;
		mundo[13][45] =pelea;
		mundo[13][47] =pelea;
		mundo[13][49] =pared;
		mundo[14][0] =pared;
		mundo[14][8] =tallgrass;
		mundo[14][22] =pared;
		mundo[14][26] =pared;
		mundo[14][32] =pelea;
		mundo[14][34] =pelea;
		mundo[14][35] =pared;
		mundo[14][36] =pared;
		mundo[14][37] =pared;
		mundo[14][38] =pared;
		mundo[14][39] =pared;
		mundo[14][40] =pared;
		mundo[14][41] =pared;
		mundo[14][42] =pared;
		mundo[14][43] =pared;
		mundo[14][44] =pelea;
		mundo[14][46] =pelea;
		mundo[14][49] =pared;
		mundo[15][0] =pared;
		mundo[15][2] =tallgrass;
		mundo[15][17] =tallgrass;
		mundo[15][21] =tallgrass;
		mundo[15][22] =pared;
		mundo[15][23] =pared;
		mundo[15][24] =pared;
		mundo[15][25] =pared;
		mundo[15][26] =pared;
		mundo[15][31] =pelea;
		mundo[15][33] =pelea;
		mundo[15][35] =pared;
		mundo[15][36] =pared;
		mundo[15][37] =pared;
		mundo[15][38] =pared;
		mundo[15][39] =pared;
		mundo[15][40] =pared;
		mundo[15][41] =pared;
		mundo[15][42] =pared;
		mundo[15][43] =pared;
		mundo[15][45] =pelea;
		mundo[15][47] =pelea;
		mundo[15][49] =pared;
		mundo[16][0] =pared;
		mundo[16][5] =pelea;
		mundo[16][13] =pelea;
		mundo[16][22] =pared;
		mundo[16][26] =pared;
		mundo[16][32] =pelea;
		mundo[16][34] =pelea;
		mundo[16][35] =pared;
		mundo[16][36] =pared;
		mundo[16][37] =pared;
		mundo[16][38] =pared;
		mundo[16][39] =pared;
		mundo[16][40] =pared;
		mundo[16][41] =pared;
		mundo[16][42] =pared;
		mundo[16][43] =pared;
		mundo[16][44] =pelea;
		mundo[16][46] =pelea;
		mundo[16][49] =pared;
		mundo[17][0] =pared;
		mundo[17][9] =tallgrass;
		mundo[17][22] =pared;
		mundo[17][26] =pared;
		mundo[17][31] =pelea;
		mundo[17][33] =pelea;
		mundo[17][35] =pelea;
		mundo[17][37] =pelea;
		mundo[17][39] =pelea;
		mundo[17][41] =pelea;
		mundo[17][43] =pelea;
		mundo[17][45] =pelea;
		mundo[17][47] =pelea;
		mundo[17][49] =pared;
		mundo[18][0] =pared;
		mundo[18][18] =pelea;
		mundo[18][22] =pared;
		mundo[18][26] =pared;
		mundo[18][31] =pared;
		mundo[18][32] =pared;
		mundo[18][34] =pelea;
		mundo[18][36] =pelea;
		mundo[18][38] =pelea;
		mundo[18][40] =pelea;
		mundo[18][42] =pelea;
		mundo[18][44] =pelea;
		mundo[18][46] =pared;
		mundo[18][47] =pared;
		mundo[18][49] =pared;
		mundo[19][0] =pared;
		mundo[19][7] =pelea;
		mundo[19][20] =tallgrass;
		mundo[19][22] =pared;
		mundo[19][23] =pared;
		mundo[19][24] =pared;
		mundo[19][25] =pared;
		mundo[19][26] =pared;
		mundo[19][31] =pared;
		mundo[19][32] =pared;
		mundo[19][33] =pelea;
		mundo[19][35] =pelea;
		mundo[19][37] =pelea;
		mundo[19][39] =pelea;
		mundo[19][41] =pelea;
		mundo[19][43] =pelea;
		mundo[19][45] =pelea;
		mundo[19][46] =pared;
		mundo[19][47] =pared;
		mundo[19][49] =pared;
		mundo[20][0] =pared;
		mundo[20][4] =tallgrass;
		mundo[20][13] =tallgrass;
		mundo[20][22] =pared;
		mundo[20][26] =pared;
		mundo[20][49] =pared;
		mundo[21][0] =pared;
		mundo[21][11] =pelea;
		mundo[21][22] =pared;
		mundo[21][26] =pared;
		mundo[21][49] =pared;
		mundo[22][0] =pared;
		mundo[22][17] =tallgrass;
		mundo[22][21] =pared;
		mundo[22][22] =pared;
		mundo[22][26] =pared;
		mundo[22][27] =pared;
		mundo[22][49] =pared;
		mundo[23][0] =pared;
		mundo[23][1] =pared;
		mundo[23][2] =pared;
		mundo[23][5] =pared;
		mundo[23][6] =pared;
		mundo[23][7] =pared;
		mundo[23][8] =pared;
		mundo[23][9] =pared;
		mundo[23][10] =pared;
		mundo[23][11] =pared;
		mundo[23][12] =pared;
		mundo[23][13] =pared;
		mundo[23][14] =pared;
		mundo[23][15] =pared;
		mundo[23][16] =pared;
		mundo[23][17] =pared;
		mundo[23][18] =pared;
		mundo[23][19] =pared;
		mundo[23][20] =pared;
		mundo[23][21] =pared;
		mundo[23][27] =pared;
		mundo[23][28] =pared;
		mundo[23][29] =pared;
		mundo[23][30] =pared;
		mundo[23][31] =pared;
		mundo[23][32] =pared;
		mundo[23][33] =pared;
		mundo[23][34] =pared;
		mundo[23][35] =pared;
		mundo[23][36] =pared;
		mundo[23][37] =pared;
		mundo[23][38] =pared;
		mundo[23][39] =pared;
		mundo[23][40] =pared;
		mundo[23][41] =pared;
		mundo[23][42] =pared;
		mundo[23][43] =pared;
		mundo[23][44] =pared;
		mundo[23][47] =pared;
		mundo[23][48] =pared;
		mundo[23][49] =pared;
		mundo[24][0] =pared;
		mundo[24][7] =pared;
		mundo[24][11] =pared;
		mundo[24][15] =pared;
		mundo[24][19] =pared;
		mundo[24][23] =pared;
		mundo[24][24] =pared;
		mundo[24][25] =pared;
		mundo[24][30] =pared;
		mundo[24][34] =pared;
		mundo[24][38] =pared;
		mundo[24][42] =pared;
		mundo[24][49] =pared;
		mundo[25][0] =pared;
		mundo[25][1] =shop;
		mundo[25][4] =NPC;
		mundo[25][24] =puerta;
		mundo[25][25] =pared;
		mundo[25][30] =pared;
		mundo[25][34] =pared;
		mundo[25][48] =shop;
		mundo[25][49] =pared;
		mundo[26][0] =pared;
		mundo[26][7] =pared;
		mundo[26][11] =pared;
		mundo[26][15] =pared;
		mundo[26][19] =pared;
		mundo[26][23] =pared;
		mundo[26][24] =pared;
		mundo[26][25] =pared;
		mundo[26][30] =pared;
		mundo[26][34] =pared;
		mundo[26][38] =pared;
		mundo[26][42] =pared;
		mundo[26][46] =NPC;
		mundo[26][49] =pared;
		mundo[27][0] =pared;
		mundo[27][1] =pared;
		mundo[27][2] =pared;
		mundo[27][5] =pared;
		mundo[27][6] =pared;
		mundo[27][7] =pared;
		mundo[27][8] =pared;
		mundo[27][9] =pared;
		mundo[27][10] =pared;
		mundo[27][11] =pared;
		mundo[27][12] =pared;
		mundo[27][13] =pared;
		mundo[27][14] =pared;
		mundo[27][15] =pared;
		mundo[27][16] =pared;
		mundo[27][17] =pared;
		mundo[27][18] =pared;
		mundo[27][19] =pared;
		mundo[27][20] =pared;
		mundo[27][21] =pared;
		mundo[27][27] =pared;
		mundo[27][28] =pared;
		mundo[27][29] =pared;
		mundo[27][30] =pared;
		mundo[27][31] =pared;
		mundo[27][32] =pared;
		mundo[27][33] =pared;
		mundo[27][34] =pared;
		mundo[27][35] =pared;
		mundo[27][36] =pared;
		mundo[27][37] =pared;
		mundo[27][38] =pared;
		mundo[27][39] =pared;
		mundo[27][40] =pared;
		mundo[27][41] =pared;
		mundo[27][42] =pared;
		mundo[27][43] =pared;
		mundo[27][44] =pared;
		mundo[27][47] =pared;
		mundo[27][48] =pared;
		mundo[27][49] =pared;
		mundo[28][0] =pared;
		mundo[28][1] =rio;
		mundo[28][2] =rio;
		mundo[28][5] =rio;
		mundo[28][6] =rio;
		mundo[28][7] =rio;
		mundo[28][8] =rio;
		mundo[28][9] =rio;
		mundo[28][10] =rio;
		mundo[28][11] =rio;
		mundo[28][12] =rio;
		mundo[28][13] =rio;
		mundo[28][14] =rio;
		mundo[28][15] =rio;
		mundo[28][16] =rio;
		mundo[28][17] =rio;
		mundo[28][18] =rio;
		mundo[28][19] =rio;
		mundo[28][20] =rio;
		mundo[28][21] =pared;
		mundo[28][22] =pared;
		mundo[28][26] =pared;
		mundo[28][27] =pared;
		mundo[28][30] =rio;
		mundo[28][49] =pared;
		mundo[29][0] =pared;
		mundo[29][1] =rio;
		mundo[29][2] =rio;
		mundo[29][5] =rio;
		mundo[29][6] =rio;
		mundo[29][7] =rio;
		mundo[29][8] =rio;
		mundo[29][9] =rio;
		mundo[29][10] =rio;
		mundo[29][17] =rio;
		mundo[29][18] =rio;
		mundo[29][19] =rio;
		mundo[29][20] =rio;
		mundo[29][21] =rio;
		mundo[29][22] =pared;
		mundo[29][26] =pared;
		mundo[29][29] =rio;
		mundo[29][30] =rio;
		mundo[29][37] =pelea;
		mundo[29][49] =pared;
		mundo[30][0] =pared;
		mundo[30][1] =rio;
		mundo[30][2] =rio;
		mundo[30][12] =pelea;
		mundo[30][19] =rio;
		mundo[30][20] =rio;
		mundo[30][21] =rio;
		mundo[30][22] =pared;
		mundo[30][23] =pared;
		mundo[30][24] =pared;
		mundo[30][25] =pared;
		mundo[30][26] =pared;
		mundo[30][29] =rio;
		mundo[30][41] =pelea;
		mundo[30][46] =pelea;
		mundo[30][49] =pared;
		mundo[31][0] =pared;
		mundo[31][1] =rio;
		mundo[31][9] =rio;
		mundo[31][10] =rio;
		mundo[31][11] =rio;
		mundo[31][13] =rio;
		mundo[31][14] =rio;
		mundo[31][15] =rio;
		mundo[31][20] =rio;
		mundo[31][21] =rio;
		mundo[31][22] =pared;
		mundo[31][26] =pared;
		mundo[31][29] =rio;
		mundo[31][49] =pared;
		mundo[32][0] =pared;
		mundo[32][2] =pelea;
		mundo[32][5] =rio;
		mundo[32][8] =rio;
		mundo[32][9] =rio;
		mundo[32][10] =rio;
		mundo[32][13] =rio;
		mundo[32][14] =rio;
		mundo[32][15] =rio;
		mundo[32][16] =rio;
		mundo[32][19] =pelea;
		mundo[32][21] =rio;
		mundo[32][22] =pared;
		mundo[32][26] =pared;
		mundo[32][28] =pelea;
		mundo[32][29] =puente;
		mundo[32][49] =pared;
		mundo[33][0] =pared;
		mundo[33][3] =rio;
		mundo[33][4] =rio;
		mundo[33][5] =rio;
		mundo[33][6] =rio;
		mundo[33][9] =rio;
		mundo[33][12] =rio;
		mundo[33][13] =rio;
		mundo[33][14] =rio;
		mundo[33][15] =rio;
		mundo[33][16] =rio;
		mundo[33][17] =rio;
		mundo[33][18] =rio;
		mundo[33][21] =rio;
		mundo[33][22] =pared;
		mundo[33][26] =pared;
		mundo[33][29] =rio;
		mundo[33][30] =rio;
		mundo[33][34] =pelea;
		mundo[33][49] =pared;
		mundo[34][0] =pared;
		mundo[34][4] =rio;
		mundo[34][5] =rio;
		mundo[34][6] =rio;
		mundo[34][7] =rio;
		mundo[34][9] =pelea;
		mundo[34][11] =rio;
		mundo[34][12] =rio;
		mundo[34][13] =rio;
		mundo[34][14] =rio;
		mundo[34][15] =rio;
		mundo[34][16] =rio;
		mundo[34][17] =rio;
		mundo[34][18] =rio;
		mundo[34][21] =rio;
		mundo[34][22] =pared;
		mundo[34][23] =pared;
		mundo[34][25] =pared;
		mundo[34][26] =pared;
		mundo[34][30] =rio;
		mundo[34][39] =pelea;
		mundo[34][45] =pelea;
		mundo[34][49] =pared;
		mundo[35][0] =pared;
		mundo[35][5] =rio;
		mundo[35][6] =rio;
		mundo[35][7] =rio;
		mundo[35][8] =rio;
		mundo[35][9] =rio;
		mundo[35][10] =rio;
		mundo[35][11] =rio;
		mundo[35][12] =rio;
		mundo[35][13] =rio;
		mundo[35][14] =rio;
		mundo[35][15] =rio;
		mundo[35][16] =rio;
		mundo[35][17] =rio;
		mundo[35][18] =rio;
		mundo[35][21] =rio;
		mundo[35][22] =pared;
		mundo[35][26] =pared;
		mundo[35][30] =rio;
		mundo[35][49] =pared;
		mundo[36][0] =pared;
		mundo[36][6] =rio;
		mundo[36][7] =rio;
		mundo[36][8] =rio;
		mundo[36][9] =rio;
		mundo[36][10] =rio;
		mundo[36][11] =pared;
		mundo[36][12] =pared;
		mundo[36][13] =rio;
		mundo[36][14] =rio;
		mundo[36][15] =rio;
		mundo[36][16] =rio;
		mundo[36][17] =rio;
		mundo[36][21] =rio;
		mundo[36][22] =pared;
		mundo[36][26] =pared;
		mundo[36][30] =rio;
		mundo[36][31] =rio;
		mundo[36][35] =pared;
		mundo[36][36] =puerta;
		mundo[36][37] =pared;
		mundo[36][48] =rio;
		mundo[36][49] =pared;
		mundo[37][0] =pared;
		mundo[37][3] =rio;
		mundo[37][6] =rio;
		mundo[37][7] =rio;
		mundo[37][8] =rio;
		mundo[37][9] =rio;
		mundo[37][10] =rio;
		mundo[37][11] =pared;
		mundo[37][12] =puerta;
		mundo[37][16] =rio;
		mundo[37][17] =rio;
		mundo[37][21] =rio;
		mundo[37][22] =pared;
		mundo[37][26] =pared;
		mundo[37][31] =rio;
		mundo[37][35] =pared;
		mundo[37][36] =pared;
		mundo[37][37] =pared;
		mundo[37][47] =rio;
		mundo[37][48] =rio;
		mundo[37][49] =pared;
		mundo[38][0] =pared;
		mundo[38][3] =rio;
		mundo[38][4] =rio;
		mundo[38][5] =pelea;
		mundo[38][6] =rio;
		mundo[38][7] =rio;
		mundo[38][8] =rio;
		mundo[38][9] =rio;
		mundo[38][10] =rio;
		mundo[38][11] =pared;
		mundo[38][12] =pared;
		mundo[38][13] =rio;
		mundo[38][14] =rio;
		mundo[38][16] =pelea;
		mundo[38][20] =rio;
		mundo[38][21] =rio;
		mundo[38][22] =pared;
		mundo[38][23] =pared;
		mundo[38][25] =pared;
		mundo[38][26] =pared;
		mundo[38][30] =pelea;
		mundo[38][31] =puente;
		mundo[38][46] =rio;
		mundo[38][47] =rio;
		mundo[38][48] =rio;
		mundo[38][49] =pared;
		mundo[39][0] =pared;
		mundo[39][3] =rio;
		mundo[39][6] =rio;
		mundo[39][7] =rio;
		mundo[39][8] =rio;
		mundo[39][9] =rio;
		mundo[39][10] =rio;
		mundo[39][11] =rio;
		mundo[39][12] =rio;
		mundo[39][13] =rio;
		mundo[39][14] =rio;
		mundo[39][15] =rio;
		mundo[39][16] =rio;
		mundo[39][17] =rio;
		mundo[39][18] =rio;
		mundo[39][19] =rio;
		mundo[39][20] =rio;
		mundo[39][21] =rio;
		mundo[39][22] =pared;
		mundo[39][26] =pared;
		mundo[39][31] =rio;
		mundo[39][32] =rio;
		mundo[39][39] =pelea;
		mundo[39][45] =rio;
		mundo[39][46] =rio;
		mundo[39][47] =rio;
		mundo[39][48] =rio;
		mundo[39][49] =pared;
		mundo[40][0] =pared;
		mundo[40][6] =rio;
		mundo[40][7] =rio;
		mundo[40][8] =rio;
		mundo[40][9] =rio;
		mundo[40][10] =rio;
		mundo[40][11] =rio;
		mundo[40][12] =rio;
		mundo[40][13] =rio;
		mundo[40][14] =rio;
		mundo[40][15] =rio;
		mundo[40][16] =rio;
		mundo[40][17] =rio;
		mundo[40][18] =rio;
		mundo[40][19] =rio;
		mundo[40][20] =rio;
		mundo[40][21] =rio;
		mundo[40][22] =pared;
		mundo[40][26] =pared;
		mundo[40][32] =rio;
		mundo[40][33] =rio;
		mundo[40][44] =rio;
		mundo[40][45] =rio;
		mundo[40][46] =rio;
		mundo[40][47] =rio;
		mundo[40][48] =rio;
		mundo[40][49] =pared;
		mundo[41][0] =pared;
		mundo[41][5] =rio;
		mundo[41][6] =rio;
		mundo[41][7] =rio;
		mundo[41][8] =rio;
		mundo[41][9] =rio;
		mundo[41][10] =rio;
		mundo[41][11] =rio;
		mundo[41][12] =rio;
		mundo[41][13] =rio;
		mundo[41][14] =rio;
		mundo[41][15] =rio;
		mundo[41][16] =rio;
		mundo[41][17] =rio;
		mundo[41][18] =rio;
		mundo[41][19] =rio;
		mundo[41][20] =rio;
		mundo[41][21] =rio;
		mundo[41][22] =pared;
		mundo[41][26] =pared;
		mundo[41][33] =rio;
		mundo[41][34] =rio;
		mundo[41][43] =rio;
		mundo[41][44] =rio;
		mundo[41][45] =rio;
		mundo[41][46] =rio;
		mundo[41][47] =rio;
		mundo[41][48] =rio;
		mundo[41][49] =pared;
		mundo[42][0] =pared;
		mundo[42][4] =rio;
		mundo[42][5] =rio;
		mundo[42][6] =rio;
		mundo[42][11] =pelea;
		mundo[42][15] =rio;
		mundo[42][16] =rio;
		mundo[42][17] =rio;
		mundo[42][18] =rio;
		mundo[42][19] =rio;
		mundo[42][20] =rio;
		mundo[42][21] =rio;
		mundo[42][22] =pared;
		mundo[42][23] =pared;
		mundo[42][25] =pared;
		mundo[42][26] =pared;
		mundo[42][29] =pelea;
		mundo[42][34] =rio;
		mundo[42][35] =puente;
		mundo[42][36] =rio;
		mundo[42][43] =rio;
		mundo[42][44] =rio;
		mundo[42][45] =rio;
		mundo[42][46] =rio;
		mundo[42][47] =rio;
		mundo[42][48] =rio;
		mundo[42][49] =pared;
		mundo[43][0] =pared;
		mundo[43][4] =rio;
		mundo[43][5] =rio;
		mundo[43][10] =rio;
		mundo[43][11] =rio;
		mundo[43][12] =rio;
		mundo[43][16] =rio;
		mundo[43][17] =rio;
		mundo[43][18] =rio;
		mundo[43][19] =rio;
		mundo[43][20] =rio;
		mundo[43][21] =rio;
		mundo[43][22] =pared;
		mundo[43][26] =pared;
		mundo[43][35] =pelea;
		mundo[43][36] =rio;
		mundo[43][37] =rio;
		mundo[43][42] =rio;
		mundo[43][43] =rio;
		mundo[43][44] =rio;
		mundo[43][45] =rio;
		mundo[43][46] =rio;
		mundo[43][47] =rio;
		mundo[43][48] =rio;
		mundo[43][49] =pared;
		mundo[44][0] =pared;
		mundo[44][1] =rio;
		mundo[44][3] =pelea;
		mundo[44][10] =rio;
		mundo[44][11] =rio;
		mundo[44][12] =rio;
		mundo[44][13] =rio;
		mundo[44][17] =rio;
		mundo[44][18] =rio;
		mundo[44][19] =rio;
		mundo[44][20] =rio;
		mundo[44][21] =rio;
		mundo[44][22] =pared;
		mundo[44][26] =pared;
		mundo[44][37] =rio;
		mundo[44][38] =rio;
		mundo[44][42] =rio;
		mundo[44][43] =rio;
		mundo[44][44] =rio;
		mundo[44][45] =rio;
		mundo[44][46] =rio;
		mundo[44][47] =rio;
		mundo[44][48] =rio;
		mundo[44][49] =pared;
		mundo[45][0] =pared;
		mundo[45][1] =rio;
		mundo[45][2] =rio;
		mundo[45][10] =rio;
		mundo[45][11] =rio;
		mundo[45][12] =rio;
		mundo[45][13] =rio;
		mundo[45][14] =rio;
		mundo[45][20] =NPC;
		mundo[45][38] =rio;
		mundo[45][39] =rio;
		mundo[45][40] =rio;
		mundo[45][41] =rio;
		mundo[45][42] =rio;
		mundo[45][43] =rio;
		mundo[45][44] =rio;
		mundo[45][45] =rio;
		mundo[45][46] =rio;
		mundo[45][47] =rio;
		mundo[45][48] =rio;
		mundo[45][49] =pared;
		mundo[46][0] =pared;
		mundo[46][1] =rio;
		mundo[46][2] =rio;
		mundo[46][3] =rio;
		mundo[46][4] =rio;
		mundo[46][5] =rio;
		mundo[46][13] =pelea;
		mundo[46][40] =rio;
		mundo[46][41] =rio;
		mundo[46][42] =rio;
		mundo[46][43] =rio;
		mundo[46][44] =rio;
		mundo[46][45] =rio;
		mundo[46][46] =rio;
		mundo[46][47] =rio;
		mundo[46][48] =rio;
		mundo[46][49] =pared;
		mundo[47][0] =pared;
		mundo[47][1] =rio;
		mundo[47][2] =rio;
		mundo[47][3] =rio;
		mundo[47][4] =rio;
		mundo[47][5] =rio;
		mundo[47][6] =rio;
		mundo[47][7] =rio;
		mundo[47][8] =rio;
		mundo[47][9] =rio;
		mundo[47][10] =rio;
		mundo[47][11] =rio;
		mundo[47][12] =rio;
		mundo[47][13] =rio;
		mundo[47][14] =rio;
		mundo[47][15] =rio;
		mundo[47][16] =rio;
		mundo[47][17] =rio;
		mundo[47][18] =rio;
		mundo[47][19] =rio;
		mundo[47][20] =rio;
		mundo[47][21] =rio;
		mundo[47][22] =pared;
		mundo[47][26] =pared;
		mundo[47][33] =pelea;
		mundo[47][39] =rio;
		mundo[47][40] =rio;
		mundo[47][41] =rio;
		mundo[47][42] =rio;
		mundo[47][43] =rio;
		mundo[47][44] =rio;
		mundo[47][45] =rio;
		mundo[47][46] =rio;
		mundo[47][47] =rio;
		mundo[47][48] =rio;
		mundo[47][49] =pared;
		mundo[48][0] =pared;
		mundo[48][1] =rio;
		mundo[48][2] =rio;
		mundo[48][3] =rio;
		mundo[48][4] =rio;
		mundo[48][5] =rio;
		mundo[48][6] =rio;
		mundo[48][7] =rio;
		mundo[48][8] =rio;
		mundo[48][9] =rio;
		mundo[48][10] =rio;
		mundo[48][11] =rio;
		mundo[48][12] =rio;
		mundo[48][13] =rio;
		mundo[48][14] =rio;
		mundo[48][15] =rio;
		mundo[48][16] =rio;
		mundo[48][17] =rio;
		mundo[48][18] =rio;
		mundo[48][19] =rio;
		mundo[48][20] =rio;
		mundo[48][21] =rio;
		mundo[48][22] =pared;
		mundo[48][24] =shop;
		mundo[48][26] =pared;
		mundo[48][38] =rio;
		mundo[48][39] =rio;
		mundo[48][40] =rio;
		mundo[48][41] =rio;
		mundo[48][42] =rio;
		mundo[48][43] =rio;
		mundo[48][44] =rio;
		mundo[48][45] =rio;
		mundo[48][46] =rio;
		mundo[48][47] =rio;
		mundo[48][48] =rio;
		mundo[48][49] =pared;
		mundo[49][0] =pared;
		mundo[49][1] =pared;
		mundo[49][2] =pared;
		mundo[49][3] =pared;
		mundo[49][4] =pared;
		mundo[49][5] =pared;
		mundo[49][6] =pared;
		mundo[49][7] =pared;
		mundo[49][8] =pared;
		mundo[49][9] =pared;
		mundo[49][10] =pared;
		mundo[49][11] =pared;
		mundo[49][12] =pared;
		mundo[49][13] =pared;
		mundo[49][14] =pared;
		mundo[49][15] =pared;
		mundo[49][16] =pared;
		mundo[49][17] =pared;
		mundo[49][18] =pared;
		mundo[49][19] =pared;
		mundo[49][20] =pared;
		mundo[49][21] =pared;
		mundo[49][22] =pared;
		mundo[49][23] =pared;
		mundo[49][24] =pared;
		mundo[49][25] =pared;
		mundo[49][26] =pared;
		mundo[49][27] =pared;
		mundo[49][28] =pared;
		mundo[49][29] =pared;
		mundo[49][30] =pared;
		mundo[49][31] =pared;
		mundo[49][32] =pared;
		mundo[49][33] =pared;
		mundo[49][34] =pared;
		mundo[49][35] =pared;
		mundo[49][36] =pared;
		mundo[49][37] =pared;
		mundo[49][38] =pared;
		mundo[49][39] =pared;
		mundo[49][40] =pared;
		mundo[49][41] =pared;
		mundo[49][42] =pared;
		mundo[49][43] =pared;
		mundo[49][44] =pared;
		mundo[49][45] =pared;
		mundo[49][46] =pared;
		mundo[49][47] =pared;
		mundo[49][48] =pared;
		mundo[49][49] =pared;
		
		mundo[44][8] = chest;
		mundo[28][29] = chest;
		mundo[22][20] = chest;
		mundo[1][48] = chest;
		
		
		for (int i = 0; i < 50; i++) {
			for (int u = 0; u < 50; u++) {

				guardado[i][u] = mundo[i][u];
			}
		}


		dibujado();

	}
	/**Este metodo sirve para cambiar el mapa del combate en base a la zona en la que estes en el mapa principal*/
	public void cambioZona() {
		if(zona.equals("grass")) {Room.zona=1;}
		if(zona.equals("sand")) {Room.zona=2;}
		if(zona.equals("ice")) {Room.zona=3;}
		if(zona.equals("fire")||zona.equals("dungeon")) {Room.zona=4;}
		
	}
	/** Dibuja el mapa del mundo*/
	public void dibujado() {
		
		if (mundo[x][y].getCode() == ("chest")) {
			
		cartera.setDinero(500);// ganamos dinero por encontrar el cofre
		mundo[x][y] = suelo;

		}
		
		if (mundo[x][y].getCode() == ("fight")) {
				
			if(((x ==2 && y == 25)|| (x ==15 && y ==29) || (x ==23 && y ==8) || (x == 27 && y == 43) || (x == 43 && y ==22))&& in == true){
				cambioZona();
				if((x ==15 && y ==29)) {// evento especial donde se podra jugar a dos jugadores
					Room.jugadores=true;
					Room.enemigos=false;
					contentPane.setFocusable(false);
					Ventana.cargarCombate();
				}else {
					//Aqui va las peleas de boses
					Room.jugadores=false;
					Room.enemigos=true;
					contentPane.setFocusable(false);
					Ventana.cargarCombate();
			}
				mundo[x][y] = suelo;
			
			}else{
			cambioZona();// seleccion del mapa
			Room.enemigos=false;
			Room.jugadores=false;
			contentPane.setFocusable(false);
			fight = true;
			sonido.stop();
			musica();
			Ventana.cargarCombate();
			mundo[x][y] = suelo;
			fight = false;
			}

		}
		if (mundo[x][y].getCode() == ("NPC")) {
			
			if(y <= 26 && x <= 23) {
				
				JOptionPane.showMessageDialog(null, "Bienvenido a nuestra aldea heroe, cuidado con el bosque al sur de la aldea.");

				
				}else if(y > 26 && x <= 23) {
					
					JOptionPane.showMessageDialog(null, "Este es el desierto eterno, donde se encuentra la piramide del faraon mavex.");

					
				}else if(y > 27) {
					
					JOptionPane.showMessageDialog(null, "Estos son los paramos helados.");

						
				}else if(y <= 26 && x > 27) {
					
					JOptionPane.showMessageDialog(null, "Estas son las pozas de fuego, cuidado con no quemarte.");
							
				}else {
					
					JOptionPane.showMessageDialog(null, "Veo que has llegado lejos, a continuacion esta la mazmorra final.");
	
				}
			}
		
		if (mundo[x][y].getCode() == ("shops")) {

			InterfazTienda.iniciar();

		}

		if (mundo[x][y].getCode() == ("doors")) {

			cargar();

		}
		repaint();

		// Visual
		this.getContentPane().removeAll();

		int pos_x = -70;

		int pos_y = -70;

		for (int i = 0; i < 10; i++) {

			pos_y = pos_y + 70;
			pos_x = -70;

			for (int u = 0; u < 10; u++) {

				JLabel mapa = new JLabel();
				JLabel pelea = new JLabel();
				JLabel path = new JLabel();
				JLabel perso = new JLabel();

				if (mundo[i + x_dib][u + y_dib].getCode().equals("grass")) {
					
					if (in == true){
						
						if(u + y_dib < 24 && i + x_dib <= 24) {

							ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/hierba.png"));

							mapa.setIcon(imagenFondo);
							
							}else if(u + y_dib > 23 && i + x_dib > 25) {
							
							ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/ice.png"));

							mapa.setIcon(imagenFondo);
							
							}else if(u + y_dib == 25 && i + x_dib == 25) {
								
								ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/ice.png"));

								mapa.setIcon(imagenFondo);
								
							}else if(u + y_dib == 26 && i + x_dib == 25) {
							
								ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/ice.png"));

								mapa.setIcon(imagenFondo);
								
							}else if(u + y_dib > 23 && i + x_dib <= 36) {
								
							ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/templo.png"));

							mapa.setIcon(imagenFondo);
							
						
							
							}else if(u + y_dib > 36 && i + x_dib > 11) {
								
							ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/block.png"));

							mapa.setIcon(imagenFondo);
								
							
								
							}else if(u + y_dib <= 26 && i + x_dib > 22) {
								
							ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/rock.png"));

							mapa.setIcon(imagenFondo);
									
							}else {
						
							ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/block.png"));
							
							mapa.setIcon(imagenFondo);
							
							}
					
					}else if(u + y_dib < 22 && i + x_dib <= 22) {

					ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/hierba.png"));

					mapa.setIcon(imagenFondo);
					
					}else if(u + y_dib > 26 && i + x_dib <= 22) {
						
					ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/arena.png"));

					mapa.setIcon(imagenFondo);
						
					}else if(u + y_dib > 26 && i + x_dib > 27) {
						
					ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/ice.png"));

					mapa.setIcon(imagenFondo);
						
					}else if(u + y_dib < 22 && i + x_dib > 27) {
						
					ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/rock.png"));

					mapa.setIcon(imagenFondo);
							
					}else {
						
					ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/block.png"));

					mapa.setIcon(imagenFondo);
						
					}

				} else if (mundo[i + x_dib][u + y_dib].getCode().equals("walls")) {
					
					if (in == true) {
						
						if(u + y_dib > 9 && i + x_dib > 11 && u + y_dib < 36) {
							
							ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/pared.png"));

							mapa.setIcon(imagenFondo);
							
							}else if(u + y_dib < 23 && i + x_dib <= 24 && u + y_dib != 0 && i + x_dib != 0) {
							
							ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/hierba.png"));

							mapa.setIcon(imagenFondo);
							
							ImageIcon imagendelante = new ImageIcon(loader.getResource("mundo/arbusto.png"));

							pelea.setIcon(imagendelante);
							
							}else if(u + y_dib > 23 && u + y_dib != 49 && i + x_dib != 0 && i + x_dib < 25) {
								
							ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/templo.png"));

							mapa.setIcon(imagenFondo);
								
							}else {
					
							ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/pared.png"));

							mapa.setIcon(imagenFondo);
							}
						
					}else if(u + y_dib > 26 && i + x_dib <= 21 && u + y_dib != 49 && i + x_dib != 0) {
					
					ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/templo.png"));

					mapa.setIcon(imagenFondo);
					
					} else {

					ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/pared.png"));

					mapa.setIcon(imagenFondo);
					
					}

				} else if (mundo[i + x_dib][u + y_dib].getCode().equals("river")) {
					
					
					if(u + y_dib <= 26 && i + x_dib > 25) {

					ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/lava.png"));

					mapa.setIcon(imagenFondo);
						
					}else {
							
					ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/Agua.png"));

					mapa.setIcon(imagenFondo);
							
					}

				} else if (mundo[i + x_dib][u + y_dib].getCode().equals("bridg")) {

					ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/bridge.png"));

					mapa.setIcon(imagenFondo);

				} else if (mundo[i + x_dib][u + y_dib].getCode().equals("fight")) {
					
						if(u + y_dib <= 23 && i + x_dib <= 24) {

						ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/hierba.png"));

						mapa.setIcon(imagenFondo);

						ImageIcon imagendelante = new ImageIcon(loader.getResource("mundo/calabera.png"));

						pelea.setIcon(imagendelante);
						
						}else if(u + y_dib > 23 && i + x_dib <= 23) {
							
						ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/arena.png"));

						mapa.setIcon(imagenFondo);
						
						ImageIcon imagendelante = new ImageIcon(loader.getResource("mundo/calabera.png"));

						pelea.setIcon(imagendelante);
							
						}else if(u + y_dib > 23 && i + x_dib > 25) {
							
						ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/ice.png"));

						mapa.setIcon(imagenFondo);

						ImageIcon imagendelante = new ImageIcon(loader.getResource("mundo/calabera.png"));
						
						pelea.setIcon(imagendelante);
								
						}else if(u + y_dib <= 26 && i + x_dib > 27) {
							
						ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/rock.png"));

						mapa.setIcon(imagenFondo);
						
						ImageIcon imagendelante = new ImageIcon(loader.getResource("mundo/calabera.png"));
						
						pelea.setIcon(imagendelante);
									
						}

				} else if (mundo[i + x_dib][u + y_dib].getCode().equals("doors")) {

					ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/puerta.png"));

					mapa.setIcon(imagenFondo);

				} else if (mundo[i + x_dib][u + y_dib].getCode().equals("roofs")) {

					ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/tejado.png"));

					mapa.setIcon(imagenFondo);

				} else if (mundo[i + x_dib][u + y_dib].getCode().equals("house")) {

					ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/casa_pared.png"));

					mapa.setIcon(imagenFondo);

				} else if (mundo[i + x_dib][u + y_dib].getCode().equals("shops")) {

					ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/block.png"));

					mapa.setIcon(imagenFondo);

					ImageIcon imagenFondos = new ImageIcon(loader.getResource("mundo/Shop.png"));

					path.setIcon(imagenFondos);

				} else if (mundo[i + x_dib][u + y_dib].getCode().equals("talls")) {

					ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/hierba.png"));

					mapa.setIcon(imagenFondo);

					ImageIcon imagenFondos = new ImageIcon(loader.getResource("mundo/arbusto.png"));

					pelea.setIcon(imagenFondos);

				} else if (mundo[i + x_dib][u + y_dib].getCode().equals("paths")) {

					ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/grabilla.png"));

					mapa.setIcon(imagenFondo);

					ImageIcon imagenFondos = new ImageIcon(loader.getResource("mundo/camino.png"));

					path.setIcon(imagenFondos);
					
				} else if (mundo[i + x_dib][u + y_dib].getCode().equals("chest")) {
					
					ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/chest.png"));

					mapa.setIcon(imagenFondo);
					
				} else if (mundo[i + x_dib][u + y_dib].getCode().equals("NPC")) {
					
					if(u + y_dib <= 26 && i + x_dib <= 23) {

						ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/hierba.png"));

						mapa.setIcon(imagenFondo);
						
						ImageIcon imagendelante = new ImageIcon(loader.getResource("mundo/NPC.png"));

						pelea.setIcon(imagendelante);
						
						}else if(u + y_dib > 26 && i + x_dib <= 23) {
							
						ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/arena.png"));

						mapa.setIcon(imagenFondo);

						ImageIcon imagendelante = new ImageIcon(loader.getResource("mundo/NPC.png"));

						pelea.setIcon(imagendelante);
							
						}else if(u + y_dib > 26 && i + x_dib > 27) {
							
						ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/ice.png"));

						mapa.setIcon(imagenFondo);

						ImageIcon imagendelante = new ImageIcon(loader.getResource("mundo/NPC.png"));

						pelea.setIcon(imagendelante);
								
						}else if(u + y_dib <= 26 && i + x_dib > 27) {
							
						ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/rock.png"));

						mapa.setIcon(imagenFondo);
						
						ImageIcon imagendelante = new ImageIcon(loader.getResource("mundo/NPC.png"));

						pelea.setIcon(imagendelante);
									
						}else {
							
							
						ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/block.png"));

						mapa.setIcon(imagenFondo);
							
						ImageIcon imagendelante = new ImageIcon(loader.getResource("mundo/NPC.png"));

						pelea.setIcon(imagendelante);
							
						}

						} else {

						mapa.setBackground(Color.BLACK);
						}
				
				if (i == x - x_dib && u == y - y_dib) {

					// Personajes

					// Arquero
					if (skin.equals("Ezio, el Arquero Centenario")) {
						
						if (direccion.equals("UP")) {
							
							ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/arquero_detras_sf.png"));

							perso.setIcon(imagenFondo);
							

						} else if (direccion.equals("DOWN")) {

							ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/arquero_delante_sf.png"));

							perso.setIcon(imagenFondo);
						} else if (direccion.equals("RIGHT")) {

							ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/arquero.png"));

							perso.setIcon(imagenFondo);

						} else if (direccion.equals("LEFT")) {

							ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/arquero_girado_sf.png"));

							perso.setIcon(imagenFondo);

						}
					// Caballero (faltan los sprites para el movimiento)
					} else if(skin.equals("Geralt de Rivia")) {
						
						if (direccion.equals("UP")) {

							ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/caballerodetras.png"));

							perso.setIcon(imagenFondo);

						} else if (direccion.equals("DOWN")) {

							ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/caballerodefrente.png"));

							perso.setIcon(imagenFondo);

						} else if (direccion.equals("RIGHT")) {

							ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/caballeroderecha.png"));

							perso.setIcon(imagenFondo);

						} else if (direccion.equals("LEFT")) {

							ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/caballeroizquierda.png"));

							perso.setIcon(imagenFondo);

						}
					// Mago (sin completar las imagenes)
					} else if(skin.equals("Kalgar de Boria")) {
						
						if (direccion.equals("UP")) {

							ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/magodetras.png"));

							perso.setIcon(imagenFondo);

						} else if (direccion.equals("DOWN")) {

							ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/magodelante.png"));

							perso.setIcon(imagenFondo);

						} else if (direccion.equals("RIGHT")) {

							ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/magoderecha.png"));

							perso.setIcon(imagenFondo);

						} else if (direccion.equals("LEFT")) {

							ImageIcon imagenFondo = new ImageIcon(loader.getResource("mundo/magoizquierda.png"));

							perso.setIcon(imagenFondo);

						}
					
					} 
					
				}

				pos_x = pos_x + 70;
				pelea.setBounds(pos_x, pos_y, 70, 70);
				contentPane.add(pelea);
				perso.setBounds(pos_x, pos_y, 70, 70);
				contentPane.add(perso);
				path.setBounds(pos_x, pos_y, 70, 70);
				contentPane.add(path);
				mapa.setBounds(pos_x, pos_y, 70, 70);
				contentPane.add(mapa);
				repaint();
			}
		}

	}

	/** Se usa para la carga de la mazmorra*/
	public void cargar() {

		try {
			Robot robot = new Robot();

			if (x > x_ant) {

				robot.keyPress(KeyEvent.VK_DOWN);
				robot.keyRelease(KeyEvent.VK_DOWN);

			} else if (x < x_ant) {

				robot.keyPress(KeyEvent.VK_UP);
				robot.keyRelease(KeyEvent.VK_UP);

			} else if (y > y_ant) {

				robot.keyPress(KeyEvent.VK_RIGHT);
				robot.keyRelease(KeyEvent.VK_RIGHT);

			} else if (y < y_ant) {

				robot.keyPress(KeyEvent.VK_LEFT);
				robot.keyRelease(KeyEvent.VK_LEFT);

			}

		} catch (Exception e) {

		}

		if (in == false) {

			for (int i = 0; i < 50; i++) {
				for (int u = 0; u < 50; u++) {

					mundo[i][u] = extra[i][u];

				}
			}

			in = true;

		} else if (in == true) {

			for (int i = 0; i < 50; i++) {
				for (int u = 0; u < 50; u++) {

					mundo[i][u] = guardado[i][u];

				}
			}

			in = false;
		}

		repaint();

	}
	
	/** Lector de teclas*/
	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_DOWN) {

			if (x <= 47) {

				if (mundo[x + 1][y].isDown()) {
					
					y_ant = y;
					x_ant = x;
					x = x + 1;
					if (x > 5 && x < 46) {
						x_dib = x_dib + 1;
					}
				}
				direccion = "DOWN";
				dibujado();
			}

		} else if (key == KeyEvent.VK_LEFT) {

			if (y >= 2) {

				if (mundo[x][y - 1].isLeft()) {
					
					y_ant = y;
					x_ant = x;
					y = y - 1;
					if (y > 4 && y < 45) {
						y_dib = y_dib - 1;
					}
				}
				direccion = "LEFT";
				dibujado();
			}

		} else if (key == KeyEvent.VK_RIGHT) {

			if (y <= 47) {

				if (mundo[x][y + 1].isRight()) {

					y_ant = y;
					x_ant = x;
					y = y + 1;
					if (y > 5 && y < 46) {
						y_dib = y_dib + 1;
					}

				}
				direccion = "RIGHT";
				dibujado();

			}

		} else if (key == KeyEvent.VK_UP) {

			if (x >= 2) {

				if (mundo[x - 1][y].isUp()) {

					y_ant = y;
					x_ant = x;
					x = x - 1;
					if (x < 45 && x > 4) {
						x_dib = x_dib - 1;
					}
				}

				direccion = "UP";
				dibujado();

			}

		} else if (key == KeyEvent.VK_ESCAPE) {
			if(in==false) {
				
				String[] info = new String[9];
				info[0] = skin;
				info[1] = Integer.toString(x);
				info[2] = Integer.toString(y);
				info[3] = Integer.toString(x_dib);
				info[4] = Integer.toString(y_dib);
				info[5] = Integer.toString(cartera.getDinero());
				info[6] = Integer.toString(vida);
				info[7] = Integer.toString(energia);
				info[8] = Integer.toString(danyoarma);
				System.out.println("Impresion de los datos de partida = Skin "+ info[0] +"; X "+ info[1]+ "; Y " + info[2]+ "; X_dib "+info[3]
						+"; Y_dib "+ info[4]+ "; Dinero " + info[5]+ "; Vida "+ info[6] + "; Energia " + info[7] + "; Danyo arma " + info[8]);
				contentPane.setFocusable(false);
				
				InterfazOpcionesJuego inter = new InterfazOpcionesJuego();
				inter.setInfoJuego(info);
				inter.setVisible(true);
				inter.setLocationRelativeTo(null);
				
			} else {
				
				contentPane.setFocusable(false);
				JOptionPane.showMessageDialog(null, "Salga de la tienda para guardar");
			}
			
		}

	}
	/** Cuando se suelta la tecla*/
	public void keyReleased(KeyEvent arg0) {

	}
	
	/** Cuando se pulsa la tecla*/
	public void keyTyped(KeyEvent arg0) {

	}

}
