package db;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Estadisticas {
	
	@PrimaryKey
	private String nombreJugador;
	private int vida;
	private String skin;
	private int danyoarma;
	private int energia;
	
	public Estadisticas() {
		super();
	}

	public Estadisticas(String nombreJugador, int vida, String skin, int danyoarma, int energia) {
		super();
		this.nombreJugador = nombreJugador;
		this.vida = vida;
		this.skin = skin;
		this.danyoarma = danyoarma;
		this.energia = energia;
	}

	public String getNombreJugador() {
		return nombreJugador;
	}

	public void setNombreJugador(String nombreJugador) {
		this.nombreJugador = nombreJugador;
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
		return "Estadisticas [nombre del jugador=" + nombreJugador + ", vida=" + vida + ", skin=" + skin + ", danyo del arma="
				+ danyoarma + ", energia=" + energia + "]";
	}
	
	
	
}
