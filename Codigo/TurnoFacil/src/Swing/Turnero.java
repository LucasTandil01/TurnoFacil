package Swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.*;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Turnero extends JFrame {

	private JPanel contentPane;
	private JTextField txtTurnosDe;

	/**
	 * Create the frame.
	 */
	public Turnero(Medico m) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		txtTurnosDe = new JTextField();
		txtTurnosDe.setHorizontalAlignment(SwingConstants.CENTER);
		txtTurnosDe.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtTurnosDe.setBorder(null);
		txtTurnosDe.setEditable(false);
		txtTurnosDe.setFocusable(false);
		txtTurnosDe.setText("Turnos de " + m.getApellido() + ", " + m.getNombre());
		txtTurnosDe.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(32, Short.MAX_VALUE)
					.addComponent(txtTurnosDe, GroupLayout.PREFERRED_SIZE, 368, GroupLayout.PREFERRED_SIZE)
					.addGap(24))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(txtTurnosDe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(230, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
