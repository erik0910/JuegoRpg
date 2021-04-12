package combate;
public class MascaraColisiones {
	private int[] x = {200,0,0};
	private int[] y = {165,110,170};
	private int[] alto = {20,20,0};
	private int[] ancho = {200,200,200};
	
	public int Colision(double xe, double ye, int altoe, int anchoe) {
		int colision = 0;
		for(int i=0; i < 3; i++) {
			if(ye >= y[i] && (ye <= y[i]+alto[i])) { //y >= 200 y y <= 250
				if(xe >= x[i] && xe <= x[i]+ancho[i]) {// x >= 100 y x <= 200
					colision = i+1;
				}
			}
		}
		return colision;
	}

	public MascaraColisiones() {super();}
	public int getX(int i) {return x[i];}
	public int getY(int i) {return y[i];}
	public int getAlto(int i) {return alto[i];}
	public int getAncho(int i) {return ancho[i];}
}
