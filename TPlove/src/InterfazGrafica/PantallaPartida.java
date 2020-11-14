package InterfazGrafica;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import juegoTP.Carta;
import juegoTP.Descarte;
import juegoTP.Jugador;
import juegoTP.Mazo;
import juegoTP.Partida;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Dimension;

public class PantallaPartida extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3078354589235509430L;
	
	private JPanel contenedorPartida;
	private SpringLayout sl_contentPane;
	
	private JLabel ronda;
	private JLabel LabelPuntuacionJ1;
	private JLabel LabelPuntuacionJ2;
	private int turno=0;
	private int numRonda=0;
	private JButton cartaJugada;
	private JLabel MazoLabel;
	
	private JLabel nombre1;
	private JLabel nombre2;
	private JLabel nombre3;
	private JLabel nombre4;
	
	private JButton cartaVisible1;
	private JButton cartaVisible2;
	private JButton cartaVisible3;
	private JButton cartaVisible4;
	private JButton cartaVisible5;
	private JButton cartaVisible6;
	private JButton cartaVisible7;
	private JButton cartaVisible8;
	
	private Jugador p1;
	private Jugador p2;
	private Jugador p3;
	private Jugador p4;
	private JLabel ronda1;
	private JLabel lblNewLabel;
	
	public JPanel getContenedorPartida() {
		return contenedorPartida;
	}

	public void setContenedorPartida(JPanel contenedorPartida) {
		this.contenedorPartida = contenedorPartida;
	}

	public SpringLayout getSl_contentPane() {
		return sl_contentPane;
	}

	public void setSl_contentPane(SpringLayout sl_contentPane) {
		this.sl_contentPane = sl_contentPane;
	}

	public JLabel getRonda() {
		return ronda;
	}

	public void setRonda(JLabel ronda) {
		this.ronda = ronda;
	}
	
	public JLabel getLabelPuntuacionJ1() {
		return LabelPuntuacionJ1;
	}

	public void setLabelPuntuacionJ1(JLabel labelPuntuacionJ1) {
		LabelPuntuacionJ1 = labelPuntuacionJ1;
	}

	public JLabel getLabelPuntuacionJ2() {
		return LabelPuntuacionJ2;
	}

	public void setLabelPuntuacionJ2(JLabel labelPuntuacionJ2) {
		LabelPuntuacionJ2 = labelPuntuacionJ2;
	}

	public JButton getCartaJugada() {
		return cartaJugada;
	}

	public void setCartaJugada(JButton cartaJugada) {
		this.cartaJugada = cartaJugada;
	}

	public JLabel getMazoLabel() {
		return MazoLabel;
	}

	public void setMazoLabel(JLabel mazoLabel) {
		MazoLabel = mazoLabel;
	}

	public JLabel getNombre1() {
		return nombre1;
	}

	public void setNombre1(JLabel nombre1) {
		this.nombre1 = nombre1;
	}

	public JLabel getNombre2() {
		return nombre2;
	}

	public void setNombre2(JLabel nombre2) {
		this.nombre2 = nombre2;
	}

	public JLabel getNombre3() {
		return nombre3;
	}

	public void setNombre3(JLabel nombre3) {
		this.nombre3 = nombre3;
	}

	public JLabel getNombre4() {
		return nombre4;
	}

	public void setNombre4(JLabel nombre4) {
		this.nombre4 = nombre4;
	}

	public JButton getCartaVisible1() {
		return cartaVisible1;
	}

	public void setCartaVisible1(JButton cartaVisible1) {
		this.cartaVisible1 = cartaVisible1;
	}

	public JButton getCartaVisible2() {
		return cartaVisible2;
	}

	public void setCartaVisible2(JButton cartaVisible2) {
		this.cartaVisible2 = cartaVisible2;
	}

	public JButton getCartaVisible3() {
		return cartaVisible3;
	}

	public void setCartaVisible3(JButton cartaVisible3) {
		this.cartaVisible3 = cartaVisible3;
	}

	public JButton getCartaVisible4() {
		return cartaVisible4;
	}

	public void setCartaVisible4(JButton cartaVisible4) {
		this.cartaVisible4 = cartaVisible4;
	}

	public JButton getCartaVisible5() {
		return cartaVisible5;
	}

	public void setCartaVisible5(JButton cartaVisible5) {
		this.cartaVisible5 = cartaVisible5;
	}

	public JButton getCartaVisible6() {
		return cartaVisible6;
	}

	public void setCartaVisible6(JButton cartaVisible6) {
		this.cartaVisible6 = cartaVisible6;
	}

	public JButton getCartaVisible7() {
		return cartaVisible7;
	}

	public void setCartaVisible7(JButton cartaVisible7) {
		this.cartaVisible7 = cartaVisible7;
	}

	public JButton getCartaVisible8() {
		return cartaVisible8;
	}

	public void setCartaVisible8(JButton cartaVisible8) {
		this.cartaVisible8 = cartaVisible8;
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}

	public int getNumRonda() {
		return numRonda;
	}

	public void setNumRonda(int numRonda) {
		this.numRonda = numRonda;
	}

	public Jugador getP1() {
		return p1;
	}

	public void setP1(Jugador p1) {
		this.p1 = p1;
	}

	public Jugador getP2() {
		return p2;
	}

	public void setP2(Jugador p2) {
		this.p2 = p2;
	}

	public Jugador getP3() {
		return p3;
	}

	public void setP3(Jugador p3) {
		this.p3 = p3;
	}

	public Jugador getP4() {
		return p4;
	}

	public void setP4(Jugador p4) {
		this.p4 = p4;
	}
	
	public PantallaPartida(ArrayList<Jugador> jugadores, Partida partida) {
		
		getContentPane().setLayout(null);
		
		if(jugadores.get(0) != null) {
			
			p1 = jugadores.get(0);
			
			if(jugadores.get(1) != null){
				
				p2 = jugadores.get(1);
				
				/*if(jugadores.get(2) != null){
					
					p3 = jugadores.get(2);
					
					if(jugadores.get(3) != null){
						
						p4 = jugadores.get(3);
					}
				}*/
			}
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contenedorPartida = new JPanel();
		contenedorPartida.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contenedorPartida);
		sl_contentPane = new SpringLayout();
		contenedorPartida.setLayout(sl_contentPane);
		
		nombre1 = new JLabel(p1.getNombre());
		nombre1.setForeground(Color.WHITE);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, nombre1, 0, SpringLayout.SOUTH, contenedorPartida);
		sl_contentPane.putConstraint(SpringLayout.EAST, nombre1, -642, SpringLayout.EAST, contenedorPartida);
		contenedorPartida.add(nombre1);
		
		nombre2 = new JLabel(p2.getNombre());
		nombre2.setForeground(Color.WHITE);
		sl_contentPane.putConstraint(SpringLayout.NORTH, nombre2, 0, SpringLayout.NORTH, contenedorPartida);
		sl_contentPane.putConstraint(SpringLayout.EAST, nombre2, 0, SpringLayout.EAST, nombre1);
		contenedorPartida.add(nombre2);
		
		cartaVisible1 = new JButton("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, cartaVisible1, 520, SpringLayout.NORTH, contenedorPartida);
		sl_contentPane.putConstraint(SpringLayout.WEST, cartaVisible1, 548, SpringLayout.WEST, contenedorPartida);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, cartaVisible1, -21, SpringLayout.NORTH, nombre1);
		contenedorPartida.add(cartaVisible1);
		
		cartaVisible2 = new JButton("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, cartaVisible2, 520, SpringLayout.NORTH, contenedorPartida);
		sl_contentPane.putConstraint(SpringLayout.EAST, cartaVisible1, -10, SpringLayout.WEST, cartaVisible2);
		sl_contentPane.putConstraint(SpringLayout.WEST, cartaVisible2, 680, SpringLayout.WEST, contenedorPartida);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, cartaVisible2, -21, SpringLayout.NORTH, nombre1);
		contenedorPartida.add(cartaVisible2);
		
		cartaVisible3 = new JButton("");
		sl_contentPane.putConstraint(SpringLayout.WEST, cartaVisible3, 0, SpringLayout.WEST, cartaVisible1);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, cartaVisible3, -524, SpringLayout.SOUTH, contenedorPartida);
		sl_contentPane.putConstraint(SpringLayout.EAST, cartaVisible3, 0, SpringLayout.EAST, cartaVisible1);
        contenedorPartida.add(cartaVisible3);

		cartaVisible4 = new JButton("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, cartaVisible4, 17, SpringLayout.SOUTH, nombre2);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, cartaVisible4, -524, SpringLayout.SOUTH, contenedorPartida);
		sl_contentPane.putConstraint(SpringLayout.NORTH, cartaVisible3, 0, SpringLayout.NORTH, cartaVisible4);
		sl_contentPane.putConstraint(SpringLayout.WEST, cartaVisible4, 680, SpringLayout.WEST, contenedorPartida);
		contenedorPartida.add(cartaVisible4);
		
		cartaJugada = new JButton("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, cartaJugada, 63, SpringLayout.SOUTH, cartaVisible4);
		sl_contentPane.putConstraint(SpringLayout.WEST, cartaJugada, 0, SpringLayout.WEST, cartaVisible2);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, cartaJugada, -287, SpringLayout.SOUTH, contenedorPartida);
		sl_contentPane.putConstraint(SpringLayout.EAST, cartaJugada, -548, SpringLayout.EAST, contenedorPartida);
		contenedorPartida.add(cartaJugada);
		
		numRonda=1;
		
		ronda = new JLabel("Ronda");
		ronda.setForeground(Color.WHITE);
        sl_contentPane.putConstraint(SpringLayout.NORTH, ronda, 51, SpringLayout.NORTH, contenedorPartida);
        sl_contentPane.putConstraint(SpringLayout.WEST, ronda, 104, SpringLayout.WEST, contenedorPartida);
        contenedorPartida.add(ronda);
		
		LabelPuntuacionJ1 = new JLabel("Puntuacion: ");
		sl_contentPane.putConstraint(SpringLayout.EAST, cartaVisible2, -34, SpringLayout.WEST, LabelPuntuacionJ1);
		sl_contentPane.putConstraint(SpringLayout.EAST, cartaVisible2, -34, SpringLayout.WEST, LabelPuntuacionJ1);
		sl_contentPane.putConstraint(SpringLayout.WEST, LabelPuntuacionJ1, 836, SpringLayout.WEST, contenedorPartida);
		LabelPuntuacionJ1.setForeground(Color.WHITE);
        sl_contentPane.putConstraint(SpringLayout.SOUTH, LabelPuntuacionJ1, -97, SpringLayout.SOUTH, contenedorPartida);
        contenedorPartida.add(LabelPuntuacionJ1);
        
        LabelPuntuacionJ2 = new JLabel("Puntuacion:");
        sl_contentPane.putConstraint(SpringLayout.EAST, cartaVisible4, -34, SpringLayout.WEST, LabelPuntuacionJ2);
        sl_contentPane.putConstraint(SpringLayout.WEST, LabelPuntuacionJ2, 836, SpringLayout.WEST, contenedorPartida);
        LabelPuntuacionJ2.setForeground(Color.WHITE);
        sl_contentPane.putConstraint(SpringLayout.NORTH, LabelPuntuacionJ2, 74, SpringLayout.NORTH, contenedorPartida);
        contenedorPartida.add(LabelPuntuacionJ2);
        
        MazoLabel = new JLabel("");
        MazoLabel.setIcon(new ImageIcon("Imagenes\\Mazo.png"));
        sl_contentPane.putConstraint(SpringLayout.NORTH, MazoLabel, 0, SpringLayout.NORTH, cartaJugada);
        sl_contentPane.putConstraint(SpringLayout.EAST, MazoLabel, -195, SpringLayout.WEST, cartaJugada);
        contenedorPartida.add(MazoLabel);
		
		
		FondoPartida fondo;
		try {
			fondo = new FondoPartida(ImageIO.read(new File("Imagenes\\fondo.jpg")));
			JPanel panel = (JPanel) this.getContentPane();
	        panel.setBorder(fondo);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setVisible(true);

		while(partida.hayGanador() == null) { //no haya ganador de partida
			
			ronda.setText("Ronda: " + numRonda);
			LabelPuntuacionJ1.setText("Puntuacion: " + p1.getPuntaje());
			LabelPuntuacionJ2.setText("Puntuacion: " + p2.getPuntaje());
			turno=0;
			int opc=0;
			Mazo mazo = new Mazo();
			Jugador jug = null;

			partida.empezarJuego(jugadores, mazo, this);
			
			JOptionPane.showMessageDialog(this, "Empieza la ronda: " + numRonda);

			while(partida.hayGanadorDeRonda() == null || mazo.getMazoVacio()) {	//no haya ganador de ronda
				
				int aux=0;
				int numJugador = turno%jugadores.size();
				jug = jugadores.get(numJugador);
				
				JOptionPane.showMessageDialog(this, "ES EL TURNO DE " + jug.getNombre() + " , NO VEAS SUS CARTAS!!!!");
				
				/*if( turno == 0) {
					
					for (Jugador jugSinPantallas : jugadores) {
						if(aux != numJugador) {
							this.invisiblesCartasJugador(aux, jugSinPantallas);				
						}	
						
						aux++;
					}
				}*/
				
				if(jug.getEstado() == "Inmune") {
					jug.setEstado("Jugando");
					
					JOptionPane.showMessageDialog(this, "El jugador " + jug.getNombre() + " ya no tiene inmunidad!");
				}
				
				
				if(jug.getEstado() != "Fuera de Ronda") {
					
					jug.agarrarCarta(mazo, this);
					this.actualizarPantalla(numJugador, jug);
					
					if(jug.getManoDeCartas().getMano().get(0).getNombre() == "Condesa" && (jug.getManoDeCartas().getMano().get(1).getNombre() == "Rey" || jug.getManoDeCartas().getMano().get(1).getNombre() == "Principe")
							|| (jug.getManoDeCartas().getMano().get(0).getNombre() == "Rey" || jug.getManoDeCartas().getMano().get(0).getNombre() == "Principe") && jug.getManoDeCartas().getMano().get(1).getNombre() == "Condesa") {
						
						Carta c1 = jug.getManoDeCartas().getMano().get(0);
						Carta c2 = jug.getManoDeCartas().getMano().get(1);
						
						if(c1.getNombre() == "Condesa") {
							opc=0;
						}
						else {
							opc=1;
						}
						
						JOptionPane.showMessageDialog(this, "La condesa no es compatible con el Rey y el Principe, despidete de ella!");
					}
					else {
						Object[] opciones = {jug.getManoDeCartas().getMano().get(0).getNombre(),jug.getManoDeCartas().getMano().get(1).getNombre()};
						opc = JOptionPane.showOptionDialog(this, "Elija 1 carta para jugar","Jugador: " + jug.getNombre(), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,opciones, opciones[1]);
					}
					
					if(opc == 0) {
						jug.jugarCartaEnCampo(numJugador,jugadores, mazo, this, jug, 0);
					}
					else{
						jug.jugarCartaEnCampo(numJugador,jugadores, mazo, this, jug, 1);
					}				
					
					this.ocultarCartasJugador(numJugador, jug);
				}
				
				turno++;
				
				
			}
			
			if(partida.hayGanadorDeRonda() == null) {
				
				Jugador maxCartaPuntaje = jugadores.get(0);
				
				for (Jugador juga : jugadores) {
					if(maxCartaPuntaje.getManoDeCartas().getMano().get(0).getPuntajeFuerza() < juga.getManoDeCartas().getMano().get(0).getPuntajeFuerza()) {
						maxCartaPuntaje = juga;
					}
				}
				
				maxCartaPuntaje.sumarCorazon();
				JOptionPane.showMessageDialog(this, "El ganador de la ronda es: " + maxCartaPuntaje.getNombre() + "\nFelicitaciones!");
			}
			else {
				partida.hayGanadorDeRonda().sumarCorazon();
				JOptionPane.showMessageDialog(this, "El ganador de la ronda es: " + partida.hayGanadorDeRonda().getNombre() + "\nFelicitaciones!");
			}
			
			
			for (Jugador jugador : jugadores) {
				jugador.setEstado("Jugando");
			}
			
			numRonda++;
			
			
		}
		
		String listado = new String();
		
		for (Jugador jugador : jugadores) {
			listado += "Jugador: " + jugador.getNombre() + "   Puntuacion: " + jugador.getPuntaje() + "\n";
		}
		
		JOptionPane.showMessageDialog(this, "El ganador del juego es: " + partida.hayGanador().getNombre() + "\nFelicitaciones!\n\n" + listado);
		
		
	}
	
	

	private void actualizarPantalla(int numJugador, Jugador jug) {
		
		Carta uno = jug.getManoDeCartas().getMano().get(0);
		Carta dos = jug.getManoDeCartas().getMano().get(1);
		
		Image img1 = null;
		try {
			img1 = ImageIO.read(new File( "Imagenes\\"+uno.getNombre()+ ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Image img2 = null;
		try {
			img2 = ImageIO.read(new File( "Imagenes\\"+dos.getNombre()+ ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		if(numJugador == 0) {
			this.cartaVisible1.setIcon(new ImageIcon(img1));
			this.cartaVisible1.setVisible(true);
			this.cartaVisible2.setIcon(new ImageIcon(img2));
			this.cartaVisible2.setVisible(true);
		}
		else if(numJugador == 1) {
			this.cartaVisible3.setIcon(new ImageIcon(img1));
			this.cartaVisible3.setVisible(true);
			this.cartaVisible4.setIcon(new ImageIcon(img2));
			this.cartaVisible4.setVisible(true);
		}
		else if(numJugador == 2) {
			this.cartaVisible5.setIcon(new ImageIcon(img1));
			this.cartaVisible5.setVisible(true);
			this.cartaVisible6.setIcon(new ImageIcon(img2));
			this.cartaVisible6.setVisible(true);
		}
		else if(numJugador == 3) {
			this.cartaVisible7.setIcon(new ImageIcon(img1));
			this.cartaVisible7.setVisible(true);
			this.cartaVisible8.setIcon(new ImageIcon(img2));
			this.cartaVisible8.setVisible(true);
		}
		
	}

	public void ocultarCartasJugador(int numJugador, Jugador jug) {
	
		Image img = null;
		try {
			img = ImageIO.read(new File( "Imagenes\\mazo.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(numJugador == 0) {
			this.cartaVisible1.setIcon(new ImageIcon(img));
			this.cartaVisible2.setIcon(new ImageIcon(img));
		}	
		else if(numJugador == 1) {
			this.cartaVisible3.setIcon(new ImageIcon(img));
			this.cartaVisible4.setIcon(new ImageIcon(img));
		}	
		else if(numJugador == 2) {
			this.cartaVisible5.setIcon(new ImageIcon(img));
			this.cartaVisible6.setIcon(new ImageIcon(img));
		}	
		else if(numJugador == 3) {
			this.cartaVisible7.setIcon(new ImageIcon(img));
			this.cartaVisible8.setIcon(new ImageIcon(img));
		}
	}
	
	private void invisiblesCartasJugador(int aux, Jugador jugSinPantallas) {

		Image img = null;
		try {
			img = ImageIO.read(new File( "Imagenes\\mazo.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(aux == 0) {
			this.cartaVisible1.setIcon(new ImageIcon(img));
			this.cartaVisible2.setVisible(false);
		}
		else if(aux == 1) {
			this.cartaVisible3.setIcon(new ImageIcon(img));
			this.cartaVisible4.setVisible(false);
		}
		else if(aux == 2) {
			this.cartaVisible5.setIcon(new ImageIcon(img));
			this.cartaVisible6.setVisible(false);
		}		
		else if(aux == 3) {
			this.cartaVisible7.setIcon(new ImageIcon(img));
			this.cartaVisible8.setVisible(false);
		}
		
	}
	
	public void mostrarRonda(String nroRonda) throws InterruptedException {
		//labelRonda.setText(nroRonda);

	}
	
	public void mazoVacio() {
		
	}
}
