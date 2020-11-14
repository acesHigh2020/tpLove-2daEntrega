package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;

import juegoTP.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class SegundaVentana extends PantallaInicio {

	private JPanel contentPane;
	private JFrame pantalla1;
	private String jugador;
	private JTextField textField_nombreJugador;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { SegundaVentana frame = new
	 * SegundaVentana(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public SegundaVentana(JFrame p1, String jug) {

		jugador = jug;
		p1.setVisible(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		FondoPartida fondo;
		try {
			fondo = new FondoPartida(ImageIO.read(new File("Imagenes\\fondoInicio.png")));
			JPanel panel = (JPanel) this.getContentPane();
	        panel.setBorder(fondo);
	        
	        
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		JButton botonCrearPartida = new JButton("Crear partida");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, botonCrearPartida, -22, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, botonCrearPartida, -10, SpringLayout.EAST, contentPane);

		contentPane.add(botonCrearPartida);

		JLabel lblNewLabel = new JLabel("Cantidad de corazones para ganar");
		lblNewLabel.setForeground(Color.WHITE);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 44, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel);

		JComboBox comboCantidadCorazones = new JComboBox();
		sl_contentPane.putConstraint(SpringLayout.NORTH, comboCantidadCorazones, -3, SpringLayout.NORTH, lblNewLabel);
		comboCantidadCorazones.setModel(new DefaultComboBoxModel(new String[] { "2", "3", "4", "5" }));
		contentPane.add(comboCantidadCorazones);

		textField_nombreJugador = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_nombreJugador, 35, SpringLayout.SOUTH,
				comboCantidadCorazones);
		contentPane.add(textField_nombreJugador);
		textField_nombreJugador.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Ingrese nombre de jugador");
		lblNewLabel_1.setForeground(Color.WHITE);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_nombreJugador, 31, SpringLayout.EAST, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 3, SpringLayout.NORTH, textField_nombreJugador);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblNewLabel);
		contentPane.add(lblNewLabel_1);

		JButton botonAgregarJugador = new JButton("Agregar");
		sl_contentPane.putConstraint(SpringLayout.NORTH, botonAgregarJugador, -1, SpringLayout.NORTH,
				textField_nombreJugador);
		sl_contentPane.putConstraint(SpringLayout.WEST, botonAgregarJugador, 57, SpringLayout.EAST,
				textField_nombreJugador);

		ArrayList jugadores = new ArrayList<Jugador>();
		jugadores.add(new Jugador(jugador));
		contentPane.add(botonAgregarJugador);

		JLabel lblNewLabel_2 = new JLabel("Indicar primer jugador de la ronda");
		lblNewLabel_2.setForeground(Color.WHITE);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 54, SpringLayout.SOUTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, lblNewLabel);
		contentPane.add(lblNewLabel_2);

		JComboBox comboListaJugadores = new JComboBox();
		sl_contentPane.putConstraint(SpringLayout.WEST, comboCantidadCorazones, 0, SpringLayout.WEST,
				comboListaJugadores);
		sl_contentPane.putConstraint(SpringLayout.NORTH, comboListaJugadores, -3, SpringLayout.NORTH, lblNewLabel_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, comboListaJugadores, 19, SpringLayout.EAST, lblNewLabel_2);
		sl_contentPane.putConstraint(SpringLayout.EAST, comboListaJugadores, 118, SpringLayout.EAST, lblNewLabel_2);
		contentPane.add(comboListaJugadores);

		JLabel lblNewLabel_3 = new JLabel("Sentido de ronda");
		lblNewLabel_3.setForeground(Color.WHITE);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 50, SpringLayout.SOUTH, lblNewLabel_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_3, 10, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_3);

		JComboBox comboSentidoRonda = new JComboBox();
		sl_contentPane.putConstraint(SpringLayout.NORTH, comboSentidoRonda, -3, SpringLayout.NORTH, lblNewLabel_3);
		sl_contentPane.putConstraint(SpringLayout.WEST, comboSentidoRonda, 20, SpringLayout.EAST, lblNewLabel_3);
		comboSentidoRonda.setModel(new DefaultComboBoxModel(new String[] { "Horario", "Antihorario" }));
		contentPane.add(comboSentidoRonda);

		DefaultComboBoxModel combo = new DefaultComboBoxModel(new String[4]);
		comboListaJugadores.setModel(combo);
		combo.insertElementAt(jugador, jugadores.size());
		
		JFrame segundaVentana = this;
		
		botonAgregarJugador.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (textField_nombreJugador.getText().length() != 0) {
					if (jugadores.size() < 4) {
						jugadores.add(new Jugador(textField_nombreJugador.getText()));

						combo.insertElementAt(textField_nombreJugador.getText(), jugadores.size());

					}
					else {
						JOptionPane.showMessageDialog(segundaVentana, "Limite de jugadores alcanzado");
					}
				} else {
					JOptionPane.showMessageDialog(segundaVentana, "Campo vacio");
				}
				textField_nombreJugador.setText("");
			}
		});

		JFrame pantallaInicio = this;

		botonCrearPartida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {	
				
				if (jugadores.size() > 0) {
					if ((String) comboListaJugadores.getSelectedItem() != null
							&& ((String) comboListaJugadores.getSelectedItem()).length() != 0) {

						Partida partida = new Partida(
								Integer.parseInt(comboCantidadCorazones.getSelectedItem().toString()));
						for (Object object : jugadores) {
							partida.agregarJugador((Jugador) object);
						}
						
						
						partida.configurarPartida(
								(Jugador) jugadores.get(combo.getIndexOf((String) combo.getSelectedItem())-1),
								(String) comboSentidoRonda.getSelectedItem());
						pantallaInicio.setVisible(false);
						PantallaPartida pantallaPar = new PantallaPartida(partida.getJugadores(), partida);
					} else {
						JOptionPane.showMessageDialog(segundaVentana, "No se eligio jugador para iniciar ronda");
					}

				} else {
					JOptionPane.showMessageDialog(segundaVentana, "No se llego a la cantidad minima de jugadores");
				}
			}
		});

	}
}
