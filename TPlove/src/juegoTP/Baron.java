package juegoTP;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import InterfazGrafica.PantallaPartida;

public class Baron extends Carta{

	public Baron() {
		super("Baron", 3, "El jugador elige otro jugador y se revelan las cartas de forma privada. El jugador que posee la carta con menos fuerza es eliminado de la ronda");
	}
		
	@Override
	public void activarEfecto(Jugador jugador, ArrayList<Jugador> listaJugadores, Mazo m, PantallaPartida pantallaPartida) {
		
		ArrayList<String>jugadoresElegibles = new ArrayList<String>();
		
		for (Jugador jug : listaJugadores) {	///METE EN UN VECTOR A LOS JUGADORES SELECCIONABLES
			
			if(jugador!=jug && jug.getEstado().compareTo("Jugando")==0) {
				
				jugadoresElegibles.add(jug.getNombre());
			}	
		}
		
		Object[] opciones = new String[jugadoresElegibles.size()];
		
		int i=0;
		
		for (String jug : jugadoresElegibles) {
			opciones[i] = jugadoresElegibles.get(i);
			i++;
		}

		int opcion = 0;
		
		if(jugadoresElegibles.size()==0) {
			JOptionPane.showMessageDialog(pantallaPartida, "No hay jugadores seleccionables.");
			return;
		}
		else if(jugadoresElegibles.size()==1) {
			opcion = JOptionPane.showOptionDialog(pantallaPartida, "Elija un jugador para comparar cartas","Jugador: " + jugador.getNombre(), JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null,opciones, opciones[0]);
		}
		else if(jugadoresElegibles.size()==2) {
			opcion = JOptionPane.showOptionDialog(pantallaPartida, "Elija un jugador para comparar cartas","Jugador: " + jugador.getNombre(), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,opciones, opciones[1]);
		}
		else {
			opcion = JOptionPane.showOptionDialog(pantallaPartida, "Elija un jugador para comparar cartas","Jugador: " + jugador.getNombre(), JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,opciones, opciones[2]);
		}
		
		Jugador jugadorElegido = null;
		
		for (Jugador jug : listaJugadores) {
			
			if(opciones[opcion] == jug.getNombre()) {
				jugadorElegido = jug;
			}
		}
		

		int comparacion = 0;
		
		comparacion = jugador.getManoDeCartas().getMano().get(0).compararCarta(jugadorElegido.getManoDeCartas().getMano().get(0));
		
		JOptionPane.showMessageDialog(pantallaPartida, jugador.getNombre() + " tiene la carta " + jugador.getManoDeCartas().getMano().get(0).getNombre() + " con puntaje " + jugador.getManoDeCartas().getMano().get(0).getPuntajeFuerza() + "\n" + 
													jugadorElegido.getNombre() + " tiene la carta " + jugadorElegido.getManoDeCartas().getMano().get(0).getNombre() + " con puntaje " + jugadorElegido.getManoDeCartas().getMano().get(0).getPuntajeFuerza());
		
		if(comparacion > 0) {			///EL JUGADOR QUE TENGA MENOR NUMERO DE CARTA ES DECLARADO FUERA DE LA RONDA
			jugadorElegido.setEstado("Fuera de Ronda");
			
			JOptionPane.showMessageDialog(pantallaPartida, "Jugador " + jugadorElegido.getNombre() + " quedo Fuera de Ronda.");
		}		
		else if(comparacion < 0) {
			jugador.setEstado("Fuera de Ronda");
			
			JOptionPane.showMessageDialog(pantallaPartida, "Jugador " + jugador.getNombre() + " quedo Fuera de Ronda.");
		}
		else {
			JOptionPane.showMessageDialog(pantallaPartida, "Hubo Empate de Fuerzas!");
		}

	}

}
