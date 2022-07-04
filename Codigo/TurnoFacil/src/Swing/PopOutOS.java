package Swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.Cobertura;
import Clases.Paciente;
import Clases.Turno;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PopOutOS extends JFrame {

	private JPanel contentPane;
	private JTextField txtElMdicoNo;
	private JTextField txtPeroSeLe;
	private JTextField txtdesea;

	/**
	 * Create the frame.
	 */
	public PopOutOS(Turnero turnero,Turno t, Paciente p, int cobraDiferencial, Cobertura os) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 339, 154);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		txtElMdicoNo = new JTextField();
		txtElMdicoNo.setBorder(null);
		txtElMdicoNo.setEditable(false);
		txtElMdicoNo.setFocusable(false);
		txtElMdicoNo.setOpaque(false);
		txtElMdicoNo.setHorizontalAlignment(SwingConstants.CENTER);
		txtElMdicoNo.setText("El médico no es cubierto por su Obra Social.");
		txtElMdicoNo.setColumns(10);
		
		txtPeroSeLe = new JTextField();
		txtPeroSeLe.setDisabledTextColor(SystemColor.menu);
		txtPeroSeLe.setEnabled(cobraDiferencial == 1);
		txtPeroSeLe.setBorder(null);
		txtPeroSeLe.setEditable(false);
		txtPeroSeLe.setFocusable(false);
		txtPeroSeLe.setOpaque(false);
		double porcentajeDiferencial = 0;
		if(txtPeroSeLe.isEnabled())
			porcentajeDiferencial = os.getPorcentaje();
		txtPeroSeLe.setText("Pero se le cobrará un diferencial de " + porcentajeDiferencial + "%.");
		txtPeroSeLe.setHorizontalAlignment(SwingConstants.CENTER);
		txtPeroSeLe.setColumns(10);
		
		txtdesea = new JTextField();
		txtdesea.setBorder(null);
		txtdesea.setEditable(false);
		txtdesea.setFocusable(false);
		txtdesea.setOpaque(false);
		txtdesea.setText("¿Desea confirmar el turno de todos modos?");
		txtdesea.setHorizontalAlignment(SwingConstants.CENTER);
		txtdesea.setColumns(10);
		
		JButton btnSi = new JButton("SI");
		btnSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.confirmarTurno(t,turnero);
				dispose();
			}
		});
		
		JButton btnNo = new JButton("NO");
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(33)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtdesea, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPeroSeLe, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtElMdicoNo, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(72)
							.addComponent(btnSi, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addGap(40)
							.addComponent(btnNo, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtElMdicoNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtPeroSeLe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtdesea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSi)
						.addComponent(btnNo))
					.addContainerGap(109, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
