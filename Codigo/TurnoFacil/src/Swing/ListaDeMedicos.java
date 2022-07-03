package Swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.*;
import Filtros.*;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class ListaDeMedicos extends JFrame {

	private Paciente p;
	private JPanel contentPane;
	private JTextField txtEspecialidad;
	private JTextField txtObraSocial;
	private DefaultListModel modelo;
	private JButton btnNewButton;
	private JList listaMedicos;
	private JTextField especialidadSearch;
	private JButton buscarBtn;
	private JTextField OSSearch;

	/**
	 * Create the frame.
	 */
	public ListaDeMedicos(TurnoFacil sistema, Paciente p) {
		this.p = p;
		setResizable(false);
		iniciarComponentes(sistema);
		actualizarMedicos(sistema.getMedicos());
	}
	
	public void actualizarMedicos(ArrayList<Medico> medicos) {		
		modelo.clear();
		String info = "";					
		for(Medico m: medicos) {
			info = m.getApellido() +", " + m.getNombre() + ". Especialidad: " + m.getEspecialidad() + ". Hora de Inicio: " + m.getHoraInicio() + "h. Hora de Fin: " + m.getHoraFin() +  "h.";
			modelo.addElement(info);
		}
		listaMedicos.setModel(modelo);
	}
	
	public void busqueda(TurnoFacil sistema) {
		ObraSocial os = new ObraSocial(OSSearch.getText());
		FiltroMedico busqueda = new FiltroAndMedico(new FiltroEspecialidad(especialidadSearch.getText()), new FiltroOS(os));				
		actualizarMedicos(sistema.buscarMedicos(busqueda));
	}
	
	public void iniciarComponentes(TurnoFacil sistema) {
		modelo = new DefaultListModel();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 506, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnNewButton = new JButton("Seleccionar Médico");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Turnero frame = new Turnero(sistema.getMedicos().get(listaMedicos.getSelectedIndex()),p);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		listaMedicos = new JList();
		listaMedicos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JLabel lblMdicos = new JLabel();
		lblMdicos.setText("Médicos");
		lblMdicos.setHorizontalAlignment(SwingConstants.CENTER);
		lblMdicos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMdicos.setBorder(null);
		
		txtEspecialidad = new JTextField();
		txtEspecialidad.setBorder(null);
		txtEspecialidad.setEditable(false);
		txtEspecialidad.setFocusable(false);
		txtEspecialidad.setHorizontalAlignment(SwingConstants.CENTER);
		txtEspecialidad.setOpaque(false);
		txtEspecialidad.setText("Especialidad");
		txtEspecialidad.setColumns(10);
		
		buscarBtn = new JButton("Buscar");
		buscarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				busqueda(sistema);
			}
		});
		
		especialidadSearch = new JTextField();
		especialidadSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){					
					busqueda(sistema);
				}				
			}
		});			
		
		txtObraSocial = new JTextField();
		txtObraSocial.setText("Obra Social");
		txtObraSocial.setOpaque(false);
		txtObraSocial.setHorizontalAlignment(SwingConstants.CENTER);
		txtObraSocial.setFocusable(false);
		txtObraSocial.setEditable(false);
		txtObraSocial.setColumns(10);
		txtObraSocial.setBorder(null);
		
		OSSearch = new JTextField();
		OSSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){					
					busqueda(sistema);
				}				
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(177)
					.addComponent(btnNewButton)
					.addContainerGap(180, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(txtEspecialidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(10)
									.addComponent(OSSearch, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
								.addComponent(txtObraSocial, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
							.addGap(37))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(listaMedicos, GroupLayout.PREFERRED_SIZE, 433, GroupLayout.PREFERRED_SIZE)
							.addGap(20))
						.addComponent(especialidadSearch, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(202)
					.addComponent(buscarBtn)
					.addContainerGap(213, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(145)
					.addComponent(lblMdicos, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(155, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblMdicos, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtEspecialidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtObraSocial, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(especialidadSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(OSSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
					.addComponent(buscarBtn)
					.addGap(18)
					.addComponent(listaMedicos, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton)
					.addGap(19))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
