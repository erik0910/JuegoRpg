package Combate;

public abstract class Objeto {
	
	// Posiciones ===========
	protected double x,y,dx,dy,xdest,ydest;
	//=======================
	int col;
	private int[] xb = {200,0};
	private int[] yb = {165,110};
	private int[] altob = {20,20};
	private int[] anchob = {200,200};
	//Dimenciones================
	protected int ancho;
	protected int alto;
	//===========================

	//animacion===================
	protected Animacion animacion;
	protected int accion;
	protected boolean mDerecha;
	//===========================
	
	//Accion=====================
	protected boolean izquierda;
	protected boolean derecha;
	protected boolean arriba;
	protected boolean abajo;
	protected boolean salto;
	protected boolean caer;
	protected boolean ataque;
	//===========================
	
	//Atributos====================
	protected double moveSpeed;
	protected double maxSpeed;
	protected double stopSpeed;
	protected double vCaida;
	protected double maxCaida;
	protected double vSalto;
	protected double pSalto;
	//==============================
	MascaraColisiones bloque = new MascaraColisiones();
	
	public void checkSuelo() {
		xdest = x + dx;
		ydest = y + dy;
		//Calcular si va a salirse de pantalla
		if (xdest > 0 && xdest < 300) x = xdest;
		else xdest -= dx;
		//====================================
		
		//Calcular si el player supera la y max
		if(ydest < 212) {
			y = ydest;
			caer = true;
		} else if (caer) {
			caer = false; 
			ydest = 212; 
			dy = 0;
		}
		//====================================
		col = bloque.Colision(x, y+10, alto, ancho);
		if(bloque.Colision(x, y+10, alto, ancho) > 0) {
			if (y-5 <= (bloque.getY(col-1)) ) {ydest -=dy;caer = false;ydest = bloque.getY(col-1)-10; dy = 0;} //No se mueve la y si est� arriba.
			else if(y < (bloque.getY(col-1) + bloque.getAlto(col-1)))xdest -= dx; //Si no est� abajo
		} 
		this.setPosition(xdest, ydest); //Aplicar
	}
	
	public int getx() { return (int)x; }
	public int gety() { return (int)y; }
	public int getancho() { return ancho; }
	public int getHeight() { return alto; }
	
	public void setPosition(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public void setIzquierda(boolean b) { izquierda = b; }
	public void setDerecha(boolean b) { derecha = b; }
	public void setArriba(boolean b) { arriba = b; }
	public void setAbajo(boolean b) { abajo = b; }
	public void setSalto(boolean b) { salto = b; }
	
	public boolean notOnScreen() {
		return x + ancho < 0 ||
			x - ancho > Juego.ANCHO ||
			y + alto < 0 ||
			y - alto > Juego.ALTO;
	}
	
	public void draw(java.awt.Graphics2D g) {
		/*Plataformas========================================*/
		for(int i=0; i < 2; i++) g.drawRect (xb[i], yb[i], anchob[i], altob[i]);
		/*===================================================*/
		
		if(mDerecha) g.drawImage(animacion.getImage(),(int)(x - ancho / 2),(int)(y - alto / 2),null);
		else g.drawImage(animacion.getImage(),(int)(x - ancho / 2 + ancho),(int)(y - alto / 2),-ancho,alto,null);
	}
}
	