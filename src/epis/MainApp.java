package epis;

public class MainApp {
	// número de filosofos > = 2
	static int n = 1;

	public static void main(String[] args) throws InterruptedException {
		Filosofo[] mesaFil = new Filosofo[n];
		// inicializando el arreglo
		for (int i = 0; i < mesaFil.length; i++) {
			mesaFil[i] = new Filosofo();
		}
		
		
		// poniendo en mesa se aplica modulo
		// caso par dando permisos
		inicializando(mesaFil);
		
		//Número de filósofo
		 for (int i = 0; i < mesaFil.length; i++) { 
			 System.out.print(i+1+" "); 
			 }
		 System.out.println();
		
		comenzandoJalar(mesaFil);
		
	}

	static void comenzandoJalar(Filosofo[] mesaFil) throws InterruptedException {
		if (n == 1) {
			for(;;) {
				imprimir(mesaFil);
				if (mesaFil[0].isDerecha() == true && mesaFil[0].isIzquierda() == true) {
					mesaFil[0].setIzquierda(false);
					mesaFil[0].setDerecha(false);
				} else {
					mesaFil[0].setIzquierda(true);
					mesaFil[0].setDerecha(true);
				}
				Thread.sleep(2000);
			}
		}
		for (;;) {

			imprimir(mesaFil);
			if (n % 2 == 0) {
				for (int i = 0; i < mesaFil.length; i++) {
					if (mesaFil[i].isDerecha() == true && mesaFil[i].isIzquierda() == true) {
						mesaFil[i].setIzquierda(false);
						mesaFil[i].setDerecha(false);
					} else {
						mesaFil[i].setIzquierda(true);
						mesaFil[i].setDerecha(true);
					}
				}

			} else {
				for (int i = 0; i < mesaFil.length; i++) {
					if (mesaFil[i].isIzquierda() == false && mesaFil[i].isDerecha() == true) {
						mesaFil[i].setDerecha(false);
						mesaFil[(i + 1) % n].setIzquierda(false);
						mesaFil[(i + 1) % n].setDerecha(true);
						break;
					}
				}
				for (int i = 0; i < mesaFil.length; i++) {
					if (mesaFil[i].isDerecha() == true && mesaFil[i].isIzquierda() == true) {
						mesaFil[i].setIzquierda(false);
						mesaFil[i].setDerecha(false);
					}
					else if (mesaFil[i].isDerecha() == false && mesaFil[i].isIzquierda() == false) {
						mesaFil[i].setIzquierda(true);
						mesaFil[i].setDerecha(true);
					}
				}
									
			}
			Thread.sleep(2000);
		}
	}

	static void inicializando(Filosofo[] mesaFil) {
		if (n == 1) {
			mesaFil[0].setIzquierda(true);
			mesaFil[0].setDerecha(true);
			return;
		}
		
		if (n % 2 == 0) {
			for (int i = 0; i < mesaFil.length; i++) {
				if (i % 2 == 0) {
					mesaFil[i].setIzquierda(true);
					mesaFil[i].setDerecha(true);
				}
			}
		} else {
			mesaFil[0].setIzquierda(true);
			mesaFil[0].setDerecha(true);
			mesaFil[1].setDerecha(false);
			mesaFil[1].setDerecha(true);
			for (int i = 2; i < mesaFil.length; i++) {
				if (i % 2 != 0) {
					mesaFil[i].setIzquierda(true);
					mesaFil[i].setDerecha(true);
				}
			}
		}
	}

	static void imprimir(Filosofo[] mesaFil) {
		for (int i = 0; i < mesaFil.length; i++) {
			System.out.print(mesaFil[i].getEstadoFil() + " ");
		}
		System.out.println();

	}

}
