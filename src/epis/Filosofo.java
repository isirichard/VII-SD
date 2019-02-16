package epis;

public class Filosofo {
	private estado estadoFil;
	private boolean izquierda;
	private boolean derecha;
	enum estado{T,H,E}
	
	public Filosofo() {
		super();
		this.izquierda = false;
		this.derecha = false;
		estadoFil = estado.T;
	}

	public boolean isIzquierda() {
		return izquierda;
	}

	public void setIzquierda(boolean izquierda) {
		this.izquierda = izquierda;
	}

	public estado getEstadoFil() {
		if(izquierda == false && derecha == false) {
			estadoFil = estado.T;
		}
		else if(izquierda == true && derecha == true) {
			estadoFil = estado.E;
		}
		else 
			estadoFil = estado.H;
		return estadoFil;
	}

	public void setEstadoFil(estado estadoFil) {
		this.estadoFil = estadoFil;
	}

	public boolean isDerecha() {
		return derecha;
	}

	public void setDerecha(boolean derecha) {
		this.derecha = derecha;
	}

}
