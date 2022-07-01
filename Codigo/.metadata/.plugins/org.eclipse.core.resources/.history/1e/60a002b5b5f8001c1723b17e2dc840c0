package Swing;

import java.awt.EventQueue;
import Clases.*;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu {

	public JFrame frame;
	private JTextField txtBienvenidoUsuario;
	private JTextField txtTurnoFcil;
	private JButton btnSoyEmpleado;

	/**
	 * Create the application.
	 */
	public Menu(TurnoFacil sistema) {
		initialize(sistema);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(TurnoFacil sistema) {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 370, 184);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		txtBienvenidoUsuario = new JTextField();
		txtBienvenidoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtBienvenidoUsuario.setOpaque(false);
		txtBienvenidoUsuario.setEditable(false);
		txtBienvenidoUsuario.setFocusable(false);
		txtBienvenidoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtBienvenidoUsuario.setBorder(null);
		txtBienvenidoUsuario.setText("Bienvenido Usuario");
		txtBienvenidoUsuario.setColumns(10);
		
		JButton btnSoyPaciente = new JButton("Soy Paciente");
		btnSoyPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							LoggerPaciente frame = new LoggerPaciente(sistema);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		txtTurnoFcil = new JTextField();
		txtTurnoFcil.setText("Turno Fácil");
		txtTurnoFcil.setOpaque(false);
		txtTurnoFcil.setHorizontalAlignment(SwingConstants.CENTER);
		txtTurnoFcil.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtTurnoFcil.setFocusable(false);
		txtTurnoFcil.setEditable(false);
		txtTurnoFcil.setColumns(10);
		txtTurnoFcil.setBorder(null);
		
		btnSoyEmpleado = new JButton("Soy Empleado");
		btnSoyEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							LoggerEmpleado frame = new LoggerEmpleado(sistema);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(28, Short.MAX_VALUE)
					.addComponent(btnSoyEmpleado, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnSoyPaciente, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
					.addGap(28))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(60)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txtTurnoFcil, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtBienvenidoUsuario, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(60, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addComponent(txtTurnoFcil, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtBienvenidoUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSoyPaciente)
						.addComponent(btnSoyEmpleado))
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
