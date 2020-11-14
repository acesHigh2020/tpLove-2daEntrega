package juegoTP;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import InterfazGrafica.PantallaPartida;

public class Mucama extends Carta{

	public Mucama() {
		super("Mucama", 4, "El jugador está protegido y no puede ser afectado por cartas de otros jugadores hasta su siguiente turno");
	}

	@Override
	public void activarEfecto(Jugador jugador, ArrayList<Jugador> listaJugadores, Mazo m, PantallaPartida pantallaPartida) {
		
		jugador.setEstado("Inmune");
		
		JOptionPane.showMessageDialog(pantallaPartida, "El jugador " + jugador.getNombre() + " es inmune hasta su proximo turno!");
	}
	
}
