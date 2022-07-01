package Swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.*;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;

public class Turnero extends JFrame {
	private JPanel contentPane;
	private JTextField txtTurnosDe;
	private DefaultListModel modelo;
	private JList listaTurDisp;
	/**
	 * Create the frame.
	 */
	
	
	public void actualizarTurnos(ArrayList<Turno> turnos) {		
		modelo.clear();
		String info = "";					
		for(Turno t: turnos) {
			info = "Hora: "+t.getHora()+". Fecha: "+t.getFecha()+". Duracion: "+t.getDuracion()+"min.";
			modelo.addElement(info);
		}
		listaTurDisp.setModel(modelo);
	}

	public Turnero(Medico m) {
		setResizable(false);
		inicComponente(m);
		actualizarTurnos(m.getTurnosDisp());
	}
	
	public void inicComponente(Medico m) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 358);
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
		
		JScrollPane scrollLista = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(21)
							.addComponent(scrollLista, GroupLayout.PREFERRED_SIZE, 435, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(58)
							.addComponent(txtTurnosDe, GroupLayout.PREFERRED_SIZE, 368, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(64, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtTurnosDe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(74)
					.addComponent(scrollLista, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(167, Short.MAX_VALUE))
		);
		
		listaTurDisp = new JList();
		scrollLista.setViewportView(listaTurDisp);
		listaTurDisp.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		contentPane.setLayout(gl_contentPane);
		modelo=new DefaultListModel();
	}
}
