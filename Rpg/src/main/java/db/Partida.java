package db;

import mapa.Tiles;

public class Partida {
	
	private int id;
	private String nombrePartida;
	private int vida;
	private String skin;
	private Tiles[][] posicion;
	
	public Partida(int id, String nombrePartida, int vida, String skin, Tiles[][] posicion) {
		super();
		this.id = id;
		this.nombrePartida = nombrePartida;
		this.vida = vida;
		this.skin = skin;
		this.posicion = posicion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Tiles[][] getPosicion() {
		return posicion;
	}

	public void setPosicion(Tiles[][] posicion) {
		this.posicion = posicion;
	}

}
