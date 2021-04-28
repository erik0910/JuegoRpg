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
	
	public Partida() {
	}

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

	public Monedero getMonedero() {
		return monedero;
	}

	public void setMonedero(Monedero monedero) {
		this.monedero = monedero;
	}

	public int getDanyoarma() {
		return danyoarma;
	}

	public void setDanyoarma(int danyoarma) {
		this.danyoarma = danyoarma;
	}

	public int getEnergia() {
		return energia;
	}

	public void setEnergia(int energia) {
		this.energia = energia;
	}

	@Override
	public String toString() {
		return "Partida [nombrePartida=" + nombrePartida + ", vida=" + vida + ", skin=" + skin + ", x=" + x + ", y=" + y
				+ ", x_dib=" + x_dib + ", y_dib=" + y_dib + ", monedero=" + monedero + ", danyoarma=" + danyoarma
				+ ", energia=" + energia + "]";
	}
	
}
