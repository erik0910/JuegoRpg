package dinero;

public class Monedero  {
	/*
	 * Clase moneda encragada de hacer toda la gestión de
	 */
	
	
	private int dinero;


	public Monedero(int dinero) {/** Constructor */

		this.dinero = 1000;
	}
	public Monedero() { /** Constructor vacio */
		super();
		this.dinero = 1000;
	}
	public int getDinero() { /** Obtiene las monedas del monedero*/

		return dinero;
	}

	public void setDinero(int dinero) { /** Setter de getDinero() */
		this.dinero += dinero;
	}

	

	public void ganar() { /** Funcion que incrementa el dinero post ganar partida */
		this.dinero += 100;
	}

	
	public void perder() { /** Funcion que decrementa el dinero post perder partida */
		this.dinero -= 100;
	}
	@Override
	public String toString() {
		return "Monedero [dinero=" + dinero + "]";
	}

	public boolean compra(int gasto) { /** Funcion que compara el dinero con el gasto antes de comprar */
		if(gasto <this.dinero) {
		this.dinero -= gasto;
		return true;
		} else {
		return false;
		}
		
	}

	
}
