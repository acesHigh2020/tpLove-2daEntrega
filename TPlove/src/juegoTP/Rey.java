package juegoTP;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import InterfazGrafica.PantallaPartida;

public class Rey extends Carta{

	public Rey() {
		super("Rey", 6, "El jugador elige otro jugador e intercambian sus manos");
	}

	@Override
	public void activarEfecto(Jugador jugador, ArrayList<Jugador> listaJugadores, Mazo m, PantallaPartida pantallaPartida) {
		
		
		ArrayList<Jugador> jugadoresElegibles = new ArrayList<Jugador>();

		int jugadorElegido = 0;

		for (Jugador jug : listaJugadores) { /// METE EN UN VECTOR A LOS JUGADORES SELECCIONABLES
			if (jugador != jug && jug.getEstado().compareTo("Jugando") == 0) {
				jugadoresElegibles.add(jug);
			}
		}

		Object[] opciones = new String[jugadoresElegibles.size()];

		int i = 0;

		for (Jugador jug : jugadoresElegibles) {
			opciones[i] = jugadoresElegibles.get(i).getNombre();
			i++;
		}

		if (jugadoresElegibles.size() == 0) {
			JOptionPane.showMessageDialog(pantallaPartida, "No hay jugadores seleccionables.");
			return;
		} else if (jugadoresElegibles.size() == 1) {
			jugadorElegido = JOptionPane.showOptionDialog(pantallaPartida, "Elija un jugador para intercambiar cartas",
					"Jugador: " + jugador.getNombre(), JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null,
						opciones, opciones[0]);
		} else if (jugadoresElegibles.size() == 2) {
			jugadorElegido = JOptionPane.showOptionDialog(pantallaPartida, "Elija un jugador para intercambiar cartas",
					"Jugador: " + jugador.getNombre(), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
						opciones, opciones[1]);
		} else {
			jugadorElegido = JOptionPane.showOptionDialog(pantallaPartida, "Elija un jugador para intercambiar cartas",
					"Jugador: " + jugador.getNombre(), JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
						null, opciones, opciones[2]);
		}

		Jugador jugElegido = jugadoresElegibles.get(jugadorElegido);
		Carta cartaInt1;
		Carta cartaInt2;

		cartaInt1 = jugador.getManoDeCartas().getMano().remove(0);
		cartaInt2 = jugElegido.getManoDeCartas().getMano().remove(0);
		
		jugador.asignarCarta(cartaInt2);
		jugElegido.asignarCarta(cartaInt1);
		
		
		
		JOptionPane.showMessageDialog(pantallaPartida, "Se ha producido el Intercambio!");

		
	}
}