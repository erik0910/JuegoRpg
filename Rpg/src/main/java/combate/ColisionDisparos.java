package combate;
public class ColisionDisparos {
	private double x, y;
	private int alto, ancho;
	/**ingreser la colision de los disparos*/
	public ColisionDisparos(double x, double y, int alto, int ancho) {
		this.alto = alto;
		this.ancho = ancho;
		this.x = x;
		this.y = y;
	}
	/**actualiza el estado de la colision*/
	public void update(double x, double y) {
		this.x = x;
		this. y = y;
	}
	/**Detección de las colisiones*/
	public boolean Colision(double xe, double ye, int altoe, int anchoe) {
		boolean colision = false;
		if(ye >= y && (ye <= y+alto)) { //y >= 200 y y <= 250
			if(xe >= x && xe <= x+ancho) {// x >= 100 y x <= 200
				colision = true;
			}
		}
		return colision;
	}

}
