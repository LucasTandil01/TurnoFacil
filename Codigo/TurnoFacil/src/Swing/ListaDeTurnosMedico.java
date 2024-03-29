package Swing;

import java.awt.Container;
import java.awt.color.CMMException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import Clases.*;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;

public class ListaDeTurnosMedico extends JFrame implements ActionListener {
	
	private Container contenedor;
	private JLabel labelTitulo;
	private JList listaTurnos;
	private DefaultListModel modelo;
	private JScrollPane scrollLista;
	private JTextField txtTurno;
	private JTextField txtDesde;
	private JTextField txtHasta;
	private JComboBox desdeDiaBox;	
	private JComboBox desdeMesBox;
	private JComboBox desdeAnioBox;
	private JComboBox hastaDiaBox;
	private JComboBox hastaMesBox;
	private JComboBox hastaAnioBox;
	private JButton btnNewButton;
	private JCheckBox checkHasta;
	private JCheckBox checkDesde;
	private JCheckBox checkTurno;
	
	
	public ListaDeTurnosMedico(Medico m){
		setResizable(false);
		iniciarComponentes(m);  	
		setSize(501,476);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		cargarTurnos(m);
	}
	
	public void cargarTurnos(Medico m) {
		modelo.clear();
		ArrayList<ArrayList<Turno>> turnos = m.getTurnos();
		for(ArrayList<Turno> lista: turnos) {actualizarTurnos(lista);}
	}
	
	public void actualizarTurnos(ArrayList<Turno> turnos) {		
		String info = "";					
		for(Turno t: turnos) {
			if(t.getPaciente()!=null) {
			info = "Hora: " +  String.format("%02d",t.getHora())+ ":" + String.format("%02d",t.getMinutos()) + ". Fecha: " + t.getFecha().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ". Duracion: "+t.getDuracion()+"min. Paciente: "+t.getPaciente().getNombre()+" "+t.getPaciente().getApellido();
			modelo.addElement(info);
			}
		}
		listaTurnos.setModel(modelo);
	}

	public void filtradoTurnos(Medico m,String turno, int diaDesde, int mesDesde, int anioDesde, int diaHasta, int mesHasta, int anioHasta) {
		modelo.clear();	
		ArrayList<Turno> turnos = m.getListaEnUnRango(m.getTurnosOcup(), LocalDate.of(anioDesde, mesDesde, diaDesde), LocalDate.of(anioHasta, mesHasta, diaHasta));
		if(!turno.equals("Cualquiera"))
			turnos = m.getTurnosFranjaHor(turnos, turno);
		actualizarTurnos(turnos);
	}
	
	public boolean cumpleFechaDesde(LocalDate fecha, int diaDesde, int mesDesde, int anioDesde) {
		return fecha.getYear()<anioDesde||(fecha.getYear()==anioDesde&&((fecha.getMonthValue()<mesDesde)||(fecha.getMonthValue()==mesDesde&&fecha.getDayOfMonth()<diaDesde)));
	}
	
	public boolean cumpleFechaHasta(LocalDate fecha, int diaHasta, int mesHasta, int anioHasta) {
		return fecha.getYear()<anioHasta||(fecha.getYear()==anioHasta&&((fecha.getMonthValue()<mesHasta)||(fecha.getMonthValue()==mesHasta&&fecha.getDayOfMonth()<=diaHasta)));
	}
	
	private void iniciarComponentes(Medico m) {
		contenedor=getContentPane();		
		labelTitulo= new JLabel();
		labelTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		labelTitulo.setText("Turnos Venideros");
		labelTitulo.setBorder(null);		
		modelo = new DefaultListModel();	   	
	    scrollLista = new JScrollPane();		
		txtTurno = new JTextField();
		txtTurno.setBorder(null);
		txtTurno.setEditable(false);
		txtTurno.setFocusable(false);
		txtTurno.setOpaque(false);
		txtTurno.setText("Turno: ");
		txtTurno.setColumns(10);		
		JComboBox turnoBox = new JComboBox();
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
		
		txtHasta = new JTextField();
		txtHasta.setText("Hasta:");
		txtHasta.setOpaque(false);
		txtHasta.setFocusable(false);
		txtHasta.setEditable(false);
		txtHasta.setColumns(10);
		txtHasta.setBorder(null);
		
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
				
		btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
					hastaDia = Integer.valueOf((String)hastaDiaBox.getSelectedItem());
					hastaMes = Integer.valueOf((String)hastaMesBox.getSelectedItem());
					hastaAnio = Integer.valueOf((String)hastaAnioBox.getSelectedItem());
				}			
				filtradoTurnos(m, turno, desdeDia, desdeMes, desdeAnio, hastaDia, hastaMes, hastaAnio);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(checkTurno)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtTurno, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(turnoBox, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(checkDesde, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(txtDesde, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(checkHasta, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(txtHasta, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(hastaDiaBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(desdeDiaBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(desdeMesBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(hastaMesBox, 0, 42, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(hastaAnioBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(desdeAnioBox, 0, 71, Short.MAX_VALUE)))
								.addComponent(scrollLista, GroupLayout.PREFERRED_SIZE, 435, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(152)
							.addComponent(labelTitulo, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(207)
							.addComponent(btnNewButton)))
					.addContainerGap(153, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(labelTitulo, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(txtTurno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(turnoBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(txtDesde, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
									.addComponent(desdeDiaBox, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
									.addComponent(desdeMesBox, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
									.addComponent(desdeAnioBox, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
								.addComponent(checkDesde, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
							.addGap(17)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(hastaAnioBox, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
									.addComponent(hastaMesBox, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
									.addComponent(hastaDiaBox, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
									.addComponent(txtHasta, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
								.addComponent(checkHasta, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
						.addComponent(checkTurno))
					.addGap(26)
					.addComponent(btnNewButton)
					.addGap(54)
					.addComponent(scrollLista, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(157, Short.MAX_VALUE))
		);
		
		listaTurnos = new JList();
		scrollLista.setViewportView(listaTurnos);
		listaTurnos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
		getContentPane().setLayout(groupLayout);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
