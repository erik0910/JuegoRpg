package dinero;

public class Monedero {
	/*
	 * Clase moneda encragada de hacer toda la gestión de
	 */
	private int dinero;

	public int getDinero() {
		return dinero;
	}

	public void setDinero(int dinero) {
		this.dinero = dinero;
	}

	public Monedero() {
		super();
		this.dinero = 1000;// ponemos por default la monedas que va a tener
	}

	// metodo que se activara cuando el personaje ha ganado
	public void ganar() {
		this.dinero += 100;
	}

	// metodo que se activa si el personaje a perdido
	public void perder() {
		this.dinero -= 100;
	}
	@Override
	public String toString() {
		return "Monedero [dinero=" + dinero + "]";
	}

	public boolean compra(int gasto) {
		if(gasto <this.dinero) {
		this.dinero -= gasto;
		return true;
		} else {
		return false;
		}
		
	}
}
