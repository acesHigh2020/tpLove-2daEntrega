package juegoTP;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import InterfazGrafica.PantallaPartida;

public class Sacerdote extends Carta {

	public Sacerdote() {
		super("Sacerdote", 2, "El jugador elige otro jugador para ver la cartas en su mano");
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
			jugadorElegido = JOptionPane.showOptionDialog(pantallaPartida, "Elija un jugador para ver su carta",
					"Jugador: " + jugador.getNombre(), JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null,
						opciones, opciones[0]);
		} else if (jugadoresElegibles.size() == 2) {
			jugadorElegido = JOptionPane.showOptionDialog(pantallaPartida, "Elija un jugador para ver su carta",
					"Jugador: " + jugador.getNombre(), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
						opciones, opciones[1]);
		} else {
			jugadorElegido = JOptionPane.showOptionDialog(pantallaPartida, "Elija un jugador para ver su carta",
					"Jugador: " + jugador.getNombre(), JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
						null, opciones, opciones[2]);
		}

		Jugador jugElegido = jugadoresElegibles.get(jugadorElegido);

		JOptionPane.showMessageDialog(pantallaPartida, "El jugador " + jugElegido.getNombre()+ " tiene la carta " + jugElegido.getManoDeCartas().getMano().get(0).getNombre());
	}
	
	
	
}
