package InterfazGrafica;

import juegoTP.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.awt.Toolkit;
import java.awt.Color;

public class PantallaInicio extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
//	private FondoPantalla fondo = new FondoPantalla();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaInicio frame = new PantallaInicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PantallaInicio() {
		setForeground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		FondoPartida fondo;
		try {
			fondo = new FondoPartida(ImageIO.read(new File("Imagenes\\fondoInicio.png")));
			JPanel panel = (JPanel) this.getContentPane();
	        panel.setBorder(fondo);
	        
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		SpringLayout sl_contentPane = new SpringLayout();
	    contentPane.setLayout(sl_contentPane);
//		this.setContentPane(fondo);
	    
		textField_1 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_1, 101, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_1, 139, SpringLayout.WEST, contentPane);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Love Letter");
		lblNewLabel.setForeground(Color.WHITE);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 166, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese nombre de usuario");
		lblNewLabel_1.setForeground(Color.WHITE);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 116, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -6, SpringLayout.NORTH, textField_1);
		contentPane.add(lblNewLabel_1);
		
		JFrame pantallaInicio = this;
		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(textField_1.getText().length() != 0) {
				String nombreDeUsuario = textField_1.getText();
				SegundaVentana ventana2 = new SegundaVentana(pantallaInicio, nombreDeUsuario);
				ventana2.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(pantallaInicio, "No se ingreso nombre de jugador");
				}
				
			}
			
			
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, botonAceptar, 16, SpringLayout.SOUTH, textField_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, botonAceptar, 164, SpringLayout.WEST, contentPane);
		contentPane.add(botonAceptar);
		
	}
	

	
}
