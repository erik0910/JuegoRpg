package combate;
import java.util.ArrayList;
import javax.imageio.ImageIO;

import interfaces.FondoIntCargar;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Objeto  {
	
	// player stuff
	private int health, maxHealth;
	private int manad1 = 30;
	public boolean animarEspada=false;
	private boolean parpadeo;
	private long parpadeoT;
	private boolean animar=true;
	int cont =0;
	// gliding
	private boolean planeo;
	boolean ataquef;
	private double mana;
	private BufferedImage [] imagenes;
	private BufferedImage [] izquierdaArma , derechaArma;//para las fotos de las armas
	// animacions
	private ArrayList<BufferedImage[]> sprites;
	private final int[] numFrames = {
		2, 8, 1, 2, 4, 2, 5
		};

	// animacion actions
	private static final int NORMAL = 0;
	private static final int ANDAR = 1;
	private static final int SALTAR = 2;
	private static final int CAER = 3;
	private static final int PLANEAR = 4;
	private static final int[] fps = {400,40,-1,100,100};
	public int estado = 0;// estado 0 = magia estado =1 arco y estado = 3 espada
	
	//Arma
	Armas espada=new Armas(20,(int)this.x,(int)this.y-23);
	Armas arco = new Armas (30,(int)this.x,(int)this.y-23);
	//tendriamos una tercera arma que seria el arma que seria la magia
	//carga de imagenes de la clase resources
	static final ClassLoader loader = Player.class.getClassLoader();
	public Player(int player) {
		animacion();// cargamos la animación
		ancho = 30;
		alto = 30;
		moveSpeed = 0.3;
		maxSpeed = 1.6;
		stopSpeed = 0.4;
		vCaida = 0.15;
		maxCaida = 4.0;
		vSalto = -4.8;
		pSalto = 0.3;
		this.mana = 100;
		//this.player = player;
		mDerecha = true;
		health = maxHealth = 100;
		//carga de las imagenes de las diferentes armas
		try {
			espada.cargaImagen(ImageIO.read(loader.getResource("combate/espada.png")));
//			arco.cargaImagen(ImageIO.read(loader.getResource("combate/disparo2.png")));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		/*Imagenes===================================================*/
		try {
			BufferedImage hoja =ImageIO.read(loader.getResource("combate/player.png")) ;
			/*======================================================*/
			sprites = new ArrayList<BufferedImage[]>();
			/*Array de im�genes====================================*/
			/*Crear en bucle cada imagen separada*/
			for(int i = 0; i < 5; i++) {
				BufferedImage[] bi = new BufferedImage[numFrames[i]];//Crear la array de imagenes
				for(int j = 0; j < numFrames[i]; j++) bi[j] = hoja.getSubimage(j * ancho, i * (alto-1), ancho, alto); //A�adir las imagenes
				sprites.add(bi); 
				/*Se a�ade en cada posici�n de la arraylist el conjunto de imagenes de cada animaci�n
				 *lo que luego vale para aplicarlas llamandolas con un n�mero que es asignado a cada nombre clave.*/
			}
			/*====================================================*/
		}
		catch(Exception e) {
		}
		animacion = new Animacion();
		accion = NORMAL;
		animacion.setAnimacion(sprites.get(NORMAL));
		animacion.setDelay(400);
		ancho = 30;
		
	}
	public void setHealth(int health) {
		this.health = health;
	}
	/*===============================================================*/
	public int getHealth() { return health; }
	public int getMaxHealth() { return maxHealth; }
	
	public void setPlaneo(boolean b) { 
		planeo = b;
	}
	
	public void hit(int damage) {
		if(parpadeo) return;
		health -= damage;
		if(health < 0) health = 0;
		parpadeo = true;
		parpadeoT = System.nanoTime();
	}
	
	private void pTemporal() {
		if(izquierda) {
			dx -= moveSpeed;
			if(dx < -maxSpeed) dx = -maxSpeed;
		}
		else if(derecha) {
			dx += moveSpeed;
			if(dx > maxSpeed) dx = maxSpeed;
		}
		else {
			if(dx > 0) {
				dx -= stopSpeed;
				if(dx < 0) dx = 0;
			}
			else if(dx < 0) {
				dx += stopSpeed;
				if(dx > 0) dx = 0;
			}
		}
		
		// jumping
		if(salto && !caer) {
			dy = vSalto;
			caer = true;
		}
		
		// caer
		if(caer) {
				if(dy > 0 && planeo) dy += vCaida * 0.1;
				else dy += vCaida;
				if(dy > 0) salto = false;
				if(dy < 0 && !salto) dy += pSalto;
				if(dy > maxCaida) dy = maxCaida;
		}
	}
	
	
	
	public void update() {
		
		// update position
		updateArma();
		pTemporal();
		checkSuelo();
		if(mana < 100) {
			this.mana += 0.5;
		}
		// check done parpadeo
		if(parpadeo) {
			long elapsed = (System.nanoTime() - parpadeoT) / 1000000;
			if(elapsed > 1000) parpadeo = false;
		}
		
		// set animacion
		if(dy > 0) {
			if(planeo) {
				if(accion != PLANEAR) {
					accion = PLANEAR;
					animacion.setAnimacion(sprites.get(PLANEAR));
				}
			}
			else if(accion != CAER) {
				accion = CAER;
				animacion.setAnimacion(sprites.get(CAER));
			}
		}
		else if(dy < 0) {
			if(accion != SALTAR) {
				accion = SALTAR;
				animacion.setAnimacion(sprites.get(SALTAR));
			}
		}
		else if(izquierda || derecha) {
			if(accion != ANDAR) {
				accion = ANDAR;
				animacion.setAnimacion(sprites.get(ANDAR));
			}
		}
		else {
			if(accion != NORMAL) {
				accion = NORMAL;
				animacion.setAnimacion(sprites.get(NORMAL));
			}
		}	
		animacion.setDelay(fps[accion]);
		animacion.update();
		
		// set direction
		if(derecha) mDerecha = true;
		if(izquierda) mDerecha = false;
		
		//Armas update
		espada.setX((int)this.x+5);
		espada.setY((int)this.y-10);
		arco.setX((int)this.x+5);
		arco.setY((int)this.y-10);
	}
	
	public void draw(Graphics2D g) {
		if(parpadeo) {
			long elapsed = (System.nanoTime() - parpadeoT) / 1000000;
			if(elapsed / 100 % 2 == 0) return;
		}
		//añadimos el pintado del arma y todas sus caracteristicas
		if(animarEspada && this.mana>=100) {//comprobamos que el mana sea 100 para poder animar el ataque
		if(mDerecha) {
			g.drawImage(derechaArma[cont], (int)this.x, (int)this.y-23, 50,40,null);	
			}else {
			g.drawImage(izquierdaArma[cont], (int)this.x-45, (int)this.y-23, 50,40,null);
			}
		cont ++;
		if(cont==3) {animarEspada= false; cont=0;}
		}else {
			pintadoArma(g);
			
		}
		//HP
		g.drawRect ((int)x-10, (int)y-30, (((health*100/maxHealth)*30)/100), 5);
		g.setColor(Color.red);
		g.fillRect((int)x-9, (int)y-29, (((health*100/maxHealth)*30)/100)-1, 4);
		//Mana
		g.setColor(Color.BLACK);
		g.drawRect ((int)x-10, (int)y-15, (int)(((mana*100/100)*30)/100), 5);
		g.setColor(Color.green);
		g.fillRect((int)x-9, (int)y-14, (int)(((mana*100/100)*30)/100)-1, 4);
		g.setColor(Color.BLACK);
		super.draw(g);
		
	}
	//metodo para representar el ataque del jugador si esta usando la espada
	// recibimos por parametro el jugador para obtener sus coordenadas y tambien poder alterar su vida 
	// su el ataque se ha producido
	public void ataque(Player jugador) {
		
		if(jugador.getHealth()<0) {Room.finalizar=true;}//Detección de si el jugador a terminado en la parte de mele
		animarEspada=true;
		
		if(espada.ataque(jugador.getx(),jugador.gety()-23 ,100 , 100)&& this.mana>=100) {
			//para iniciar la animacion de la espada
			jugador.setHealth(jugador.getHealth()-50);
			this.mana-=80;
		}
		
	}
	// metodo que cambiara constantemente la posicion del arma o mas bien el area de impacto del arma
	private void updateArma() {
		espada.setSpeed((int)this.x);
		espada.setY((int)this.y -23);
	}
	private void pintadoArma(Graphics2D g) {
		BufferedImage imagen = null;
		//pintado del arma
		if(estado==2) {
			try {
				imagen = ImageIO.read(loader.getResource("combate/espada.png"));
					} catch (IOException e) {
				e.printStackTrace();
					}
			if(mDerecha) {
				g.drawImage(imagen, (int)this.x-13, (int)this.y-23, 50,40,null);	
				}else {
				g.drawImage(imagen, (int)this.x-35, (int)this.y-23, 50,40,null);
		}
	}

	}
	//animacion para el arma
	public void animacion() {
		BufferedImage[] derecha = new BufferedImage[3];
		BufferedImage[] izquierda = new BufferedImage[3];
		//cargamos la correspondientes imagenes
		try {
			derecha[0]=ImageIO.read(loader.getResource("combate/espada.png"));
			izquierda[0]=ImageIO.read(loader.getResource("combate/espada.png"));
			derecha[1]=ImageIO.read(loader.getResource("combate/espadaDerecha1.png"));
			derecha[2]=ImageIO.read(loader.getResource("combate/espadaDerecha2.png"));
			izquierda[1]=ImageIO.read(loader.getResource("combate/espadaIzquierda1.png"));
			izquierda[2]= ImageIO.read(loader.getResource("combate/espadaIzquierda2.png"));
			derechaArma=derecha;
			izquierdaArma=izquierda;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	// metodo que permitira cambiar de arma a el jugador
	public void cambiarEstado() {
		if(estado==0) {estado = 2;}else {estado=0;}
	}
	public void setFalse() {
		this.abajo = false;
		this.izquierda = false;
		this.salto = false;
		this.planeo = false;
		this.derecha = false;
		this.ataque = false;
	}
	
	public void setAtaque(boolean b) {this.ataque = true;}
	public boolean getAtaque() {return this.ataque;}
	public boolean getmDerecha() {return this.mDerecha;}
	public double getAlto() {return this.alto;}
	public double getMana() {
		return mana;
	}
	public void setMana(double manas) {
		this.mana=manas;
	}
	public int getManad1() {
		return manad1;
	}

}

