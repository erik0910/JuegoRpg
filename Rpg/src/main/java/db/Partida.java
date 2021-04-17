package db;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Partida {
	protected String nombrePartida = null;
	protected int vida = 0;
	protected String skin = null;
	protected int x,y,x_dib,y_dib = 0;
	
	public Partida() {
	}

	public Partida(String nombrePartida, int vida, String skin, int x, int y, int x_dib, int y_dib) {
		this.nombrePartida = nombrePartida;
		this.vida = vida;
		this.skin = skin;
		this.x = x;
		this.y = y;
		this.x_dib = x_dib;
		this.y_dib = y_dib;
		
	}

	public String getNombrePartida() {
		return nombrePartida;
	}

	public void setNombrePartida(String nombrePartida) {
		this.nombrePartida = nombrePartida;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public String getSkin() {
		return skin;
	}

	public void setSkin(String skin) {
		this.skin = skin;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX_dib() {
		return x_dib;
	}

	public void setX_dib(int x_dib) {
		this.x_dib = x_dib;
	}

	public int getY_dib() {
		return y_dib;
	}

	public void setY_dib(int y_dib) {
		this.y_dib = y_dib;
	}

	
}
