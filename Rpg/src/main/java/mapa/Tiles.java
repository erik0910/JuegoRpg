package mapa;

public class Tiles {

	private String code;
	private boolean up;
	private boolean down;
	private boolean left;
	private boolean right;

	/** Constructor vacio*/
	public Tiles() {
		super();
	}

	/** Constructor con argumentos*/
	public Tiles(String code, boolean up, boolean down, boolean left, boolean right) {
		super();
		this.code = code;
		this.up = up;
		this.down = down;
		this.left = left;
		this.right = right;
	}

	/** Obtiene el codigo*/
	public String getCode() {
		return code;
	}

	/** Cambia el codigo*/
	public void setCode(String code) {
		this.code = code;
	}

	/** Devuelve si hay colision por arriba o si el bloque es atravesable*/
	public boolean isUp() {
		return up;
	}

	/** Cambia el valor de la colision por arriba*/
	public void setUp(boolean up) {
		this.up = up;
	}
	/** Devuelve si hay colision por abajo o si el bloque es atravesable*/
	public boolean isDown() {
		return down;
	}
	/** Cambia el valor de la colision por abajo*/
	public void setDown(boolean down) {
		this.down = down;
	}
	/** Devuelve si hay colision por izquierda o si el bloque es atravesable*/
	public boolean isLeft() {
		return left;
	}
	/** Cambia el valor de la colision por izquierda*/
	public void setLeft(boolean left) {
		this.left = left;
	}
	/** Devuelve si hay colision por derecha o si el bloque es atravesable*/
	public boolean isRight() {
		return right;
	}
	/** Cambia el valor de la colision por derecha*/
	public void setRight(boolean right) {
		this.right = right;
	}

}
