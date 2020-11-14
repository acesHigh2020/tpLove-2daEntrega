package juegoTP;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import InterfazGrafica.PantallaPartida;

public class Guardia extends Carta {

	public Guardia() {
		super("Guardia", 1, "El jugador elige otro jugador oponente y nombra un tipo de carta (excepto \"Guardia\"). Si el oponente tiene en su mano una carta de ese tipo, el oponente es eliminado de la ronda");
	}
	
	@Override
	public void activarEfecto(Jugador jugador, ArrayList<Jugador> listaJugadores, Mazo m, PantallaPartida pantallaPartida) {

			int jugadorElegido = 0,cartaElegida;
			ArrayList<Jugador> jugadoresElegibles = new ArrayList<Jugador>();

			String cartas[] = {"Sacerdote", "Baron", "Mucama", "Principe", "Rey", "Condesa", "Princesa"};

			for (Jugador jug : listaJugadores) { /// METE EN UN VECTOR A LOS JUGADORES SELECCIONABLES
				if (jugador != jug && jug.getEstado().compareTo("Jugando") == 0) {
					jugadoresElegibles.add(jug);
				}
			}

			Object[] opciones = new String[jugadoresElegibles.size()];

			int i=0;

			for (Jugador jug : jugadoresElegibles) {
				opciones[i] = jugadoresElegibles.get(i).getNombre();
				i++;
			}

			if(jugadoresElegibles.size()==0) {
				JOptionPane.showMessageDialog(pantallaPartida, "No hay jugadores seleccionables.");
				return;
			}
			else if(jugadoresElegibles.size()==1) {
				jugadorElegido = JOptionPane.showOptionDialog(pantallaPartida, "Elija un jugador para tratar de adivinar su carta","Jugador: " + jugador.getNombre(), JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null,opciones, opciones[0]);
			}
			else if(jugadoresElegibles.size()==2) {
				jugadorElegido = JOptionPane.showOptionDialog(pantallaPartida, "Elija un jugador para tratar de adivinar su carta","Jugador: " + jugador.getNombre(), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,opciones, opciones[1]);
			}
			else {
				jugadorElegido =JOptionPane.showOptionDialog(pantallaPartida, "Elija un jugador para tratar de adivinar su carta","Jugador: " + jugador.getNombre(), JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,opciones, opciones[2]);
			}

			JComboBox combo = new JComboBox(cartas);

			JOptionPane.showMessageDialog(null, combo, "Que carta crees que tenga tu oponente?", JOptionPane.QUESTION_MESSAGE);

			cartaElegida = combo.getSelectedIndex();

			if( jugadoresElegibles.get(jugadorElegido).getManoDeCartas().getMano().get(0).getNombre() == cartas[cartaElegida] ){
				JOptionPane.showMessageDialog(pantallaPartida, "Carta Correcta! " + jugadoresElegibles.get(jugadorElegido).getNombre() + " quedo fuera de ronda.");
				jugadoresElegibles.get(jugadorElegido).setEstado("Fuera de Ronda");
			}else {
				JOptionPane.showMessageDialog(pantallaPartida, "El jugador " + jugadoresElegibles.get(jugadorElegido).getNombre() + " no tiene la carta seleccionada");
			}
				
	}
}
