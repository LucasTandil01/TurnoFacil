package Swing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import Clases.*;
import javax.swing.JTextField;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PortalPaciente extends JFrame {

	private JPanel contentPane;
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public PortalPaciente(Paciente p, TurnoFacil sistema) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 471, 299);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTextField txtpnSeAccedeAl = new JTextField();
		txtpnSeAccedeAl.setBorder(null);
		txtpnSeAccedeAl.setHorizontalAlignment(SwingConstants.CENTER);
		txtpnSeAccedeAl.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		txtpnSeAccedeAl.setOpaque(false);
		txtpnSeAccedeAl.setFocusable(false);
		txtpnSeAccedeAl.setEditable(false);
		txtpnSeAccedeAl.setText("BIENVENID@ " + p.getNombre() + " " + p.getApellido());
		
		textField = new JTextField();
		textField.setText("Nombre: " + p.getNombre());
		textField.setOpaque(false);
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField.setFocusable(false);
		textField.setEditable(false);
		textField.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		textField.setColumns(10);
		textField.setBorder(null);
		
		textField_1 = new JTextField();
		textField_1.setText("Apellido: " + p.getApellido());
		textField_1.setOpaque(false);
		textField_1.setHorizontalAlignment(SwingConstants.LEFT);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField_1.setFocusable(false);
		textField_1.setEditable(false);
		textField_1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		
		textField_2 = new JTextField();
		textField_2.setText("Dirección: " + p.getDireccion());
		textField_2.setOpaque(false);
		textField_2.setHorizontalAlignment(SwingConstants.LEFT);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField_2.setFocusable(false);
		textField_2.setEditable(false);
		textField_2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		textField_2.setColumns(10);
		textField_2.setBorder(null);
		
		textField_3 = new JTextField();
		textField_3.setText("Teléfono: " + p.getTelefono());
		textField_3.setOpaque(false);
		textField_3.setHorizontalAlignment(SwingConstants.LEFT);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField_3.setFocusable(false);
		textField_3.setEditable(false);
		textField_3.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		textField_3.setColumns(10);
		textField_3.setBorder(null);
		
		textField_4 = new JTextField();
		textField_4.setText("Email: " + p.getEmail());
		textField_4.setOpaque(false);
		textField_4.setHorizontalAlignment(SwingConstants.LEFT);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField_4.setFocusable(false);
		textField_4.setEditable(false);
		textField_4.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		textField_4.setColumns(10);
		textField_4.setBorder(null);
		
		textField_5 = new JTextField();
		textField_5.setText("Obra Social: " + p.getObraSocialNombre());
		textField_5.setOpaque(false);
		textField_5.setHorizontalAlignment(SwingConstants.LEFT);
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField_5.setFocusable(false);
		textField_5.setEditable(false);
		textField_5.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		textField_5.setColumns(10);
		textField_5.setBorder(null);
		
		textField_6 = new JTextField();
		textField_6.setText("Número de Afiliado: " + p.getNumAfiliado());
		textField_6.setOpaque(false);
		textField_6.setHorizontalAlignment(SwingConstants.LEFT);
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField_6.setFocusable(false);
		textField_6.setEditable(false);
		textField_6.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		textField_6.setColumns(10);
		textField_6.setBorder(null);
		
		JButton btnNewButton = new JButton("Sacar turno");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ListaDeMedicos frame = new ListaDeMedicos(sistema);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		JButton btnVerPrximosTurnos = new JButton("Ver próximos turnos");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addComponent(textField_6, GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
						.addComponent(textField_4)
						.addComponent(textField_3)
						.addComponent(textField_2)
						.addComponent(textField_1)
						.addComponent(textField))
					.addGap(22))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addComponent(txtpnSeAccedeAl, 415, 415, 415)
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(80)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
					.addComponent(btnVerPrximosTurnos)
					.addGap(78))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(7)
					.addComponent(txtpnSeAccedeAl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnVerPrximosTurnos))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
