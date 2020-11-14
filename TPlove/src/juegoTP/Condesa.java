package juegoTP;

import java.util.ArrayList;

import InterfazGrafica.PantallaPartida;

public class Condesa extends Carta{

	public Condesa() {	
		super("Condesa",7,"Si un jugador tiene esta carta y el Rey o el Príncipe, esta carta debe ser jugada inmediatamente");
	}

	@Override
	public void activarEfecto(Jugador jugador, ArrayList<Jugador> listaJugadores, Mazo m, PantallaPartida pantallaPartida) {
		///ESTE EFECTO NO SE ACTIVA NUNCA PORQUE YA ESTA PREDEFINIDO EN LA CLASE JUGADOR
	}

}
