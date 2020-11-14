package juegoTP;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import InterfazGrafica.PantallaPartida;

public class Jugador extends Observador {

	private String nombre, estado; // Jugando - Fuera de Ronda - Perdedor - Inmune
	private int puntaje;
	private Mano manoDeCartas;
	boolean esAdmin;
	int cartasTiradas;
	Partida partidaJuego;

	public Jugador(String nombre) {
		this.nombre = nombre;
		estado = "Jugando";
		puntaje = 0;
		manoDeCartas = new Mano();
		esAdmin = false;
		cartasTiradas = 0;
		partidaJuego = null;
	}

	/*public void iniciarPartida(Partida p) {
		if (this.esAdmin == true) {
			if (p.getCantJugadores() >= 2) {
				p.jugarPartida();
				this.estado = "Jugando";
			} else
				System.out.println("No se puede inicar la partida al no haber 2 jugadores o mas");
		} else
			System.out.println("Solo un administrador puede inicar la partida");
	}*/

	public void unirsePartida(Partida pp) {
		pp.agregarJugador(this);
		this.partidaJuego = pp;
		this.setEstado("Jugando");
	}

	public Partida crearPartida() {
		int cantSimbolos;
		Scanner leoTeclado = new Scanner(System.in);
		do {
			System.out.println("-------Ingrese cantidad de simbolos para ganar de 2 a 10: ");
			cantSimbolos = leoTeclado.nextInt();
		} while (cantSimbolos < 2 || cantSimbolos > 10);
		this.esAdmin = true;
		this.partidaJuego = new Partida(cantSimbolos);
		this.estado = "Jugando";
		return partidaJuego;
	}

	public boolean agarrarCarta(Mazo mazo, PantallaPartida pantallaPartida) {
		Carta cartaAsignada = mazo.asignarCarta();
		if (cartaAsignada != null) {
			asignarCarta(cartaAsignada);
			return true;
		}
		return false;
	}// Agarrar carte debe recibir por parametro una carta, entonces busco en mazo la
		// que esta arriba de todo, y la
		/// retorno a partir del metodo asignar carta
	
	public boolean agarrarCarta(Mazo mazo) {
		Carta cartaAsignada = mazo.asignarCarta();
		if (cartaAsignada != null) {
			asignarCarta(cartaAsignada);
			return true;
		}
		return false;
	}

	public void asignarCarta(Carta c) {
		manoDeCartas.agarrarCarta(c);
	}

	public Carta seleccionarCartaAJugar() { /// Metodo por el cual el jugador elije una de las 2
											/// cartas que posee en la mano, que es un array list de
											/// cartas, por lo que debera insertar el indice de la carta
											/// que quiere tirar
		int pos = 0, opcion = 0;

		Scanner tecla = new Scanner(System.in);
		while (opcion != 1) {
			do {
				System.out.println(this.manoDeCartas);
				System.out.println("\n-------Seleccione 1 o 2 dependiendo la carta que quiera jugar:");
				pos = tecla.nextInt() - 1;
			} while (pos < 0 || pos > 1);/// la posicion debe ser la 1ra o 2da de su mano
											/// ya que nunca tendra mas de 2 cartas en su mano, y siempre por lo menos
											/// tendra 1

			System.out.println("\nSe eligio la carta" + this.manoDeCartas.getCartaEn(pos) + "\n");
			System.out.println("-------Presione 1 para confirmar");
			System.out.println("-------Presione otro NUMERO para volver a elegir");
			opcion = tecla.nextInt();

		}
		return manoDeCartas.sacarCarta(pos);
	}

	/*public boolean jugarCarta(Carta carta, Descarte descarte, ArrayList<Jugador> jugadores, Mazo mazo, Jugador j) {// descartar
																													// carta
		/// recibe por parametro la carta que se saco de su mano
		/// y el descarte, para tirar la carta alli
//		System.out.println("oprime una tecla para jugar la carta seleccionada");
//		Scanner tecla = new Scanner(System.in);
//		tecla.next();
		boolean sacoJug = carta.activarEfecto(j, jugadores, descarte, mazo);/// DENTRO DE ESTE METODO SE VA A
																			/// SELECCIONAR UN JUGADOR DEL ARRAY DE
																			/// JUGADORES
		/// PARA ACTIVARLE EL EFECTO QUE SE LE VA A DAR
		System.out.println("Se jugo la carta: " + carta.getNombre());
		descarte.agregarCarta(carta);
		cartasTiradas++; // AL FINAL DE CADA RONDA SE VERIFICA CUANTAS CARTAS TIRO, PARA VER QUIEN GANO
		return sacoJug;
	}*/

	public void descarto(Descarte d, Mazo m) {
		Carta c = this.manoDeCartas.sacarCarta(0);
		d.agregarCarta(c);
		cartasTiradas++;
		if (c.getPuntajeFuerza() == 9)
			this.setEstado("Fuera de Ronda");

		else if (m.getCantidadCartas() > 0)
			this.manoDeCartas.agarrarCarta(m.asignarCarta());

	}

	/*public boolean jugada(Mazo mazo, ArrayList<Jugador> jugadores, Descarte descarte) {
		/// ESTE METODO ES AL QUE SE LLAMA CUANDO LE TOCA EL TURNO A CADA JUGADOR
		/// DENTRO DE ESTE EL JUGADOR REALIZA TODO LO Q DEBE HACER: AGARRA UNA CARTA DEL
		/// MAZO,
		/// SE VERIFICA SI TIENE CONDEZA, Y LUEGO SELECCIONA UNA CARTA DEL MAZO
		if(this.getEstado() == "Inmune") {
			this.setEstado("Jugando");
		}

		if (!this.agarrarCarta(mazo)) {
			System.out.println("No hay mas cartas en el mazo!");
			return false;
		}

		if (manoDeCartas.estaCarta(new Condesa())
				&& (manoDeCartas.estaCarta(new Principe()) || manoDeCartas.estaCarta(new Rey()))) {

			System.out.println(this.manoDeCartas);

			System.out.println("Solo puede jugar la condesa");
			return jugarCarta(manoDeCartas.sacarCondesa(), descarte, jugadores, mazo, this);/// SE DEBE JUGAR
			/// OBLIGATORIAMENTE LA CONDESA, POR LO QUE SE BUSCARA EL INDICE DE LA CARTA Y
			/// SE PROCEDERA A TIRAR ESA. Se le pasa EL ARRAY DE JUGADORES, PARA QUE AL
			/// LLAMAR A ACTIVAR
			/// EFECTO DE CADA CARTA SE LE PUEDA ELEGIR UN JUGADOR AL CUAL ACTIVARLE EL
			/// EFECTO

		}

		return jugarCarta(seleccionarCartaAJugar(), descarte, jugadores, mazo, this);
	}*/

	public String getNombre() {
		return nombre;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setPuntaje(int n) {
		this.puntaje += n;
	}

	public int getPuntaje() {
		return this.puntaje;
	}

	public void rendirse() {
		setEstado("Perdedor");
	}

	public boolean esAdminONo() {
		return this.esAdmin;
	}

	public int setCantidadDeSimbolos() {
		Scanner escriboSimbolos = new Scanner(System.in);
		System.out.println("Ingrese la cantidad de simbolos necesarias para ganar la partida: ");
		int simbolos;
		do {
			simbolos = escriboSimbolos.nextInt();
		} while (simbolos < 1 && simbolos > 15);
		return simbolos;
	}

	public void resetCantCartasTiradas() {
		cartasTiradas = 0;
	}

	public Carta getCartaMano() {
		return manoDeCartas.sacarCarta(0);
		/// ESTE METODO SE PENSO PARA COMPARAR AL FINAL DE LA RONDA LA FUERZA DE LAS
		/// CARTAS
	}

	public Mano getManoDeCartas() {
		return manoDeCartas;
		/// ESTE METODO DEVUELVE LA MANO DEL JUGADOR PARA DESCARTAR Y AGARRAR UNA CARTA
		/// MEDIANTE EFECTO DEL PRINCIPE
	}

	public Carta getReferenciaCarta() {
		return this.manoDeCartas.getReferencia();
	}

	/*
	 * Se agrego el get porque necesitabamos saber desde ronda la cantidad de cartas
	 * que tiro cada jugador para desempatar
	 */
	public int getCartasTiradas() {
		return cartasTiradas;
	}

	public void verCarta(Carta c) {
		System.out.println(c);
	}

	/// Se agregan los metodos para que puedan cambiarse el puntaje desde ronda, u
	// no no hace nada porque notifica a partido
	@Override
	public void notificarse() {
		// TODO Auto-generated method stub
		// nada de nada
	}

	/// Ronda avisa a jugador que debe cambiar su valor
	@Override
	public void notificarseJugador(Jugador jugador) {
		jugador.setPuntaje(1);
	}

	public void setCarta(Carta cartaMano) {
		this.manoDeCartas.agarrarCarta(cartaMano);
	}

	public String getInfoCarta() {
		return manoDeCartas.toString();
	}

	public int getFuerzaCarta() {
		return this.manoDeCartas.getCartaEn(0).getPuntajeFuerza();
	}

///////////////////////////////////////////////////////// COMMENT# 1 

//	
//	
////	public void crearSala() {///a completar para proximas entregas
//	this.esAdmin = true;
//}
//
//public void salirDeSala() {///a completar para proximas entregas
//	
//}
//	private void setOrdenRonda() {
//		Scanner entradaJugador = new Scanner(System.in);
//		int ordenRonda;
//		do {
//			System.out.print("\nElija una opcion: \n0-Orden Horario\n1-Orden inverso\nOpcion: ");
//			ordenRonda = entradaJugador.nextInt();
//		} while (ordenRonda < 0 && ordenRonda > 1);
//		partidaJuego.setOrden(ordenRonda);
//	}

//	
	private void setPrimerJugador() {
		int cantJug = partidaJuego.getCantJugadores();
		Scanner entradaJugador = new Scanner(System.in);
		System.out.println("Seleccione el jugador que inicia la ronda");
		int eleccion;
		do {
			eleccion = entradaJugador.nextInt() - 1;
		} while (eleccion < 0 && eleccion >= cantJug);
		partidaJuego.setPrimerJugador(eleccion);
	}

//	
//	///SE PENSARON PRIVATE PARA SER LLAMADAS DENTRO DE CONFIGURAR PARTIDA
//	
//	public void configurarPartida() {
//		if (this.esAdmin == true) {
//			setPrimerJugador();/// Este metodo de partida va a ver en el array de jguadores
//								/// y hacer que tire primero ese jugador que eligio la persona
//								/// que creo la sala
//			setOrdenRonda();
//		}
//
//	}

	public void sumarUnDesc() {
		this.cartasTiradas++;
		
	}

	public void sumarCorazon() {
		this.puntaje++;
	}

	public void jugarCartaEnCampo(int numJugador, ArrayList<Jugador> jugadores, Mazo mazo, PantallaPartida pantallaPartida, Jugador jug, int pos) {
		
		if(numJugador == 0 && pos==0) {
			pantallaPartida.getCartaVisible1().setVisible(false);
		}
		
		if(numJugador == 0 && pos==1) {
			pantallaPartida.getCartaVisible2().setVisible(false);
		}
		
		if(numJugador == 1 && pos==0) {
			pantallaPartida.getCartaVisible3().setVisible(false);
		}
		
		if(numJugador == 1 && pos==1) {
			pantallaPartida.getCartaVisible4().setVisible(false);
		}
		
		if(numJugador == 2 && pos==0) {
			pantallaPartida.getCartaVisible5().setVisible(false);
		}
		
		if(numJugador == 2 && pos==1) {
			pantallaPartida.getCartaVisible6().setVisible(false);
		}
		
		if(numJugador == 3 && pos==0) {
			pantallaPartida.getCartaVisible7().setVisible(false);
		}
		
		if(numJugador == 3 && pos==1) {
			pantallaPartida.getCartaVisible8().setVisible(false);
		}
		
		JButton cartaJugada = pantallaPartida.getCartaJugada();
		
		Carta card = jug.getManoDeCartas().getMano().get(pos);
		
		Image img = null;
		try {
			img = ImageIO.read(new File( "Imagenes\\"+card.getNombre()+ ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cartaJugada.setIcon(new ImageIcon(img));
		
		jug.getManoDeCartas().sacarCarta(pos);
		
		card.activarEfecto(jug, jugadores, mazo, pantallaPartida);
		
		
	}

	public void jugarCartaEnCampoPrincipe(int numJugador, ArrayList<Jugador> listaJugadores, Mazo m,
			PantallaPartida pantallaPartida, Jugador jug, int pos) {
		
			if(numJugador == 0 && pos==0) {
				pantallaPartida.getCartaVisible1().setVisible(false);
			}
			
			if(numJugador == 0 && pos==1) {
				pantallaPartida.getCartaVisible2().setVisible(false);
			}
			
			if(numJugador == 1 && pos==0) {
				pantallaPartida.getCartaVisible3().setVisible(false);
			}
			
			if(numJugador == 1 && pos==1) {
				pantallaPartida.getCartaVisible4().setVisible(false);
			}
			
			if(numJugador == 2 && pos==0) {
				pantallaPartida.getCartaVisible5().setVisible(false);
			}
			
			if(numJugador == 2 && pos==1) {
				pantallaPartida.getCartaVisible6().setVisible(false);
			}
			
			if(numJugador == 3 && pos==0) {
				pantallaPartida.getCartaVisible7().setVisible(false);
			}
			
			if(numJugador == 3 && pos==1) {
				pantallaPartida.getCartaVisible8().setVisible(false);
			}
			
			JButton cartaJugada = pantallaPartida.getCartaJugada();
			
			Carta card = jug.getManoDeCartas().getMano().get(pos);
			
			Image img = null;
			try {
				img = ImageIO.read(new File( "Imagenes\\"+card.getNombre()+ ".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			cartaJugada.setIcon(new ImageIcon(img));
			
			jug.getManoDeCartas().sacarCarta(pos);
		
	}

//	public void seleccionarSala() {
//		
//	}
///////////////////////////////////////////////////////////////// FIN COMMENT 1# ESTOS METODOS LOS VA A EJECUTAR
////UN JUGADOR QUE ES ADMIN APRA CONFIGURAR LA PARTIDA, AL MOMENTO QUE CREA UNA SALA

}
