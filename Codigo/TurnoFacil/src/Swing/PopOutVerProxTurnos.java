package Swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PopOutVerProxTurnos extends JFrame {

	private JPanel contentPane;
	private JTextField txtNoHayTurnos;
	private JTextField txtdeseaVerLos;

	/**
	 * Create the frame.
	 */
	public PopOutVerProxTurnos(Turnero t) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 321, 136);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		txtNoHayTurnos = new JTextField();
		txtNoHayTurnos.setEditable(false);
		txtNoHayTurnos.setBorder(null);
		txtNoHayTurnos.setFocusable(false);
		txtNoHayTurnos.setOpaque(false);
		txtNoHayTurnos.setHorizontalAlignment(SwingConstants.CENTER);
		txtNoHayTurnos.setText("No hay turnos en el rango seleccionado.");
		txtNoHayTurnos.setColumns(10);
		
		txtdeseaVerLos = new JTextField();
		txtdeseaVerLos.setEditable(false);
		txtdeseaVerLos.setBorder(null);
		txtdeseaVerLos.setFocusable(false);
		txtdeseaVerLos.setOpaque(false);
		txtdeseaVerLos.setText("¿Desea ver los turnos de la siguiente semana?");
		txtdeseaVerLos.setHorizontalAlignment(SwingConstants.CENTER);
		txtdeseaVerLos.setColumns(10);
		
		JButton btnNo = new JButton("NO");
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JButton btnSi = new JButton("SI");
		btnSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.mostrarProxTurnos();
				dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtNoHayTurnos, GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
								.addComponent(txtdeseaVerLos, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(79)
							.addComponent(btnSi, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnNo, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtNoHayTurnos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtdeseaVerLos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNo)
						.addComponent(btnSi))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
