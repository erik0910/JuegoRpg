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
	
	/**Constructor vacio*/
	public Estadisticas() {
		super();
	}
	/**Constructor con propiedades*/
	public Estadisticas(String nombreJugador, int vida, String skin, int danyoarma, int energia) {
		super();
		this.nombreJugador = nombreJugador;
		this.vida = vida;
		this.skin = skin;
		this.danyoarma = danyoarma;
		this.energia = energia;
	}
	/**Getter para el nombre jugador*/
	public String getNombreJugador() {
		return nombreJugador;
	}
	/**Setter para el nombre jugador*/
	public void setNombreJugador(String nombreJugador) {
		this.nombreJugador = nombreJugador;
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
	/**Getter para el danyo del arma*/
	public int getDanyoarma() {
		return danyoarma;
	}
	/**Setter para el danyo del arma*/
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
		return "Estadisticas [nombre del jugador=" + nombreJugador + ", vida=" + vida + ", skin=" + skin + ", danyo del arma="
				+ danyoarma + ", energia=" + energia + "]";
	}
	
	
	
}
