package Swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.Paciente;
import Clases.Turno;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import java.awt.Font;
import java.time.format.DateTimeFormatter;

import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaTurnosPaciente extends JFrame {

	private Paciente p;
	private JList listaTurnos;
	private DefaultListModel modelo;
	private JPanel contentPane;
	private JTextField txtPrximosTurnos;
	
	public void actualizarTurnos() {		
		modelo.clear();
		String info = "";					
		for(Turno t: p.getTurnosReservados()) {
			info = "Hora: " +  String.format("%02d",t.getHora())+ ":" + String.format("%02d",t.getMinutos()) +". Fecha: "+t.getFecha().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ". Duracion: "+t.getDuracion()+"min.";
			modelo.addElement(info);
		}
		listaTurnos.setModel(modelo);
	}

	/**
	 * Create the frame.
	 */
	public ListaTurnosPaciente(Paciente p) {
		this.p = p;
		inicComponentes();
		actualizarTurnos();
	}
	
	public void inicComponentes() {
		modelo=new DefaultListModel();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 492, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		txtPrximosTurnos = new JTextField();
		txtPrximosTurnos.setText("Próximos turnos");
		txtPrximosTurnos.setHorizontalAlignment(SwingConstants.CENTER);
		txtPrximosTurnos.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtPrximosTurnos.setFocusable(false);
		txtPrximosTurnos.setEditable(false);
		txtPrximosTurnos.setColumns(10);
		txtPrximosTurnos.setBorder(null);
		
		JScrollPane scrollLista = new JScrollPane();
		
		JButton btnNewButton = new JButton("Actualizar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarTurnos();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(49)
					.addComponent(txtPrximosTurnos, GroupLayout.PREFERRED_SIZE, 368, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(49, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(scrollLista, GroupLayout.PREFERRED_SIZE, 454, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(200, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(195))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtPrximosTurnos, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addComponent(scrollLista, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		listaTurnos = new JList();
		listaTurnos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollLista.setViewportView(listaTurnos);
		contentPane.setLayout(gl_contentPane);
	}
}	
