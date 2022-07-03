package Swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.*;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class Turnero extends JFrame {
	private Turnero t = this;
	private Medico m;
	private Paciente p;
	private ArrayList<Turno> turnos;
	private JPanel contentPane;
	private JTextField txtTurnosDe;
	private DefaultListModel modelo;
	private JList listaTurDisp;
	private JTextField txtTurno;
	private JTextField txtDesde;
	private JTextField txtHasta;
	private JComboBox desdeDiaBox;	
	private JComboBox desdeMesBox;
	private JComboBox desdeAnioBox;
	private JComboBox hastaDiaBox;
	private JComboBox hastaMesBox;
	private JComboBox hastaAnioBox;
	private JComboBox turnoBox;
	private JCheckBox checkTurno;
	private JCheckBox checkDesde;
	private JCheckBox checkHasta;
	/**
	 * Create the frame.
	 */
	
	public void actualizarTurnos() {		
		modelo.clear();
		String info = "";					
		for(Turno t: turnos) {
			info = "Hora: " +  String.format("%02d",t.getHora())+ ":" + String.format("%02d",t.getMinutos()) +". Fecha: "+t.getFecha().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ". Duracion: "+t.getDuracion()+"min.";
			modelo.addElement(info);
		}
		listaTurDisp.setModel(modelo);
	}

	public void mostrarProxTurnos() {
		int hastaDia = Integer.valueOf((String) hastaDiaBox.getSelectedItem());
		int hastaMes = Integer.valueOf((String) hastaMesBox.getSelectedItem());
		int hastaAnio = Integer.valueOf((String) hastaAnioBox.getSelectedItem());
		LocalDate fecha = LocalDate.of(hastaAnio, hastaMes, hastaDia);
		desdeDiaBox.setSelectedIndex(hastaDia-1);
		desdeMesBox.setSelectedIndex(hastaMes-1);
		desdeAnioBox.setSelectedIndex(hastaAnio-2022);
		hastaDiaBox.setSelectedIndex(fecha.plusWeeks(1).getDayOfMonth()-1);
		hastaMesBox.setSelectedIndex(fecha.plusWeeks(1).getMonthValue()-1);
		hastaAnioBox.setSelectedIndex(fecha.plusWeeks(1).getYear()-2022);
		turnos = m.quiereVerSemProx(LocalDate.of(hastaAnio, hastaMes, hastaDia));
		actualizarTurnos();
	}
	
	public Turnero(Medico m, Paciente p) {
		this.m = m;
		this.p = p;
		setResizable(false);
		inicComponente();
		turnos = m.getTurnosDisp();
		actualizarTurnos();
	}
	
	public void inicComponente() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 504, 469);
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
					
		txtTurno = new JTextField();
		txtTurno.setText("Turno: ");
		txtTurno.setOpaque(false);
		txtTurno.setFocusable(false);
		txtTurno.setEditable(false);
		txtTurno.setColumns(10);
		txtTurno.setBorder(null);
		
		turnoBox = new JComboBox();
		turnoBox.setEnabled(false);
		turnoBox.addItem("Cualquiera");
		turnoBox.addItem("Mañana");
		turnoBox.addItem("Tarde");
		
		txtDesde = new JTextField();
		txtDesde.setText("Desde: ");
		txtDesde.setOpaque(false);
		txtDesde.setFocusable(false);
		txtDesde.setEditable(false);
		txtDesde.setColumns(10);
		txtDesde.setBorder(null);
		
		desdeDiaBox = new JComboBox();
		desdeDiaBox.setEnabled(false);
		desdeDiaBox.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		
		desdeMesBox = new JComboBox();
		desdeMesBox.setEnabled(false);
		desdeMesBox.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		
		desdeAnioBox = new JComboBox();
		desdeAnioBox.setEnabled(false);
		desdeAnioBox.setModel(new DefaultComboBoxModel(new String[] {"2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039"}));
		
		hastaDiaBox = new JComboBox();
		hastaDiaBox.setEnabled(false);
		hastaDiaBox.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		
		hastaMesBox = new JComboBox();
		hastaMesBox.setEnabled(false);
		hastaMesBox.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		
		hastaAnioBox = new JComboBox();
		hastaAnioBox.setEnabled(false);
		hastaAnioBox.setModel(new DefaultComboBoxModel(new String[] {"2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039"}));
				
		txtHasta = new JTextField();
		txtHasta.setText("Hasta:");
		txtHasta.setOpaque(false);
		txtHasta.setFocusable(false);
		txtHasta.setEditable(false);
		txtHasta.setColumns(10);
		txtHasta.setBorder(null);
		
		listaTurDisp = new JList();
		scrollLista.setViewportView(listaTurDisp);
		listaTurDisp.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);		
		modelo=new DefaultListModel();
		
		JButton seleccionarTurnoBtn = new JButton("Seleccionar Turno");
		seleccionarTurnoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.verificarTurno(turnos.get(listaTurDisp.getSelectedIndex()));
				buscar();
			}
		});
		
		checkTurno = new JCheckBox("");
		checkTurno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				turnoBox.setEnabled(!turnoBox.isEnabled());				
			}
		});			
		
		checkDesde = new JCheckBox("");
		checkDesde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desdeDiaBox.setEnabled(!desdeDiaBox.isEnabled());				
				desdeMesBox.setEnabled(!desdeMesBox.isEnabled());				
				desdeAnioBox.setEnabled(!desdeAnioBox.isEnabled());				
			}
		});
		
		checkHasta = new JCheckBox("");
		checkHasta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hastaDiaBox.setEnabled(!hastaDiaBox.isEnabled());				
				hastaMesBox.setEnabled(!hastaMesBox.isEnabled());				
				hastaAnioBox.setEnabled(!hastaAnioBox.isEnabled());				
			}
		});
							
		JButton buscarBtn = new JButton("Buscar");
		buscarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar();
			}
		});		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(58)
							.addComponent(txtTurnosDe, GroupLayout.PREFERRED_SIZE, 368, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addComponent(scrollLista, GroupLayout.PREFERRED_SIZE, 454, GroupLayout.PREFERRED_SIZE))
							.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(214)
										.addComponent(checkHasta, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(txtHasta, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(checkTurno, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(txtTurno, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(turnoBox, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(checkDesde, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(txtDesde, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)))
								.addGap(2)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(desdeDiaBox, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(desdeMesBox, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(desdeAnioBox, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(hastaDiaBox, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(hastaMesBox, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(hastaAnioBox, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))))))
					.addGap(14))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(184, Short.MAX_VALUE)
					.addComponent(seleccionarTurnoBtn)
					.addGap(177))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(192, Short.MAX_VALUE)
					.addComponent(buscarBtn, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addGap(188))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtTurnosDe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtDesde, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
							.addComponent(desdeDiaBox, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addComponent(desdeAnioBox, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addComponent(desdeMesBox, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addComponent(checkTurno, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(turnoBox, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtTurno, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addComponent(checkDesde, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(hastaAnioBox, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addComponent(hastaMesBox, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtHasta, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
							.addComponent(hastaDiaBox, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addComponent(checkHasta, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(22)
					.addComponent(buscarBtn)
					.addGap(18)
					.addComponent(scrollLista, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(seleccionarTurnoBtn)
					.addGap(23))
		);	
		contentPane.setLayout(gl_contentPane);
	}
	
	public void buscar() {
		String turno = "Cualquiera";
		int desdeDia = 1;
		int desdeMes = 1;
		int desdeAnio = 2022;
		int hastaDia = 31;
		int hastaMes = 12;
		int hastaAnio = 2039;
		if(checkTurno.isSelected()) {
			turno = turnoBox.getSelectedItem().toString();
		}
		if (checkDesde.isSelected()) {
			desdeDia = Integer.valueOf((String) desdeDiaBox.getSelectedItem());
			desdeMes = Integer.valueOf((String) desdeMesBox.getSelectedItem());
			desdeAnio = Integer.valueOf((String) desdeAnioBox.getSelectedItem());
		} 
		if(checkHasta.isSelected()) {
			hastaDia = Integer.valueOf((String) hastaDiaBox.getSelectedItem());
			hastaMes = Integer.valueOf((String) hastaMesBox.getSelectedItem());
			hastaAnio = Integer.valueOf((String) hastaAnioBox.getSelectedItem());
		}
		
		turnos = m.getListaEnUnRango(m.getTurnosDisp(),LocalDate.of(desdeAnio, desdeMes, desdeDia),LocalDate.of(hastaAnio, hastaMes, hastaDia)); 
		if(turnos.isEmpty()) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						PopOutVerProxTurnos frame = new PopOutVerProxTurnos(t);
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		if(turno.equals("Cualquiera"))
			actualizarTurnos();
		else
			turnos = m.getTurnosFranjaHor(turnos, turno);
			actualizarTurnos();
	}
}
