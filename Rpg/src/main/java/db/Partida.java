package db;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

import dinero.Monedero;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Partida {
	@PrimaryKey
	private String nombrePartida;
	private int vida;
	private String skin;
	private int x;
	private int y;
	private int x_dib;
	private int y_dib;
	private Monedero monedero = new Monedero();
	private int danyoarma;
	private int energia;
	
	/**Constructor vacio*/
	public Partida() {
	}
	
	/**Constructor con propiedades*/
	public Partida(String nombrePartida, int vida, String skin, int x, int y, int x_dib, int y_dib, Monedero monedero, int danyoarma, int energia) {
		this.nombrePartida = nombrePartida;
		this.vida = vida;
		this.skin = skin;
		this.x = x;
		this.y = y;
		this.x_dib = x_dib;
		this.y_dib = y_dib;
		this.monedero = monedero;
		this.danyoarma = danyoarma;
		this.energia = energia;
		
	}
	/**Getter para el nombre partida*/
	public String getNombrePartida() {
		return nombrePartida;
	}
	/**Setter para el nombre partida*/
	public void setNombrePartida(String nombrePartida) {
		this.nombrePartida = nombrePartida;
	}
	/**Getter para la vida*/
	public int getVida() {
		return vida;
	}
	/**Setter para la vida*/
	public void setVida(int vida) {
		this.vida = vida;
	}
	/**Getter para el nombre de la skin*/
	public String getSkin() {
		return skin;
	}
	/**Setter para el nombre de la skin*/
	public void setSkin(String skin) {
		this.skin = skin;
	}
	/**Getter para la X*/
	public int getX() {
		return x;
	}
	/**Setter para la X*/
	public void setX(int x) {
		this.x = x;
	}
	/**Getter para la Y*/
	public int getY() {
		return y;
	}
	/**Setter para la Y*/
	public void setY(int y) {
		this.y = y;
	}
	/**Getter para la X_Dib*/
	public int getX_dib() {
		return x_dib;
	}
	/**Setter para la X_Dib*/
	public void setX_dib(int x_dib) {
		this.x_dib = x_dib;
	}
	/**Getter para la Y_Dib*/
	public int getY_dib() {
		return y_dib;
	}
	/**Setter para la Y_Dib*/
	public void setY_dib(int y_dib) {
		this.y_dib = y_dib;
	}
	/**Getter para el monedero*/
	public Monedero getMonedero() {
		return monedero;
	}
	/**Setter para el monedero*/
	public void setMonedero(Monedero monedero) {
		this.monedero = monedero;
	}
	/**Getter para el danyo de arma*/
	public int getDanyoarma() {
		return danyoarma;
	}
	/**Setter para el danyo de arma*/
	public void setDanyoarma(int danyoarma) {
		this.danyoarma = danyoarma;
	}
	/**Getter para la energia*/
	public int getEnergia() {
		return energia;
	}
	/**Setter para la energia*/
	public void setEnergia(int energia) {
		this.energia = energia;
	}

	/**Metodo para el toString*/
	public String toString() {
		return "Partida [nombrePartida=" + nombrePartida + ", vida=" + vida + ", skin=" + skin + ", x=" + x + ", y=" + y
				+ ", x_dib=" + x_dib + ", y_dib=" + y_dib + ", monedero=" + monedero + ", danyoarma=" + danyoarma
				+ ", energia=" + energia + "]";
	}
	
}
